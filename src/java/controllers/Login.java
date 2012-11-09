package controllers;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import db.*;
import containers.*;

/**
 *
 * @author Justin Walrath
 */
public class Login extends HttpServlet
{
    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String passwd = request.getParameter("password");
        String nextTask = "guest";
        String url = "/home.jsp";
        
        ConnectDB db = new ConnectDB(DatabaseInformation.getUsername(), DatabaseInformation.getPassword(), DatabaseInformation.getDbAddress());
        
        User member = db.login(username, passwd);
        if(member != null)
        {
            nextTask = "loggedIn";
        }
        else
        {
            url = "/loginPage.jsp";
        }
        
        session.setAttribute("userInfo", member);
        session.setAttribute("action", nextTask);

        RequestDispatcher dispatch = getServletContext().getRequestDispatcher(url);
        dispatch.forward(request, response);
    }
}
