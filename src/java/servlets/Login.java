package servlets;

import data.DB;
import entity.User;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jamie
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> users = new ArrayList();
        try {
            ResultSet rs = DB.getConnection().prepareStatement("SELECT * FROM login").executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                int balance = rs.getInt(4);
                users.add(new User(id, username, password, balance));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        request.getSession().setAttribute("users", users);
        response.sendRedirect("userlist.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            String sql = "SELECT password from login where username=?;";
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            String dbPass = rs.getString(1);

            if (!password.equals(dbPass)) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                sql = "SELECT balance from login where username=?;";
                pstmt = DB.getConnection().prepareStatement(sql);
                pstmt.setString(1, username);
                rs = pstmt.executeQuery();
                rs.next();
                int balance = rs.getInt(1);
                request.getSession().setAttribute("username", username);
                request.getSession().setAttribute("balance", balance);

                request.getRequestDispatcher("shop.jsp").forward(request, response);
            }
//            response.getWriter().print("Succes. The user " + username + " has been added in the system.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
