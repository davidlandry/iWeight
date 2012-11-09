/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import containers.DatabaseInformation;
import db.ConnectDB;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author justin
 */
public class AddExerciseType extends HttpServlet
{/**
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
        
        String errorMessage = db.addExerciseType(request.getParameter("exerciseType"));
        
        session.setAttribute("errorMessage", errorMessage);
            
        String url = "/addExerciseType.jsp";
        RequestDispatcher dispatch = getServletContext().getRequestDispatcher(url);
        dispatch.forward(request, response);
    }
}
