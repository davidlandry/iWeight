/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testingfields;

import containers.Exercise;
import containers.ExerciseType;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import containers.*;
import java.util.ArrayList;
import utilities.*;

/**
 *
 * @author justin
 */
public class TestFindExerciseTypeIndex
{
    private ArrayList<Exercise> exercises;
    private ArrayList<ExerciseType> exerciseTypes;   
    
    public TestFindExerciseTypeIndex()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
        exercises = new ArrayList<Exercise>();
        exerciseTypes = new ArrayList<ExerciseType>();
        
        exerciseTypes.add(new ExerciseType(1, "cardio"));
        exerciseTypes.add(new ExerciseType(2, "weight"));
        exerciseTypes.add(new ExerciseType(3, "resistance"));
        
        exercises.add(new Exercise(1, "Skiing", 1, 30));
        exercises.add(new Exercise(2, "Lifting", 2, 444));
        exercises.add(new Exercise(3, "Mowing lawns", 3, 699));
    }
    
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void findExerciseTypeIndex()
    {
        String typeName = FindExerciseTypeIndex.findExerciseType(1, exerciseTypes.toArray(new ExerciseType[exerciseTypes.size()]));
        assertEquals("cardio", typeName);
        typeName = FindExerciseTypeIndex.findExerciseType(2, exerciseTypes.toArray(new ExerciseType[exerciseTypes.size()]));
        assertEquals("weight", typeName);
        typeName = FindExerciseTypeIndex.findExerciseType(3, exerciseTypes.toArray(new ExerciseType[exerciseTypes.size()]));
        assertEquals("resistance", typeName);
        
        typeName = FindExerciseTypeIndex.findExerciseType(1, exercises.toArray(new Exercise[exercises.size()]), exerciseTypes.toArray(new ExerciseType[exerciseTypes.size()]));
        assertEquals("cardio", typeName);
        typeName = FindExerciseTypeIndex.findExerciseType(2, exercises.toArray(new Exercise[exercises.size()]), exerciseTypes.toArray(new ExerciseType[exerciseTypes.size()]));
        assertEquals("weight", typeName);
        typeName = FindExerciseTypeIndex.findExerciseType(3, exercises.toArray(new Exercise[exercises.size()]), exerciseTypes.toArray(new ExerciseType[exerciseTypes.size()]));
        assertEquals("resistance", typeName);
    }
}
