/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 * All the data connection information in one simple container.
 * 
 * @author Justin Walrath
 * @since 11/4/12
 */
public class DatabaseInformation
{
    private final static String dbAddress = "jdbc:mysql://mucis1.mansfield.edu/walrathja13";
    private final static String username = "walrathja13";
    private final static String password = "walrathja13";

    public static String getDbAddress()
    {
        return dbAddress;
    }

    public static String getUsername()
    {
        return username;
    }

    public static String getPassword()
    {
        return password;
    } 
}
