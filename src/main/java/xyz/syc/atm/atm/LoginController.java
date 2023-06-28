package xyz.syc.atm.atm;

import com.jfoenix.controls.JFXDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController implements ControlledStage {


    private static int count = 0;
    StageController myController;
    @FXML
    private TextField numTextField;

    @FXML
    private PasswordField passwordField;
    ShowWarningMessage showWarningMessage;
    @FXML
    private Label header;
    @FXML
    private Label body;
    @FXML
    private AnchorPane context;
    @FXML
    private JFXDialog dialog;

    public void onLoginClick(ActionEvent actionEvent) {
        if (showWarningMessage == null) {
            initShowWarningMessage();
        }
        if (numTextField.getText().isEmpty() || passwordField.getText().isEmpty()) {
            showWarningMessage.setMessage("警告！",
                    "输入不能为空！", 2);
            showWarningMessage.alert();
            return;
        }
        if (count == 5) {
            System.exit(1);
        }
        String num = numTextField.getText();
        String passwd = passwordField.getText();
        ResultSet res = Dao.queryInfo(num);
        try {
            res.next();
        } catch (SQLException e) {
            showWarningMessage.setMessage("警告！",
                    "用户不存在或账号错误！", 2);
            showWarningMessage.alert();
        }
        try {
            if (res.getString("passwd").equals(passwd)) {
                DataModel.setPasswd(res.getString("passwd"));
                DataModel.setNum(res.getString("bankid"));
                DataModel.setMoney(res.getInt("money"));
                myController.loadStage("ServiceController", "Service.fxml");
                myController.setStage("ServiceController", "LoginController");
            } else {
                count += 1;
                showWarningMessage.setMessage("警告！",
                        "密码错误！重试次数" + (5 - count), 2);
                showWarningMessage.alert();
            }
        } catch (SQLException e) {
            showWarningMessage.setMessage("警告！",
                    "用户不存在或账号错误！", 2);
            showWarningMessage.alert();
        }
    }

    @Override
    public void setStageController(StageController stageController) {
        myController = stageController;
    }

    public void initShowWarningMessage() {
        showWarningMessage = new ShowWarningMessage(context, dialog, header, body);

    }


    public void close(ActionEvent actionEvent) {
        if (showWarningMessage == null) {
            initShowWarningMessage();
        }
        showWarningMessage.close();
    }
}
