<%-- 
    Document   : addWorkout
    Created on : Nov 7, 2012, 11:08:38 AM
    Author     : Justin walrath <walrathjaw@gmail.com>
--%>

<%@page import="containers.*"%>
<%@page import="db.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Weight Tracker - Add a workout</title>
        <link href="/Weight%20Tracker/Styles/homeStyle.css" rel="stylesheet">
    </head>
    <body>
        
<%
    ConnectDB db = new ConnectDB(DatabaseInformation.getUsername(), DatabaseInformation.getPassword(), DatabaseInformation.getDbAddress());
    Exercise[] exercises = db.getExercises();

    if(session.getAttribute("errorMessage") != null)
    {
%>
        <div id="banner"><p id="errorDisplay"><%= session.getAttribute("errorMessage") %></p></div>
<%
        session.setAttribute("errorMessage", null);
    }
%>
        
        <a href="/Weight%20Tracker/"><img src="/Weight%20Tracker/Images/returnHome.png"></a>
        <form id="userAddForm" action="AddWorkout" method="post">
            <table id="userInputForm">
                <tr>
                    <th id="addTableHeader" colspan="3">Record your workout!</th>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>How long was the workout?</td>
                    <td><input class="loginTextDesign" id="lengthInput" name="workoutLength" type="text" onfocus="clearLength(this)" onblur="repopulateLength(this)" value="000"></td>
                    <td>Minutes</td>
                </tr>
                <tr>
                    <td>Exercise:</td>
                    <td><select id="exerciseSelect" size="1" name="exercise">                
<%
    for(Exercise i : exercises)
    {
%>
                            <option value="<%=String.valueOf(i.getExerciseId())%>"><%=i.getExerciseName()%></option>
<%
    }
%>
                        </select></td>
                    <td class="setLabelWidth2"><a href="/Weight%20Tracker/addExercise.jsp">Don't see your exercise?</a></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td><a href="/Weight%20Tracker/">Return</a></td>
                    <td>&nbsp;</td>
                    <td><input id="JoinButton" name="add" value="Add!" type="submit"</td>
                </tr>
            </table>
        </form>
        <!--Placing the Javascript at the end just incase. That way it won't hick up the page-->
        <script src="/Weight%20Tracker/Scripts/addWorkout.js" type="text/javascript"></script>
    </body>
</html>
