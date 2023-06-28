package xyz.syc.atm.atm;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ServiceController implements ControlledStage, Initializable {
    @FXML
    public AnchorPane root;
    @FXML
    public Label welcome;
    @FXML
    public Label money;
    @FXML
    public JFXButton querybutton;
    @FXML
    public JFXButton changebutton;
    @FXML
    public JFXButton savebutton;
    @FXML
    public JFXButton withdrawbutton;
    StageController myController;

    @Override
    public void setStageController(StageController stageController) {
        myController = stageController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcome.setText("您好，卡号" + DataModel.getNum().substring(0, 2) + "***" + DataModel.getNum().substring(3, 5) + "的用户，欢迎使用本ATM设备");
    }

    public void onClickQuery() {
        money.setText("您的余额为：￥" + DataModel.getMoney());
    }

    public void onClickChange() {
        myController.loadStage("ChangePassUIController", "ChangePassUI.fxml");
        myController.setStage("ChangePassUIController");
    }

    public void onClickSave() {
        myController.loadStage("SaveUIController", "SaveUI.fxml");
        myController.setStage("SaveUIController");
    }


    public void onClickWithdraw() {
        myController.loadStage("WithdrawUIController", "WithdrawUI.fxml");
        myController.setStage("WithdrawUIController");
    }
}
