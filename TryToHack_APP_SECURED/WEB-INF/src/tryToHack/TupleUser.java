package tryToHack;

public class TupleUser
{
    private int idUser;
    private String username;
    private String password;
    
    public TupleUser() { }
    
    public TupleUser(String username, String password)
    {
        this.setUsername(username);
        this.setPassword(password);
    }

    public int getIdUser()
    {
        return idUser;
    }

    public void setIdUser(int idUser)
    {
        this.idUser = idUser;
    }
 
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }
 
    public void setPassword(String password)
    {
        this.password = password;
    }

}
