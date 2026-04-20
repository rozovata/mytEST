import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDateTime;

class Death extends JFrame {


    character fon = new character("src/image/death.png", 0, 0);
    bear Bear = new bear("src/image/bear.png",
            bear.head(),
            bear.top(),
            bear.trousers(),
            bear.boots(),
            0, 0);





    Death() throws IOException {
        setSize(1920,1080);
        setVisible(true);
        addMouseListener(ML);
        bi = new BufferedImage(getWidth(), getHeight(), 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Time.SaveTime(LocalDateTime.now());
        Needs.CounteSaveFile2(0,"test.txt");
        Needs.CounteSaveFile2(0,"test1.txt");
        Needs.CounteSaveFile2(0,"test2.txt");
        Needs.CounteSaveFile2(0,"test3.txt");
        osn1.SaveFile(1,"boots.txt");
        osn1.SaveFile(1,"head.txt");
        osn1.SaveFile(1,"top.txt");
        osn1.SaveFile(1,"trousers.txt");

        GameManager.stopAllTimers();
        Needs.CounteSaveFile2(0, "food_death.txt");
        Needs.CounteSaveFile2(0, "game_death.txt");
        Needs.CounteSaveFile2(0, "shower_death.txt");
        Needs.CounteSaveFile2(0, "sleep_death.txt");

        // Сбрасываем комнату на гостиную
        Needs.CounteSaveFile2(1, "rooms.txt");

        // Обновляем картинки в Needs (чтобы при следующем запуске были правильные)
        GameManager.getSleepNeeds().updateImage();
        GameManager.getShowerNeeds().updateImage();
        GameManager.getFoodNeeds().updateImage();
        GameManager.getGameNeeds().updateImage();
    }

    BufferedImage  bi;
    public void paint(Graphics g)
    {
        if (bi == null) {
            bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        }
        Graphics2D test = bi.createGraphics();
        if (fon._image != null) test.drawImage(fon._image, fon.x, fon.y, this);
        g.drawImage(bi,0,0,this);

    }
    MouseListener ML = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent qwerty) {
            try {
                new Menu();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            dispose();

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