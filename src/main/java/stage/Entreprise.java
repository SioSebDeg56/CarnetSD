package stage;

public class Entreprise {

    private int idEnt;
    private String nom;
    private String mail;
    private String tel;
    private String url;
    private int taille;


    public Entreprise (int objIdEnt,String objNom,String objMail,String objTel, String objURL, int objTaille){
        super();
        this.idEnt=objIdEnt;
        this.nom=objNom;
        this.mail=objMail;
        this.tel=objTel;
        this.url=objURL;
        this.taille=objTaille;
    }

    public int getIdEnt() {
        return idEnt;
    }

    public void setIdEnt(int idEnt) {
        this.idEnt = idEnt;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    @Override
    public String toString() {
        return "Entreprise{" +
                "idEnt=" + idEnt +
                ", nom='" + nom + '\'' +
                ", mail='" + mail + '\'' +
                ", tel='" + tel + '\'' +
                ", url='" + url + '\'' +
                ", taille=" + taille +
                '}';
    }
}

