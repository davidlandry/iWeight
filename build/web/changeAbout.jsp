<%-- 
    Document   : changeAbout
    Created on : Nov 8, 2012, 11:55:05 PM
    Author     : Justin Walrath
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
        <form id="userAddForm" action="ChangeAbout" method="post">
            <table id="userInputForm">
                <tr>
                    <th id="addTableHeader" colspan="4">Enter your new profile!</th>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>Personal Description:</td>
                    <td colspan="3"><textarea class="aboutInputDesign" id="aboutInformation" name="aboutInformation" rows="4" cols="50" onfocus="clearTextArea(this)" onblur="repopulateTextArea(this)">Enter some information about yourself..</textarea></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td><a href="/Weight%20Tracker/home.jsp">Return</a></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td><input id="JoinButton" name="add" value="Update!" type="submit"</td>
                </tr>
            </table>
        </form>
        <!--Placing the Javascript at the end just incase. That way it won't hick up the page-->
        <script src="/Weight%20Tracker/Scripts/changeAbout.js" type="text/javascript"></script>
    </body>
</html>

