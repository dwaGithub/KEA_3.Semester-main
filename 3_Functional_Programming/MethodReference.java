import java.util.Arrays;
import java.util.List;

public class MethodReference {

    /*public static void outStaticVersion(String content){
        System.out.println(content);
    }*/

    public void out(String content) {
        System.out.println(content);
    }

    public MethodReference(String content){
        System.out.println(content);
    }

    public static void main(String[] args) {
        List<String> greetings = Arrays.asList("Hello World", "Godmorgen");

        // Not a method reference but a lambda!
        //greetings.forEach((greeting -> System.out.println(greeting)));

        // Method references

        //this won't work if the constructor exists
        // greetings.forEach(new MethodReference()::out);

        // greetings.forEach(MethodReference()::outStaticVersion);
        // greetings.forEach(MethodReference::new);

        greetings.forEach(System.out::println);
    }
}
