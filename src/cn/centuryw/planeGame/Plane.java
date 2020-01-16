package cn.centuryw.planeGame;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * 飞机类
 */
public class Plane extends GameObject{
    //控制方向 左右上下，按下为true，松开为false
    boolean left,right,up,down;

    public void drawSelf(Graphics g) {
        g.drawImage(img, (int) x, (int) y, null);
        x++;
    }

    public Plane(Image img,double x,double y){
        this.img = img;
        this.x = x;
        this.y = y;
    }
    //按下某键，增加相应的方向
    public void addDirection(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
        }
    }
    //按下某键，取消相应的方向
    public void deleteDirection(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
        }
    }


}
