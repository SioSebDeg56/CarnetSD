package dao;

import stage.Entreprise;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EntrepriseDAO extends DAO<Entreprise>{


    private static final String TABLE = "Entreprise";
    private static final String CLE_PRIMAIRE = "IdEntreprise";

    private static final String NOM = "Nom";
    private static final String MAIL ="Email";
    private static final String TEL = "Téléphone";
    private static final String URL = "URL";
    private static final String TAILLE = "TailleEntreprise";

    private static EntrepriseDAO instance=null;

    public static EntrepriseDAO getInstance(){
        if (instance==null){
            instance = new EntrepriseDAO();
        }
        return instance;
    }

    @Override
    public boolean create(Entreprise obj) {
        return false;
    }

    @Override
    public boolean delete(Entreprise obj) {
        return false;
    }

    @Override
    public boolean update(Entreprise obj) {
        return false;
    }

    @Override
    public Entreprise read(int id) {
        Entreprise entreprise = null;
        if (donnees.containsKey(id)) {
            //System.out.println("r�cup�r�");
            entreprise=donnees.get(id);
        }
        else {
            //System.out.println("recherch� dans la BD");
            try {

                String requete = "SELECT * FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = "+id;
                ResultSet rs = Connexion.executeQuery(requete);
                rs.next();
                String nom = rs.getString(NOM);
                String email = rs.getString(MAIL);
                String tel = rs.getString(TEL);
                String url = rs.getString(URL);
                int taille = rs.getInt(TAILLE);

                entreprise = new Entreprise (id, nom, email, tel,url,taille);
                donnees.put(id, entreprise);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return entreprise;
    }
}
