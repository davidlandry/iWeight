<%-- 
    Document   : addUserPage
    Created on : Nov 4, 2012, 11:38:00 AM
    Author     : Justin Walrath
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Weight Center - Register</title>
        <link href="/Weight%20Tracker/Styles/homeStyle.css" rel="stylesheet">
    </head>
    <body>
        <a href="/Weight%20Tracker/"><img src="/Weight%20Tracker/Images/returnHome.png"></a>
<%
    if(session.getAttribute("errorMessage") != null)
    {
%>
        <div id="banner"><p id="errorDisplay"><%= session.getAttribute("errorMessage") %></p></div>
<%
        session.setAttribute("errorMessage", null);
    }
%>
        <form id="userAddForm" action="AddUser" method="post">
            <table id="userInputForm">
                <tr>
                    <th id="addTableHeader" colspan="4">Enter your information and click join!</th>
                </tr>
                <tr>
                    <td>Username:</td>
                    <td><input class="loginTextDesign" id="usernameInput" name="username" type="text" onfocus="clearUsername(this)" onblur="repopulateUsername(this)" value="Enter a requested username"</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input class="loginTextDesign" id="passwordInput" name="password" type="password" onfocus="clearPass(this)" onblur="repopulatePass(this)" value="        "</td>
                    <td>Re-enter</td>
                    <td><input class="loginTextDesign" id="password2Input" name="passwordAgain" type="password" onfocus="clearPass(this)" onblur="repopulatePass(this)" value="        "</td>
                </tr>
                <tr>
                    <td>First Name:</td>
                    <td><input class="loginTextDesign" id="firstNameInput" name="firstName" type="text" onfocus="clearFirst(this)" onblur="repopulateFirst(this)" value="Enter First Name"</td>
                    <td>Last Name:</td>
                    <td><input class="loginTextDesign" id="lastNameInput" name="lastName" type="text" onfocus="clearLast(this)" onblur="repopulateLast(this)" value="Enter Last Name"</td>
                </tr>
                <tr>
                    <td>Initial Weight:</td>
                    <td><input class="loginTextDesign" id="initialWeight" name="initialWeight" type="text" onfocus="clearWeight(this)" onblur="repopulateWeight(this)" value="000"</td>
                    <td>In pounds!</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>Email Address:</td>
                    <td><input class="loginTextDesign" id="email" name="email" type="text" onfocus="clearEmail(this)" onblur="repopulateEmail(this)" value="Enter email address"</td>
                </tr>
                <tr>
                    <td>Personal Description:</td>
                    <td colspan="3"><textarea class="aboutInputDesign" id="aboutInformation" name="aboutInformation" rows="4" cols="50" onfocus="clearTextArea(this)" onblur="repopulateTextArea(this)">Enter some information about yourself..</textarea></td>
                </tr>
                <tr>
                    <td><a href="/Weight%20Tracker/">Return home</a></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td><input id="JoinButton" name="join" value="Join!" type="submit"</td>
                </tr>
            </table>
        </form>
        
    <!--Placing the Javascript at the end just incase. That way it won't hick up the page-->
    <script src="/Weight%20Tracker/Scripts/adduser.js" type="text/javascript"></script>
        
    </body>
</html>
