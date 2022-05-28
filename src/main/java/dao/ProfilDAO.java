package dao;

import stage.Profil;
import stage.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProfilDAO extends DAO<Profil>{

    private static final String TABLE = "Profil";
    private static final String CLE_PRIMAIRE = "IdProfil";

    private static final String TEL = "Tel";
    private static final String MAIL ="Mail";

    private static ProfilDAO instance=null;

    public static ProfilDAO getInstance(){
        if (instance==null){
            instance = new ProfilDAO();
        }
        return instance;
    }


    @Override
    public boolean create(Profil profil) {
        boolean succes=true;
        try {
            String requete = "INSERT INTO "+TABLE+" ("+TEL+","+MAIL+") VALUES (?, ?)";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, profil.getTel());
            pst.setString(2, profil.getMail());

            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                profil.setIdProfil(rs.getInt(1));
            }
            donnees.put(profil.getIdProfil(), profil);

        } catch (SQLException e) {
            succes=false;
            e.printStackTrace();
        }

        return succes;
    }

    @Override
    public boolean delete(Profil obj) {
        return false;
    }

    @Override
    public boolean update(Profil obj) {
        return false;
    }

    @Override
    public Profil read(int id) {
        Profil profil = null;
        if (donnees.containsKey(id)) {
            //System.out.println("r�cup�r�");
            profil=donnees.get(id);
        }
        else {
            //System.out.println("recherch� dans la BD");
            try {
                String requete = "SELECT * FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = "+id;
                ResultSet rs = Connexion.executeQuery(requete);
                rs.next();
                String tel = rs.getString(TEL);
                String mail = rs.getString(MAIL);

                //public User(int idProfil, String nom, String  prenom, String login, String mdp) {
                profil = new Profil (id,tel, mail);

                donnees.put(id, profil);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return profil;
    }


}
