public class LatinAlphabet {
    public static void main(String[] args) {
        //Код первой буквы латинского алфавита
        char firstLetter = 'A';
        int code = (int) firstLetter;

        for(int i = code; i < code + 26; i++) {
            System.out.println("Код " + i + " соответствует букве " + (char) i);
        }
    }
}
