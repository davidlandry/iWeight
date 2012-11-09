/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import java.text.*;
import java.util.*;

/**
 * Container for the workout
 * 
 * @author Justin Walrath <walrathjaw@gmail.com>
 * @since 11/7/12
 */
public class Workout
{
    
    private int WorkoutId;
    private String UserId;
    private int ExerciseId;
    private int Length;
    private String WorkoutTime;
    //private Date WorkoutTime;
    
    /**
     * Simple constructor for adding to the database.
     * 
     * @param userId User's Id code.
     * @param exerciseId Exercise Id code.
     * @param lengthOfWorkout The length of the workout in minutes.
     */
    public Workout(String userId, int exerciseId, int lengthOfWorkout)
    {
        WorkoutId = 0;
        UserId = userId;
        ExerciseId = exerciseId;
        Length = lengthOfWorkout;
        WorkoutTime = null;
    }
    
    /**
     * Full constructor for housing the exercise routine information.
     * 
     * @param userId User's Id code.
     * @param exerciseId Exercise Id code.
     * @param lengthOfWorkout When the workout occured 
     * @param workoutTime The length of the workout in minutes.
     */
    public Workout(int workoutId, String userId, int exerciseId, int lengthOfWorkout, String workoutTime)
    {
        try
        {
            WorkoutId = workoutId;
            UserId = userId;
            ExerciseId = exerciseId;
            Length = lengthOfWorkout;
            WorkoutTime = workoutTime;
            
            //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //WorkoutTime = df.parse(workoutTime);
        }
        catch(Exception er)
        {}
    }

    /**
     * Get the user id associated with this workout.
     * @return The user id
     */
    public String getUserId()
    {
        return UserId;
    }

    /**
     * Get the exercise id associated with this workout.
     * @return The exercise id
     */
    public int getExerciseId()
    {
        return ExerciseId;
    }

    /**
     * Get the workout length of time.
     * @return The workout length
     */
    public int getLength()
    {
        return Length;
    }

    /**
     * Get the workout id associated with this workout.
     * @return The workout id
     */
    public int getWorkoutId()
    {
        return WorkoutId;
    }

    /**
     * Get the Workout date and time associated with this workout.
     * @return The workout date and time
     */
    public String getWorkoutTime()
    {
        return WorkoutTime;
    }
}
