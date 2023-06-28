package xyz.syc.atm.atm;

import com.jfoenix.controls.JFXDialog;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class ShowWarningMessage {
    AnchorPane context;

    JFXDialog dialog;

    StackPane dialogStackPane;

    private Label header;

    private Label body;

    private double normal = 16.0;

    ShowWarningMessage(AnchorPane context, JFXDialog dialog, Label header, Label body) {
        this.context = context;
        this.dialog = dialog;
        this.header = header;
        this.body = body;
    }

    /**
     * 弹出JFXDialog弹窗
     */
    public void alert() {
        addDialogStackPane();
        dialogStackPane.setPrefWidth(context.getPrefWidth() * 0.7);
        dialogStackPane.setPrefHeight(context.getPrefHeight() * 0.5);
        dialogStackPane.setLayoutX((context.getPrefWidth() - dialogStackPane.getPrefWidth()) / 2);
        dialogStackPane.setLayoutY((context.getPrefHeight() - dialogStackPane.getPrefHeight()) / 2 / 2);
        dialog.setTransitionType(JFXDialog.DialogTransition.CENTER);
        dialog.show(dialogStackPane);
    }

    /**
     * 关闭JFXDialog弹窗
     */
    public void close() {
        dialog.close();
        dialogStackPane.getChildren().remove(dialog);
        context.getChildren().remove(dialogStackPane);
    }

    /**
     * 新增JFXDialog弹窗容器
     */
    private void addDialogStackPane() {
        dialogStackPane = new StackPane();
        dialogStackPane.setPrefHeight(context.getHeight());
        dialogStackPane.setPrefWidth(context.getWidth());
        context.getChildren().add(dialogStackPane);
    }

    public void setMessage(String headerStr, String bodyStr, int type) {
        switch (type) {
            case 1 -> header.setStyle("-fx-text-fill: green");
            case 2 -> header.setStyle("-fx-text-fill: red");
            default -> header.setStyle("-fx-text-fill: black");
        }
        header.setText(headerStr);
        body.setText(bodyStr);
        //自适应显示字符串长度匹配文字大小
        body.setFont(Font.font(normal - ((bodyStr.length() / 8) * 4)));

    }
}
