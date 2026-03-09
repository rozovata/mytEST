import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

class Game_gift extends JFrame {


    public static void main(String[] args) throws IOException {
        Game_gift game = new Game_gift();
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
    String [] foodImages = {
            "src/image/food1.png",
            "src/image/food2.png",
            "src/image/food3.png",
            "src/image/food4.png",
            "src/image/food5.png"
    };
    String [] gameImages = {
            "src/image/game1.png",
            "src/image/game2.png",
            "src/image/game3.png",
            "src/image/game4.png",
            "src/image/game5.png"
    };


    Needs sleepNeeds = new Needs("test.txt", sleepImages);
    Needs showerNeeds = new Needs("test2.txt", showerImages);
    Needs foodNeeds = new Needs("test1.txt", foodImages );
    Needs gameNeeds = new Needs("test3.txt", gameImages );

    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ee) {
            try {
                // Обновляем картинки в объектах
                sleepNeeds.next();
                showerNeeds.next();
                foodNeeds.next();
                gameNeeds.next();
            } catch (IOException e) {
                e.printStackTrace();
            }
            repaint();
        }
    };

    Timer my_timer = new Timer(10000,al); //таймер через 10 секунд совершает действия в actionlistener
    character fon = new character("src/image/fon_gift_game.png", 0, 0);
    // character gf = new character("src/image/gift.png", 0, 0);
    static Player gift = new Player(1920/2-70,0,"src/image/gift.png");
    static character platform = new character("src/image/platform.png",1920/2-150,800);


    KeyListener KL = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT && platform.x>0) {
                platform.x -= 10;
                with_platform2();
            }
            if (key == KeyEvent.VK_RIGHT && platform.x<1920-platform._image.getWidth()) {
                platform.x += 10;
                with_platform1();
            }
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {


        }
    } ;
    Game_gift() throws IOException {
        setSize(1920,1080);
        setVisible(true);
        addKeyListener(KL);
        addMouseListener(ML);
        bi = new BufferedImage(getWidth(), getHeight(), 2);
        my_timer.start();
        block_timer.start();
        timer.start();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

    BufferedImage  bi;
    public void paint(Graphics g)
    {
        // Отрисовка рамок

        if (bi == null) {
            bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        }
        Graphics2D test = bi.createGraphics();
        if (fon._image != null) test.drawImage(fon._image, fon.x, fon.y, this);
        if (platform._image != null) test.drawImage(platform._image, platform.x, platform.y, this);
        if (gift_1.image != null) test.drawImage(gift_1.image, gift_1.x, gift_1.y, this);
        if (gift_2.image != null) test.drawImage(gift_2.image, gift_2.x, gift_2.y, this);
        if (gift_3.image != null) test.drawImage(gift_3.image, gift_3.x, gift_3.y, this);
        if (gift_4.image != null) test.drawImage(gift_4.image, gift_4.x, gift_4.y, this);
        if (gift_5.image != null) test.drawImage(gift_5.image, gift_5.x, gift_5.y, this);

        g.drawImage(bi,0,0,this);



    }
    static Random inn = new Random();
    static Player gift_1=new Player(inn.nextInt(0,1920-gift.image.getWidth()),0,"src/image/gift.png");
    static Player gift_2=new Player(inn.nextInt(0,1920-gift.image.getWidth()),-500,"src/image/gift.png");
    static Player gift_3=new Player(inn.nextInt(0,1920-gift.image.getWidth()),-1000,"src/image/gift.png");
    static Player gift_4=new Player(inn.nextInt(0,1920-gift.image.getWidth()),-1500,"src/image/gift.png");
    static Player gift_5=new Player(inn.nextInt(0,1920-gift.image.getWidth()),-2000,"src/image/gift.png");
    static Boolean[] mas_pl={false,false,false,false,false};
    static Player[] mas_Player={gift_1,gift_2,gift_3,gift_4,gift_5};
    static int Y = platform.y;
    static int X = platform.x;
    static int Width = platform._image.getWidth();
    static int Height = platform._image.getHeight();
    Random in = new Random();
    ActionListener al1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if( with_platform3())
            {
                if( BAM() )
                {
                    System.out.println("попадение");
                }
                else{
                    block_timer.stop();
                    try {
                        new Game_room();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    dispose();
                }
            }
            else {
                for (int i=0; i<5; i++)
            {
                if (mas_pl[i]==false)
                {
                    mas_Player[i].y+= 10;
                }
            }
            }
            repaint();
        }
    } ;
    Timer block_timer = new Timer(100,al1); //таймер через 10 секунд совершает действия в actionlistener

    MouseListener ML = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent qwerty) {
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
    ActionListener al2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ee) {
            gameNeeds.counter--;
            if (gameNeeds.counter<0)
            {
                gameNeeds.counter=0;
            }
            gameNeeds.CounteSaveFile();
        }
    };

    Timer timer = new Timer(1000,al2);
    public void with_platform1 ()
    {
        for (int i=0; i<5; i++)
        {
            if (mas_pl[i]==true)
            {
                mas_Player[i].x+= 10;
            }
        }
    }
    public void with_platform2 ()
    {
        for (int i=0; i<5; i++)
        {
            if (mas_pl[i]==true)
            {
                mas_Player[i].x-= 10;
            }
        }
    }
    public boolean with_platform3 ()
    {

        for (int i=0; i<5; i++)
        {
            if (mas_Player[i].y+mas_Player[i].image.getHeight()>=Y && mas_pl[i]!=true)
            {
                System.out.println("!!! ПОДАРОК " + i + " ОСТАНОВЛЕН на y=" + mas_Player[i].y);
                mas_pl[i]=true;
                mas_Player[i].y= Y - mas_Player[i].image.getHeight() +5;
                System.out.println("ooo");
                return true;
            }
        }
        return false;

    }
    public boolean BAM ()
    {
        System.out.println("BAM: подарок на платформе");

        Rectangle pl= new Rectangle(X, Y,Width,Height);
        for (int i=0; i<5; i++)
        {
            if (mas_Player[i].bam(pl) && mas_pl[i]!=true)
            {
                mas_Player[i].y= Y - mas_Player[i].image.getHeight();
                System.out.println("BAM: подарок " + i + " на платформе");

                System.out.println("333");
                X=mas_Player[i].x;
                Y=mas_Player[i].y;
                Width=mas_Player[i].image.getWidth();
                Height=mas_Player[i].image.getHeight();
                System.out.println("111");
                return true;
            }
        }
        return false;

    }


}


