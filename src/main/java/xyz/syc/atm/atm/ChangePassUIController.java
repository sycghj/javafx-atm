package xyz.syc.atm.atm;

import com.jfoenix.controls.JFXDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ChangePassUIController implements ControlledStage {

    @FXML
    public TextField oldpasswd;
    @FXML
    public TextField newpasswd;
    @FXML
    public TextField confirmpasswd;

    StageController myController;
    ShowWarningMessage showWarningMessage;
    @FXML
    private Label header;
    @FXML
    private Label body;
    @FXML
    private AnchorPane context;
    @FXML
    private JFXDialog dialog;

    @Override
    public void setStageController(StageController stageController) {
        myController = stageController;
    }

    public void onClick() {
        if (showWarningMessage == null) {
            initShowWarningMessage();
        }
        if (oldpasswd.getText().isEmpty() || newpasswd.getText().isEmpty() || confirmpasswd.getText().isEmpty()) {
            showWarningMessage.setMessage("警告！",
                    "输入不能为空！", 2);
            showWarningMessage.alert();
            return;
        }
        String temp = newpasswd.getText();
        if (DataModel.getPasswd().equals(oldpasswd.getText())) {
            char t = temp.charAt(0);
            int count = 1;
            for (int i = 1; i < temp.length(); i++) {
                if (t == temp.charAt(i)) {
                    count += 1;
                }
            }
            if (count == temp.length()) {
                showWarningMessage.setMessage("警告！",
                        "密码不能为重复数字！", 2);
                showWarningMessage.alert();
                return;
            }
            if (newpasswd.getText().equals(confirmpasswd.getText())) {
                Dao.updatePasswd(newpasswd.getText());
                DataModel.setPasswd(newpasswd.getText());
                showWarningMessage.setMessage("成功！",
                        "密码修改成功！", 1);
                showWarningMessage.alert();
            } else {
                showWarningMessage.setMessage("警告！",
                        "两次密码不一致！", 2);
                showWarningMessage.alert();
            }
        } else {
            showWarningMessage.setMessage("警告！",
                    "原密码错误！", 2);
            showWarningMessage.alert();
        }
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
