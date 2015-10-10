package atagg.workshop

import java.io.File;

import org.apache.ftpserver.ConnectionConfigFactory;
import org.apache.ftpserver.FtpServerFactory
import org.apache.ftpserver.ftplet.UserManager
import org.apache.ftpserver.ftplet.Authority
import org.apache.ftpserver.listener.ListenerFactory
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory
import org.apache.ftpserver.usermanager.SaltedPasswordEncryptor
import org.apache.ftpserver.usermanager.impl.BaseUser
import org.apache.ftpserver.usermanager.impl.WritePermission

import groovy.transform.CompileStatic




class FtpServer {
    static final def PORT  = System.getProperty('FTPPORT') ?: 50021
//    static final String READROOT    = "ftp://guest:guest@localhost:${PORT}"
//    static final String WRITEROOT   = "ftp://root:root@localhost:${PORT}"
    static final File ROOT = new File('./ftpdata')

    def server

    static void main(String[] args) {
        if(!ROOT.exists()) {
            ROOT.mkdirs()
        }
        new FtpServer().start()
    }

    FtpServer() {

        def userManagerFactory = new PropertiesUserManagerFactory()
        def userMgr = userManagerFactory.createUserManager()
        def serverFactory = new FtpServerFactory()
        def factory = new ListenerFactory()
        def configFactory = new ConnectionConfigFactory()

        [
            'guest'   : ROOT.absolutePath,
            'root'    : ROOT.absolutePath
        ].each { k,v ->
            def user = new BaseUser()
            ArrayList<Authority> auths = []
            def auth = new WritePermission()

            auths.add(auth)
            user.setName( k )
            user.setPassword( k )
            user.setHomeDirectory( v )
            user.setAuthorities(auths)
            userMgr.save(user)
        }

        configFactory.maxLogins = 20
        serverFactory.userManager = userMgr
        serverFactory.connectionConfig = configFactory.createConnectionConfig()
        factory.port = PORT
        serverFactory.addListener("default", factory.createListener())

        server = serverFactory.createServer();
    }

    void start() {
        server.start()
    }

}