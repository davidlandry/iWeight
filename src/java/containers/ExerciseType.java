package containers;

/**
 * Container to hold the exercise types.
 * 
 * @author Justin Walrath <walrathjaw@gmail.com>
 * @since 11/6/12
 */
public class ExerciseType
{
    private int ExerciseTypeId;
    private String ExerciseTypeName;
    
    /**
     * Constructor to easily make a container
     * @param id The id number of the type.
     * @param typeName The name of the type.
     */
    public ExerciseType(int id, String typeName)
    {
        ExerciseTypeId = id;
        ExerciseTypeName = typeName;
    }

    /**
     * Get the id number of the exercise type.
     * @return id number.
     */
    public int getExerciseTypeId()
    {
        return ExerciseTypeId;
    }

    /**
     * Get the name of the exercise type.
     * @return Name of the exercise type.
     */
    public String getExerciseTypeName()
    {
        return ExerciseTypeName;
    }
}
