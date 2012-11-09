<%-- 
    Document   : pollWorkouts
    Created on : Nov 9, 2012, 1:29:44 AM
    Author     : Justin Walrath
--%>

<%@page import="utilities.FindExerciseTypeIndex"%>
<%@page import="utilities.FindExerciseIndex"%>
<%@page import="utilities.CalculateRoutine"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.ConnectDB"%>
<%@page import="java.lang.reflect.Member"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controllers.*" %>
<%@page import="containers.*"%>
<%
    User member = (User)session.getAttribute("userInfo");
    ConnectDB db = new ConnectDB(DatabaseInformation.getUsername(), DatabaseInformation.getPassword(), DatabaseInformation.getDbAddress());
    Workout[] workouts = db.getLastWeeksWorkouts(member.getUserId());
    Exercise[] exercises = db.getExercises();
    ExerciseType[] exerciseTypes = db.getExerciseTypes();
    int typeCount = db.getExerciseTypeCount();
    String tmpErrorMessage = CalculateRoutine.calculate(typeCount, exercises, exerciseTypes, workouts);
    if(!tmpErrorMessage.equals(""))
    {
        session.setAttribute("errorMessage", tmpErrorMessage);
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
            <div id="signedIn">
                Welcome, <%=member.getUsername()%> <a href="Logout">Done Today?</a>
            </div>
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
                    <h1 class="contentMaxWidth">
                        Last Weeks Workouts:
                    </h1>
                    <table class="contentMaxWidth">
                        <tr>
                            <th class="hangALoui">
                                Exercise
                            </th>
                            <th class="hangALoui">
                                Type of Exercise
                            </th>
                            <th class="hangALoui">
                                Workout Length
                            </th>
                            <th class="hangALoui">
                                Date
                            </th>
                        </tr>
<%
                    for(Workout w : workouts)
                    {
%>
                        <tr>
                            <td><%=FindExerciseIndex.findExercise(w.getExerciseId(), exercises)%></td>
                            <td><%=FindExerciseTypeIndex.findExerciseType(w.getExerciseId(), exercises, exerciseTypes)%></td>
                            <td><%=w.getLength()%></td>
                            <td><%=w.getWorkoutTime()%></td>
                        </tr>
<%
                    }
%>
                    </table>
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

