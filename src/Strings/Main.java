package Strings;

import Strings.StringPermutations.StringPermutations;

public class Main {
    public static void main(String[] args) {

        StringPermutations strPerm = new StringPermutations("abc");
        System.out.println(strPerm.getPermutations().toString());
        System.out.println(strPerm.getPermutationsBacktracking().toString());



    }
}
