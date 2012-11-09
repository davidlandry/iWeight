/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import java.util.UUID;

/**
 *
 * @author Justin Walrath <walrathjaw@gmail.com
 */
public class User
{
    private String UserId;
    private String Username;
    private String Password;
    private String FirstName;
    private String LastName;
    private int Weight;
    private String Email;
    private String AboutInformation;
    
    /**
     * Constructs a user information object.
     * 
     * @author Justin Walrath <walrathjaw@gmail.com>
     * @since 11/1/12
     * @param username The user's requested login.
     * @param passwd The user's requested password.
     * @param firstName The user's first name. 
     * @param lastName The user's last name.
     * @param weight The user's current weight.
     * @param emailAddress The user's contact email.
     * @param about The user's Personal about paragraph.
     */
    public User(String username, String passwd, String firstName, String lastName, int weight, String emailAddress, String about)
    {
        UserId = UUID.randomUUID().toString();
        Username = username;
        Password = passwd;
        FirstName = firstName;
        LastName = lastName;
        Weight = weight;
        Email = emailAddress;
        AboutInformation = about;
    }
    
    /**
     * Constructs a user information object.
     * 
     * @author Justin Walrath <walrathjaw@gmail.com>
     * @since 11/1/12
     * @param username The user's requested login.
     * @param passwd The user's requested password.
     * @param firstName The user's first name. 
     * @param lastName The user's last name.
     * @param weight The user's current weight.
     * @param emailAddress The user's contact email.
     * @param about The user's Personal about paragraph.
     */
    public User(String id, String username, String passwd, String firstName, String lastName, int weight, String emailAddress, String about)
    {
        UserId = id;
        Username = username;
        Password = passwd;
        FirstName = firstName;
        LastName = lastName;
        Weight = weight;
        Email = emailAddress;
        AboutInformation = about;
    }
    
    /**
     * Class that removes the password so that you may use the object securely
     */
    public void prepForSession()
    {
        Password = "";
    }

    /**
     * Retrieves the userId
     * @return userId
     */
    public String getUserId()
    {
        return UserId;
    }

    /**
     * Retrieves the Username
     * @return Username
     */
    public String getUsername()
    {
        return Username;
    }

    /**
     * Retrieves the password
     * @return password
     */
    public String getPassword()
    {
        return Password;
    }

    /**
     * Retrieves the first name
     * @return The first name
     */
    public String getFirstName()
    {
        return FirstName;
    }

    /**
     * Retrieves the last name
     * @return the last name
     */
    public String getLastName()
    {
        return LastName;
    }

    /**
     * Retrieves the weight
     * @return the weight
     */
    public int getWeight()
    {
        return Weight;
    }

    /**
     * Retrieves the email
     * @return the email
     */
    public String getEmail()
    {
        return Email;
    }

    /**
     * Retrieves the about information
     * @return the about information
     */
    public String getAboutInformation()
    {
        return AboutInformation;
    }

    /**
     * Set the email
     * @param Email The new email address.
     */
    public void setEmail(String Email)
    {
        this.Email = Email;
    }

    /**
     * Set the user's about information.
     * @param AboutInformation 
     */
    public void setAboutInformation(String AboutInformation)
    {
        this.AboutInformation = AboutInformation;
    }
}
