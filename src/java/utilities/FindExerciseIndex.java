package utilities;

import containers.*;

/**
 * Finds the index number and returns the Exercise
 * @author Justin Walrath <walrathjaw@gmail.com>
 */
public class FindExerciseIndex
{
    /**
     * Finds the name of the exercise
     * @param index The Id to look for
     * @param exercises The list of exercises
     * @return The Name of the exercise
     */
    public static String findExercise(int index, Exercise[] exercises)
    {
        for(Exercise i : exercises)
        {
            if(i.getExerciseId()== index)
            {
                return(i.getExerciseName());
            }
        }
        return("");
    }
    
    /**
     * Finds the type id of the exercise
     * @param index The Exercise Id to search for
     * @param exercises The list of exercises
     * @return The id of the exercise type
     */
    public static int findType(int index, Exercise[] exercises)
    {
        for(Exercise i : exercises)
        {
            if(i.getExerciseId()== index)
            {
                return(i.getExerciseTypeId());
            }
        }
        return(0);
    }
}
