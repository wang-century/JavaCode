package cn.centuryw.planeGame;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;


/**
 * 游戏主窗口
 *
 * @author centuryw
 */
public class MyGameFrame extends JFrame {
    //加载图片
    Image planeImage = GameUtil.getImage("images/planeGame/explode/plane.png");
    Image bg = GameUtil.getImage("images/planeGame/explode/bg.jpg");

    Plane plane = new Plane(planeImage, 250, 250);
    Shell[] shells = new Shell[50];
    Explode explode;
    //计时
    Date startTime = new Date();
    Date endTime;
    int score;  //游戏成绩  存活时间

    //键盘监听的内部类
    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            plane.deleteDirection(e);
        }


    }


    /*初始化窗口*/
    public void launchFrame() {
        //在游戏窗口打印标题
        this.setTitle("飞机游戏");
        this.setVisible(true);  //设置可见
        this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);  //设置窗口大小
        this.setLocation(300, 300);  //设置显示位置


        //关闭窗口时关闭进程
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new KeyMonitor());   //增加键盘监听
        new PaintThread().start();   //启动重画窗口的线程

        //初始化炮弹
        for (int i = 0; i < shells.length; i++) {
            shells[i] = new Shell();
        }

    }


    //反复的重画窗口
    class PaintThread extends Thread {
        @Override
        public void run() {
            while (true) {
//                System.out.println("窗口重画");
                repaint();  //重画
                try {
                    Thread.sleep(40);   //1s=1000ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void paint(Graphics g) {  //自动被调用，g相当于一只画笔
        /*
        Color a = g.getColor(); //将现有颜色保存
        g.setColor(Color.GREEN);    //修改画笔颜色
        g.drawLine(100,100,300,300);    //线
        g.drawRect(100,100,300,300);    //矩形
        g.drawOval(100,100,300,300);    //椭圆 依据外切矩形
        g.setColor(a);  //还原颜色

        Font f = g.getFont();   //获取当前字体
        g.setFont(new Font("宋体",Font.BOLD,50)); //设置字体
        g.drawString("你好！",200,200);    //写字
        g.setFont(f);   //还原字体
        */
        g.drawImage(bg, 0, 0, null);
        plane.drawSelf(g);  //画飞机
        //画出所有炮弹
        for (int i = 0; i < shells.length; i++) {
            shells[i].draw(g);
            //判断是否碰撞
            boolean peng = shells[i].getRect().intersects(plane.getRect());
            if (peng){
                plane.live = false;
                endTime = new Date();
                if (explode == null){
                    explode = new Explode(plane.x,plane.y);
                }
                explode.draw(g);
                score = (int)(endTime.getTime() - startTime.getTime())/1000;
            }
            if (!plane.live){
                g.setColor(Color.white);
                g.setFont(new Font("宋体",Font.BOLD,30)); //设置字体
                g.drawString("存活时间:"+score+"秒",(int)plane.x,(int)plane.y);
            }
        }


    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }


    //双缓冲解决闪烁问题
    private Image offScreenImage = null;

    public void update(Graphics g) {
        if (offScreenImage == null)
            offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);

        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }
}


