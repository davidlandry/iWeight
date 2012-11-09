package utilities;

import containers.*;

/**
 * This class will calculate if a routine needs more of a different type of exercise
 * @author Justin Walrath
 */
public class CalculateRoutine
{
    /**
     * This takes the workouts and calculates if there is a lack of one type of exercise.
     * @param typeCount The number of exercise types there are
     * @param exercises The list of exercises
     * @param exerciseTypes The list of exercise Types
     * @param workouts The list of workouts
     * @return A String detailing what the check results are
     */
    public static String calculate(int typeCount, Exercise[] exercises, ExerciseType[] exerciseTypes, Workout[] workouts)
    {
        String returnMessage = "You seem to be low on ";
        
        int[][] workoutCount = new int[typeCount][2];
        double percentageCheck = .75 * (100.0 / (double)typeCount);
        int count = 0;
        Boolean firstRunThrough = true;
        
        for(int i = 0; i< typeCount; i++)
        {
            workoutCount[i][0] = exerciseTypes[i].getExerciseTypeId();
        }
        
        //Runs through the workouts to test add up each individual values.
        for(Workout w : workouts)
        {
            int otmp = FindExerciseIndex.findType(w.getExerciseId(), exercises);
            int i = 0;
            while(FindExerciseIndex.findType(w.getExerciseId(), exercises) != workoutCount[i][0] && i < typeCount)
            {   
                i++;
            }
            if(FindExerciseIndex.findType(w.getExerciseId(), exercises) == workoutCount[i][0])
            {
                workoutCount[i][1]++;
            }
        }
        
        //This finds the percentage of the workouts
        for(int i = 0; i < typeCount; i++)
        {
            double tmp = (((double)workoutCount[i][1] * 100.0) / (double)workouts.length);
            if(tmp < percentageCheck)
            {
                if(firstRunThrough == false)
                {
                    returnMessage+=", ";
                }
                if(i == typeCount-1)
                {
                    returnMessage+="and ";
                }
                returnMessage+=FindExerciseTypeIndex.findExerciseType(workoutCount[i][0], exerciseTypes);
                firstRunThrough = false;
            }
        }
        
        if(returnMessage.equals("You seem to be low on "))
        {
            returnMessage = "";
        }   
        
        return(returnMessage);
    }
}
