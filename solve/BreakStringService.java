package com.yky.test.solve;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 提供字符串分隔的服务
 */
public class BreakStringService {
    /**
     * 默认字典
     */
    private Set<String> dict;

    /**
     * 设置默认字典的数据
     * @param dict
     */
    public void setDict(Set<String> dict){
        this.dict = dict;
    }

    /**
     * 使用默认字典分隔字符串
     * @param str
     * @return
     */
    public List<String> solveWithDefaultDict(String str){
        return StringBreakUtil.wordBreak(str, dict);
    }

    /**
     * 使用业务指定的字典分隔字符串
     * @param str
     * @param customDict
     * @return
     */
    public List<String> solveWithCustomDict(String str, Set<String> customDict){
        return StringBreakUtil.wordBreak(str, customDict);
    }

    /**
     * 使用业务指定字典和默认字典混合后得到的字典合集分隔字符串
     * @param str
     * @param customDict
     * @return
     */
    public List<String> solveStringWithMixDict(String str, Set<String> customDict){
        Set<String> mixDict = new HashSet<>();
        mixDict.addAll(customDict);
        mixDict.addAll(dict);
        return StringBreakUtil.wordBreak(str, mixDict);
    }
}
