package xyz.syc.atm.atm;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ChangePassUIController implements ControlledStage {

    @FXML
    public TextField oldpasswd;
    @FXML
    public TextField newpasswd;
    @FXML
    public TextField confirmpasswd;
    @FXML
    public Label warning;
    StageController myController;

    @Override
    public void setStageController(StageController stageController) {
        myController = stageController;
    }

    public void onClick() {
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
                warning.setText("密码不能为重复数字！");
                return;
            }
            if (newpasswd.getText().equals(confirmpasswd.getText())) {
                Dao.updatePasswd(newpasswd.getText());
                DataModel.setPasswd(newpasswd.getText());
                warning.setText("密码修改成功！");
            } else {
                warning.setText("两次输入的密码不一致！");
            }
        } else {
            warning.setText("原密码错误！");
        }
    }
}
