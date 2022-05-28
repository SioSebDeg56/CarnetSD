package stage;

import dao.HistoriqueDAO;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class C_profil implements Initializable {

    @FXML
    private TableView historiqueTable;
    @FXML
    private TableColumn<Historique, String> CnomEntreprise;
    @FXML
    private TableColumn<Historique, String> Cmethode;
    @FXML
    private TableColumn<Historique, String> Cretour;
    @FXML
    private TableColumn<Historique, String> Cdate;

    @FXML
    private Label Lprenom;

    @FXML
    private Label Lnom;

    @FXML
    private Label LadrNum;

    @FXML
    private Label LadrLib;

    @FXML
    private Label LadrVille;

    @FXML
    private Label LadrCP;

    @FXML
    private Label LadrPays;

    public void test() {
        System.out.println("bouton ok");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Lnom.setText(C_Login.userLog.getNom());
        Lprenom.setText(C_Login.userLog.getPrenom());
        Adresse userAdr = C_Login.userLog.getAdr();
        LadrNum.setText(userAdr.getNumVoie());
        LadrLib.setText(userAdr.getVoie());
        LadrVille.setText(userAdr.getVille());
        LadrCP.setText(userAdr.getCodePostal());
        LadrPays.setText(userAdr.getPays());

        List<Historique> historiques = HistoriqueDAO.getInstance().readByUserNom(C_Login.userLog.getIdUtilisateur());
        System.out.println(historiques);

        ObservableList<Historique> meshistoriques = FXCollections.observableArrayList(historiques);
        System.out.println(meshistoriques);

        CnomEntreprise.setCellValueFactory(new PropertyValueFactory<>("entName"));
        Cmethode.setCellValueFactory(new PropertyValueFactory<>("Methode"));
        Cretour.setCellValueFactory(new PropertyValueFactory<>("Retour"));
        Cdate.setCellValueFactory(new PropertyValueFactory<>("dateHist"));

        historiqueTable.setItems(meshistoriques);
    }

}
