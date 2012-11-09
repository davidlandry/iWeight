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
        <form id="userAddForm" action="ChangePassword" method="post">
            <table id="userInputForm">
                <tr>
                    <th id="addTableHeader" colspan="4">Change your password!</th>
                </tr>
                <tr>
                    <td>Enter your old password:</td>
                    <td><input class="loginTextDesign" id="oldPasswordInput" name="oldPassword" type="password" onfocus="clearPass(this)" onblur="repopulatePass(this)" value="        "</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>New Password:</td>
                    <td><input class="loginTextDesign" id="passwordInput" name="newPassword" type="password" onfocus="clearPass(this)" onblur="repopulatePass(this)" value="        "</td>
                    <td>Re-enter</td>
                    <td><input class="loginTextDesign" id="password2Input" name="passwordAgain" type="password" onfocus="clearPass(this)" onblur="repopulatePass(this)" value="        "</td>
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
        <script src="/Weight%20Tracker/Scripts/changePassword.js" type="text/javascript"></script>
    </body>
</html>

