package com.imzz.webchat.utils;

/**
 * @Author: james
 * @Description: This is description
 * @Date: created in 18:08 2018/8/21
 * @Modified By:
 **/
public class ForMatJSONStr {

    /**
     * 得到格式化json数据  退格用\t 换行用\r
     * @param jsonStr
     * @return
     */
    public static String format(String jsonStr) {
        int level = 0;
        StringBuffer jsonForMatStr = new StringBuffer();
        for(int i = 0;i < jsonStr.length();i++){
            char c = jsonStr.charAt(i);
            if(level > 0 && '\n' == jsonForMatStr.charAt(jsonForMatStr.length() - 1)){
                jsonForMatStr.append(getLevelStr(level));
            }
            switch (c) {
                case '{':
                case '[':
                    jsonForMatStr.append(c+"\n");
                    level++;
                    break;
                case ',':
                    jsonForMatStr.append(c+"\n");
                    break;
                case '}':
                case ']':
                    jsonForMatStr.append("\n");
                    level--;
                    jsonForMatStr.append(getLevelStr(level));
                    jsonForMatStr.append(c);
                    break;
                default:
                    jsonForMatStr.append(c);
                    break;
            }
        }
        return jsonForMatStr.toString();
    }

    private static String getLevelStr(int level){

        StringBuffer levelStr = new StringBuffer();

        for(int levelI = 0;levelI < level; levelI++){
            levelStr.append("\t");
        }

        return levelStr.toString();
    }
}
