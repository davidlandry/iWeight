/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import containers.*;
import utilities.*;
import java.sql.*;
import java.util.*;

/**
 * Class that manipulates the database.
 * 
 * @author Justin Walrath <walrathjaw@gmail.com>
 * @since 11/1/12
 */
public class ConnectDB
{
    private Connection connect = null;
    private String dbURL = "";
    private String username = "";
    private String password = "";
    
    /**
     * Constructor: Records the database information and then connects to it.
     * 
     * @author Justin Walrath <walrathjaw@gmail.com>
     * @since 11/1/12
     * @param usr The username of the database to connect to.
     * @param passwd The password for the username in the database.
     * @param host The controller and the database to connect to.
     */
    public ConnectDB(String usr, String passwd, String host)
    {
        dbURL = host;
        username = usr;
        password = passwd;
        
        initializeConnection();
    }
    
    /**
     * Open the connection to the database as specified by the connection information.
     * 
     * @author Justin Walrath <walrathjaw@gmail.com>
     * @since 11/1/12
     */
    private String initializeConnection()
    {
        String connectionResult = "There was an error connecting to the database.";
        try
        {
            connect = DriverManager.getConnection(dbURL, username, password);
            connectionResult = "Connected Successfully";
        }
        catch (SQLException er)
        {
            connectionResult = "SQLException: " + er.toString();
        }
        
        return(connectionResult);
    }
    
    /**
     * Adds a new exercise to the database.
     * 
     * @author Justin Walrath <walrathjaw@gmail.com>
     * @since 11/2/12
     */
    public String addExercise(String exerciseName, int exerciseTypeId, int caloriesPerHour)
    {
        String insertionResult = "There was an error adding to the database.";
        PreparedStatement ps= null;
        
        try
        {
            //Insert an exercise
            String q= "insert into weightExercises(exerciseId, exerciseName, exerciseTypeId, averageCaloriesBurned) values(null, ?, ?, ?)";
            ps= connect.prepareStatement(q, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, exerciseName);
            ps.setInt(2, exerciseTypeId);
            ps.setInt(3, caloriesPerHour);
            ps.executeUpdate();
            
            ResultSet tmp = ps.getGeneratedKeys();
            int generatedKey = -1;
            
            tmp.next();
            generatedKey = tmp.getInt(1);
	    ps.close();
            
            insertionResult = "The Exercise has been added: " + String.valueOf(generatedKey);
        }
        catch(Exception er)
        {
            insertionResult = "SQLException: " + er.toString();
        }
        
        return(insertionResult);
    }
    
    /**
     * Adds a new exercise type to the database.
     * 
     * @author Justin Walrath <walrathjaw@gmail.com>
     * @since 11/2/12
     */
    public String addExerciseType(String typeName)
    {
        String insertionResult = "There was an error adding to the database.";
        PreparedStatement ps= null;
        
        try
        {
            //Insert an exercise
            String q= "insert into weightExerciseTypes(exerciseTypeId, exerciseType) values(null, ?)";
            ps= connect.prepareStatement(q, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, typeName);
            ps.executeUpdate();
            
            ResultSet tmp = ps.getGeneratedKeys();
            int generatedKey = -1;
            
            tmp.next();
            generatedKey = tmp.getInt(1);
	    ps.close();
            
            insertionResult = "The Exercise has been added: " + String.valueOf(generatedKey);
        }
        catch(Exception er)
        {
            insertionResult = "SQLException: " + er.toString();
        }
        
        return(insertionResult);
    }
    
    /**
     * Adds a new user to the database.
     * 
     * @author Justin Walrath <walrathjaw@gmail.com>
     * @since 11/2/12
     */
    public String addUser(User user)
    {
        String insertionResult = "There was an error adding to the database.";
        PreparedStatement ps= null;
        String salt = SaltShaker.generateSalt(10);
        
        try
        {
            String q= "insert into weightUsers(userId, username, password, salt, firstName, lastName, weight, email, joinDate, aboutText) values(?, ?, SHA(?), ?, ?, ?, ?, ?, NOW(), ?)";
            System.out.println(salt);
            ps= connect.prepareStatement(q);
            ps.setString(1, user.getUserId());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword() + salt);
            ps.setString(4, salt);
            ps.setString(5, user.getFirstName());
            ps.setString(6, user.getLastName());
            ps.setInt(7, user.getWeight());
            ps.setString(8, user.getEmail());
            ps.setString(9, user.getAboutInformation());
            ps.executeUpdate();
	    ps.close();
            
            insertionResult = "The user has been added: " + user.getUserId();
        }
        catch(Exception er)
        {
            insertionResult = "SQLException: " + er.toString();
        }
        
