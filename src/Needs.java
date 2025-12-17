import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

class Needs extends JFrame  {


    public static void main(String[] args) throws IOException {
        //System.out.println("  read my text file:  "+readFile.next());
        number = readFile.next().charAt(0)-48;
        System.out.println(number);

        Needs game = new Needs();
    }

    public String [] sometext = new String[]{"1","2","3","4","5"};
    static FileReader fileReader;

    static {
        try {
            fileReader = new FileReader("test.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static Scanner readFile = new Scanner(fileReader);
    static int number;
    public int minuteCounter=number;
    Sleep sleep = new Sleep("src/image/void.png",0,0);
    Shower shower = new Shower("src/image/void.png",0,0);

    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ee) {
            try (FileWriter fileWriter = new FileWriter("test.txt");){//чтобы не закрывать поток
                fileWriter.write(sometext[minuteCounter]);
                fileWriter.flush();  // ← ПРИНУДИТЕЛЬНАЯ запись!

                System.out.println("УСПЕХ: Записано");
            } catch (IOException a) {
                throw new RuntimeException(a);
            }
            if (minuteCounter<5)
            {
                minuteCounter++;
            }
            if (minuteCounter == 5) {
                minuteCounter = 0;
                System.out.println("Начинаем новый цикл");
            }
            // Смена картинок sleep
            try {
                switch(minuteCounter) {
                    case 0:
                        sleep._image = ImageIO.read(new File("src/image/sleep1.png"));
                        break;
                    case 1:
                        sleep._image = ImageIO.read(new File("src/image/sleep2.png"));
                        break;
                    case 2:
                        sleep._image = ImageIO.read(new File("src/image/sleep3.png"));
                        break;
                    case 3:
                        sleep._image = ImageIO.read(new File("src/image/sleep4.png"));
                        break;
                    case 4:
                        sleep._image = ImageIO.read(new File("src/image/sleep5.png"));
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                switch(minuteCounter) {
                    case 0:
                        shower._image = ImageIO.read(new File("src/image/shower1.png"));
                        break;
                    case 1:
                        shower._image = ImageIO.read(new File("src/image/shower2.png"));
                        break;
                    case 2:
                        shower._image = ImageIO.read(new File("src/image/shower3.png"));
                        break;
                    case 3:
                        shower._image = ImageIO.read(new File("src/image/shower4.png"));
                        break;
                    case 4:
                        shower._image = ImageIO.read(new File("src/image/shower5.png"));
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            repaint(); // <-- ВАЖНО! Перерисовать окно после смены картинки

        }
    };

    Timer my_timer = new Timer(1000,al); //таймер через 10 секунд совершает действия в actionlistener


    Needs() throws IOException {


        setSize(1920,1080);
        setVisible(true);
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
        if (sleep._image != null) test.drawImage(sleep._image, sleep.x, sleep.y, this);
        if (shower._image != null) test.drawImage(shower._image, shower.x, shower.y, this);


        g.drawImage(bi,0,0,this);


    }


}