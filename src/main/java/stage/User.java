package stage;

public class User {

    private int idUtilisateur;
    private Profil profil;
    //private int idProfil;
    private String nom;
    private String prenom;
    private String login;
    private String mdp;
    private Adresse adr;

    /**
     * ON ajoute des commentaires
     * @param profil
     * @param nom
     * @param prenom
     * @param login
     * @param mdp
     */
    public User(Profil profil, String nom, String  prenom, String login, String mdp,Adresse adr) {
        super();
        this.profil=profil;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mdp=mdp;
        this.adr=adr;
    }
    public User(int idUtilisateur,Profil profil, String nom, String  prenom, String login, String mdp,Adresse adr) {
        super();
        this.idUtilisateur = idUtilisateur;
        this.profil=profil;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mdp=mdp;
        this.adr=adr;
    }

    /**
     * Encore d'autres
     * @return la localisation
     */
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public Profil getProfil() {
        return profil;
    }

    public String getNom() {
        return nom;
    }

    public Adresse getAdr() {return adr; }

    public String getPrenom() {
        return prenom;
    }

    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUtilisateur=" + idUtilisateur +
                ", profil=" + profil +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                ", adr=" + adr +
                '}';
    }
}
