package tryToHack;

import java.sql.*;

public class TableMembres
{
    private PreparedStatement stmtExiste;
    private PreparedStatement stmtInsert;
    private PreparedStatement stmtUpdateIncrNbPret;
    private PreparedStatement stmtUpdateDecNbPret;
    private PreparedStatement stmtDelete;
    private Connexion cx;

    public TableMembres(Connexion cx) throws SQLException
    {
        this.cx = cx;
        stmtExiste = cx.getConnection()
                .prepareStatement("select idMembre, nom, telephone, limitePret, nbpret from membre where idmembre = ?");
        stmtInsert = cx.getConnection().prepareStatement(
                "insert into membre (idmembre, nom, telephone, limitepret, nbpret) " + "values (?,?,?,?,0)");
        stmtUpdateIncrNbPret = cx.getConnection()
                .prepareStatement("update membre set nbpret = nbPret + 1 where idMembre = ?");
        stmtUpdateDecNbPret = cx.getConnection()
                .prepareStatement("update membre set nbpret = nbPret - 1 where idMembre = ?");
        stmtDelete = cx.getConnection().prepareStatement("delete from membre where idmembre = ?");
    }

    public Connexion getConnexion()
    {
        return cx;
    }

    public boolean existe(int idMembre) throws SQLException
    {
        stmtExiste.setInt(1, idMembre);
        ResultSet rset = stmtExiste.executeQuery();
        boolean membreExiste = rset.next();
        rset.close();
        return membreExiste;
    }

    public TupleMembre getMembre(int idMembre) throws SQLException
    {
        stmtExiste.setInt(1, idMembre);
        ResultSet rset = stmtExiste.executeQuery();
        if (rset.next())
        {
            TupleMembre tupleMembre = new TupleMembre();
            tupleMembre.setIdMembre(idMembre);
            tupleMembre.setNom(rset.getString(2));
            tupleMembre.setTelephone(rset.getLong(3));
            rset.close();
            return tupleMembre;
        }
        else
        {
            return null;
        }
    }

    public void inscrire(int idMembre, String nom, long telephone) throws SQLException
    {
        stmtInsert.setInt(1, idMembre);
        stmtInsert.setString(2, nom);
        stmtInsert.setLong(3, telephone);
        stmtInsert.executeUpdate();
    }

    public int preter(int idMembre) throws SQLException
    {
        stmtUpdateIncrNbPret.setInt(1, idMembre);
        return stmtUpdateIncrNbPret.executeUpdate();
    }

    public int retourner(int idMembre) throws SQLException
    {
        stmtUpdateDecNbPret.setInt(1, idMembre);
        return stmtUpdateDecNbPret.executeUpdate();
    }

    public int desinscrire(int idMembre) throws SQLException
    {
        stmtDelete.setInt(1, idMembre);
        return stmtDelete.executeUpdate();
    }
}
