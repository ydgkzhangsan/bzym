package com.ydgk.springmvc;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author kfstart
 * @descrption
 * @create 2020-06-19 14:51
 */
@Component
public class MyView implements View {
    /*
    视图返回的类型
     */
    @Override
    public String getContentType() {
        return "html/text";
    }
    /*
    渲染视图的方法
     */
    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.getWriter().write("This My View~~~~~~");
    }
}
