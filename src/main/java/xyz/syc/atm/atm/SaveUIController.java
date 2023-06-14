package xyz.syc.atm.atm;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SaveUIController implements ControlledStage{
    StageController myController;
    @FXML
    public TextField intextfield;
    @FXML
    public Label tips2;
    @Override
    public void setStageController(StageController stageController) {
        myController = stageController;
    }
    public void onClick(){

        int inmoney  = Integer.parseInt(intextfield.getText());
        if(inmoney%100==0&&inmoney>0){
            Dao.updateMoney(inmoney);
            DataModel.setMoney(DataModel.getMoney()+inmoney);
            tips2.setText("存款成功，当前余额："+DataModel.getMoney());
            tips2.setStyle("-fx-text-fill: green");
        }else{
            tips2.setText("存款金额错误，请重新输入！");
            tips2.setStyle("-fx-text-fill: red");
        }
    }

}
