import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "GBFilter")
public class GBFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String encoding=request.getCharacterEncoding();//原来的编码
        System.out.println("before encoding " + encoding + " filter！");
        encoding="utf-8";//新编码
        request.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset="+encoding);
        chain.doFilter(request, response);
        System.out.println("after encoding " + encoding + " filter！");
        System.err.println("----------------------------------------");


        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
