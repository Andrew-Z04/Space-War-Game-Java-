import javax.swing.*;
import java.awt.*;
public class RepairBox {
    private int repairBox_x ;
    private int repairBox_y ;
    private Image img;
    private int h;
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
    public RepairBox(){
        int r =(int) (Math.random()*42);
        repairBox_x =   r * 10;
        r = (int)   (Math.random()*42);
        repairBox_y = r * 10;
        loadImage();
    }
    private void loadImage(){
        ImageIcon ii= new ImageIcon("src/Image/RepairBox.png");
        img = ii.getImage();
        w=img.getWidth(null);
        h=img.getHeight(null);
    }
    public int getRepairBoxX() {
        return repairBox_x;
    }
    public int getRepairBoxY() {
        return repairBox_y;
    }
    public void setRepairBox_x(int repairBox_x) {
        this.repairBox_x = repairBox_x;
    }
    public void setRepairBox_y(int repairBox_y) {
        this.repairBox_y = repairBox_y;
    }
}
