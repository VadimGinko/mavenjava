import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "AddServlet", urlPatterns = "/AddServlet")
public class AddServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/servlet?autoReconnect=true&useSSL=false";
    private static final String DB_NAME = "root";
    private static final String DB_PASSWORD = "6788393vadim";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String Name = request.getParameter("addname");
        String Type = request.getParameter("addtype");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = connection.prepareStatement
                    ("insert into newspapers values(?,?)");
            if(Name != "" && Type != "") {
                ps.setString(1, Name);
                ps.setString(2, Type);
                String path2 = request.getContextPath();
                response.sendRedirect(path2 + "/home");
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
