package xyz.syc.atm.atm;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class WithdrawUIController implements ControlledStage {
    @FXML
    public TextField intextfield;
    @FXML
    public Label tips2;
    public int count = 0;
    StageController myController;

    @Override
    public void setStageController(StageController stageController) {
        myController = stageController;
    }

    public void onClick() {
        int inmoney = Integer.parseInt(intextfield.getText());
        if (inmoney >= 5000 || count >= 5000) {
            tips2.setText("总取款额度不能大于5000元！");
            tips2.setStyle("-fx-text-fill: red");
        }
        if (inmoney > DataModel.getMoney()) {
            tips2.setText("余额不足，请重新输入！");
            tips2.setStyle("-fx-text-fill: red");
            return;
        }
        if (inmoney % 100 == 0 && inmoney > 0) {
            Dao.updateMoney(-inmoney);
            DataModel.setMoney(DataModel.getMoney() - inmoney);
            tips2.setText("取款成功，当前余额：" + DataModel.getMoney());
            tips2.setStyle("-fx-text-fill: green");
        } else {
            tips2.setText("取款金额错误，请重新输入！");
            tips2.setStyle("-fx-text-fill: red");
        }
    }
}
