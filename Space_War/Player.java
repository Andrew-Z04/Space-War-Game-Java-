import javax.swing.*;
import java.awt.*;
public class Player {
    private int player_x = 80;
    private int player_y = 250;
    private Image img;
    private void loadImage(){
        ImageIcon ii= new ImageIcon("src/Image/Player.png");
        img = ii.getImage();
        w=img.getWidth(null);
        h=img.getHeight(null);
    }
    public Image getImg() {
        return img;
    }
    public void setImg(Image img) {
        this.img = img;
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
    private int h, w;
    public Player(){
        loadImage();
    }

    public int getPlayerX(){
        return this.player_x;
    }
    public int getPlayerY(){
        return this.player_y;
    }
    public void setPlayer_x(int player_x) {
        this.player_x = player_x;
    }
    public void setPlayer_y(int player_y) {
        this.player_y = player_y;
    }
    public Bullet shoot(){
        return new Bullet(this);
    }
}
