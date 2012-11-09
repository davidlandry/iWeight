<%-- 
    Document   : home.jsp
    Created on : Oct 22, 2012, 1:07:41 PM
    Author     : Justin Walrath <walrathjaw@gmail.com
--%>


<%@page import="java.lang.reflect.Member"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controllers.*" %>
<%@page import="containers.*"%>
<%
//Retrieve the session variables to determine which page to show.
    String action = "";
    User member = new User("", "", "", "", 0, "", "");
    
    if(session.getAttribute("action") == null)
    {
        action = "guest";
    }
    else
    {
        action = (String)session.getAttribute("action");
        
        //Pull the user information
        member = (User)session.getAttribute("userInfo");
    }
    
    if(session.getAttribute("errorMessage") != null)
    {
%>
        <div id="banner"><p id="errorDisplay"><%= session.getAttribute("errorMessage") %></p></div>
<%
        session.setAttribute("errorMessage", null);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Weight Center - </title>
        <link href="/Weight%20Tracker/Styles/homeStyle.css" rel="stylesheet">
    </head>
    <body>
        <div class ="mainContainer">
            <a href="/Weight%20Tracker/"><img src="/Weight%20Tracker/Images/returnHome.png"></a>
<%
    if(action == "guest")
    {
%>
        <div id="signIn">
            <form action="Login" id="signInForm" method="post">
                <table id="userLoginMainInputForm">
                    <tr>
                        <td>Username</td>
                        <td><input class="loginTextDesign" id="usernameInput" name="username" type="text" onfocus="clearUsername(this)" onblur="repopulateUsername(this)" value="Your username"></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input class="loginTextDesign" id="passwordInput" name="password" type="password" onfocus="clearPass(this)" onblur="repopulatePass(this)" value="        "></td>
                    </tr>
                    <tr>
                        <td><input id="submitButton" name="Login" type="submit" value="Sign in"</td>
                        <td><a class="centerColumn" href="addUserPage.jsp">or, Sign up!</a></td>
                    </tr>
                </table>
            </form>
        </div>
<%
    }
       else if(action == "loggedIn")
    {
%>
            <div id="signedIn">Welcome, <%=member.getUsername()%> <a href="Logout">Done Today?</a></div>
<%
    }
%>
            <div id="internalContainer">
                <div id="containerTabs">
                    <a id="pollWorkoutsLabel" href="/Weight%20Tracker/pollWorkouts.jsp">
                        <div class="containerTabButton">
                            Check Your Workouts!
                        </div>
                    </a>
                    <a id="addWorkoutsLabel" href="/Weight%20Tracker/addWorkout.jsp">
                        <div class="containerTabButton">
                            Record a Workout!
                        </div>
                    </a>
                    <a id="addExerciseLabel" href="/Weight%20Tracker/addExercise.jsp">
                        <div class="containerTabButton">
                            Create New Exercise
                        </div>
                    </a>
                    <a id="addLocationLabel" href="/Weight%20Tracker/addLocation.jsp">
                        <div class="containerTabButton">
                            Register a Location
                        </div>
                    </a>
                    <a id="changePasswordLabel" href="/Weight%20Tracker/changePassword.jsp">
                        <div class="containerTabButton">
                            Change Password
                        </div>
                    </a>
                    <a id="changeAboutLabel" href="/Weight%20Tracker/changeAbout.jsp">
                        <div class="containerTabButton">
                            Modify About information
                        </div>
                    </a>
                    <a id="changeAboutLabel" href="/Weight%20Tracker/changeEmail.jsp">
                        <div class="containerTabButton">
                            Change Email Address
                        </div>
                    </a>
                </div>
                <div id="containerContent">
                    <img id="titleImage" src="/Weight%20Tracker/Images/ID-10034488.jpg">
                    <p class="contentMaxWidth">Welcome to your weight center! Your source for keeping track of your exercises and
                        feeling a bit healthier. Everyone has a the potential to be healthy, they just may need
                        a little help to keep track of things. Well Weight Center is here with Tracker, just for that need!
                        Weight Tracker lets you record your workout regimen and will estimate your calories burned based
                        the individual activities that you do. It will even help you balance your routines! You know that
                        shouldn't overload on only on type of exercise. You want to mix it up! Our banner alerts will make sure
                        that you know which exercise you should do next to keep a balanced routine.
                    </p>
<%
    if(!member.getAboutInformation().equals(""))
    {
%>
                    <h1 class="contentMaxWidth">
                        Your About information
                    </h1>
                    <p class="contentMaxWidth">
                        <%=member.getAboutInformation()%>
                    </p>
<%
    }
%>
                </div>
            </div>
            <div id="copyright">
                <br>&nbsp;<br>&nbsp;<br>&nbsp;<br>
                <p>Weight Tracker Maximx1 &copy Justin Walrath from Mansfield University</p>
                <p>Image courtesy of PhotoStock / <a href="http://www.freedigitalphotos.net" target="_blank">FreeDigitalPhotos.net</a></p>
            </div>
        </div>
    <!--Placing the Javascript at the end just incase. That way it won't hick up the page-->
    <script src="/Weight%20Tracker/Scripts/home.js" type="text/javascript"></script>
    </body>
</html>
