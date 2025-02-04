import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main(){
        initUI();
    }
    private void initUI(){
        add(new Board());
        setResizable(false);
        pack();
        setTitle("Space War");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[]args){
        EventQueue.invokeLater(()-> {
            JFrame window = new Main();
            window.setVisible(true);
        });
    }
}
