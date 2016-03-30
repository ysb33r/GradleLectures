package gradle.workshop

/**
 * @author Schalk W. Cronjé
 */
class HelloKotlin( var name : String ) {

    // Hello from foo, now using kotlin
    override fun toString() : String {
        return "Hello from " + name + ", now using kotlin"
    }
}