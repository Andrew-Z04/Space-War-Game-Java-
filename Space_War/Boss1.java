import javax.swing.*;
import java.awt.*;
public class Boss1 {
    private int boss1_x = 500;
    private int boss1_y = 280;
    private int w;
    private int h;
    public Boss1() {
        loadImage();
    }
    public int getBoss1_x() {
        return boss1_x;
    }
    public void setBoss1_x(int boss1_x) {
        this.boss1_x = boss1_x;
    }
    public int getBoss1_y() {
        return boss1_y;
    }
    public void setBoss1_y(int boss1_y) {
        this.boss1_y = boss1_y;
    }
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
    public Image getImg() {
        return img;
    }
    public void setImg(Image img) {
        this.img = img;
    }
    private Image img;
    private void loadImage() {
        ImageIcon ii = new ImageIcon("src/Image/Boss1.png");
        img = ii.getImage();
        w = img.getWidth(null);
        h = img.getHeight(null);
    }
    public EnemyBoss1Bullet shoot(){
        return new EnemyBoss1Bullet(this);
    }
}
