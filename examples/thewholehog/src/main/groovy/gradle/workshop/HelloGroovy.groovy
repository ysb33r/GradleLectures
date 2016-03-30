package gradle.workshop

import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

/**
 * @author Schalk W. Cronjé
 */
@CompileStatic
class HelloGroovy {
    String name
    String toString() {"A groovy hello from ${name}"}

    HelloGroovy(final String name) {
        this.name = name
    }
}
