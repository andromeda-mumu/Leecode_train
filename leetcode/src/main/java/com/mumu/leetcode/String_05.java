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
     * 1-1.iiabcbaxxxxx   显然只有abcba是回文字串,看样子翻转字符串也不行。
     *   xxxxxabcbaii
     *
     * 2.先找到a的位置，有两个，然后各往后，往前，相等的话，继续往后往前，直至都指向同一个位置为止，那么就是回文了
     *   iiabcbaxxaxx
     *   用这个字符串分析：
     *      i的位置0,1. 相邻算一个回文吧。
     *      a的位置2,6,9 。往后往前 3‘b’,5'b',8'x' ,就3 5相等。下一步对这两个进行往前往后，4‘c’ 4'c'。直到startIndex+2=endIndex
     *
     *
     *
     * */

    public static void main(String[] args) {
//        for(int i=0;i<=26;i++){
//            System.out.print((char)(96+i));
//        }
        String result = handle_01("iiabcbaxxaxx");
        System.out.println("result:"+result);
    }
    /**
     * 先计算只有一个回文字串的情况
     * */
    public static String handle_01(String str){
        if(str==null || "".equals(str))
            return "";
        if(str.length()==1)
            return "字符串太短，不构成回文字串";
        str=str.toLowerCase();
        /**--------------思路验证02----------------*/
        //困难1，无法一次性获得一个字符在字符串中所有的位置
        String letters = "abcdefghijklmnopqrstuvwxyz";
        List<String> allHuiWen = new ArrayList<>();
        //加上字符串都是字母，没有特殊字符
        for(int i=0;i<letters.length();i++){
            char c =letters.charAt(i);
            int startIdx =str.indexOf(c);
            if(startIdx<str.length()){
                String tmpStr = str.substring(startIdx+1);
                int endIdx= tmpStr.indexOf(c);
                if(endIdx<0){//没有c,进行下一个
                    continue;
                }else{//有c,则往前往后
                    endIdx = startIdx+endIdx+1;//iiabcbaxxaxx
                    int s=startIdx;
                    int e=endIdx;
                    if(startIdx==str.length()-1 || endIdx==0){//那说明两个是紧挨着的，就没有必要往前往后了。
                        continue;
                    }
                    while (str.charAt(++startIdx)==str.charAt(--endIdx)){
                        if(startIdx==endIdx){
                            allHuiWen.add(str.substring(s,e+1));
                            System.out.println("最终结果："+str.substring(s,e+1));
                        }
                        if(startIdx==str.length()-1 || endIdx==0){//那说明两个是紧挨着的，就没有必要往前往后了。
                            break;
                        }
                    }
                }

            }

        }

        int maxLength = 0;
        String result="" ;
        for(int i=0;i<allHuiWen.size();i++){
            String s = allHuiWen.get(i);
            int len= s.length();
            if(len>maxLength){
                maxLength = len;
                result = s;
                continue;
            }
        }
        return result;



        /**------------------思路失败01-----------------------*/
//        /** 翻转字符串 */
//        char[] chars = new char[str.length()];//=========开销
//        for(int i=0;i<chars.length;i++){
//            chars[i]= str.charAt(str.length()-i-1);
//        }
//        String reverseStr = chars.toString();
//        System.out.println("reverseStr:"+reverseStr);

//        /** 比较是否相等 */
//        int index = 0;
//        //存错所有回文字串
//        List<String> allHuiwen = new ArrayList<>();
//        StringBuffer sb = new StringBuffer();//=========开销
//        for(int i=0;i<str.length();i++){
//            char reChar = reverseStr.charAt(i);
//            char oriChar = str.charAt(i);
//            if(reChar==oriChar){
//                sb.append(reChar);
//                continue;
//            }else{
//                //判断sb中是否大于3 ，因为两个
//            }
//        }

    }
}
