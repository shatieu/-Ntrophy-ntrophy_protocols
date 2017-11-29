/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocols_app;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import protocol.enums.Attributes;

/**
 *
 * @author Ondrej Urbanovsky
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    private ChoiceBox ifChoice;
    @FXML
    private ChoiceBox<?> choiseIf;
    @FXML
    private ChoiceBox<?> choiceActionTrue;
    @FXML
    private ChoiceBox<?> choiceActionFalse;
    @FXML
    private Button buttonSaveProtocol;
    @FXML
    private Button buttonAddLineProtocol;
    @FXML
    private Button buttonRemoveLineProtocol;
    @FXML
    private TextField fieldProtocolName;
    @FXML
    private Label labelIfID;
    @FXML
    private ChoiceBox<?> choiseIf1;
    @FXML
    private ChoiceBox<?> choiceActionTrue1;
    @FXML
    private ChoiceBox<?> choiceActionFalse1;
    @FXML
    private Label labelIfID1;
    @FXML
    private ChoiceBox<?> choiseIf11;
    @FXML
    private ChoiceBox<?> choiceActionTrue11;
    @FXML
    private ChoiceBox<?> choiceActionFalse11;
    @FXML
    private Label labelIfID11;
    @FXML
    private Button buttonObjectCreate;
    @FXML
    private TextField fieldObjectName;
    @FXML
    private ChoiceBox<?> choiceObjectType;
    @FXML
    private ChoiceBox<?> choiceActiveObject;
    @FXML
    private Button buttonObjectRun;
    @FXML
    private Button buttonObjectDelete;
    @FXML
    private Button buttonObjectLoad;
    @FXML
    private Button buttonCreateAllObject;
    @FXML
    private ChoiceBox<?> choiceActiveProtocol;
    @FXML
    private Button buttonProtocolRun;
    @FXML
    private Button buttonProtocolDelete;
    @FXML
    private Button buttonProtocolLoad;
    @FXML
    private Button buttonProtocolExport;
    @FXML
    private Button buttonImportAndExecute;
    @FXML
    private ChoiceBox<?> choiceAttributeLife;
    @FXML
    private ChoiceBox<?> choiceAttributeBigger;
    @FXML
    private ChoiceBox<?> choiceAttributeActive;
    @FXML
    private ChoiceBox<?> choiceAttributeWeapons;
    @FXML
    private ChoiceBox<?> choiceAttributeFast;
    @FXML
    private ChoiceBox<?> choiceAttributeResources;
    @FXML
    private ChoiceBox<?> choiceAttributeComm;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setIfChoices(new ChoiceBox[]{choiseIf});
        setAttributeChoises(new ChoiceBox[]{choiceAttributeActive, choiceAttributeBigger, choiceAttributeComm, choiceAttributeFast, choiceAttributeLife, choiceAttributeResources, choiceAttributeWeapons});
    }

    private void setIfChoices(ChoiceBox[] boxes) {
        ObservableList<String> values = FXCollections.observableArrayList();
        for (Attributes atr : Attributes.values()) {
            values.add(atr.toString());
        }

        for (ChoiceBox box : boxes) {
            box.setItems(values);
        }
    }

    private void setAttributeChoises(ChoiceBox[] boxes) {
        ObservableList<String> values = FXCollections.observableArrayList(
                "True", "False", "Undefined"
        );

        for (ChoiceBox box : boxes) {
            box.setItems(values);
        }
    }

}