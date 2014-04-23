package angulardemo.web.REST;

import com.google.inject.Singleton;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by saumil on 2014/04/23.
 */
@Singleton
public class ResponseCorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if ( request instanceof HttpServletRequest ) {
            HttpServletResponse changedResponse = (HttpServletResponse) response;
            addHeaderForResponse(HttpServletResponse.SC_OK, changedResponse);
        }
        chain.doFilter(request, response);
    }

    private void addHeaderForResponse(int responseCode, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "*, Cache-Control, Pragma, Origin, Authorization, X-Request-With, PUT, DELETE");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type, GET, OPTIONS, X-XSRF-TOKEN");
    }

    @Override
    public void destroy() {
    }
}
