package stage;

import dao.*;

public class Main {

    public static void main(String[] args) {

        Connexion.getInstance();
        //System.out.println(HistoriqueDAO.getInstance().readByUserNom(6));
        Profil prof=new Profil(1,"01 44 23 23 98","nouveau@profil.fr");
        System.out.println(prof);
        //Historique historique=HistoriqueDAO.getInstance().read(1);
        //System.out.println(historique);
    }

}

