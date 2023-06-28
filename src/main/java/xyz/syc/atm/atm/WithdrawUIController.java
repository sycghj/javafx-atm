package xyz.syc.atm.atm;

import com.jfoenix.controls.JFXDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class WithdrawUIController implements ControlledStage {
    @FXML
    public TextField intextfield;
    @FXML
    public Label tips2;
    public int count = 0;
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
        if (intextfield.getText().isEmpty()) {
            showWarningMessage.setMessage("警告！",
                    "输入不能为空！", 2);
            showWarningMessage.alert();
            return;
        }
        int inmoney = Integer.parseInt(intextfield.getText());
        if (inmoney >= 5000 || count >= 5000) {
            showWarningMessage.setMessage("警告！",
                    "取款总额不能大于5000元！", 2);
            showWarningMessage.alert();
        }
        if (inmoney > DataModel.getMoney()) {
            showWarningMessage.setMessage("警告！",
                    "余额不足！", 2);
            showWarningMessage.alert();
            return;
        }
        if (inmoney % 100 == 0 && inmoney > 0) {
            Dao.updateMoney(-inmoney);
            DataModel.setMoney(DataModel.getMoney() - inmoney);
            showWarningMessage.setMessage("成功！",
                    "取款成功，当前余额" + DataModel.getMoney() + "！", 1);
            showWarningMessage.alert();
        } else {
            showWarningMessage.setMessage("警告！",
                    "输入金额错误，请重新输入！", 2);
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
