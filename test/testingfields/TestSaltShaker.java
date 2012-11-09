package testingfields;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import containers.*;
import utilities.*;

/**
 * Tests the salt shaker class
 * @author Justin Walrath
 */
public class TestSaltShaker
{
    
    public TestSaltShaker()
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
    }
    
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void generateSalt()
    {
        String salt = SaltShaker.generateSalt(10);
        assertEquals(10, salt.length());
    }
}
