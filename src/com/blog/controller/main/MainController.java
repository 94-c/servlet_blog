package com.blog.controller.main;

import com.blog.controller.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("main 경로 진입");
        System.out.println("main 경로 진입 2");
        return "RequestDispatcher:/jsp/main/main.jsp";
    }
}
