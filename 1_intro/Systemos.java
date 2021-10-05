import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Systemos {

    public Systemos out;

    public static void println(String indhold){
        System.out.println(indhold);
    }

    public static void println(int indhold){
        System.out.println(indhold);

    }

    public static void println(double indhold){
        System.out.println(indhold);
    }

    public static void println(Word word){
        System.out.println(word);
    }

    public static void println(String[] word){
        for(String s : word){
            System.out.print(s);
        }
    }

    public static void println(float indhold){
        System.out.println(indhold);
    }

    public static void println(){

    }

    /*ublic void println(List Object) {
        System.out.println("runs here" + object);
    }

    public static void println(List content){
        content.forEach(object -> println(object));
    }

    /*public static void println(indhold){
        System.out.println(indhold);
    }*/
}
