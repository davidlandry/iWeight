/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import containers.*;
import db.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author justin
 */
public class AddWorkout extends HttpServlet
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
        String errorMessage = "";
        HttpSession session = request.getSession();
        ConnectDB db = new ConnectDB(DatabaseInformation.getUsername(), DatabaseInformation.getPassword(), DatabaseInformation.getDbAddress());
        String url = "/addWorkout.jsp";
        RequestDispatcher dispatch;
        
        if (request.getRequestedSessionId() != null && !request.isRequestedSessionIdValid())
        {
            if(session.getAttribute("userInfo") == null)
            {
                url = "/home.jsp";
                dispatch = getServletContext().getRequestDispatcher(url);
                errorMessage = "You must be logged in to continue";
                dispatch.forward(request, response);
            }
            
        }
        User member = (User)session.getAttribute("userInfo");
        
        Workout workout = new Workout(member.getUserId(), Integer.parseInt(request.getParameter("exercise")), Integer.parseInt(request.getParameter("workoutLength")));
        
        errorMessage = db.recordWorkout(workout);
        
        session.setAttribute("errorMessage", errorMessage);
        
        dispatch = getServletContext().getRequestDispatcher(url);
        dispatch.forward(request, response);
    }
}