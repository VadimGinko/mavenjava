import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

@WebServlet(name = "InfoServlet", urlPatterns = "/InfoServlet")
public class InfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("<html> <head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <title>Тег META, атрибут charset</title>\n" +
                " </head>");
        pw.println("<h3>");
        pw.println("method " + new Date());        pw.println("</h3>");
        pw.println("<h3>");
        pw.println("method " + request.getMethod());
        pw.println("</h3>");

        pw.println("<h3>");
        pw.println("URL "+ request.getRequestURL());
        pw.println("</h3>");

        pw.println("<h3>");
        pw.println("IP " + request.getRemoteAddr());
        pw.println("</h3>");

        pw.println("<h3>");
        pw.println("Port " + request.getRemotePort());
        pw.println("</h3>");

        pw.println("<h3>");
        pw.println("Http-string " + request.getQueryString());
        pw.println("</h3>");

        Cookie[] cookies = request.getCookies();
        int q2 = cookies.length;
        String cookieName = "vad";
        Cookie coo = null;
        if(cookies !=null) {
            for(Cookie c: cookies) {
                if(cookieName.equals(c.getName())) {
                    coo = c;
                    break;
                }
            }
        }
        pw.println("<h3>");
        pw.println("cookie:");


        if(coo != null)
        {
            String q = coo.getValue();
            pw.println(q);
        }

        pw.println("</h3>");
        Enumeration< String > e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            String value = request.getHeader(name);
            pw.println(name + " = " + value);
        }
        pw.println("</html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
