import javax.swing.*;
import java.awt.*;
public class Enemy {
    private int enemy_x = 680;
    private int enemy_y;
    private  int h;
    public int getH() {
        return h;
    }
    public void setH(int h) {
        this.h = h;
    }
    public int getW() {
        return w;
    }
    public void setW(int w) {
        this.w = w;
    }
    private int w;
    public Image getImg() {
        return img;
    }
    public void setImg(Image img) {
        this.img = img;
    }
    private Image img;

    public Enemy() {
        loadImage();
        int r = (int) (Math.random() * 11);
        this.enemy_y = r * 40;
    }

    private void loadImage() {
        ImageIcon ii= new ImageIcon("src/Image/Enemy.png");
        img = ii.getImage();
        w=img.getWidth(null);
        h=img.getHeight(null);
    }
    public int getEnemyX() {
        return enemy_x;
    }
    public int getEnemyY() {
        return enemy_y;
    }
    public void setEnemy_x(int enemy_x) {
        this.enemy_x = enemy_x;
    }
    public void setEnemy_y(int enemy_y) {
        this.enemy_y = enemy_y;
    }
    public EnemyBullet shoot(){
        return new EnemyBullet(this);
        }
}

