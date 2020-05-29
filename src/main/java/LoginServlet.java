import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static Connection connection;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/servlet?autoReconnect=true&useSSL=false";
    private static final String DB_NAME = "root";
    private static final String DB_PASSWORD = "6788393vadim";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Account> basket = new ArrayList<Account>();
        try {
            connection = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
        } catch (SQLException  e) {
            e.printStackTrace();
        }

        boolean flag = true;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        PreparedStatement preparedStatement = null;

        ResultSet res;

        String zap = "SELECT * FROM account";
        try {
            preparedStatement = connection.prepareStatement(zap);
            res = preparedStatement.executeQuery();
            while (res.next()) {
                Account acc = new Account();
                acc.name = res.getString("name");
                acc.password = res.getString("password");
                acc.role = res.getString("role");
                if (login.equals(acc.name) && password.equals(acc.password)) {
                    flag = false;
                    Date date = new Date();
                    // получаем сессию
                    HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(-1);
                    session.setAttribute("name",acc.name);
                    Cookie cookie = new Cookie(acc.name, acc.name + acc.role + new Date());
                    response.addCookie(cookie);
                    //на стартовую страницу
                    String path2 = request.getContextPath();
                    response.sendRedirect(path2);
                }
                //basket.add(acc);
            }
            if(flag)
            {
                //если не зарегистрирован
                String path = "/LoginForm";
                request.setAttribute("code2", "1");
                ServletContext servletContext = getServletContext();
                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
                requestDispatcher.forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        protected void doGet(HttpServletRequest request, HttpServletResponse response){
            String q = new String();
        }
}
