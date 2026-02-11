import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

class Cook_room extends JFrame {


    public static void main(String[] args) throws IOException {

        Cook_room game = new Cook_room();
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

    botton cake = new botton("src/image/cake.png");
    botton tea = new botton("src/image/tea.png");
    botton hot_dog = new botton("src/image/hot_dog.png");
    Needs sleepNeeds = new Needs("test.txt", sleepImages);
    Needs showerNeeds = new Needs("test2.txt", showerImages);
    Needs foodNeeds = new Needs("test1.txt", foodImages );
    Needs gameNeeds = new Needs("test3.txt", gameImages );
    Sleep sleep = new Sleep(sleepNeeds.getCurrentImagePath(),0,0);
    Shower shower = new Shower(showerNeeds.getCurrentImagePath(),0,0);
    Food food = new Food(foodNeeds.getCurrentImagePath(),0,0);
    Game game = new Game(gameNeeds.getCurrentImagePath(),0,0);

    static int meal = 1;

    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ee) {
            try {
                // Обновляем картинки в объектах
                sleepNeeds.next();
                showerNeeds.next();
                foodNeeds.next();
                gameNeeds.next();
                sleep._image = sleepNeeds.image;
                shower._image = showerNeeds.image;
                food._image = foodNeeds.image;
                game._image = gameNeeds.image;

            } catch (IOException e) {
                e.printStackTrace();
            }
            repaint();
        }
    };


    Timer my_timer = new Timer(10000,al); //таймер через 100 секунд совершает действия в actionlistener
    character fon = new character("src/image/Cook_room.png", 0, 0);
    character fon1 = new character("src/image/desk.png", 0, 0);
    bear Bear = new bear("src/image/bearcook.png",
            bear.head(),
            bear.top(),
            "src/image/void.png",
            "src/image/void.png",
            0, 0);
    botton arrowright = new botton("src/image/arrowright.png");
    botton arrowleft = new botton("src/image/arrowleft.png");
    botton arrow_room_right = new botton("src/image/arrow_room_right.png");
    botton arrow_room_left = new botton("src/image/arrow_room_left.png");

    KeyListener KL = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT) {
                Bear.x -= 2;
            }
            if (key == KeyEvent.VK_RIGHT) {
                Bear.x += 2;
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
    Cook_room() throws IOException {
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
        if (Bear._image != null) test.drawImage(Bear._image, Bear.x, Bear.y, this);
        if (sleep._image != null) test.drawImage(sleep._image, sleep.x, sleep.y, this);
        if (shower._image != null) test.drawImage(shower._image, shower.x, shower.y, this);
        if (food._image != null) test.drawImage(food._image, food.x, food.y, this);
        if (game._image != null) test.drawImage(game._image, game.x, game.y, this);
        if (Bear._image1 != null) test.drawImage(Bear._image1, 295-620,340-230, this);
        if (Bear._image2 != null) test.drawImage(Bear._image2,400-767,694-565, this);
        if (fon1._image != null) test.drawImage(fon1._image, fon1.x, fon1.y, this);
        if ( meal== 2 && cake._image != null) {
            test.drawImage(cake._image, 0, 0, this);
        }
        if ( meal== 3 && tea._image != null) {
            test.drawImage(tea._image, 0, 0, this);
        }
        if ( meal == 4 && hot_dog._image != null) {
            test.drawImage(hot_dog._image, 0, 0, this);
        }
        if (meal> 4 || meal < 1) {
            meal = 1;
        }
        if (arrowright._image != null) test.drawImage(arrowright._image, 0,0, this);
        if (arrowleft._image != null) test.drawImage(arrowleft._image, 0,0,this);
        if (arrow_room_right._image != null) test.drawImage(arrow_room_right._image, 0,0,this);
        if (arrow_room_left._image != null) test.drawImage(arrow_room_left._image, 0,0,this);


        g.drawImage(bi,0,0,this);


    }
    MouseListener ML = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent qwerty) {
            if (qwerty.getX() >= 1280 && qwerty.getX()<= 1371 && qwerty.getY() >= 875 && qwerty.getY()<= 1020 )
            {
                meal+=1;

            }
            repaint();
            if (qwerty.getX() >= 12 && qwerty.getX()<= 625 && qwerty.getY() >= 875 && qwerty.getY()<= 1020 )
            {
                meal-=1;

            }
            repaint();
            if (qwerty.getX() >= 720 && qwerty.getX()<= 1200 && qwerty.getY() >= 630 && qwerty.getY()<= 1010 && meal==2 )
            {
                try {cake._image = ImageIO.read(new File("src/image/void.png")); }catch (IOException e) { }
                foodNeeds.counter= foodNeeds.counter-3;
                osn1.SaveFile(foodNeeds.counter,"test1.txt");

            }
            repaint();
            if (qwerty.getX() >= 720 && qwerty.getX()<= 1200 && qwerty.getY() >= 630 && qwerty.getY()<= 1010 && meal==3 )
            {
                try {tea._image = ImageIO.read(new File("src/image/void.png")); }catch (IOException e) { }
                foodNeeds.counter= foodNeeds.counter-1;
                osn1.SaveFile(foodNeeds.counter,"test1.txt");

            }
            repaint();
            if (qwerty.getX() >= 720 && qwerty.getX()<= 1200 && qwerty.getY() >= 630 && qwerty.getY()<= 1010 && meal==4 )
            {
                try {hot_dog._image = ImageIO.read(new File("src/image/void.png")); }catch (IOException e) { }
                foodNeeds.counter= foodNeeds.counter-2;
                osn1.SaveFile(foodNeeds.counter,"test1.txt");

            }
            repaint();
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