package Strings;

import Strings.StringPermutations.StringPermutations;
import Strings.Subsequences.Subsequences;

public class Main {
    public static void main(String[] args) {

        StringPermutations strPerm = new StringPermutations("abc");
        System.out.println("Without backtracking: " + strPerm.getPermutations());
        System.out.println("Backtracking: " + strPerm.getPermutationsBacktracking());

        Subsequences subsequences = new Subsequences("abc");
        System.out.println("Subsequences: " + subsequences.getSubsequences());

    }
}
