package xyz.syc.atm.atm;

public class DataModel {
    private static String num;

    private static String passwd;

    private static int money;

    public static int getMoney() {
        return money;
    }

    public static String getNum() {
        return num;
    }

    public static String getPasswd() {
        return passwd;
    }

    public static void setMoney(int money) {
        DataModel.money = money;
    }

    public static void setNum(String num) {
        DataModel.num = num;
    }

    public static void setPasswd(String passwd) {
        DataModel.passwd = passwd;
    }
}
