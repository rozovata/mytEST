import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;
class Living_room1 extends JFrame {

    Needs sleepNeeds;
    Needs showerNeeds;
    Needs foodNeeds;
    Needs gameNeeds;

    Sleep sleep;
    Shower shower;
    Food food;
    Game game;
    botton arrow_room_right = new botton("src/image/arrow_room_right.png");
    botton arrow_room_left = new botton("src/image/arrow_room_left.png");
    character exit = new character("src/image/exit..png", 0, 0);
    Timer timerBad;
    character fon = new character("src/image/Bad_room.png", 0, 0);
    bear Bear;

     int bad=0;
    ActionListener al1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ee) {
            if (bad<=3 && bad!=0)
            {

                try {Bear._image = ImageIO.read(new File("src/image/Bearbad.png")); }catch (IOException e) { }
                try {Bear._image1 = ImageIO.read(new File("src/image/void.png")); }catch (IOException e) { }
                try {Bear._image2 = ImageIO.read(new File("src/image/void.png")); }catch (IOException e) { }
                try {Bear._image3 = ImageIO.read(new File("src/image/void.png")); }catch (IOException e) { }
                try {Bear._image4 = ImageIO.read(new File("src/image/void.png")); }catch (IOException e) { }
                bad++;
                try (FileWriter fileWriter = new FileWriter(sleepNeeds.filePath)){
                    if (sleepNeeds.counter>0)
                    {
                        sleepNeeds.counter--;
                    }
                    fileWriter.write(String.valueOf(sleepNeeds.counter));
                    fileWriter.flush();
                    System.out.println("Файл записан: " + sleepNeeds.filePath + " значение: " + (sleepNeeds.counter));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    sleepNeeds.updateImage();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                sleep._image = sleepNeeds.image;
                repaint();

                if (!timerBad.isRunning()) {
                    timerBad.start();
                }
            }
            else {
                timerBad.stop();
                bad =0;
                try {
                    Bear._image = ImageIO.read(new File("src/image/Bear.png"));
                    Bear._image1 = ImageIO.read(new File(bear.head()));
                    Bear._image2 = ImageIO.read(new File(bear.top()));
                    Bear._image3 = ImageIO.read(new File(bear.trousers()));
                    Bear._image4 = ImageIO.read(new File(bear.boots()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            repaint();

        }
    };


    Living_room1() throws IOException {

        // Берём потребности из GameManager
        sleepNeeds = GameManager.getSleepNeeds();
        showerNeeds = GameManager.getShowerNeeds();
        foodNeeds = GameManager.getFoodNeeds();
        gameNeeds = GameManager.getGameNeeds();
        sleepNeeds.updateImage();
        showerNeeds.updateImage();
        foodNeeds.updateImage();
        gameNeeds.updateImage();
        // Создаём объекты с картинками
        sleep = new Sleep(sleepNeeds.getCurrentImagePath(), 0, 0);
        shower = new Shower(showerNeeds.getCurrentImagePath(), 0, 0);
        food = new Food(foodNeeds.getCurrentImagePath(), 0, 0);
        game = new Game(gameNeeds.getCurrentImagePath(), 0, 0);

        sleep._image = sleepNeeds.image;
        shower._image = showerNeeds.image;
        food._image = foodNeeds.image;
        game._image = gameNeeds.image;
        GameManager.setCurrentRoom(this);
        GameManager.refreshImage();


        Bear = new bear("src/image/bear.png",
                bear.head(), bear.top(), bear.trousers(), bear.boots(), 0, 0);

        timerBad = new Timer(1000, al1);

        setSize(1920, 1080);
        setVisible(true);
        addMouseListener(ML);
        bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

        // Запускаем глобальные таймеры (один раз)
        GameManager.startGlobalTimers();

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
        if (Bear._image1 != null) test.drawImage(Bear._image1, Bear.x, Bear.y, this);
        if (Bear._image2 != null) test.drawImage(Bear._image2, Bear.x, Bear.y, this);
        if (Bear._image3 != null) test.drawImage(Bear._image3, Bear.x, Bear.y, this);
        if (Bear._image4 != null) test.drawImage(Bear._image4, Bear.x, Bear.y, this);
        if (exit != null) test.drawImage(exit._image, exit.x, exit.y, this);
        if (arrow_room_right._image != null) test.drawImage(arrow_room_right._image, 0,0,this);
        if (arrow_room_left._image != null) test.drawImage(arrow_room_left._image, 0,0,this);


        g.drawImage(bi,0,0,this);


    }
    MouseListener ML = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent qwerty) {
            if (qwerty.getX() >= 1755 && qwerty.getX()<= 1920 && qwerty.getY() >= 0 && qwerty.getY()<= 167 )
            {
                GameManager.stopAllTimers();
                exit();
            }
            if (qwerty.getX() >= 900 && qwerty.getX() <= 1700 && qwerty.getY() >= 412 && qwerty.getY() <= 840) {
                bad += 1;
                if (!timerBad.isRunning()) {
                    timerBad.start();
                } else {
                }
            } else {
                //System.out.println("Мимо");
            }
            repaint();
            boolean n = false;
            if (qwerty.getX() >= 25 && qwerty.getX() <= 171 && qwerty.getY() >= 500 && qwerty.getY() <= 683)
            {
                try {
                    Rooms.room_next(n);
                    timerBad.stop();
                    Rooms.class_room();
                    dispose();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (qwerty.getX() >= 1750 && qwerty.getX() <= 1893 && qwerty.getY() >= 500 && qwerty.getY() <= 683)
            {
                n=true;
                try {
                    Rooms.room_next(n);
                    timerBad.stop();
                    Rooms.class_room();
                    dispose();
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

    public static void exit()
    {
        try {
            Needs.CounteSaveFile2(1,"rooms.txt");
            Time.SaveTime(LocalDateTime.now());
            Needs.CounteSaveFile2(0, "food_death.txt");
            Needs.CounteSaveFile2(0, "game_death.txt");
            Needs.CounteSaveFile2(0, "shower_death.txt");
            Needs.CounteSaveFile2(0, "sleep_death.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }

}


