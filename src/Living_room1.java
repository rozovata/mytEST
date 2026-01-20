import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

class Living_room1 extends JFrame {


    public static void main(String[] args) throws IOException {

        Living_room1 game = new Living_room1();
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


    Timer my_timer = new Timer(10000,al); //таймер через 10 секунд совершает действия в actionlistener
     int bad=0;
    ActionListener al1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ee) {
            if (bad<=3 && bad!=0)
            {
                try {bear._image = ImageIO.read(new File("src/image/bearbad.png")); }catch (IOException e) { }
                bad++;
                try (FileWriter fileWriter = new FileWriter(sleepNeeds.filePath)){
                    if (sleepNeeds.counter>0)
                    {
                        sleepNeeds.counter--;
                    }
                    fileWriter.write(String.valueOf(sleepNeeds.counter));
                    fileWriter.flush();
                    System.out.println("Файл записан: " + sleepNeeds.filePath + " значение: " + (sleepNeeds.counter));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    sleepNeeds.updateImage();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                sleep._image = sleepNeeds.image;
                repaint();

                if (!timerBad.isRunning()) { // ← ЗАПУСКАЕМ ТАЙМЕР
                    timerBad.start();
                }
            }
            else {
                timerBad.stop();
                bad =0;
                try {
                    bear._image = ImageIO.read(new File("src/image/bear.png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            repaint();

        }
    };

    Timer timerBad = new Timer(1000,al1);
    character fon = new character("src/image/Bad_room.png", 0, 0);
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
    Living_room1() throws IOException {
        setSize(1920,1080);
        setVisible(true);
        addKeyListener(KL);
        addMouseListener(ML);
        bi = new BufferedImage(getWidth(), getHeight(), 2);
        my_timer.start();
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
        if (bear._image != null) test.drawImage(bear._image, bear.x, bear.y, this);
        if (sleep._image != null) test.drawImage(sleep._image, sleep.x, sleep.y, this);
        if (shower._image != null) test.drawImage(shower._image, shower.x, shower.y, this);


        g.drawImage(bi,0,0,this);


    }
    MouseListener ML = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent qwerty) {
            System.out.println("=== МЫШЬ КЛИКНУТА ===");
            System.out.println("Координаты: X=" + qwerty.getX() + " Y=" + qwerty.getY());

            if (qwerty.getX() >= 900 && qwerty.getX() <= 1900 && qwerty.getY() >= 412 && qwerty.getY() <= 840) {
                System.out.println("ПОПАДАНИЕ В ОБЛАСТЬ!");
                bad += 1;
                System.out.println("bad увеличен до: " + bad);

                if (!timerBad.isRunning()) {
                    System.out.println("Запускаем timerBad...");
                    timerBad.start();
                } else {
                    System.out.println("timerBad уже работает");
                }
            } else {
                System.out.println("МИМО области!");
            }
            repaint();
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


