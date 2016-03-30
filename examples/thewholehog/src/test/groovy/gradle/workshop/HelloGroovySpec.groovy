package gradle.workshop

import spock.lang.Specification


/**
 * @author Schalk W. Cronjé
 */
class HelloGroovySpec extends Specification {

    def "Groovy Greeting"() {

        given: 'A user foo'
        def hello = new HelloGroovy('foo')

        expect: 'A groovy greeting from foo'
        hello.name == 'foo'
        hello.toString() == "A groovy hello from foo"
    }
}