package com.CK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        String s = "ababcbacadefegdehijhklij";
//        String s = "dccccbaabe";
        String s = "caedbdedda";
//        String s = "eaaaabaaec";
        Solution solution = new Solution();
        System.out.println(solution.partitionLabels(s).toString());
    }
}

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S.isEmpty()) return res;
        int left = 0, right = S.lastIndexOf(S.charAt(0)), lastIndex, preRes = -1;
        while (right < S.length()) {
            while (left < right) {
                lastIndex = S.lastIndexOf(S.charAt(left));
                if (lastIndex <= right) left++;
                else right = lastIndex;
            }
            res.add(right - preRes);
            preRes = right;
            if (right != S.length() - 1) left = right + 1;
            else break;
            right = S.lastIndexOf(S.charAt(left));
        }
        if (preRes != S.length() - 1) res.add(S.length() - 1 - preRes);
        return res;
    }
}
