package com.threadstudy;

public class StacticProxy {

    public static void main(String[] args) {
        Team team = new Team(new You());
        team.HappyShoot();
    }

}
interface shoot{
    //投篮
    void HappyShoot();
}

//真实角色，科比去投篮
class You implements shoot{

    @Override
    public void HappyShoot() {
        System.out.println("科比执行投篮！");
    }
}
//团队一起进攻
class Team implements shoot{

    private shoot target;

    public Team(shoot target) {
        this.target = target;
    }

    @Override
    public void HappyShoot() {
        before();
        this.target.HappyShoot();
        after();
    }

    private void before() {
        System.out.println("一个团队互相传球！最后传给科比！");
    }

    private void after() {
        System.out.println("球进了，绝杀！");
    }
}