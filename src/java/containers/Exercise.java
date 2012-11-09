package containers;

/**
 * Container for the exercise table.
 * 
 * @author Justin Walrath <walrathjaw@gmail.com>
 * @since 11/7/12
 */
public class Exercise
{
    int ExerciseId;
    String ExerciseName;
    int ExerciseTypeId;
    int CaloriesBurnedPerHour;
    
    /**
     * Constructor to quickly build the table row.
     * 
     * @author Justin Walrath <walrathjaw@gmail.com>
     * @since 11/7/12
     * @param exerciseId The id of the exercise.
     * @param exerciseName The name/description of the exercise;
     * @param exerciseTypeId The foreign key of the exercise type id.
     * @param caloriesBurnedPerHour The calories that would be burned per hour.
     */
    public Exercise(int exerciseId, String exerciseName, int exerciseTypeId, int caloriesBurnedPerHour)
    {
        ExerciseId = exerciseId;
        ExerciseName = exerciseName;
        ExerciseTypeId = exerciseTypeId;
        CaloriesBurnedPerHour = caloriesBurnedPerHour;
    }

    /**
     * Gets the exercise id.
     * @return The exercise id.
     */
    public int getExerciseId()
    {
        return ExerciseId;
    }

    /**
     * Gets the exercise name.
     * @return The exercise name.
     */
    public String getExerciseName()
    {
        return ExerciseName;
    }

    /**
     * Gets the exercise type id.
     * @return The exercise type id.
     */
    public int getExerciseTypeId()
    {
        return ExerciseTypeId;
    }

    /**
     * Gets the calories burned in an hour.
     * @return The calories burned in an hour.
     */
    public int getCaloriesBurnedPerHour()
    {
        return CaloriesBurnedPerHour;
    }
}
