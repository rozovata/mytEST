import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDateTime;

class Setting_text extends JFrame {


    public static void main(String[] args) throws IOException {
        Setting_text Setting_text = new Setting_text();
    }
    character setting_text = new character("src/image/setting_text.png",0,0);


    Setting_text() throws IOException {
        setSize(1920,1080);
        setVisible(true);
        addMouseListener(ML);
        bi = new BufferedImage(getWidth(), getHeight(), 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    BufferedImage  bi;
    public void paint(Graphics g)
    {
        if (bi == null) {
            bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        }
        Graphics2D test = bi.createGraphics();
        if (setting_text._image != null) test.drawImage(setting_text._image, setting_text.x, setting_text.y, this);
        g.drawImage(bi,0,0,this);

    }
    MouseListener ML = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent qwerty) {
            try {
                new Menu();
            } catch (FileNotFoundException e) {
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