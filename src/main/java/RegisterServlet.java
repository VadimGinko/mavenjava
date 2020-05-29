import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/servlet?autoReconnect=true&useSSL=false";
    private static final String DB_NAME = "root";
    private static final String DB_PASSWORD = "6788393vadim";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        if(name =="" && pass=="")
        {
            throw new RuntimeException();
        }
        try {

            //creating connection with the database
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            PreparedStatement ps = connection.prepareStatement
                    ("insert into account values(?,?,'user')");

            ps.setString(1, name);
            ps.setString(2, pass);
            int i = ps.executeUpdate();
            String path = "/RegisterForm";
            if(i > 0) {
                //если успешно зарешистрирован переходим на логин

                String path2 = request.getContextPath() + "/LoginForm";
                response.sendRedirect(path2);
            }

        }
        catch(Exception se) {
            request.setAttribute("code", "1");
            String path = "/RegisterForm";
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
            requestDispatcher.forward(request, response);
            se.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
