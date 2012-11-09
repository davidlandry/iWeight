/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.Random;

/**
 * Class to generate a random salt for the password.
 * 
 * @author Justin Walrath <walrathjaw@gmail.com>
 * @since 11/1/12
 */
public class SaltShaker
{
    public static String generateSalt(int length)
    {
        String salt = "";
        
        for(int i=0; i< length; i++)
        {
            salt += String.valueOf(randomChar());
        }
        
        return(salt);
    }
    
    public static char randomChar()
    {
        Random rnd = new Random();
        return((char)(rnd.nextInt(58) + 'A'));
    }
}
