package stage;

import java.util.Date;

public class Historique {

    private int id;
    private int idEleve;
    private Entreprise entreprise;
    private String entName;
    private String Methode;
    private String Retour;
    private String dateHist;

    /**
     * ON ajoute des commentaires
     */
    public Historique(int id, int idEleve,Entreprise entreprise,String Methode,String Retour,String dateHist) {
        super();
        this.id = id;
        this.idEleve = idEleve;
        this.entreprise = entreprise;
        this.Methode = Methode;
        this.Retour = Retour;
        this.dateHist=dateHist;
    }

    public Historique(int id, int idEleve,String entName,String Methode,String Retour,String dateHist) {
        super();
        this.id = id;
        this.idEleve = idEleve;
        this.entName = entName;
        this.Methode = Methode;
        this.Retour = Retour;
        this.dateHist=dateHist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(int idEleve) {
        this.idEleve = idEleve;
    }

    public String getMethode() {
        return Methode;
    }

    public void setMethode(String methode) {
        Methode = methode;
    }

    public String getRetour() {
        return Retour;
    }

    public void setRetour(String retour) {
        Retour = retour;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public String getDateHist() {
        return dateHist;
    }

    public void setDateHist(String dateHist) {
        this.dateHist = dateHist;
    }

    @Override
    public String toString() {
        return "Historique{" +
                "id=" + id +
                ", idEleve=" + idEleve +
                ", entreprise=" + entreprise +
                ", entName='" + entName + '\'' +
                ", Methode='" + Methode + '\'' +
                ", Retour='" + Retour + '\'' +
                ", dateHist=" + dateHist +
                '}';
    }
}

