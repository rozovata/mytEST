import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

class Bad_room extends JFrame {


    public static void main(String[] args) throws IOException {

        Bad_room game1 = new Bad_room();
    }
    // Инициализируем
    String[] sleepImages = {
            "src/image/sleep1.png",
            "src/image/sleep2.png",
            "src/image/sleep3.png",
            "src/image/sleep4.png",
            "src/image/sleep5.png"
    };

    String[] showerImages = {
            "src/image/shower1.png",
            "src/image/shower2.png",
            "src/image/shower3.png",
            "src/image/shower4.png",
            "src/image/shower5.png"
    };

    Needs sleepNeeds = new Needs("test.txt", sleepImages);
    Needs showerNeeds = new Needs("test2.txt", showerImages);
    Sleep sleep = new Sleep(sleepNeeds.getCurrentImagePath(),0,0);
    Shower shower = new Shower(showerNeeds.getCurrentImagePath(),0,0);
    Food food = new Food("src/image/void.png",0,0);

    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ee) {
            try {
                // Обновляем картинки в объектах
                sleep._image = sleepNeeds.image;
                shower._image = showerNeeds.image;

                sleepNeeds.next();
                showerNeeds.next();

            } catch (IOException e) {
                e.printStackTrace();
            }
            repaint();
        }
    };


    Timer my_timer = new Timer(1000,al); //таймер через 10 секунд совершает действия в actionlistener

    character fon = new character("src/image/Kitchen.png", 0, 0);
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
    Bad_room() throws IOException {
        setSize(1920,1080);
        setVisible(true);
        addKeyListener(KL);
        bi = new BufferedImage(getWidth(), getHeight(), 2);
        my_timer.start();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    ActionListener al1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ee) {
            if (bad<=3)
            {
                try {bear._image = ImageIO.read(new File("src/image/void.png")); }catch (IOException e) { }
                bad++;
            }
            else {
                timerBad.stop();
                try {
                    bear._image = ImageIO.read(new File("src/image/void.png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    };

    Timer timerBad = new Timer(1000,al1);


    BufferedImage  bi;
    public void paint(Graphics g)
    {

        if (bi == null) {
            bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        }
        Graphics2D test = bi.createGraphics();


        if (fon._image != null) test.drawImage(fon._image, fon.x, fon.y, this);
        if (bear._image != null) test.drawImage(bear._image, bear.x, bear.y, this);
        if (sleep._image != null) test.drawImage(sleep._image, sleep.x, sleep.y, this);
        if (shower._image != null) test.drawImage(shower._image, shower.x, shower.y, this);


        g.drawImage(bi,0,0,this);


    }
    int bad=0;
    MouseListener ML = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent qwerty) {
            if (qwerty.getX() >= 1550)
            {
                timerBad.start();


            }
            repaint();
            bad=0;



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