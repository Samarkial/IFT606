package tryToHack;

public class TupleMembre
{
    private int idMembre;
    private String nom;
    private long telephone;
    
    public TupleMembre()
    {
    }
    
    public TupleMembre(int idMembre, String nom, long telephone)
    {
        this.setIdMembre(idMembre);
        this.setNom(nom);
        this.setTelephone(telephone);
    }

    public int getIdMembre()
    {
        return idMembre;
    }

    public void setIdMembre(int idMembre)
    {
        this.idMembre = idMembre;
    }
 
    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public long getTelephone()
    {
        return telephone;
    }
 
    public void setTelephone(long telephone)
    {
        this.telephone = telephone;
    }

}
