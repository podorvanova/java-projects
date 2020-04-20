public class Main {
    public static void main(String[] args) {
        String text = "An engine that performs match operations on a character sequence by interpreting a Pattern.\n" +
                "A matcher is created from a pattern by invoking the pattern's matcher method. Once created, a matcher can be used to perform three different kinds of match operations:\n" +
                "\n" +
                "The matches method attempts to match the entire input sequence against the pattern.\n" +
                "\n" +
                "The lookingAt method attempts to match the input sequence, starting at the beginning, against the pattern.\n" +
                "\n" +
                "The find method scans the input sequence looking for the next subsequence that matches the pattern.\n" +
                "\n" +
                "Each of these methods returns a boolean indicating success or failure. More information about a successful match can be obtained by querying the state of the matcher.\n" +
                "\n" +
                "A matcher finds matches in a subset of its input called the region. By default, the region contains all of the matcher's input. The region can be modified via theregion method and queried via the regionStart and regionEnd methods. The way that the region boundaries interact with some pattern constructs can be changed. See useAnchoringBounds and useTransparentBounds for more details.\n" +
                "\n" +
                "This class also defines methods for replacing matched subsequences with new strings whose contents can, if desired, be computed from the match result. The appendReplacement and appendTail methods can be used in tandem in order to collect the result into an existing string buffer, or the more convenient replaceAll method can be used to create a string in which every matching subsequence in the input sequence is replaced.\n" +
                "\n" +
                "The explicit state of a matcher includes the start and end indices of the most recent successful match. It also includes the start and end indices of the input subsequence captured by each capturing group in the pattern as well as a total count of such subsequences. As a convenience, methods are also provided for returning these captured subsequences in string form.\n" +
                "\n" +
                "The explicit state of a matcher is initially undefined; attempting to query any part of it before a successful match will cause an IllegalStateException to be thrown. The explicit state of a matcher is recomputed by every match operation.\n" +
                "\n" +
                "The implicit state of a matcher includes the input character sequence as well as the append position, which is initially zero and is updated by the appendReplacement method.\n" +
                "\n" +
                "A matcher may be reset explicitly by invoking its reset() method or, if a new input sequence is desired, its reset(CharSequence) method. Resetting a matcher discards its explicit state information and sets the append position to zero.\n" +
                "\n" +
                "Instances of this class are not safe for use by multiple concurrent threads.";

        String[] words = text.replaceAll("[,.;]", "").split("\\s+");
        for(String word : words) {
            System.out.println(word);
        }
    }
}
