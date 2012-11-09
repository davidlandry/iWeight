<%-- 
    Document   : addExerciseType
    Created on : Nov 6, 2012, 11:30:04 AM
    Author     : Justin Warlrath
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Weight Tracker - Add Exercise Type</title>
        <link href="/Weight%20Tracker/Styles/homeStyle.css" rel="stylesheet">
    </head>
    <body>
        
<%
    if(session.getAttribute("errorMessage") != null)
    {
%>
        <div id="banner"><p id="errorDisplay"><%= session.getAttribute("errorMessage") %></p></div>
<%
        session.setAttribute("errorMessage", null);
    }
%>
        
        <a href="/Weight%20Tracker/"><img src="/Weight%20Tracker/Images/returnHome.png"></a>
        <form id="userAddForm" action="AddExerciseType" method="post">
            <table id="userInputForm">
                <tr>
                    <th id="addTableHeader" colspan="4">Create an exercise Type!</th>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td class="setLabelWidth">Exercise Type:</td>
                    <td><input class="loginTextDesign" id="typeInput" name="exerciseType" type="text" onfocus="clearType(this)" onblur="repopulateType(this)" value="Enter Exercise Type"></td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td><a href="/Weight%20Tracker/addExercise.jsp">Return</a></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td><input id="JoinButton" name="add" value="Add!" type="submit"</td>
                </tr>
            </table>
        </form>
        <!--Placing the Javascript at the end just incase. That way it won't hick up the page-->
        <script src="/Weight%20Tracker/Scripts/addExerciseType.js" type="text/javascript"></script>
    </body>
</html>
