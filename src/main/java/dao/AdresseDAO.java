package dao;

import stage.Adresse;
import java.sql.ResultSet;
import java.sql.SQLException;

import stage.Adresse;
import stage.User;

public class AdresseDAO extends DAO<Adresse>{
    private static final String TABLE = "Adresse";
    private static final String CLE_PRIMAIRE = "IdAdresse";

    private static final String NUM_VOIE = "NumVoie";
    private static final String VOIE ="LibelleVoie";
    private static final String CODE_POSTAL = "CodePostal";
    private static final String VILLE = "Ville";
    private static final String PAYS = "Pays";

    private static AdresseDAO instance=null;

    public static AdresseDAO getInstance(){
        if (instance==null){
            instance = new AdresseDAO();
        }
        return instance;
    }

    private AdresseDAO() {
        super();
    }

    @Override
    public boolean create(Adresse obj) {return false;}
    @Override
    public boolean delete(Adresse obj) {
        return false;
    }
    @Override
    public boolean update(Adresse obj) {
        return false;
    }

    @Override
    public Adresse read(int id) {
        Adresse adresse = null;
        if (donnees.containsKey(id)) {
            //System.out.println("r�cup�r�");
            adresse=donnees.get(id);
        }
        else {
            //System.out.println("recherch� dans la BD");
            try {

                String requete = "SELECT * FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = "+id;
                ResultSet rs = Connexion.executeQuery(requete);
                rs.next();
                String numVoie = rs.getString(NUM_VOIE);
                String Voie = rs.getString(VOIE);
                String CP = rs.getString(CODE_POSTAL);
                String ville = rs.getString(VILLE);
                String pays = rs.getString(PAYS);

                adresse = new Adresse (id, numVoie, Voie, CP, ville, pays);
                donnees.put(id, adresse);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return adresse;
    }
}
