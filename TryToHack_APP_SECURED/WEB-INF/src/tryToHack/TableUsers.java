package tryToHack;

import java.sql.*;

public class TableUsers
{
    private PreparedStatement stmtExiste;
    private PreparedStatement stmtInsert;
    private PreparedStatement stmtDelete;
    private PreparedStatement stmtVerifyCredential;
    private Connexion cx;

    public TableUsers(Connexion cx) throws SQLException
    {
        this.cx = cx;
        stmtExiste = cx.getConnection().prepareStatement("SELECT userid, username FROM users_secured WHERE username = ?");
        stmtVerifyCredential = cx.getConnection().prepareStatement("SELECT userid, username FROM users_secured WHERE username = ? AND password = ?");
        stmtInsert = cx.getConnection().prepareStatement("INSERT INTO users_secured (nom, prenom, username, password) VALUES (?,?,?,?)");
        stmtDelete = cx.getConnection().prepareStatement("DELETE FROM users_secured WHERE userid = ?");
    }

    public Connexion getConnexion()
    {
        return cx;
    }

    public boolean existe(String username) throws SQLException
    {
        stmtExiste.setString(1, username);
        ResultSet rset = stmtExiste.executeQuery();
        boolean userExiste = rset.next();
        rset.close();
        return userExiste;
    }

    public boolean verifyCredentials(String username, String password) throws SQLException
    {
    		stmtVerifyCredential.setString(1, username);
    		stmtVerifyCredential.setString(2, password);
        
    		ResultSet rset = stmtVerifyCredential.executeQuery();
        boolean res = rset.next();
        rset.close();
        
        return res;
    }

    public TupleUser getUser(int iduser) throws SQLException
    {
        stmtExiste.setInt(1, iduser);
        
        ResultSet rset = stmtExiste.executeQuery();
        if (rset.next())
        {
            TupleUser tupleUser = new TupleUser();
            tupleUser.setIdUser(iduser);
            tupleUser.setUsername(rset.getString(2));
            tupleUser.setPassword(rset.getString(3));
            rset.close();
            return tupleUser;
        }
        else
        {
            return null;
        }
    }

    public void addUser(String nom, String prenom, String username, String password, String password2) throws SQLException
    {
        stmtInsert.setString(1, nom);
        stmtInsert.setString(2, prenom);
        stmtInsert.setString(3, username);
        stmtInsert.setString(4, password);
        
        stmtInsert.executeUpdate();
    }

    public int removeUser(int idUser) throws SQLException
    {
        stmtDelete.setInt(1, idUser);
        return stmtDelete.executeUpdate();
    }
}
