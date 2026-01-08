/*import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

class Living_room extends JFrame {


    public static void main(String[] args) throws IOException {
        //System.out.println("  read my text file:  "+readFile.next());
        // Открываем НОВЫЕ Scanner для чтения
        try (Scanner s1 = new Scanner(new File("test.txt"));
             Scanner s2 = new Scanner(new File("test2.txt"))) {

            // Читаем test.txt
            if (s1.hasNext()) {
                String text = s1.next();
                number1 = text.charAt(0) - '0';
            } else {
                number1 = 0;
            }

            // Читаем test2.txt
            if (s2.hasNext()) {
                String text = s2.next();
                number2 = text.charAt(0) - '0';
            } else {
                number2 = 0;
            }
        }

        System.out.println("Прочитано: number1=" + number1 + ", number2=" + number2);

        //number1 = readFile.next().charAt(0)-48;
        //number2 = readFile2.next().charAt(0)-48;
        System.out.println(number2);

        Living_room game = new Living_room();
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
    static FileReader fileReader2;

    static {
        try {
            fileReader2 = new FileReader("test2.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    static int number1;
    static int number2;
    public int minuteCounter1=number1;
    public int minuteCounter2=number2;

    Sleep sleep = new Sleep("src/image/void.png",0,0);
    Shower shower = new Shower("src/image/void.png",0,0);
    Food food = new Food("src/image/void.png",0,0);

    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ee) {
            try (FileWriter fileWriter = new FileWriter("test.txt");){//чтобы не закрывать поток
                fileWriter.write(sometext[minuteCounter1]);
                fileWriter.flush();  // ← ПРИНУДИТЕЛЬНАЯ запись!

                System.out.println("УСПЕХ: Записано");
            } catch (IOException a) {
                throw new RuntimeException(a);
            }
            if (minuteCounter1<5)
            {
                minuteCounter1++;
            }
            if (minuteCounter1 == 5) {
                minuteCounter1 = 0;
                System.out.println("Начинаем новый цикл");
            }
            // Смена картинок sleep
            try {
                switch(minuteCounter1) {
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


            try (FileWriter fileWriter = new FileWriter("test2.txt");){//чтобы не закрывать поток
                fileWriter.write(sometext[minuteCounter2]);
                fileWriter.flush();  // ← ПРИНУДИТЕЛЬНАЯ запись!

                System.out.println("УСПЕХ: Записано");
            } catch (IOException a) {
                throw new RuntimeException(a);
            }
            if (minuteCounter2<5)
            {
                minuteCounter2++;
            }
            if (minuteCounter2 == 5) {
                minuteCounter2 = 0;
                System.out.println("Начинаем новый цикл");
            }
            try {
                switch(minuteCounter2) {
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
    Living_room() throws IOException {


        setSize(1920,1080);
        setVisible(true);
        addKeyListener(KL);
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


}*/