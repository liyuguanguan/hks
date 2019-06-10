package com.moji.hks.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: liyu.guan
 * @Date: 2019/6/10 上午9:33
 */
public class CodeUtil {

    /**
     * 将获取到的前端参数转为string类型
     * @param request
     * @param key
     * @return
     */
    public static String getString(HttpServletRequest request, String key) {
        try {
            String result = request.getParameter(key);
            if(result != null) {
                result = result.trim();
            }
            if("".equals(result)) {
                result = null;
            }
            return result;
        }catch(Exception e) {
            return null;
        }
    }
    /**
     * 验证码校验
     * @param request
     * @return
     */
    public static boolean checkVerifyCode(HttpServletRequest request,  String  code) {
        //获取生成的验证码
        String verifyCodeExpected = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        //获取用户输入的验证码
//        String verifyCodeActual = CodeUtil.getString(request, "verifyCodeActual");
        if(code == null ||!code.equalsIgnoreCase(verifyCodeExpected)) {
            return false;
        }
        return true;
    }

}
