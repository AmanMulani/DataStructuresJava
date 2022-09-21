package Strings.StringPermutations;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

    public String str;
    private final int length;

    public StringPermutations(String str) {
        this.str = str;
        this.length = str.length();
    }

    public List<String> getPermutations() {
        List<String> permutations = new ArrayList<>();
        permutations(str, 0, permutations);
        return permutations;
    }

    public List<String> getPermutationsBacktracking() {
        List<String> permutations = new ArrayList<>();
        permutations(new StringBuilder(str), 0, permutations);
        return permutations;
    }

    private void permutations(String str, int currIndex, List<String> permutations) {

        //A recursive implementation without backtracking
        if(currIndex == this.length - 1) {
            permutations.add(str);
            return;
        }

        for(int i = currIndex; i<this.length; i++) {
            String newString = replaceCharacters(str, currIndex, i);
            permutations(newString, currIndex+1, permutations);
        }
    }

    private void permutations(StringBuilder str, int currIndex, List<String> permutations) {
        //A recursive implementation with backtracking
        if(currIndex == this.length - 1) {
            permutations.add(str.toString());
            return;
        }

        for(int i = currIndex; i<this.length; i++) {
            replaceCharacters(str, currIndex, i);
            permutations(str, currIndex+1, permutations);

            //Backtracking step
            replaceCharacters(str, i, currIndex);
        }
    }

    private void replaceCharacters(StringBuilder str, int idx1, int idx2) {
        //Function overloading
        //Since StringBuilder objects are mutable, we swap the characters in-place.
        char ch1 = str.charAt(idx1);
        char ch2 = str.charAt(idx2);
        str.setCharAt(idx1, ch1);
        str.setCharAt(idx2, ch2);
    }

    private String replaceCharacters(String str, int currIndex, int requiredIndex) {

        //Function overloading
        //Since String objects are immutable, we create a new String where the required characters are swapped.

        StringBuilder newString = new StringBuilder();
        for(int i = 0; i<currIndex; i++) {
            newString.append(str.charAt(i));
        }

        char ch1 = str.charAt(currIndex);
        char ch2 = str.charAt(requiredIndex);

        for(int i = currIndex; i<this.length; i++) {
            if(i == currIndex) {
                newString.append(ch2);
            } else if (i == requiredIndex) {
                newString.append(ch1);
            } else {
                newString.append(str.charAt(i));
            }
        }

        return newString.toString();
    }
}
