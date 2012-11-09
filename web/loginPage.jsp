<%-- 
    Document   : loginPage
    Created on : Nov 5, 2012, 9:24:46 PM
    Author     : justin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Weight Tracker - Failed to log in!</title>
        <link href="/Weight%20Tracker/Styles/homeStyle.css" rel="stylesheet">
    </head>
    <body>
        <a href="/Weight%20Tracker/"><img src="/Weight%20Tracker/Images/returnHome.png"></a>
        <form id="userAddForm" action="Login" method="post">
            <table id="userInputForm">
                <tr>
                    <th id="addTableHeader" colspan="4">Username and/or password incorrect please try again!</th>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>Username:</td>
                    <td><input class="loginTextDesign" id="usernameInput" name="username" type="text" onfocus="clearUsername(this)" onblur="repopulateUsername(this)" value="Your username"</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>Password</td>
                    <td><input class="loginTextDesign" id="passwordInput" name="password" type="password" onfocus="clearPass(this)" onblur="repopulatePass(this)" value="        "</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td><a href="/Weight%20Tracker/">Return home</a></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td><input id="JoinButton" name="join" value="Log in!" type="submit"</td>
                </tr>
            </table>
        </form>
        
        <!--Placing the Javascript at the end just incase. That way it won't hick up the page-->
        <script src="/Weight%20Tracker/Scripts/loginPage.js" type="text/javascript"></script>
    </body>
</html>