        return(insertionResult);
    }
    
    /**
     * Adds a new location to the database.
     * 
     * @author Justin Walrath <walrathjaw@gmail.com>
     * @since 11/2/12
     */
    public String addLocation(String locationName)
    {
        String insertionResult = "There was an error adding to the database.";
        PreparedStatement ps= null;
        
        try
        {
            String q= "insert into weightLocation(locationId, locationName) values(null, ?)";
            ps= connect.prepareStatement(q, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, locationName);
            ps.executeUpdate();
            
            ResultSet tmp = ps.getGeneratedKeys();
            int generatedKey = -1;
            
            tmp.next();
            generatedKey = tmp.getInt(1);
            
            insertionResult = "The location has been added: " + String.valueOf(generatedKey);
            
            
	    ps.close();
        }
        catch(Exception er)
        {
            insertionResult = "SQLException: " + er.toString();
        }
        
        return(insertionResult);
    }
    
    /**
     * Adds a new workout to the database using the user id and the exercise id;
     * 
     * @author Justin Walrath <walrathjaw@gmail.com>
     * @since 11/2/12
     */
    public String recordWorkout(Workout workout)
    {
        String insertionResult = "There was an error adding to the database.";
        PreparedStatement ps= null;
        
        try
        {
            String q= "insert into weightWorkout(workoutId, userId, exerciseId, workoutTime, workoutlength) values(null, ?, ?, NOW(), ?)";
            ps= connect.prepareStatement(q, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, workout.getUserId());
            ps.setInt(2, workout.getExerciseId());
            ps.setInt(3, workout.getLength());
            ps.executeUpdate();
            
            ResultSet tmp = ps.getGeneratedKeys();
            int generatedKey = -1;
            
            tmp.next();
            generatedKey = tmp.getInt(1);
	    ps.close();
            
            insertionResult = "The workout has been added: " + String.valueOf(generatedKey);
        }
        catch(Exception er)
        {
            insertionResult = "SQLException: " + er.toString();
        }
        
        return(insertionResult);
    }
    
    /**
     * Check the username and password to make sure that the combination exists.
     * If so it generates a User object with the information.
     * 
     * @author Justin Walrath <walrathjaw@gmail.com>
     * @since 11/5/12
     * 
     * @param username The user's username.
     * @param password The user's Password
     * @return User object with the users information or null if combination doesn't exist.
     */
    public User login(String username, String password)
    {
        User user = null;
        PreparedStatement ps= null;
        
        try
        {
            String q= "select userId, username, firstName, lastName, weight, email, aboutText from weightUsers where username=? and password=sha(concat(?,(select salt from weightUsers where username=?)));";

            ps= connect.prepareStatement(q);
	    ps.setString(1, username);
	    ps.setString(2, password);
	    ps.setString(3, username);
	    ResultSet rs= ps.executeQuery();

	    if(rs.next())
	    {
                user= new User(rs.getString("userId"), rs.getString("username"), "", rs.getString("firstName"), rs.getString("lastName"), rs.getInt("weight"), rs.getString("email"), rs.getString("aboutText"));
            }

	    rs.close();
	    ps.close();
        }
	catch (SQLException e)
	{}
                
        return(user);
    }
    
    /**
     * Query the database to get a list of all the Exercise types.
     * 
     * @author Justin Walrath <walrathjaw@gmail.com>
     * @since 11/6/12
     * @return List of exercise types.
     */
    public ExerciseType[] getExerciseTypes()
    {
        ArrayList<ExerciseType> typesList = new ArrayList<ExerciseType>();
        PreparedStatement ps= null;
        
        try
        {
            String q= "select exerciseTypeId, exerciseType from weightExerciseTypes";

            ps= connect.prepareStatement(q);
	    ResultSet rs= ps.executeQuery();

	    while(rs.next())
	    {
                typesList.add(new ExerciseType(rs.getInt("exerciseTypeId"), rs.getString("exerciseType")));
            }

	    rs.close();
	    ps.close();
        }
	catch (SQLException e)
	{}
        
        return(typesList.toArray(new ExerciseType[typesList.size()]));
    }
    
    /**
     * Query the database to get a list of all the Exercises.
     * 
     * @author Justin Walrath <walrathjaw@gmail.com>
     * @since 11/5/12
     * @return List of exercises.
     */
    public Exercise[] getExercises()
    {        
        ArrayList<Exercise> exerciseList = new ArrayList<Exercise>();
        PreparedStatement ps= null;
        
        try
        {
            String q= "select exerciseId, exerciseName, exerciseTypeId, averageCaloriesBurned from weightExercises";

            ps= connect.prepareStatement(q);
	    ResultSet rs= ps.executeQuery();

	    while(rs.next())
	    {
                exerciseList.add(new Exercise(rs.getInt("exerciseId"), rs.getString("exerciseName"), rs.getInt("exerciseTypeId"), rs.getInt("averageCaloriesBurned")));
            }

	    rs.close();
	    ps.close();
        }
	catch (SQLException e)
	{}
        
        return(exerciseList.toArray(new Exercise[exerciseList.size()]));
    }
    
    /**
     * Sets a new password
     * @param password the users new password
     * @param username the user's username
     * @return The string telling of it's success
     */
    public String setPassword(String password, String username)
    {
        String insertionResult = "There was an error adding to the database.";
        PreparedStatement ps= null;
        
        try
        {
            String q= "update weightUsers set password= SHA(CONCAT(?, salt)) where username = ?";
            ps= connect.prepareStatement(q);
            ps.setString(1, password);
            ps.setString(2, username);
            ps.executeUpdate();
	    ps.close();
            
            insertionResult = "The password has been updated.";
        }
        catch(Exception er)
        {
            insertionResult = "SQLException: " + er.toString();
        }
        
        return(insertionResult);
    }
    
    /**
     * Checks the password
     * @param password the old password
     * @param username The username
     * @return A string telling of it's success
     */
    public String checkPassword(String username, String password)
    {
        String insertionResult = "There was an error adding to the database.";
        PreparedStatement ps= null;
        
        try
        {
            String q= "select firstName from weightUsers where username=? and password=sha(concat(?,(select salt from weightUsers where username=?)));";

            ps= connect.prepareStatement(q);
	    ps.setString(1, username);
	    ps.setString(2, password);
	    ps.setString(3, username);
	    ResultSet rs= ps.executeQuery();

	    if(rs.next())
	    {
                insertionResult = "SUCCESS";
            }
            else
            {
                insertionResult = "FAILURE";
            }

	    rs.close();
	    ps.close();
        }
	catch (SQLException e)
	{
            insertionResult = "There was an error checking the password";
        }
        
        return(insertionResult);
    }
    
    /**
     * Updates the about information
     * @param username The user's username.
     * @param aboutInformation The user's about information.
     * @return A string detailing it's success.
     */
    public String setAbout(String username, String aboutInformation)
    {
        String insertionResult = "There was an error adding to the database.";
        PreparedStatement ps= null;
        
        try
        {
            String q= "update weightUsers set aboutText= ? where username = ?";
            ps= connect.prepareStatement(q);
            ps.setString(1, aboutInformation);
            ps.setString(2, username);
            ps.executeUpdate();
	    ps.close();
            
            insertionResult = "SUCCESS.";
        }
        catch(Exception er)
        {
            insertionResult = "SQLException: " + er.toString();
        }
        
        return(insertionResult);
    }
    
    /**
     * Sets the user's email.
     * @param username The user's username.
     * @param emailAddress The user's email address.
     * @return A string detailing the success.
     */
    public String setEmail(String username, String emailAddress)
    {
        String insertionResult = "There was an error adding to the database.";
        PreparedStatement ps= null;
        
        try
        {
            String q= "update weightUsers set email= ? where username = ?";
            ps= connect.prepareStatement(q);
            ps.setString(1, emailAddress);
            ps.setString(2, username);
            ps.executeUpdate();
	    ps.close();
            
            insertionResult = "SUCCESS";
        }
        catch(Exception er)
        {
            insertionResult = "SQLException: " + er.toString();
        }
        
        return(insertionResult);
    }
    
    /**
     * Get the last weeks workouts
     * @param userId The user's user id
     * @return a list of exercises from the last week
     */
    public Workout[] getLastWeeksWorkouts(String userId)
    {
        ArrayList<Workout> workouts = new ArrayList<Workout>();
        PreparedStatement ps= null;
        
        try
        {
            String q= "select workoutId, userId, exerciseId, workoutTime, workoutlength from weightWorkout where workoutTime > DATE_ADD(CURRENT_TIMESTAMP, INTERVAL -7 DAY) and userId = ?;";

            ps= connect.prepareStatement(q);
	    ps.setString(1, userId);
	    ResultSet rs= ps.executeQuery();

	    while(rs.next())
	    {
                workouts.add(new Workout(rs.getInt("workoutId"), rs.getString("userId"), rs.getInt("exerciseId"), rs.getInt("workoutlength"), rs.getString("workoutTime")));
            }

	    rs.close();
	    ps.close();
        }
	catch (SQLException e)
	{}
        
        return(workouts.toArray(new Workout[workouts.size()]));
    }
    
    /**
     * Gets a count of how many exercise types there are.
     * @return A count of the exercise types.
     */
    public int getExerciseTypeCount()
    {
        int count=0;
        PreparedStatement ps= null;
        
        try
        {
            String q= "select count(exerciseTypeId) from weightExerciseTypes;";

            ps= connect.prepareStatement(q);
	    ResultSet rs= ps.executeQuery();

	    if(rs.next())
	    {
                count = rs.getInt("count(exerciseTypeId)");
            }

	    rs.close();
	    ps.close();
        }
	catch (SQLException e)
	{}
        
        return(count);
    }
}
