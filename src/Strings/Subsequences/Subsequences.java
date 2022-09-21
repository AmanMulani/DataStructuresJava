package Strings.Subsequences;

import java.util.ArrayList;
import java.util.List;

//Input = abc
//Output = [, c, b, bc, a, ac, ab, abc]

public class Subsequences {

    public String str;
    public final int length;

    public Subsequences(String str) {
        this.str = str;
        this.length = str.length();
    }

    public List<String> getSubsequences() {
        List<String> subsequences = new ArrayList<>();
        findSubsequences("", 0, subsequences);
        return subsequences;
    }

    private void findSubsequences(String str, int currIndex, List<String> subsequences) {

        if(currIndex == this.length) {
            subsequences.add(str);
            return;
        }

        findSubsequences(str, currIndex+1, subsequences);
        findSubsequences(str+this.str.charAt(currIndex), currIndex+1, subsequences);
    }


}
