package xyz.syc.atm.atm;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApplication extends Application {
    public static String mainViewID = "LoginController";
    public static String mainViewRes = "Login.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //新建一个StageController控制器
        StageController stageController = new StageController();

        //将主舞台交给控制器处理
        stageController.setPrimaryStage("primaryStage", primaryStage);

        //加载两个舞台，每个界面一个舞台
//        stageController.loadStage(loginViewID, loginViewRes, StageStyle.UNDECORATED);
        stageController.loadStage(mainViewID, mainViewRes);

        //显示MainView舞台
        stageController.setStage(mainViewID);
    }
}
