import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.*;


class Living_room extends JFrame  {


    public static void main(String[] args) throws IOException {
        Living_room game = new Living_room();
    }

    public String [] sometext = new String[]{"1","2","3","4","5"};
   // FileReader fileReader = new FileReader("test.txt");

    public int minuteCounter=0;

    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try (FileWriter fileWriter = new FileWriter("test.txt");){//чтобы не закрывать поток
                fileWriter.write(sometext[minuteCounter]);
                fileWriter.flush();  // ← ПРИНУДИТЕЛЬНАЯ запись!

                System.out.println("УСПЕХ: Записано");
            } catch (IOException a) {
                throw new RuntimeException(a);
            }
            if (minuteCounter<4)
            {
                minuteCounter++;
            }
            System.out.println(1);
            if (minuteCounter == 4) {
                minuteCounter = 0;
                System.out.println("Начинаем новый цикл");
            }

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


    BufferedImage  bi;

    Living_room() throws IOException {


        setSize(1920,1080);
        setVisible(true);
        addKeyListener(KL);
        bi = new BufferedImage(getWidth(), getHeight(), 2);
        my_timer.start();
    }


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


}