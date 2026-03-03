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
    character gf = new character("src/image/gift.png", 0, 0);
    Player gift = new Player(1920/2-70,0,gf._image);
    character platform = new character("src/image/platform.png",1920/2-150,800);



    KeyListener KL = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT) {
                platform.x -= 10;

            }
            if (key == KeyEvent.VK_RIGHT) {
                platform.x += 10;
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
        if (gift.image != null) test.drawImage(gift.image, gift.x, gift.y, this);

        g.drawImage(bi,0,0,this);



    }
    Random inn = new Random();
    ActionListener al1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Rectangle pl= new Rectangle(platform.x, platform.y,platform._image.getWidth(),platform._image.getHeight());
            if(gift.y>=platform.y-platform._image.getHeight()){
                if( gift.bam(pl) )
                {
                    System.out.println("попадение");
                    int randIndex = inn.nextInt(platform._image.getWidth()/2,1920-platform._image.getWidth()/2);
                    gift.x=randIndex;
                    gift.y=0;
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
            else {gift.y=gift.y+10;}
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

}




