package gradle.workshop;

public class HelloJava {
    public static void main(String [] args) {
        HelloKotlin kt = new HelloKotlin("Gradle Workshop");
        HelloGroovy gr = new HelloGroovy("Gradle Workshop");
        System.out.println("Hello, this is a Java main");
        System.out.println(gr.toString());
        System.out.println(kt.toString());
        System.out.println("Bye...");
    }
}
