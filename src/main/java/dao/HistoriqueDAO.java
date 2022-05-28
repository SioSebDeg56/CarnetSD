package dao;

import stage.Entreprise;
import stage.Historique;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class HistoriqueDAO extends DAO<Historique> {
    private static final String TABLE = "Historique";
    private static final String CLE_PRIMAIRE = "Id";

    private static final String ID_ELEVE = "Id_élève";
    private static final String ID_ENTREPRISE = "Id_entreprise";
    private static final String METHODE = "Méthode";
    private static final String RETOUR = "Retour";
    private static final String DATE = "Date";

    private static HistoriqueDAO instance = null;

    public static HistoriqueDAO getInstance() {
        if (instance == null) {
            instance = new HistoriqueDAO();
        }
        return instance;
    }

    //private HistoriqueDAO() {
    //super();
    //}

    @Override
    public boolean create(Historique obj) {
        return false;
    }

    @Override
    public boolean delete(Historique obj) {
        return false;
    }

    @Override
    public boolean update(Historique obj) {
        return false;
    }

    @Override
    public Historique read(int id) {
        Historique historique = null;
        if (donnees.containsKey(id)) {
            //System.out.println("r�cup�r�");
            historique = donnees.get(id);
        } else {
            //System.out.println("recherch� dans la BD");
            try {

                String requete = "SELECT * FROM " + TABLE + " WHERE " + CLE_PRIMAIRE + " = " + id;
                ResultSet rs = Connexion.executeQuery(requete);
                rs.next();
                int idElev = rs.getInt(ID_ELEVE);

                int idEntre = rs.getInt(ID_ENTREPRISE);
                Entreprise entreprise = EntrepriseDAO.getInstance().read(idEntre);

                String Methode = rs.getString(METHODE);
                String Ret = rs.getString(RETOUR);
                String date = rs.getString(DATE);

                historique = new Historique(id, idElev, entreprise, Methode, Ret, date);
                donnees.put(id, historique);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return historique;
    }

    public List<Historique> readAll() {
        Historique historique = null;
        List<Historique> historiques = null;
        try {
            String requete = "SELECT * FROM " + TABLE;
            ResultSet rs = Connexion.executeQuery(requete);
            historiques = new ArrayList<Historique>();
            boolean recordNext = rs.next();
            while (recordNext) {
                int id = rs.getInt(CLE_PRIMAIRE);
                int idElev = rs.getInt(ID_ELEVE);

                int idEntre = rs.getInt(ID_ENTREPRISE);
                Entreprise entreprise = EntrepriseDAO.getInstance().read(idEntre);

                String Methode = rs.getString(METHODE);
                String Ret = rs.getString(RETOUR);
                String date = rs.getString(DATE);

                historique = new Historique(id, idElev, entreprise, Methode, Ret, date);
                historiques.add(historique);
                recordNext = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return historiques;
    }

    public List<Historique> readByUserComplet(int id) {
        Historique historique = null;
        List<Historique> historiques = null;
        try {
            String requete = "SELECT * FROM " + TABLE + " WHERE " + ID_ELEVE + " = " + id;
            ;
            ResultSet rs = Connexion.executeQuery(requete);
            historiques = new ArrayList<Historique>();
            boolean recordNext = rs.next();
            while (recordNext) {
                int idHist = rs.getInt(CLE_PRIMAIRE);

                int idEntre = rs.getInt(ID_ENTREPRISE);
                Entreprise entreprise = EntrepriseDAO.getInstance().read(idEntre);

                String Methode = rs.getString(METHODE);
                String Ret = rs.getString(RETOUR);
                String date = rs.getString(DATE);

                historique = new Historique(idHist, id, entreprise, Methode, Ret, date);
                historiques.add(historique);
                recordNext = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return historiques;
    }

    public List<Historique> readByUserNom(int id) {
        Historique historique = null;
        List<Historique> historiques = null;
        try {
            String requete = "SELECT * FROM " + TABLE + " WHERE " + ID_ELEVE + " = " + id;
            ResultSet rs = Connexion.executeQuery(requete);
            historiques = new ArrayList<Historique>();
            boolean recordNext = rs.next();
            while (recordNext) {
                int idHist = rs.getInt(CLE_PRIMAIRE);

                int idEntre = rs.getInt(ID_ENTREPRISE);
                Entreprise entreprise = EntrepriseDAO.getInstance().read(idEntre);
                String entrepriseName = entreprise.getNom();

                String Methode = rs.getString(METHODE);
                String Ret = rs.getString(RETOUR);
                String dateH = rs.getString(DATE);

                historique = new Historique(idHist, id, entrepriseName, Methode, Ret, dateH);
                historiques.add(historique);
                recordNext = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return historiques;
    }
}
