package dao;

import stage.Adresse;

import java.sql.ResultSet;
import java.sql.SQLException;

import stage.Adresse;
import stage.Profil;
import stage.User;

//public class UserDAO {

public class UserDAO extends DAO<User>{

    private static final String TABLE = "Utilisateur";
    private static final String CLE_PRIMAIRE = "IdUtilisateur";

    private static final String NOM = "Nom";
    private static final String PRENOM ="Prénom";
    private static final String LOGIN = "Login";
    private static final String MDP = "MotDePasse";
    private static final String IDPROFIL = "IdProfil";
    private static final String IDADRESSE = "IdAdresse";

    private static UserDAO instance=null;

    public static UserDAO getInstance(){
        if (instance==null){
            instance = new UserDAO();
        }
        return instance;
    }

    private UserDAO() {
        super();
    }


    @Override
    public boolean create(User obj) {
        return false;
    }

    @Override
    public boolean delete(User obj) {
        return false;
    }

    @Override
    public boolean update(User obj) {
        return false;
    }


    public User readUser(String login) {
        User user = null;
        try {
            String requete = "SELECT * FROM " + TABLE + " WHERE " + LOGIN + " = '" + login + "'";
            ResultSet rs = Connexion.executeQuery(requete);
            rs.next();
            String nom = rs.getString(NOM);
            String prenom = rs.getString(PRENOM);
            //String login = rs.getString(LOGIN);
            String mdp = rs.getString(MDP);
            int idProfil = rs.getInt(IDPROFIL);
            Profil profil= ProfilDAO.getInstance().read(idProfil);
            int id = rs.getInt(CLE_PRIMAIRE);
            int idAdr = rs.getInt(IDADRESSE);

            Adresse adr= AdresseDAO.getInstance().read(idAdr);
            user = new User (id,profil, nom, prenom, login, mdp,adr);

        } catch (SQLException e) {
            System.out.println("Pas de donnée pour cet utilisateur");
        }
        return user;
    }

    @Override
    public User read(int id) {
        User user = null;
        if (donnees.containsKey(id)) {
            //System.out.println("r�cup�r�");
            user=donnees.get(id);
        }
        else {
            //System.out.println("recherch� dans la BD");
            try {
                String requete = "SELECT * FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = "+id;
                ResultSet rs = Connexion.executeQuery(requete);
                rs.next();
                String nom = rs.getString(NOM);
                String prenom = rs.getString(PRENOM);
                String login = rs.getString(LOGIN);
                String mdp = rs.getString(MDP);

                int idProfil = rs.getInt(IDPROFIL);
                Profil profil= ProfilDAO.getInstance().read(idProfil);

                int idAdr = rs.getInt(IDADRESSE);
                Adresse adr= AdresseDAO.getInstance().read(idAdr);

                //public User(int idProfil, String nom, String  prenom, String login, String mdp) {
                user = new User (id,profil, nom, prenom, login, mdp, adr);

                donnees.put(id, user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}









