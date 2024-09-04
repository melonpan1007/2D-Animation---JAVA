import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener{

    final int panel_width = 500;
    final int panel_height = 500;
    Image enemy;
    Image backgroundImage;
    Timer timer;
    int xVelocity=2;
    int yVelocity=1;
    int x=0;
    int y=0;

    MyPanel(){
        this.setPreferredSize(new Dimension(panel_width,panel_height));
        this.setBackground(Color.black);
        enemy=new ImageIcon("sharingan.png").getImage();
        backgroundImage = new ImageIcon("bgimage.jpg").getImage();
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g){
        super.paint(g);//paint background
        Graphics g2D = (Graphics2D)g;
        g2D.drawImage(backgroundImage,0,0,null);
        g2D.drawImage(enemy, x, y, null);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(x>=panel_width-enemy.getWidth(null) || x<0){
            xVelocity =xVelocity *  -1;
        }
        x = x + xVelocity;

        if(y>=panel_width-enemy.getWidth(null) || y<0){
            yVelocity =yVelocity *  -1;
        }
        y = y + yVelocity;
        repaint();
        
    }
}
