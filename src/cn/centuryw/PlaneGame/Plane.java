package cn.centuryw.PlaneGame;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * 飞机类
 */
public class Plane extends GameObject {

    //控制方向 左右上下，按下为true，松开为false
    boolean left, right, up, down;
    boolean live = true;

    public void drawSelf(Graphics g) {
        if (live) {
            g.drawImage(img, (int) x, (int) y, null);

            if (left) {
                x -= speed;
            }
            if (right) {
                x += speed;
            }
            if (up) {
                y -= speed;
            }
            if (down) {
                y += speed;
            }
        }else {

        }
    }

    public Plane(Image img, double x, double y) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = 3; //设置移动速度
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }

    //按下某键，增加相应的方向
    public void addDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
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
    public void deleteDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
        }
    }


}
