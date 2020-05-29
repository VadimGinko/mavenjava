import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "Task6SecondServlet", urlPatterns = "/Task6SecondServlet")
public class Task6SecondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("<html> <head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <title>Тег META, атрибут charset</title>\n" +
                " </head>");
        pw.println("<h3>");
        String spam = (String) request.getAttribute("res");
        pw.println("param: " + spam);
        pw.println("<h3>");
        pw.println("</html");

        String path = "/Task6";
        request.setAttribute("res", spam);
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("<html> <head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <title>Тег META, атрибут charset</title>\n" +
                " </head>");
        pw.println("<h3>");
        String spam = (String) request.getAttribute("res");
        pw.println("get: " + spam);
        pw.println("<h3>");
        pw.println("</html");
    }
}
