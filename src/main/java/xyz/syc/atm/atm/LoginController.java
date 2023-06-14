package xyz.syc.atm.atm;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController implements ControlledStage {


    StageController myController;

    private static int count = 0;

    @FXML
    private TextField numTextField;

    @FXML
    private Label wrningnum;

    @FXML
    private PasswordField passwordField;
    @FXML
    private Label wrningpasswd;
    @FXML
    private JFXButton loginButton;

    public void onLoginClick(ActionEvent actionEvent) {
        if(count==5){
            System.exit(1);
        }
        String num = numTextField.getText();
        if (num.isEmpty()){
            wrningnum.setText("用户名不能为空！");
            return;
        }
        String passwd = passwordField.getText();
        if (passwd.isEmpty()){
            wrningpasswd.setText("密码不能为空！");
            return;
        }
        ResultSet res = Dao.queryInfo(num);
        try {
            res.next();
        } catch (SQLException e) {
            wrningnum.setText("用户不存在！");
        }
        try {
            if(res.getString("passwd").equals(passwd)){
                DataModel.setPasswd(res.getString("passwd"));
                DataModel.setNum(res.getString("bankid"));
                DataModel.setMoney(res.getInt("money"));
                myController.loadStage("ServiceController","Service.fxml");
                myController.setStage("ServiceController","LoginController");
            }else {
                count+=1;
                wrningpasswd.setText("密码错误！重试次数"+(5-count));
            }
        } catch (SQLException e) {
                wrningnum.setText("用户不存在！");
        }
    }

    @Override
    public void setStageController(StageController stageController) {
        myController = stageController;
    }
}
