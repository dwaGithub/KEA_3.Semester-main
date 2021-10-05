import java.util.ArrayList;

public class MyMain {

    public static void main(String[] args) {
        Systemos Systemos = new Systemos();
        Systemos.out.println("Hello World");
        Systemos.out.println(5);
        Systemos.out.println(5.00);
        Systemos.out.println(1);

        Systemos.out.println(new Word("Word"));

        //String[] word = {"Word 1", "Word 2", "Word 3", "Word 4", "Word 5"};
        //Systemos.out.println(word);

        ArrayList<Word> wordList = new ArrayList<>();
        wordList.add(new Word("a word"));
        wordList.add(new Word("one word"));
        wordList.add(new Word("multiple words"));

        //Systemos.out.println(wordList);


        /* public static void <T> out String

         */


    }
}
