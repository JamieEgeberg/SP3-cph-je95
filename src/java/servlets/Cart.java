/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import data.DB;
import entity.Cupcake;
import entity.Orderline;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jamie
 */
@WebServlet(name = "Cart", urlPatterns = {"/Cart"})
public class Cart extends HttpServlet {

    List<Orderline> lines = new ArrayList();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {

            String origin = request.getParameter("origin");
            request.getSession().setAttribute("origin", origin);
            switch (origin) {
                case "add":
                    String top = request.getParameter("Top");
                    String bottom = request.getParameter("Bottom");

                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    Orderline ol = new Orderline(new Cupcake(top, bottom), quantity);
                    lines.add(ol);

                    request.getSession().setAttribute("lines", lines);
                    response.sendRedirect("shop.jsp");
                    break;
                case "buy":
                    String total = request.getParameter("total");
                    String username = (String) request.getSession().getAttribute("username");
                    String sql = "update login set balance=balance-? where username=?;";
                    PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
                    pstmt.setString(1, total);
                    pstmt.setString(2, username);
                    pstmt.executeUpdate();
                    sql = "SELECT balance from login where username=?;";
                    pstmt = DB.getConnection().prepareStatement(sql);
                    pstmt.setString(1, username);
                    ResultSet rs = pstmt.executeQuery();
                    rs.next();
                    int balance = rs.getInt(1);
                    request.getSession().setAttribute("balance", balance);
                    lines.clear();

                    request.getSession().setAttribute("lines", lines);
                    response.sendRedirect("shop.jsp");
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
