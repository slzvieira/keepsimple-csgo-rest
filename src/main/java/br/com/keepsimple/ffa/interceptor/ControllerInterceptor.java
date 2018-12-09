package br.com.keepsimple.ffa.interceptor;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ControllerInterceptor implements HandlerInterceptor {

    private static final Log log = LogFactory.getLog(ControllerInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        String requestURI = request.getRequestURI();
        if (requestURI == null || !requestURI.startsWith("/kills") ) {
            return true;
        }

//        log.info(getContent(request));

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
                    throws Exception {
        // do nothing
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // do nothing
    }
    
    private String getContent(HttpServletRequest request) throws IOException {

        StringBuilder uri = new StringBuilder();
        uri.append("[URI=");
        uri.append(request.getRequestURL());
        String queryString = request.getQueryString();
        
        if (queryString != null) {
            uri.append("?").append(queryString);
        }

        ServletInputStream is = request.getInputStream();
        
        if (is == null) {
            return uri.append("]").toString();
        }


        uri.append("; Body: ");
        
        Reader reader = new InputStreamReader(is, Charset.forName("UTF-8"));
        char[] buffer = new char[1024];
        int size;
        
        while ((size = reader.read(buffer)) > 0) {
            uri.append(buffer, 0, size);
        }
        
        return uri.append("]").toString();
    }
}
