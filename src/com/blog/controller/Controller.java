package com.blog.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class Controller extends HttpServlet{

    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String requestURl = request.getRequestURI();
        String contextPath = request.getContextPath();
        String command = requestURl.substring(contextPath.length());

        Action action = null;
        String forward = null;

        ServletContext context = getServletContext();
        String fullPath = context.getRealPath("/WEB-INF/class.properties");
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(fullPath);

        properties.load(fileInputStream);
        fileInputStream.close();

        String classPath = properties.getProperty(command);

        //System.out.printIn(command + "----------" + fullPath);
        try{
            Class<?> url = Class.forName(classPath);
            action = (Action) url.newInstance();
            try{
                forward = action.execute(request, response);
            } catch (Exception e){
                //세션 잃어버렸는데, 작업을 진행할 떄
            }
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }catch (InstantiationException ex){
            ex.printStackTrace();
        }catch (IllegalAccessException ex){
            ex.printStackTrace();
        }catch (NullPointerException ex){
            {
                ex.printStackTrace();
            }
            if (forward != null) {
                if (forward.contains("RequestDispatchar:")){
                    String jspName = (forward.split(":")[1]);
                    request.getRequestDispatcher("WEB-INF/" + forward.split(":")[1]).forward(request, response);
                }else {
                    PrintWriter pr = response.getWriter();
                    pr.print(forward);
                    pr.flush();
                    pr.close();
                }
            }
        }

    }
}
