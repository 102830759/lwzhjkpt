package com.hdsx.hession.servlet;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kimbo on 2017/2/21.
 */
public class HessianHttpRequestHandlerServlet extends HttpServlet {
    private HttpRequestHandler target;
    private WebApplicationContext wac;
    public HessianHttpRequestHandlerServlet() {
    }
    public void init() throws ServletException {
        this.wac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo=request.getPathInfo();
        int index=pathInfo.lastIndexOf("/");
        this.target = (HttpRequestHandler)wac.getBean(pathInfo.substring(index+1), HttpRequestHandler.class);
        LocaleContextHolder.setLocale(request.getLocale());
        try {
            this.target.handleRequest(request, response);
        } catch (HttpRequestMethodNotSupportedException var8) {
            String[] supportedMethods = var8.getSupportedMethods();
            if(supportedMethods != null) {
                response.setHeader("Allow", StringUtils.arrayToDelimitedString(supportedMethods, ", "));
            }
            response.sendError(405, var8.getMessage());
        } finally {
            LocaleContextHolder.resetLocaleContext();
        }

    }
}
