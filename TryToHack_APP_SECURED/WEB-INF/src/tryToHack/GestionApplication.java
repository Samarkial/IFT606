package tryToHack;

import java.sql.*;

public class GestionApplication
{
    private Connexion cx;
    private TableUsers user;
    private GestionUser gestionUser;
    private GestionInterrogation gestionInterrogation;

    public GestionApplication() throws TryToHackException, SQLException
    {
        cx = new Connexion();
        user = new TableUsers(getConnexion());
        setGestionUser(new GestionUser(user));
        setGestionInterrogation(new GestionInterrogation(getConnexion()));
    }

    public void fermer() throws SQLException
    {
        getConnexion().fermer();
    }

	public Connexion getConnexion()
	{
		return cx;
	}

    public GestionUser getGestionUser()
    {
        return gestionUser;
    }

    private void setGestionUser(GestionUser gestionUser)
    {
        this.gestionUser = gestionUser;
    }

    public GestionInterrogation getGestionInterrogation()
    {
        return gestionInterrogation;
    }

    private void setGestionInterrogation(GestionInterrogation gestionInterrogation)
    {
        this.gestionInterrogation = gestionInterrogation;
    }
}
