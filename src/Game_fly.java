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
    Blocks blocks_1 = new Blocks("src/image/stone2.png","src/image/stone2.png","src/image/stone2.png",0,250,800);
    Player player = new Player (Bear.x ,Bear.y,Bear._image);
    //character white_heart = new character("src/image/white_heart.png", 0, 0);
    character red_heart1  = new character("src/image/red_heart.png", 0, 0);
    character red_heart2  = new character("src/image/red_heart.png", 0, 0);
    character red_heart3  = new character("src/image/red_heart.png", 0, 0);


    KeyListener KL = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT) {
                Bear.x -= 10;
                player.x -= 10;

            }
            if (key == KeyEvent.VK_RIGHT) {
                Bear.x += 10;
                player.x += 10;
            }
            if (key == KeyEvent.VK_SPACE) {
                System.out.println("Ты нажал на мишку");
            }
            if (key == KeyEvent.VK_UP) {
                Bear.y -= 10;
                player.y -= 10;
            }
            if (key == KeyEvent.VK_DOWN) {
                Bear.y += 10;
                player.y += 10;
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
        timer.start();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    BufferedImage  bi;
    public void paint(Graphics g)
    {
        // Отрисовка рамок
        Graphics2D g2d = (Graphics2D) g;

        // Рамка игрока - КРАСНАЯ
        g2d.setColor(Color.RED);
        g2d.drawRect(player.x + 40, player.y + 40,
                player.image.getWidth() - 80, player.image.getHeight() - 80);

        // Рамки камней - СИНИЕ
        g2d.setColor(Color.BLUE);
        g2d.drawRect(blocks_1.x + 60, blocks_1.y1 + 60,
                blocks_1.image1.getWidth() - 120, blocks_1.image1.getHeight() - 120);
        g2d.drawRect(blocks_1.x + 60, blocks_1.y2 + 60,
                blocks_1.image2.getWidth() - 120, blocks_1.image2.getHeight() - 120);
        g2d.drawRect(blocks_1.x + 60, blocks_1.y3 + 60,
                blocks_1.image3.getWidth() - 120, blocks_1.image3.getHeight() - 120);
        if (bi == null) {
            bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        }
        Graphics2D test = bi.createGraphics();
        if (fon._image != null) test.drawImage(fon._image, fon.x, fon.y, this);
        if (Bear._image != null) test.drawImage(Bear._image, Bear.x, Bear.y, this);
        if (blocks_1.image1 != null) test.drawImage(blocks_1.image1, blocks_1.x, blocks_1.y1, this);
        if (blocks_1.image2 != null) test.drawImage(blocks_1.image2, blocks_1.x, blocks_1.y2, this);
        if (blocks_1.image3 != null) test.drawImage(blocks_1.image3, blocks_1.x, blocks_1.y3, this);
        //if (white_heart._image != null) test.drawImage(white_heart._image, white_heart.x, white_heart.y, this);
        if (red_heart1._image != null) test.drawImage(red_heart1._image, red_heart1.x, red_heart1.y, this);
        if (red_heart2._image != null) test.drawImage(red_heart2._image, 200, red_heart2.y, this);
        if (red_heart3._image != null) test.drawImage(red_heart3._image, 400, red_heart3.y, this);


        g.drawImage(bi,0,0,this);



    }
    static int bam=0;
    Random inn = new Random();
    ActionListener al1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Rectangle bl1= new Rectangle(blocks_1.x, blocks_1.y1,blocks_1.image1.getWidth(),blocks_1.image1.getHeight());
            Rectangle bl2= new Rectangle(blocks_1.x, blocks_1.y2,blocks_1.image2.getWidth(),blocks_1.image2.getHeight());
            Rectangle bl3= new Rectangle(blocks_1.x, blocks_1.y3,blocks_1.image3.getWidth(),blocks_1.image3.getHeight());
            if(player.bam(bl1) || player.bam(bl2) || player.bam(bl3) )
            {
                bam++;
                if (bam==1){
                    try {
                        red_heart1._image=ImageIO.read(new File("src/image/white_heart.png"));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                if (bam==2){
                    try {
                        red_heart2._image=ImageIO.read(new File("src/image/white_heart.png"));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                if (bam==3){
                    try {
                        red_heart3._image=ImageIO.read(new File("src/image/white_heart.png"));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                if (bam==4){
                    block_timer.stop();
                    dispose();
                    try {
                        new Game_room();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
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

    Timer timer = new Timer(100,al2);

}
class Player
{
    int x;
    int y;
    BufferedImage image;
    public Player (int x_, int y_, BufferedImage image_)
    {
         x = x_;
         y = y_;
         image = image_;
    }
    public boolean bam (Rectangle temp)
    {
        Rectangle boarder= new Rectangle(x,y,image.getWidth(), image.getHeight() );
        if (boarder.intersects(temp))
        {
            System.out.println("boom!!!!!");
            return true;
        }
        return false;
    }
}



