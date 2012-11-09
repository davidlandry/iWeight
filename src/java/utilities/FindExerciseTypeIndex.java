package utilities;

import containers.*;

/**
 * Finds the index number and returns the ExerciseType
 * @author Justin Walrath <walrathjaw@gmail.com>
 */
public class FindExerciseTypeIndex
{
    /**
     * Gets the exercise type from the straight index.
     * @param index The TypeId
     * @param exerciseTypes The list of exercise types
     * @return the matching type name
     */
    public static String findExerciseType(int index, ExerciseType[] exerciseTypes)
    {
        for(ExerciseType i : exerciseTypes)
        {
            if(i.getExerciseTypeId() == index)
            {
                return(i.getExerciseTypeName());
            }
        }
        return("");
    }
    
    /**
     * Extracts the exercise type name from a specific Exercise container
     * @param index The index of the Exercise container
     * @param exercises The list of exercises
     * @param exerciseTypes The list of exercise types
     * @return the matching type name
     */
    public static String findExerciseType(int index, Exercise[] exercises, ExerciseType[] exerciseTypes)
    {
        return(findExerciseType(FindExerciseIndex.findType(index, exercises), exerciseTypes));
    }
}
