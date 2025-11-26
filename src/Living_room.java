import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Living_room extends JFrame  {


    public static void main(String[] args) {
        Living_room game = new Living_room();
    }

    character fon = new character("src/image/fon1.png", 0, 0);
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


    BufferedImage  bi;

    Living_room()
    {


        setSize(1920,1080);
        setVisible(true);
        addKeyListener(KL);
        bi = new BufferedImage(getWidth(), getHeight(), 2);
    }


    public void paint(Graphics g)
    {
        Graphics2D test = bi.createGraphics();
        if (bi == null) {
            bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        }


        if (fon._image != null) test.drawImage(fon._image, fon.x, fon.y, this);
        if (bear._image != null) test.drawImage(bear._image, bear.x, bear.y, this);


        g.drawImage(bi,0,0,this);

    }
}