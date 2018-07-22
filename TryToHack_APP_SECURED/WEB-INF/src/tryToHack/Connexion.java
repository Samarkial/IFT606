package tryToHack;

import java.sql.*;

public class Connexion
{
    private Connection conn;

    public Connexion() throws TryToHackException, SQLException
    {
        Driver d;
        try
        { 

            d = (Driver)Class.forName("org.postgresql.Driver").newInstance();

            DriverManager.registerDriver(d);
            
            conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/trytohack", "Kevin", "qwertyui");

            conn.setAutoCommit(false);

            DatabaseMetaData dbmd = conn.getMetaData();
            if (dbmd.supportsTransactionIsolationLevel(Connection.TRANSACTION_SERIALIZABLE))
            {
                conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                //System.out.println("Ouverture de la connexion en mode sérialisable :\n" + "Estampille " + System.currentTimeMillis() + " " + conn);
            }
            else
            {
                //System.out.println("Ouverture de la connexion en mode read committed (default) :\n" + "Heure " + System.currentTimeMillis() + " " + conn);
            }
        }catch (SQLException e){
            throw e;
        }
        catch (Exception e)
        {
            e.printStackTrace(System.out);
            throw new SQLException("JDBC Driver non instancié");
        }
    }

    public void fermer() throws SQLException
    {
        conn.rollback();
        conn.close();
        System.out.println("Connexion fermée " + conn);
    }

    public void commit() throws SQLException
    {
        conn.commit();
    }

    public void setIsolationReadCommited() throws SQLException
    {
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
    }

    public void rollback() throws SQLException
    {
        conn.rollback();
    }

    public Connection getConnection()
    {
        return conn;
    }

    public void setAutoCommit(boolean m) throws SQLException
    {
        conn.setAutoCommit(false);
    }
}
