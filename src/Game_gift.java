import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

class Game_gift extends JFrame {

    Needs gameNeeds = GameManager.getGameNeeds();



    character fon = new character("src/image/fon_gift_game.png", 0, 0);
    Player gift = new Player(1920/2-70,0,"src/image/gift.png");
    character platform = new character("src/image/platform1.png",1920/2-150,800);


    KeyListener KL = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT && platform.x>0) {
                platform.x -= 15;
                with_platform2();
            }
            if (key == KeyEvent.VK_RIGHT && platform.x<1920-platform._image.getWidth()) {
                platform.x += 15;
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
    Random inn = new Random();
    Player gift_1=new Player(inn.nextInt(0,1920-gift.image.getWidth()),0,"src/image/gift.png");
    Player gift_2=new Player(inn.nextInt(0,1920-gift.image.getWidth()),-800,"src/image/gift.png");
    Player gift_3=new Player(inn.nextInt(0,1920-gift.image.getWidth()),-1600,"src/image/gift.png");
    Player gift_4=new Player(inn.nextInt(0,1920-gift.image.getWidth()),-2400,"src/image/gift.png");
    Player gift_5=new Player(inn.nextInt(0,1920-gift.image.getWidth()),-3200,"src/image/gift.png");
    Boolean[] mas_pl={false,false,false,false,false};
    Player[] mas_Player={gift_1,gift_2,gift_3,gift_4,gift_5};
    int Y = platform.y;
    int X = platform.x;
    int Width = platform._image.getWidth();
    int Height = platform._image.getHeight();
    int count = 0;
    Random in = new Random();
    ActionListener al1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if( with_platform3())
            {
                if( BAM() && count<=2 )
                {
                    System.out.println("попадение");
                    count++;
                }
                else{
                    block_timer.stop();
                    timer.stop();
                    try {
                        gameNeeds.updateImage();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        GameManager.refreshImage();
                        GameManager.startGlobalTimers();
                        new Game_room();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    gift_1=new Player(inn.nextInt(0,1920-gift.image.getWidth()),0,"src/image/gift.png");
                    gift_2=new Player(inn.nextInt(0,1920-gift.image.getWidth()),-800,"src/image/gift.png");
                    gift_3=new Player(inn.nextInt(0,1920-gift.image.getWidth()),-1600,"src/image/gift.png");
                    gift_4=new Player(inn.nextInt(0,1920-gift.image.getWidth()),-2400,"src/image/gift.png");
                    gift_5=new Player(inn.nextInt(0,1920-gift.image.getWidth()),-3200,"src/image/gift.png");
                    mas_pl= new Boolean[]{false, false, false, false, false};
                    Y = platform.y;
                    X = platform.x;
                    Width = platform._image.getWidth();
                    Height = platform._image.getHeight();
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

    Timer timer = new Timer(5000,al2);
    public void with_platform1()
    {
        for (int i=0; i<5; i++)
        {
            if (mas_pl[i]==true)
            {
                mas_Player[i].x+= 15;
            }
        }
    }
    public void with_platform2()
    {
        for (int i=0; i<5; i++)
        {
            if (mas_pl[i]==true)
            {
                mas_Player[i].x-= 15;
            }
        }
    }
    public boolean with_platform3()
    {

        for (int i=0; i<5; i++)
        {
            if (mas_Player[i].y+mas_Player[i].image.getHeight()>=Y && mas_pl[i]!=true)
            {
                int t=0;
                System.out.println("!!! ПОДАРОК " + i + " ОСТАНОВЛЕН на y=" + mas_Player[i].y);
                for (int p=0; p<5; p++)
                {
                    if (mas_Player[p].y+10>=Y && mas_Player[p].y-10<=Y )
                    {
                        X=mas_Player[p].x;
                        t=1;
                        System.out.println("yt");
                    }

                }
                if(t==0){X=platform.x;
                System.out.println("ytt");}
                System.out.println("ooo");
                return true;
            }
        }
        return false;

    }
    public boolean BAM()
    {
        System.out.println("подарок на платформе");

        Rectangle pl= new Rectangle(X, Y,Width,Height);
        for (int i=0; i<5; i++)
        {
            if (mas_Player[i].bam(pl) && mas_pl[i]!=true)
            {
                mas_pl[i]=true ;
                System.out.println("BAM: подарок " + i + " на платформе");
                mas_Player[i].y= Y - mas_Player[i].image.getHeight();
                System.out.println("333");
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


