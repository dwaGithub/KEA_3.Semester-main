import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringStream {
    public static void main(String[] args) {
        // Create a list of strings that contains cool words

        List<String> coolWords = Arrays.asList("Swag", "Soft-ice", "Swag", "Jan", "");

        List<String> onlyWords = coolWords.stream().filter(word -> !word.isEmpty()).collect(Collectors.toList());

        long vocabulary = coolWords.stream().filter(word -> word.length() > 0).distinct().count();
        //System.out.println(vocabulary);

        String sentence = coolWords.parallelStream().filter(word -> !(word.equals(""))).collect(Collectors.joining(" ")) + ".";
        System.out.println(sentence);

    }
}
