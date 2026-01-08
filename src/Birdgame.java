import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Birdgame extends JFrame{
    public boolean t=false;

    BufferedImage  bi;
    public void paint(Graphics g)
    {

        if (bi == null) {
            bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        }
        Graphics2D test = bi.createGraphics();


        if (fon._image != null) test.drawImage(fon._image, fon.x, fon.y, this);
        if (bear._image != null) test.drawImage(bear._image, bear.x, bear.y, this);

        g.drawImage(bi,0,0,this);

    }
    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ee) {



        }
    };


    Timer my_timer = new Timer(1000,al); //таймер через 10 секунд совершает действия в actionlistener

    character fon = new character("src/image/Living_room.png", 0, 0);
    bear bear = new bear("src/image/bear.png",
            "src/image/void.png",
            "src/image/void.png",
            "src/image/void.png",
            "src/image/void.png",
            0, 0);



    KeyListener KL = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT) {
                bear.x -= 2;
            }
            if (key == KeyEvent.VK_RIGHT) {
                bear.x += 2;
            }
            if (key == KeyEvent.VK_SPACE) {
                System.out.println("Ты нажал на мишку");
            }
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {


        }
    } ;
    Birdgame() throws IOException {


        setSize(1920,1080);
        setVisible(true);
        addKeyListener(KL);
        bi = new BufferedImage(getWidth(), getHeight(), 2);
        my_timer.start();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    public static void main(String[] args) throws IOException {
        Birdgame t= new Birdgame();
    }
}


