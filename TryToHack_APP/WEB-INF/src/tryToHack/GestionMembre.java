package tryToHack;

import java.sql.*;

public class GestionMembre
{
    private Connexion cx;
    private TableMembres membre;

    /**
     * Creation d'une instance
     */
    public GestionMembre(TableMembres membre) throws TryToHackException
    {
        this.cx = membre.getConnexion();
        this.membre = membre;
    }
    
    public boolean existe(int idMembre)
            throws SQLException
    {
        return this.membre.existe(idMembre);
    }

    public void inscrire(int idMembre, String nom, long telephone, int limitePret)
            throws SQLException, TryToHackException, Exception
    {
        try
        {
            // Vérifie si le membre existe déja
            if (membre.existe(idMembre))
                throw new TryToHackException("Membre existe deja: " + idMembre);

            // Ajout du membre.
            membre.inscrire(idMembre, nom, telephone);
            
            // Commit
            cx.commit();
        }
        catch (Exception e)
        {
            cx.rollback();
            throw e;
        }
    }

    /**
     * Suppression d'un membre de la base de donnees.
     */
    public void desinscrire(int idMembre) throws SQLException, TryToHackException, Exception
    {
        try
        {
            // Vérifie si le membre existe et son nombre de pret en cours
            TupleMembre tupleMembre = membre.getMembre(idMembre);
            if (tupleMembre == null)
                throw new TryToHackException("Membre inexistant: " + idMembre);
           
            // Suppression du membre
            int nb = membre.desinscrire(idMembre);
            if (nb == 0)
                throw new TryToHackException("Membre " + idMembre + " inexistant");
            
            // Commit
            cx.commit();
        }
        catch (Exception e)
        {
            cx.rollback();
            throw e;
        }
    }
}// class
