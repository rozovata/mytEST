import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;

public class g extends JFrame {
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
    KeyListener KL=new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    } ;
    MouseListener ML = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent qwerty) {
            if (qwerty.getX() >= 665 && qwerty.getX()<= 1280 && qwerty.getY() >= 334 && qwerty.getY()<= 334+598-483 )
            {
                try {
                    new Living_room1();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                dispose();
            }
            if (qwerty.getX() >= 665 && qwerty.getX()<= 1280 && qwerty.getY() >= 634 && qwerty.getY()<= 634+598-483 )
            {
                System.exit(0);
            }
            if (qwerty.getX() >= 665 && qwerty.getX()<= 1280 && qwerty.getY() >= 482 && qwerty.getY()<= 600 )
            {
                try {
                    new Setting_text();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                dispose();
            }

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


    g() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(2000, 1000);
        setVisible(true);
        addKeyListener(KL);
        addMouseListener(ML);

        try {
            if(Time.NeedsTime(foodNeeds)==1 ||
            Time.NeedsTime(sleepNeeds)==1 ||
            Time.NeedsTime(showerNeeds)==1 ||
            Time.NeedsTime(gameNeeds)==1)
            {
                new Death();
                dispose();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    character fon = new character("src/image/fon_start.png", 0, 0);
    character setting = new character("src/image/setting.png", 0, 0);
    character play = new character("src/image/play.png",0,0);
    character exit = new character("src/image/exit.png",0,0);

    BufferedImage  bi;

    public void paint(Graphics g)
    {
        if (bi == null) {
            bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        }
        Graphics2D test = bi.createGraphics();
        if (fon._image != null) test.drawImage(fon._image, fon.x, fon.y, this);
        if (setting._image != null) test.drawImage(setting._image, setting.x, setting.y, this);
        if (play._image != null) test.drawImage(play._image, play.x, play.y, this);
        if (exit._image != null) test.drawImage(exit._image, exit.x, exit.y, this);

        g.drawImage(bi,0,0,this);
    }

    //"C:TATIANA/Users/Tom/IdeaProjects/my_game/5438484227139173417.jpg"
    public static void main(String[] args) {
        g w=new g();

    }


}

































/*import javax.swing.*;
import java.awt.*;

public class work extends JFrame
{


    Image _image;
    Image fon;


    work()
    {
        setSize(500,500);
        setVisible(true);
        _image= Toolkit.getDefaultToolkit().createImage("H:/ros/me_1project/my2/src/im.jpg");
        fon=Toolkit.getDefaultToolkit().createImage("H:/ros/me_1project/my2/src/Фон.jpg");
    }


    public void paint(Graphics g)
    {
        g.drawImage(fon,100,100,this);
        g.drawImage(_image,200,100,this);


    }



    //"H:/ros/me_1project/my2/src/im.jpg"
    public static void main(String[] args) {
        work w=new work();



    }


}
*/