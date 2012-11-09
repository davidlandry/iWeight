/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import containers.*;
import db.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 *
 * @author Justin Walrath <walrathjaw@gmail.com>
 */
@WebServlet(name = "AddLocation", urlPatterns =
{
    "/AddLocation"
})
public class AddLocation extends HttpServlet
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
        ConnectDB db = new ConnectDB(DatabaseInformation.getUsername(), DatabaseInformation.getPassword(), DatabaseInformation.getDbAddress());
        
        String errorMessage = db.addLocation(request.getParameter("location"));
        
        session.setAttribute("errorMessage", errorMessage);
            
        String url = "/addLocation.jsp";
        RequestDispatcher dispatch = getServletContext().getRequestDispatcher(url);
        dispatch.forward(request, response);
    }
}