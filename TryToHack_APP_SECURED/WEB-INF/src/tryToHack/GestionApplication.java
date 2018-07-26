package tryToHack;

import java.sql.*;

public class GestionApplication
{
    private Connexion cx;
    private TableUsers user;
    private GestionUser gestionUser;

    public GestionApplication() throws TryToHackException, SQLException
    {
        cx = new Connexion();
        user = new TableUsers(getConnexion());
        setGestionUser(new GestionUser(user));
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
}
