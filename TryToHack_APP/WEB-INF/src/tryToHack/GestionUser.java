package tryToHack;

import java.sql.*;

public class GestionUser
{
    private Connexion cx;
    private TableUsers user;

    public GestionUser(TableUsers user) throws TryToHackException
    {
        this.cx = user.getConnexion();
        this.user = user;
    }
    
    public boolean existe(String username) throws SQLException
    {
        return this.user.existe(username);
    }

    public boolean addUser(String nom, String prenom, String username, String password, String password2) throws SQLException, TryToHackException, Exception
    {
        try
        {
            if (user.existe(username)) {
            		throw new TryToHackException("Username existe deja.");
            }

            user.addUser(nom, prenom, username, password, password2);
            
            cx.commit();
            
            return true;
        }
        catch (Exception e)
        {
            cx.rollback();
            return false;
        }
    }

    public void removeUser(int idUser) throws SQLException, TryToHackException, Exception
    {
        try
        {
            TupleUser tupleMembre = user.getUser(idUser);
            if (tupleMembre == null)
                throw new TryToHackException("User inexistant: " + idUser);
           
            int nb = user.removeUser(idUser);
            if (nb == 0)
                throw new TryToHackException("User " + idUser + " inexistant");
            
            cx.commit();
        }
        catch (Exception e)
        {
            cx.rollback();
            throw e;
        }
    }
    
    public boolean verifyCredentials(String username, String password) throws SQLException, TryToHackException {
    		return this.user.verifyCredentials(username, password);
	}
}
