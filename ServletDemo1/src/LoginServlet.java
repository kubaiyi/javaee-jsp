import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("txtName");
        String password = request.getParameter("txtPwd");

        out.println("您好！" + username + " "+password + "<br>");
        Connection conn = null;
        ResultSet rs;
        PreparedStatement prep;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=JavaEE","root","123321");

            String sql = "select * from Students where username=? and password=?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, username);
            prep.setString(2, password);
            rs=prep.executeQuery();

            if (rs.next()) {
                out.println("您好！" + username + " "+password + "<br>");

                Cookie cooUserName= new Cookie("username", username);
                cooUserName.setMaxAge(60*60*24*7);
                response.addCookie(cooUserName);

                Cookie cooPwd= new Cookie("pwd", password);
                cooPwd.setMaxAge(60*60*24*7);
                response.addCookie(cooPwd);

                HttpSession session = request.getSession(true);
                session.setAttribute("username", username);

                String path = request.getContextPath();
                System.out.println("path:"+path);
                String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
                String page=basePath+"/page/index.html";
                System.out.println("basePath:"+basePath);
                response.sendRedirect(page);
            }
            else {
                out.println("错误的用户名和密码");
            }
            rs.close();
            conn.close();
            prep.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
