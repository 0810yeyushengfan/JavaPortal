package test3;

public class BallTest {
}
interface Playable {
    void play();
}
interface Bounceable {
    void play();
}
interface Rollable extends Playable,
        Bounceable {
    Ball ball = new Ball("PingPang");
}
class Ball implements Rollable {
    private String name;
    public String getName() {
        return name; }
    public Ball(String name) {
        this.name = name; }
    public void play() {//这个方法重写的是所有的和它重名同参数的方法，也就是说在本题中重写了Bounceable的play()方法和playable的play()方法这两个方法。
        //编译报错，因为ball之前在Rollable这个接口中定义过了，而在接口中定义的变量都算作全局常量，不能修改。
        //ball = new Ball("Football");
        System.out.println(ball.getName());
    } }