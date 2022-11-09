package com.threadstudy.syn;

//不安全的取钱
public class UnSafeBank {
    public static void main(String[] args) {
        //账户
        Account money = new Account(1000,"结婚基金");

        Drawing you = new Drawing(money,50,"你");
        Drawing yourgirfriend = new Drawing(money,100,"女朋友");

        you.start();
        yourgirfriend.start();

    }



}
class Account{
    int money;//余额
    String name;//卡名

    public Account(int money, String name){
        this.money = money;
        this.name = name;
    }
}

//模拟银行取款
class  Drawing extends Thread{
    Account account;//账户
    //取了多少钱
    int drawingMany;
    //现在手里有多少钱
    int nowMoney;

    public Drawing(Account account, int drawingMany, String name){
        super(name);
        this.account = account;
        this.drawingMany = drawingMany;
    }

    //取钱
    @Override
    public void run() {

        synchronized (account){
            //判断有没有钱
            if (account.money - drawingMany < 0){
                System.out.println(this.getName() + "的余额不足！");
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //进行取款操作,账户中的余额等于原来的钱减去你取的
            account.money = account.money - drawingMany;
            //你手里的钱等于
            nowMoney = nowMoney + drawingMany;

            System.out.println(account.name  + "余额为" + account.money);
            //这里this.getName() 等价于 Thread.currentThread.getName
            System.out.println(this.getName() + "手里的钱为" + nowMoney);
        }
    }
}