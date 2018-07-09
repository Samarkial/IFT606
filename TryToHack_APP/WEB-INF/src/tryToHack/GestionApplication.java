package tryToHack;

import java.sql.*;

public class GestionApplication
{
    private Connexion cx;
    private TableMembres membre;
    private GestionMembre gestionMembre;
    private GestionInterrogation gestionInterrogation;

    public GestionApplication(String user, String password)
            throws TryToHackException, SQLException
    {
        // allocation des objets pour le traitement des transactions
        cx = new Connexion(user, password);
        //membre = new TableMembres(getConnexion());
        //setGestionMembre(new GestionMembre(membre));
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

    public GestionMembre getGestionMembre()
    {
        return gestionMembre;
    }

    private void setGestionMembre(GestionMembre gestionMembre)
    {
        this.gestionMembre = gestionMembre;
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
