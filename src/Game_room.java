import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDateTime;

class Game_room extends JFrame {

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
    botton play_button = new botton("src/image/play_button.png");
    botton play_array = new botton("src/image/play_array.png");

    character exit = new character("src/image/exit..png", 0, 0);
    character fon = new character("src/image/game_room.png", 0, 0);
    bear Bear = new bear("src/image/bear.png",
            bear.head(),
            bear.top(),
            bear.trousers(),
            bear.boots(),
            0, 0);

    Game_room() throws IOException {
        sleepNeeds = GameManager.getSleepNeeds();
        showerNeeds = GameManager.getShowerNeeds();
        foodNeeds = GameManager.getFoodNeeds();
        gameNeeds = GameManager.getGameNeeds();

        sleep = new Sleep(sleepNeeds.getCurrentImagePath(), 0, 0);
        shower = new Shower(showerNeeds.getCurrentImagePath(), 0, 0);
        food = new Food(foodNeeds.getCurrentImagePath(), 0, 0);
        game = new Game(gameNeeds.getCurrentImagePath(), 0, 0);

        sleep._image = sleepNeeds.image;
        shower._image = showerNeeds.image;
        food._image = foodNeeds.image;
        game._image = gameNeeds.image;

        setSize(1920,1080);
        setVisible(true);
        addMouseListener(ML);
        bi = new BufferedImage(getWidth(), getHeight(), 2);
        GameManager.setCurrentRoom(this);
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
        if (arrow_room_right._image != null) test.drawImage(arrow_room_right._image, 0,0,this);
        if (arrow_room_left._image != null) test.drawImage(arrow_room_left._image, 0,0,this);
        if (play_button != null) test.drawImage(play_button._image, 0,0,this);
        if (play_array != null) test.drawImage(play_array._image, 0,0,this);
        if (exit != null) test.drawImage(exit._image, exit.x, exit.y, this);




        g.drawImage(bi,0,0,this);


    }
    MouseListener ML = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent qwerty) {
            if (qwerty.getX() >= 1755 && qwerty.getX()<= 1920 && qwerty.getY() >= 0 && qwerty.getY()<= 167 )
            {
                GameManager.stopAllTimers();
                Living_room1.exit();

            }
            boolean n = false;
            if (qwerty.getX() >= 25 && qwerty.getX() <= 171 && qwerty.getY() >= 500 && qwerty.getY() <= 683)
            {
                try {
                    Rooms.room_next(n);
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
                    Rooms.class_room();
                    dispose();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (qwerty.getX() >= 43 && qwerty.getX() <= 655 && qwerty.getY() >= 800 && qwerty.getY() <= 1015)
            {
                try {
                    GameManager.stopAllTimers();
                    new Game_fly();
                    dispose();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (qwerty.getX() >= 43 && qwerty.getX() <= 655 && qwerty.getY() >= 572 && qwerty.getY() <= 785)
            {
                try {
                    GameManager.stopAllTimers();
                    new Game_gift();
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

}


