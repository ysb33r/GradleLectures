package gradle.workshop

import spock.lang.Specification


/**
 * @author Schalk W. Cronjé
 */
class HelloKotlinSpec extends Specification {

    def "Kotlin Greeting"() {

        given: 'A user foo'
        def hello = new HelloKotlin('foo')

        expect: 'A kotlin greeting from foo'
        hello.name == 'foo'
        hello.toString() == "Hello from foo, now using kotlin"
    }
}