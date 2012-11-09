/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import containers.DatabaseInformation;
import containers.User;
import db.ConnectDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Changes the users email address
 * @author Justin Walrath
 */
public class ChangeEmail extends HttpServlet
{

   /**
     * Handles the HTTP <code>POST</code> method.
     * 
     * @author Justin Walrath <walrathjaw@gmail.com>
     * @since 11/4/12
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        String email = (String)request.getParameter("email");
        HttpSession session = request.getSession();
        
        User member = (User)session.getAttribute("userInfo");
        ConnectDB db = new ConnectDB(DatabaseInformation.getUsername(), DatabaseInformation.getPassword(), DatabaseInformation.getDbAddress());
        
        String errorMessage = db.setEmail(member.getUsername(), email);
        
        if(errorMessage.startsWith("SUCCESS"))
        {
            errorMessage = "Your email has been updated successfully";
            member.setEmail(email);
            session.setAttribute("userInfo", member);
        }
        
        session.setAttribute("errorMessage", errorMessage);

        String url = "/home.jsp";
        RequestDispatcher dispatch = getServletContext().getRequestDispatcher(url);
        dispatch.forward(request, response);
    }
}