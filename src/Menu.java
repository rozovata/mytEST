import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

public class Menu extends JFrame {

    Needs sleepNeeds;
    Needs showerNeeds;
    Needs foodNeeds;
    Needs gameNeeds;

    MouseListener ML = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent qwerty) {
            if (qwerty.getX() >= 665 && qwerty.getX() <= 1280 && qwerty.getY() >= 334 && qwerty.getY() <= 334 + 598 - 483) {
                try {
                    new Living_room1();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                dispose();
            }
            if (qwerty.getX() >= 665 && qwerty.getX() <= 1280 && qwerty.getY() >= 634 && qwerty.getY() <= 634 + 598 - 483) {
                System.exit(0);
            }
            if (qwerty.getX() >= 665 && qwerty.getX() <= 1280 && qwerty.getY() >= 482 && qwerty.getY() <= 600) {
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


    Menu() throws IOException {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(2000, 1000);
        setVisible(true);

        addMouseListener(ML);

        fiile();
        // Инициализируем GameManager (один раз)
        GameManager.init();
        sleepNeeds = GameManager.getSleepNeeds();
        showerNeeds = GameManager.getShowerNeeds();
        foodNeeds = GameManager.getFoodNeeds();
        gameNeeds = GameManager.getGameNeeds();

        int t1 = Time.NeedsTime(GameManager.getSleepNeeds());
        int t2 = Time.NeedsTime(GameManager.getShowerNeeds());
        int t3 = Time.NeedsTime(GameManager.getGameNeeds());
        int t4 = Time.NeedsTime(GameManager.getFoodNeeds());


        try {
            if (t1 == 1 || t2 == 1 || t3 == 1 || t4 == 1) {
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
    character play = new character("src/image/play.png", 0, 0);
    character exit = new character("src/image/exit.png", 0, 0);

    BufferedImage bi;

    public void paint(Graphics g) {
        if (bi == null) {
            bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        }
        Graphics2D test = bi.createGraphics();
        if (fon._image != null) test.drawImage(fon._image, fon.x, fon.y, this);
        if (setting._image != null) test.drawImage(setting._image, setting.x, setting.y, this);
        if (play._image != null) test.drawImage(play._image, play.x, play.y, this);
        if (exit._image != null) test.drawImage(exit._image, exit.x, exit.y, this);

        g.drawImage(bi, 0, 0, this);
    }

    //"C:TATIANA/Users/Tom/IdeaProjects/my_game/5438484227139173417.jpg"
    public static void main(String[] args) throws IOException {
        Menu w = new Menu();

    }

    private static void fiile() {
        try {
            if (!new File("test.txt").exists()) {
                new File("test.txt").createNewFile();
                Needs.CounteSaveFile2(0, "test.txt");
            }
            if (!new File("test1.txt").exists()) {
                new File("test1.txt").createNewFile();
                Needs.CounteSaveFile2(0, "test1.txt");
            }
            if (!new File("test2.txt").exists()) {
                new File("test2.txt").createNewFile();
                Needs.CounteSaveFile2(0, "test2.txt");
            }
            if (!new File("test3.txt").exists()) {
                new File("test3.txt").createNewFile();
                Needs.CounteSaveFile2(0, "test3.txt");
            }
            if (!new File("top.txt").exists()) {
                new File("top.txt").createNewFile();
                Needs.CounteSaveFile2(1, "top.txt");
            }
            if (!new File("trousers.txt").exists()) {
                new File("trousers.txt").createNewFile();
                Needs.CounteSaveFile2(1, "trousers.txt");
            }
            if (!new File("head.txt").exists()) {
                new File("head.txt").createNewFile();
                Needs.CounteSaveFile2(1, "head.txt");
            }
            if (!new File("boots.txt").exists()) {
                new File("boots.txt").createNewFile();
                Needs.CounteSaveFile2(1, "boots.txt");
            }
            if (!new File("time.txt").exists()) {
                new File("time.txt").createNewFile();
                LocalDateTime now = LocalDateTime.now();
                Time.SaveTime(now);
            }
            if (!new File("rooms.txt").exists()) {
                new File("rooms.txt").createNewFile();
                Needs.CounteSaveFile2(1, "rooms.txt");
            }
            if (!new File("food_death.txt").exists()) {
                new File("food_death.txt").createNewFile();
                Needs.CounteSaveFile2(0, "food_death.txt");
            }
            if (!new File("game_death.txt").exists()) {
                new File("game_death.txt").createNewFile();
                Needs.CounteSaveFile2(0, "game_death.txt");
            }
            if (!new File("shower_death.txt").exists()) {
                new File("shower_death.txt").createNewFile();
                Needs.CounteSaveFile2(0, "shower_death.txt");
            }
            if (!new File("sleep_death.txt").exists()) {
                new File("sleep_death.txt").createNewFile();
                Needs.CounteSaveFile2(0, "sleep_death.txt");
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


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