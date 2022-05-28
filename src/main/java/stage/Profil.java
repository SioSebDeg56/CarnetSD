package stage;

public class Profil {

    private int idProfil;
    private String tel;
    private String mail;

    /**
     * ON ajoute des commentaires
     * @param idProfil
     * @param tel
     * @param mail
     */
    public Profil(int idProfil, String tel, String  mail) {
        super();
        this.idProfil=idProfil;
        this.tel = tel;
        this.mail = mail;
    }

    public int getIdProfil() {
        return idProfil;
    }

    public String getTel() {
        return tel;
    }

    public String getMail() {
        return mail;
    }

    public void setIdProfil(int idProfil) {
        this.idProfil = idProfil;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Profil{" +
                "idProfil=" + idProfil +
                ", tel='" + tel + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
