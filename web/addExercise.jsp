<%-- 
    Document   : addExercise
    Created on : Nov 6, 2012, 4:14:35 PM
    Author     : Justin Walrath <walrathjaw@gmail.com>
--%>

<%@page import="containers.*"%>
<%@page import="db.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Weight tracker - Add Exercises</title>
        <link href="/Weight%20Tracker/Styles/homeStyle.css" rel="stylesheet">
    </head>
    <body>
        
<%
    ConnectDB db = new ConnectDB(DatabaseInformation.getUsername(), DatabaseInformation.getPassword(), DatabaseInformation.getDbAddress());
    ExerciseType[] exerciseTypes = db.getExerciseTypes();

    if(session.getAttribute("errorMessage") != null)
    {
%>
        <div id="banner"><p id="errorDisplay"><%= session.getAttribute("errorMessage") %></p></div>
<%
        session.setAttribute("errorMessage", null);
    }
%>
        
        <a href="/Weight%20Tracker/"><img src="/Weight%20Tracker/Images/returnHome.png"></a>
        <form id="userAddForm" action="AddExercise" method="post">
            <table id="userInputForm">
                <tr>
                    <th id="addTableHeader" colspan="4">Add an exercise!</th>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td class="setLabelWidth">Exercise Name:</td>
                    <td><input class="loginTextDesign" id="ExerciseInput" name="exerciseName" type="text" onfocus="clearExerciseName(this)" onblur="repopulateExerciseName(this)" value="Enter Exercise Name"></td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>Calories Burned/hour</td>
                    <td><input class="loginTextDesign" id="caloriesInput" name="calories" type="text" onfocus="clearCalories(this)" onblur="repopulateCalories(this)" value="Enter Calories Burned per Hour"></td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>Exercise Type:</td>
                    <td><select id="exerciseTypeSelect" size="1" name="exerciseType">                
<%
    for(ExerciseType i : exerciseTypes)
    {
%>
                            <option value="<%=String.valueOf(i.getExerciseTypeId())%>"><%=i.getExerciseTypeName()%></option>
<%
    }
%>
                        </select></td>
                    <td><a href="/Weight%20Tracker/addExerciseType.jsp">Don't see what you need.</a></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td><a href="/Weight%20Tracker/addWorkout.jsp">Return</a></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td><input id="JoinButton" name="add" value="Add!" type="submit"</td>
                </tr>
            </table>
        </form>
        <!--Placing the Javascript at the end just incase. That way it won't hick up the page-->
        <script src="/Weight%20Tracker/Scripts/addExercise.js" type="text/javascript"></script>
    </body>
</html>
