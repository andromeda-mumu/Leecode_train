package com.mumu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjiao on 2020/8/6.
 * description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class String_05 {
    /**
     * 思路:
     * 1.假设 nabcbab ,肯定有笨方法，先想一个方法出来。
     *       babcban 先翻转一下，然后比较共同相同的部分。
     * 2.iiabaxxxxx   显然只有aba是回文字串
     *   xxxxxabaii
     *
     * */

    public static void main(String[] args) {
        System.out.println(10);
    }
    private String handle(String str){
        if(str==null || "".equals(str))
            return "";
        if(str.length()==1)
            return "字符串太短，不构成回文字串";
        /** 翻转字符串 */
        char[] chars = new char[str.length()];//=========开销
        for(int i=0;i<chars.length;i++){
            chars[i]= str.charAt(str.length()-i-1);
        }
        String reverseStr = chars.toString();
        System.out.println("reverseStr:"+reverseStr);

        /** 比较是否相等 */
        int index = 0;
        //存错所有回文字串
        List<String> allHuiwen = new ArrayList<>();
        StringBuffer sb = new StringBuffer();//=========开销
        for(int i=0;i<str.length();i++){
            char reChar = reverseStr.charAt(i);
            char oriChar = str.charAt(i);
            if(reChar==oriChar){
                sb.append(reChar);
                continue;
            }else{
                //判断sb中是否大于3 ，因为两个
            }
        }

    }
}
