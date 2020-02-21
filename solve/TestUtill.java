package com.yky.test.solve;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 测试类
 */
public class TestUtill {
    public static void main(String[] args){
        BreakStringService service = new BreakStringService();
        Set<String> dict = new HashSet<>();
        String[] arr = {"i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "man go"};
        dict.addAll(Arrays.asList(arr));
        service.setDict(dict);
        String str = "ilikesamsungmobile";

        // Stage1
        List<String> result = service.solveWithDefaultDict(str);
        System.out.println("stage1");
        result.forEach((data) ->System.out.println(data));

        // Stage2
        String[] arr2 = { "i", "like", "sam", "sung", "mobile", "icecream", "man go", "mango"};
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(arr2));
        List<String> result2 = service.solveWithCustomDict(str, set);
        System.out.println("stage2");
        result2.forEach((data) ->System.out.println(data));

        // Stage3
        List<String> result3 = service.solveStringWithMixDict(str, set);
        System.out.println("stage3");
        result3.forEach((data) ->System.out.println(data));
    }
}
