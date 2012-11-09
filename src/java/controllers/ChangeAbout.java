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
 * @since 11/8/12
 */
public class ChangeAbout extends HttpServlet
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
        String aboutInformation = (String)request.getParameter("aboutInformation");
        HttpSession session = request.getSession();
        
        User member = (User)session.getAttribute("userInfo");
        ConnectDB db = new ConnectDB(DatabaseInformation.getUsername(), DatabaseInformation.getPassword(), DatabaseInformation.getDbAddress());
        
        String errorMessage = db.setAbout(member.getUsername(), aboutInformation);
        
        if(errorMessage.startsWith("SUCCESS"))
        {
            member.setAboutInformation(aboutInformation);
            errorMessage = "Your about information has been updated successfully";
            
            session.setAttribute("userInfo", member);
        }
        
        session.setAttribute("errorMessage", errorMessage);

        String url = "/changeAbout.jsp";
        RequestDispatcher dispatch = getServletContext().getRequestDispatcher(url);
        dispatch.forward(request, response);
    }
}
