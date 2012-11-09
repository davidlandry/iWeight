/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import db.*;
import containers.*;

/**
 * Calls connections to the database and adds a user.
 * 
 * @author Justin Walrath
 * @since 11/4/12
 */
public class AddUser extends HttpServlet
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
        String username = (String)request.getParameter("username");
        String password = (String)request.getParameter("password");
        String firstName = (String)request.getParameter("firstName");
        String lastName = (String)request.getParameter("lastName");
        int weight = Integer.parseInt((String)request.getParameter("initialWeight"));
        String email = (String)request.getParameter("email");
        String aboutInformation = (String)request.getParameter("aboutInformation");
        String nextTask;
        HttpSession session = request.getSession();
        
        User newMember = new User(username, password, firstName, lastName, weight, email, aboutInformation);
        ConnectDB db = new ConnectDB(DatabaseInformation.getUsername(), DatabaseInformation.getPassword(), DatabaseInformation.getDbAddress());
        
        String errorMessage = db.addUser(newMember);
        
        if(errorMessage.startsWith("The user has been added:"))
        {
            newMember.prepForSession();
            
            nextTask = "loggedIn";
            session.setAttribute("userInfo", newMember);
            session.setAttribute("action", nextTask);
            
            String url = "/home.jsp";
            RequestDispatcher dispatch = getServletContext().getRequestDispatcher(url);
            dispatch.forward(request, response);
        }
        else
        {
            if(errorMessage.contains("Duplicate entry") && errorMessage.contains("'username'"))
            {
                errorMessage = "'" + newMember.getUsername() + "' has already been taken, try another username.";
            }
            nextTask = "guest";
            session.setAttribute("userInfo", null);
            session.setAttribute("action", nextTask);
            session.setAttribute("errorMessage", errorMessage);
            
            String url = "/addUserPage.jsp";
            RequestDispatcher dispatch = getServletContext().getRequestDispatcher(url);
            dispatch.forward(request, response);
        }
    }
}
