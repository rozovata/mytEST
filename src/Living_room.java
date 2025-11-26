import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class osn1 extends JFrame implements KeyListener {


    public static void main(String[] args) {
        osn1 game = new osn1();
    }


    BufferedImage bi ;

    osn1() {

        setSize(1920, 1080);
        setVisible(true);
        setTitle("The best game");
        addKeyListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(ML);
        bi = new BufferedImage(1920,1080,BufferedImage.TYPE_INT_RGB);
    }
    public void paint(Graphics g) {
        if (bi == null) {
            bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        }

        Graphics2D test = bi.createGraphics();

        // Очищаем буфер БЕЛЫМ цветом
        test.setColor(Color.WHITE);
        test.fillRect(0, 0, getWidth(), getHeight());

        // Рисуем все картинки с проверками
        if (fon._image != null) test.drawImage(fon._image, fon.x, fon.y, this);
        if (bear._image != null) test.drawImage(bear._image, bear.x, bear.y, this);

        test.dispose();
        g.drawImage(bi, 0, 0, this);
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            bear.x -= 2;
        }
        if (key == KeyEvent.VK_RIGHT) {
            bear.x += 2;
        }
        if (key == KeyEvent.VK_SPACE) {
            System.out.println("Ты нажал на мишку");
        }
        repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    MouseListener ML = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent qwerty) {

            repaint();



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