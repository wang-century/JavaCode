package cn.centuryw.PlaneGame;

import java.awt.*;

/**
 * 炮弹类
 */
public class Shell extends GameObject{

    double degree;

    public Shell(){
        x = 200;
        y = 200;
        width = 10;
        height = 10;
        speed = 3;
        degree = Math.random()*Math.PI*2;   //角度随机 0-2PI
    }

    public void draw(Graphics g){
        Color a = g.getColor();
        g.setColor(Color.yellow);   //设置为黄色
        g.fillOval((int)x,(int)y,width,height);
        //炮弹沿着任意角度飞
        x += speed*Math.cos(degree);
        y += speed*Math.sin(degree);
        //添加反弹
        if (x<0 || x>Constant.GAME_WIDTH-width){
            degree = Math.PI - degree;
        }
        if (y<30 || y>Constant.GAME_HEIGHT-height){
            degree = - degree;
        }

        g.setColor(a);
    }

}
