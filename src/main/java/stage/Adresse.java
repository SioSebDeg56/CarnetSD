package stage;

public class Adresse {

    private int idAd;
    private String numVoie;
    private String voie;
    private String codePostal;
    private String ville;
    private String pays;

    /**
     * ON ajoute des commentaires
     */
    public Adresse(int objIdAD, String objnumVoie,String objvoie,String objCP,String objville,String objpays) {
        super();
        this.idAd = objIdAD;
        this.numVoie = objnumVoie;
        this.voie = objvoie;
        this.codePostal = objCP;
        this.ville = objville;
        this.pays=objpays;
    }

    public int getIdAd() {
        return idAd;
    }

    public String getNumVoie() {
        return numVoie;
    }

    public String getVoie() {
        return voie;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }

    public String getPays() {
        return pays;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "idAd=" + idAd +
                ", numVoie='" + numVoie + '\'' +
                ", voie='" + voie + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }
}
