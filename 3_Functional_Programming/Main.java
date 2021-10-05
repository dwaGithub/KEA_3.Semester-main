import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        // anonymous class
        AbstractClass abstractClassImplemented = new AbstractClass() {

            @Override
            public void makeSurrealArt(){
                System.out.println("Created by Dali!");
            }
        };

        // implementation of a (functional) interface
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String firstString, String secondString) {
                return firstString.compareTo(secondString);
            }
        };

        stringComparator.compare("Hello", "world");

        Comparator<String> stringComparatorLambda = (String firstString, String secondString) -> firstString.compareTo(secondString);
        System.out.println(stringComparatorLambda.compare("a", "b"));

        //Concatenator concat = (prependorString, appendorString) -> prependorString + appendorString;
        //System.out.println(concat.cat("Jan", "Jan"));
    }
}
