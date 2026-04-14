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

    /* ActionListener al = new ActionListener() {
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

    Timer my_timer = new Timer(10000,al); //таймер через 10 секунд совершает действия в actionlistener*/
    character fon = new character("src/image/fon_fly.png", 0, 0);
    bear Bear = new bear("src/image/bear_fly.png",
            "src/image/void.png",
            "src/image/void.png",
            "src/image/void.png",
            "src/image/void.png",
            200, 650);
    Blocks blocks_1 = new Blocks("src/image/stone2.png","src/image/stone2.png","src/image/stone2.png",0,250,800);
    Blocks blocks_2 = new Blocks("src/image/stone2.png","src/image/stone2.png","src/image/stone2.png",0,250,500);
    Player player = new Player (Bear.x ,Bear.y,"src/image/bear_fly.png");
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
            if (key == KeyEvent.VK_LEFT && player.x>0) {
                Bear.x -= 10;
                player.x -= 10;

            }
            if (key == KeyEvent.VK_RIGHT  && player.x<1920-player.image.getWidth()) {
                Bear.x += 10;
                player.x += 10;
            }
            if (key == KeyEvent.VK_UP && player.y>0) {
                Bear.y -= 10;
                player.y -= 10;
            }
            if (key == KeyEvent.VK_DOWN && player.y<1080-player.image.getHeight()) {
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
        //my_timer.start();
        block_timer.start();
        timer.start();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    BufferedImage  bi;
    public void paint(Graphics g)
    {
        // Отрисовка рамок
        Graphics2D g2d = (Graphics2D) g;


       /* g2d.setColor(Color.RED);
        g2d.drawRect(player.x , player.y ,
                player.image.getWidth() - 10, player.image.getHeight() - 10);

        g2d.setColor(Color.BLUE);
        g2d.drawRect(blocks_1.x , blocks_1.y1,
                blocks_1.image1.getWidth() - 10, blocks_1.image1.getHeight() - 10);
        g2d.drawRect(blocks_1.x , blocks_1.y2 ,
                blocks_1.image2.getWidth() - 10, blocks_1.image2.getHeight() - 10);
        g2d.drawRect(blocks_1.x , blocks_1.y3,
                blocks_1.image3.getWidth() - 10, blocks_1.image3.getHeight() - 10);
        if (bi == null) {
            bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        }*/
        Graphics2D test = bi.createGraphics();
        if (fon._image != null) test.drawImage(fon._image, fon.x, fon.y, this);
        if (Bear._image != null) test.drawImage(Bear._image, Bear.x, Bear.y, this);
        if (blocks_1.image1 != null) test.drawImage(blocks_1.image1, blocks_1.x, blocks_1.y1, this);
        if (blocks_1.image2 != null) test.drawImage(blocks_1.image2, blocks_1.x, blocks_1.y2, this);
        if (blocks_1.image3 != null) test.drawImage(blocks_1.image3, blocks_1.x, blocks_1.y3, this);
        if (blocks_2.image1 != null) test.drawImage(blocks_2.image1, blocks_2.x2, blocks_2.y1, this);
        if (blocks_2.image2 != null) test.drawImage(blocks_2.image2, blocks_2.x2, blocks_2.y2, this);
        if (blocks_2.image3 != null) test.drawImage(blocks_2.image3, blocks_2.x2, blocks_2.y3, this);
        //if (white_heart._image != null) test.drawImage(white_heart._image, white_heart.x, white_heart.y, this);
        if (red_heart1._image != null) test.drawImage(red_heart1._image, red_heart1.x, red_heart1.y, this);
        if (red_heart2._image != null) test.drawImage(red_heart2._image, 200, red_heart2.y, this);
        if (red_heart3._image != null) test.drawImage(red_heart3._image, 400, red_heart3.y, this);


        g.drawImage(bi,0,0,this);



    }
    static int bam = 0;
    static boolean wasCl = false;
    Random inn = new Random();
    ActionListener al1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Rectangle bl1= new Rectangle(blocks_1.x, blocks_1.y1,blocks_1.image1.getWidth()-10,blocks_1.image1.getHeight()-10);
            Rectangle bl2= new Rectangle(blocks_1.x, blocks_1.y2,blocks_1.image2.getWidth()-10,blocks_1.image2.getHeight()-10);
            Rectangle bl3= new Rectangle(blocks_1.x, blocks_1.y3,blocks_1.image3.getWidth()-10,blocks_1.image3.getHeight()-10);
            Rectangle bl4= new Rectangle(blocks_2.x2, blocks_2.y1,blocks_2.image1.getWidth()-10,blocks_2.image1.getHeight()-10);
            Rectangle bl5= new Rectangle(blocks_2.x2, blocks_2.y2,blocks_2.image2.getWidth()-10,blocks_2.image2.getHeight()-10);
            Rectangle bl6= new Rectangle(blocks_2.x2, blocks_2.y3,blocks_2.image3.getWidth()-10,blocks_2.image3.getHeight()-10);

            boolean isCl = player.bam(bl1) || player.bam(bl2) || player.bam(bl3) || player.bam(bl4) || player.bam(bl5) || player.bam(bl6);
            if( isCl && !wasCl )
            {
                bam++;
                System.out.println("попадение");
                if (bam==1){
                    try {
                        red_heart1._image=ImageIO.read(getClass().getResourceAsStream("src/image/white_heart.png"));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else if (bam==2){
                    try {
                        red_heart2._image=ImageIO.read(getClass().getResourceAsStream("src/image/white_heart.png"));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else if (bam==3){
                    try {
                        red_heart3._image=ImageIO.read(getClass().getResourceAsStream("src/image/white_heart.png"));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    //my_timer.stop();
                    block_timer.stop();
                    timer.stop();
                    try {
                        new Game_room();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    dispose();
                }
            }
            wasCl=isCl;
            if(blocks_1.x== - blocks_1.image3.getWidth()){
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
            else {blocks_1.x=blocks_1.x-15;}
            repaint();
            if(blocks_2.x2 == -blocks_1.image3.getWidth()){
                blocks_2.x2=Blocks.xx1;
                int[] num = {Blocks.yy1,Blocks.yy2,Blocks.yy3,Blocks.yy4};
                int randIndex = inn.nextInt(num.length);

                blocks_2.y1 =num[randIndex];
                blocks_2.y2=blocks_2.y1;
                blocks_2.y3=blocks_2.y1;
                while (blocks_2.y2==blocks_2.y1 )
                {
                    randIndex = inn.nextInt(num.length);
                    blocks_2.y2 =num[randIndex];

                }
                while (blocks_2.y3==blocks_2.y1 || blocks_2.y3==blocks_2.y2 )
                {
                    randIndex = inn.nextInt(num.length);
                    blocks_2.y3 =num[randIndex];

                }


            }
            else {blocks_2.x2=blocks_2.x2-15;}
            repaint();

        }
    } ;
    Timer block_timer = new Timer(50,al1); //таймер через 10 секунд совершает действия в actionlistener

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

}




