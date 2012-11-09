/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testingfields;

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
 * This tests the FindExerciseIndex class
 * @author Justin Walrath
 */
public class TestFindExerciseIndex
{
    private ArrayList<Exercise> exercises;
    private ArrayList<ExerciseType> exerciseTypes;
    
    public TestFindExerciseIndex()
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
    public void findExerciseIndex()
    {
        //Find the name of a an exercise in a list of exercises
        String indexed = FindExerciseIndex.findExercise(1, exercises.toArray(new Exercise[exercises.size()]));
        assertEquals("Skiing", indexed);
        indexed = FindExerciseIndex.findExercise(2, exercises.toArray(new Exercise[exercises.size()]));
        assertEquals("Lifting", indexed);
        indexed = FindExerciseIndex.findExercise(3, exercises.toArray(new Exercise[exercises.size()]));
        assertEquals("Mowing lawns", indexed);
        
        //Find the typeId
        int typeId = FindExerciseIndex.findType(1, exercises.toArray(new Exercise[exercises.size()]));
        assertEquals(1, typeId);
        typeId = FindExerciseIndex.findType(2, exercises.toArray(new Exercise[exercises.size()]));
        assertEquals(2, typeId);
        typeId = FindExerciseIndex.findType(3, exercises.toArray(new Exercise[exercises.size()]));
        assertEquals(3, typeId);
    }
}
