package com.yky.test.solve;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/**
 * 字符串分隔的工具类
 */
public class StringBreakUtil {
    /**
     * 根据字典中的单词分隔字符串
     * @param s 待分隔的字符串
     * @param dict 用于匹配的字典
     * @return 分隔好的字符串set集合
     */
    public static List<String> wordBreak(String s, Set<String> dict) {
        List<String> list = new ArrayList<String>();
        List<String> ret = new ArrayList<String>();
        rec(s, dict, list, ret);
        return ret;
    }

    /**
     *将字符串进行分隔操作，将分隔好的字符串保存在set集合返回
     * @param s 待分隔的字符串
     * @param dict 用于匹配的字典
     * @param list 保存已经分隔的单词集合
     * @param ret 保存已经分隔完成的完整单词集合
     */
    public static void rec(String s, Set<String> dict, List<String> list, List<String> ret) {
        if(!isBreak(s, dict)){  // test before run to avoid TLE
            return;
        }
        if(s.length() == 0) {
            String concat = "";
            for(int i=0; i<list.size(); i++) {
                concat += list.get(i);
                if(i != list.size()-1) {
                    concat += " ";
                }
            }
            ret.add(concat);
            return;
        }

        for(String cur : dict) {
            if(cur.length() > s.length()) {
                continue;
            }
            String substr = s.substring(0, cur.length());
            if(substr.equals(cur)) {
                list.add(substr);
                rec(s.substring(cur.length()), dict, list, ret);
                list.remove(list.size()-1);
            }
        }
    }

    /**
     * 判断字典中的单词是否能将字符串完全匹配
     * @param s 待分隔的字符串
     * @param dict 单词字典
     * @return 能完全匹配返回true，不能返回folse
     */
    public static boolean isBreak(String s, Set<String> dict) {
        boolean[] canBreak = new boolean[s.length()+1];
        canBreak[0] = true;

        for(int i=1; i<=s.length(); i++) {
            boolean flag = false;
            for(int j=0; j<i; j++) {
                if(canBreak[j] && dict.contains(s.substring(j,i))) {
                    flag = true;
                    break;
                }
            }
            canBreak[i] = flag;
        }
        return canBreak[s.length()];
    }
}
