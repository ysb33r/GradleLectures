package devoxxma.workshop

import spock.lang.*


/**
 * @author Schalk W. Cronjé
 */
class ExampleSpec extends Specification {

    def "A rose by another name is still a rose"() {
        given:
        Example example = new Example()

        when:
        example.name = 'rose'

        then:
        example.name == 'rose'
    }

    @Ignore
    def "A daisy is not a rose"() {
        given:
        Example example = new Example()

        when:
        example.name = 'rose'

        then:
        example.name == 'daisy'
    }

}
