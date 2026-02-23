import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

class Death extends JFrame {


    public static void main(String[] args) throws IOException {
        Death game = new Death();
    }
    // Инициализируем
    static String[] sleepImages = {
            "src/image/sleep1.png",
            "src/image/sleep2.png",
            "src/image/sleep3.png",
            "src/image/sleep4.png",
            "src/image/sleep5.png"
    };

    static String[] showerImages = {
            "src/image/shower1.png",
            "src/image/shower2.png",
            "src/image/shower3.png",
            "src/image/shower4.png",
            "src/image/shower5.png"
    };
    static String [] foodImages = {
            "src/image/food1.png",
            "src/image/food2.png",
            "src/image/food3.png",
            "src/image/food4.png",
            "src/image/food5.png"
    };
    static String [] gameImages = {
            "src/image/game1.png",
            "src/image/game2.png",
            "src/image/game3.png",
            "src/image/game4.png",
            "src/image/game5.png"
    };


    static Needs sleepNeeds;
    static Needs showerNeeds;
    static Needs foodNeeds;
    static Needs gameNeeds;

    static {
        try {
            sleepNeeds = new Needs("test.txt", sleepImages);
            showerNeeds = new Needs("test2.txt", showerImages);
            foodNeeds = new Needs("test1.txt", foodImages );
            gameNeeds = new Needs("test3.txt", gameImages );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    character fon = new character("src/image/death.png", 0, 0);
    bear Bear = new bear("src/image/bear.png",
            bear.head(),
            bear.top(),
            bear.trousers(),
            bear.boots(),
            0, 0);





    Death() throws IOException {
        setSize(1920,1080);
        setVisible(true);
        addMouseListener(ML);
        bi = new BufferedImage(getWidth(), getHeight(), 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    BufferedImage  bi;
    public void paint(Graphics g)
    {
        if (bi == null) {
            bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        }
        Graphics2D test = bi.createGraphics();
        if (fon._image != null) test.drawImage(fon._image, fon.x, fon.y, this);
        g.drawImage(bi,0,0,this);

    }
    MouseListener ML = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent qwerty) {
            dispose();
            new g();

        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };
}