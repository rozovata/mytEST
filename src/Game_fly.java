import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

class Game_fly extends JFrame {


    public static void main(String[] args) throws IOException {

        Game_fly game = new Game_fly();
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
    character fon = new character("src/image/fon_fly.png", 0, 0);
    bear Bear = new bear("src/image/bear_fly.png",
            "src/image/void.png",
            "src/image/void.png",
            "src/image/void.png",
            "src/image/void.png",
            200, 650);
    Blocks blocks_1 = new Blocks("src/image/stone.png","src/image/stone.png","src/image/stone.png",0,250,800);


    KeyListener KL = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT) {
                Bear.x -= 10;
            }
            if (key == KeyEvent.VK_RIGHT) {
                Bear.x += 10;
            }
            if (key == KeyEvent.VK_SPACE) {
                System.out.println("Ты нажал на мишку");
            }
            if (key == KeyEvent.VK_UP) {
                Bear.y -= 10;
            }
            if (key == KeyEvent.VK_DOWN) {
                Bear.y += 10;
            }
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {


        }
    } ;
    Game_fly() throws IOException {
        setSize(1920,1080);
        setVisible(true);
        addKeyListener(KL);
        addMouseListener(ML);
        bi = new BufferedImage(getWidth(), getHeight(), 2);
        my_timer.start();
        block_timer.start();
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
        if (Bear._image != null) test.drawImage(Bear._image, Bear.x, Bear.y, this);
        if (blocks_1.image1 != null) test.drawImage(blocks_1.image1, blocks_1.x, blocks_1.y1, this);
        if (blocks_1.image2 != null) test.drawImage(blocks_1.image2, blocks_1.x, blocks_1.y2, this);
        if (blocks_1.image3 != null) test.drawImage(blocks_1.image3, blocks_1.x, blocks_1.y3, this);


        g.drawImage(bi,0,0,this);



    }
    Random inn = new Random();
    ActionListener al1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(blocks_1.x==0){
                blocks_1.x=Blocks.xx1;
                int[] num = {Blocks.yy1,Blocks.yy2,Blocks.yy3,Blocks.yy4};
                int randIndex = inn.nextInt(num.length);

                blocks_1.y1 =num[randIndex];
                blocks_1.y2=blocks_1.y1;
                blocks_1.y3=blocks_1.y1;
                while (blocks_1.y2==blocks_1.y1 )
                {
                    randIndex = inn.nextInt(num.length);
                    blocks_1.y2 =num[randIndex];

                }
                while (blocks_1.y3==blocks_1.y1 || blocks_1.y3==blocks_1.y2 )
                {
                    randIndex = inn.nextInt(num.length);
                    blocks_1.y3 =num[randIndex];

                }


            }
            else {blocks_1.x=blocks_1.x-10;}
            repaint();
        }
    } ;
    Timer block_timer = new Timer(100,al1); //таймер через 10 секунд совершает действия в actionlistener

    MouseListener ML = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent qwerty) {
            boolean n = false;
            if (qwerty.getX() >= 25 && qwerty.getX() <= 171 && qwerty.getY() >= 500 && qwerty.getY() <= 683)
            {
                try {
                    Rooms.room_next(n);
                    my_timer.stop();
                    dispose();
                    Rooms.class_room();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (qwerty.getX() >= 1750 && qwerty.getX() <= 1893 && qwerty.getY() >= 500 && qwerty.getY() <= 683)
            {
                n=true;
                try {
                    Rooms.room_next(n);
                    my_timer.stop();
                    dispose();
                    Rooms.class_room();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            /*if (qwerty.getX() >= 43 && qwerty.getX() <= 655 && qwerty.getY() >= 800 && qwerty.getY() <= 1015)
            {

            }*/
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


