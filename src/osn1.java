import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class osn1 extends JFrame implements KeyListener {


    public static void main(String[] args) {
        osn1 game = new osn1();
    }
    character fon = new character("src/image/fon1.png", 0, 0);

    //Image fon = Toolkit.getDefaultToolkit().createImage("C:/Users/Tom/Documents/Школа/fon1.png");
    character no = new character("src/image/no.png", 0, 0);
    bear Bear = new bear("src/image/Bear.png",
            bear.head(),
            bear.top(),
            bear.trousers(),
            bear.boots(),
            0, 0);
    character yes = new character("src/image/yes.png", 0, 0);
    character panel = new character("src/image/panel1.png", 0, 0);
    character name = new character("src/image/name.png", 0, 0);
    botton pole = new botton("src/image/pole.png");
    botton arrow = new botton("src/image/arrow.png");
    botton arrow1 = new botton("src/image/arrow1.png");
    botton top = new botton("src/image/ts1.png");
    botton top2 = new botton("src/image/ts2.png");
    botton hat = new botton("src/image/hat.png");
    botton hat1 = new botton("src/image/hat1.png");
    botton hat2 = new botton("src/image/hat2.png");
    botton bottom = new botton("src/image/bottom.png");
    botton shoes = new botton("src/image/shoes.png");
    botton to_return = new botton("src/image/to_return.png");

    int i=1;
    int p=1;
    int l=1;
    int m=1;

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
        if (Bear._image != null) test.drawImage(Bear._image, Bear.x, Bear.y, this);
        if (Bear._image1 != null) test.drawImage(Bear._image1, Bear.x, Bear.y, this);
        if (Bear._image2 != null) test.drawImage(Bear._image2, Bear.x, Bear.y, this);
        if (Bear._image3 != null) test.drawImage(Bear._image3, Bear.x, Bear.y, this);
        if (Bear._image4 != null) test.drawImage(Bear._image4, Bear.x, Bear.y, this);
        if (no._image != null) test.drawImage(no._image, no.x, no.y, this);
        if (yes._image != null) test.drawImage(yes._image, yes.x, yes.y, this);
        if (panel._image != null) test.drawImage(panel._image, panel.x, panel.y, this);
        if (name._image != null) test.drawImage(name._image, name.x, name.y, this);
        if (to_return._image != null) test.drawImage(to_return._image, 0,0,this);

        if (pole._image != null) {
            test.drawImage(pole._image, 0, 0, this);
            test.drawImage(pole._image, 0, 200, this);
            test.drawImage(pole._image, 0, 400, this);
            test.drawImage(pole._image, 0, 600, this);
        }

        if (arrow._image != null) {
            test.drawImage(arrow._image, 0, 0, this);
            test.drawImage(arrow._image, 0, 200, this);
            test.drawImage(arrow._image, 0, 400, this);
            test.drawImage(arrow._image, 0, 600, this);
        }

        if (arrow1._image != null) {
            test.drawImage(arrow1._image, 0, 0, this);
            test.drawImage(arrow1._image, 0, 200, this);
            test.drawImage(arrow1._image, 0, 400, this);
            test.drawImage(arrow1._image, 0, 600, this);
        }

        if (i == 2 && top._image != null) {
            test.drawImage(top._image, 0, 0, this);
        }
        if (i == 3 && top2._image != null) {
            test.drawImage(top2._image, 0, 0, this);
        }
        if (i > 3 || i < 1) {
            i = 1;
        }

        if (p == 2 && hat._image != null) {
            test.drawImage(hat._image, 0, -30, this);
        }
        if (p == 3 && hat1._image != null) {
            test.drawImage(hat1._image, 0, -30, this);
        }
        if (p == 4 && hat2._image != null) {
            test.drawImage(hat2._image, 0, -30, this);
        }
        if (p > 4 || p < 1) {
            p = 1;
        }

        if (l == 2 && bottom._image != null) {
            test.drawImage(bottom._image, 0, -50, this);
        }
        if (l > 2 || l < 1) {
            l = 1;
        }

        if (m == 2 && shoes._image != null) {
            test.drawImage(shoes._image, 0, -70, this);
        }
        if (m > 2 || m < 1) {
            m = 1;
        }
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

    MouseListener ML = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent qwerty) {
            if (qwerty.getX() >= 1770 && qwerty.getX()<= (1770 + 60) && qwerty.getY() >= 200 && qwerty.getY()<= (200+ 100) )
            {
                i+=1;

            }
            repaint(1760,200,60,100);
            if (qwerty.getX() >= 1770 && qwerty.getX()<= (1770 + 60) && qwerty.getY() >= 400 && qwerty.getY()<= (400+ 100) )
            {
                p+=1;

            }
            repaint(1770,400,60,100);
            if (qwerty.getX() >= 1770 && qwerty.getX()<= (1770 + 60) && qwerty.getY() >= 600 && qwerty.getY()<= (600+ 100) )
            {
                l+=1;

            }
            repaint(1770,600,60,100);
            if (qwerty.getX() >= 1770 && qwerty.getX()<= (1770 + 60) && qwerty.getY() >= 800 && qwerty.getY()<= (800+ 100) )
            {
                m+=1;

            }
            repaint(1770,800,60,100);
            if (qwerty.getX() >= 1495 && qwerty.getX()<= (1495 + 60) && qwerty.getY() >= 200 && qwerty.getY()<= (200+ 100) )
            {
                i-=1;

            }
            repaint(1495,200,60,100);
            if (qwerty.getX() >= 1495 && qwerty.getX()<= (1495 + 60) && qwerty.getY() >= 400 && qwerty.getY()<= (400+ 100) )
            {
                p-=1;

            }
            repaint(1495,400,60,100);
            if (qwerty.getX() >= 1495 && qwerty.getX()<= (1495 + 60) && qwerty.getY() >= 600 && qwerty.getY()<= (600+ 100) )
            {
                l-=1;

            }
            repaint(1495,600,60,100);
            if (qwerty.getX() >= 1495 && qwerty.getX()<= (1495 + 60) && qwerty.getY() >= 800 && qwerty.getY()<= (800+ 100) )
            {
                m-=1;

            }
            repaint(1495,800,60,100);
            if (qwerty.getX() >= 1550 && qwerty.getX()<= (190+1550) && qwerty.getY() >= 183 && qwerty.getY()<= (183+165) && i==2 )
            {
                try {Bear._image1 = ImageIO.read(new File("src/image/top.png")); }catch (IOException e) { }
                SaveFile(2,"top.txt");

            }
            repaint();
            if (qwerty.getX() >= 1550 && qwerty.getX()<= (190+1550) && qwerty.getY() >= 183 && qwerty.getY()<= (183+165) && i==3 )
            {
                try {Bear._image1 = ImageIO.read(new File("src/image/top2.png")); }catch (IOException e) { }
                SaveFile(3,"top.txt");

            }
            repaint();
            if (qwerty.getX() >= 1550 && qwerty.getX()<= (190+1550) && qwerty.getY() >= 183 && qwerty.getY()<= (183+165) && i==1 )
            {
                try {Bear._image1 = ImageIO.read(new File("src/image/void.png")); }catch (IOException e) { }
                SaveFile(1,"top.txt");

            }
            repaint();
            if (qwerty.getX() >= 1550 && qwerty.getX()<= (190+1550) && qwerty.getY() >= 383 && qwerty.getY()<= (383+165) && p==2 )
            {
                try {Bear._image2 = ImageIO.read(new File("src/image/head1.png")); }catch (IOException e) { }
                SaveFile(2,"head.txt");

            }
            repaint();
            if (qwerty.getX() >= 1550 && qwerty.getX()<= (190+1550) && qwerty.getY() >= 383 && qwerty.getY()<= (383+165) && p==3 )
            {
                try {Bear._image2 = ImageIO.read(new File("src/image/head2.png")); }catch (IOException e) { }
                SaveFile(3,"head.txt");

            }
            repaint();
            if (qwerty.getX() >= 1550 && qwerty.getX()<= (190+1550) && qwerty.getY() >= 383 && qwerty.getY()<= (383+165) && p==4 )
            {
                try {Bear._image2 = ImageIO.read(new File("src/image/head.png")); }catch (IOException e) { }
                SaveFile(4,"head.txt");
            }
            repaint();
            if (qwerty.getX() >= 1550 && qwerty.getX()<= (190+1550) && qwerty.getY() >= 383 && qwerty.getY()<= (383+165) && p==1 )
            {
                try {Bear._image2 = ImageIO.read(new File("src/image/void.png")); }catch (IOException e) { }
                SaveFile(1,"head.txt");
            }
            repaint();
            if (qwerty.getX() >= 1550 && qwerty.getX()<= (190+1550) && qwerty.getY() >= 583 && qwerty.getY()<= (583+165) && l==2 )
            {
                try {Bear._image3 = ImageIO.read(new File("src/image/trousers.png")); }catch (IOException e) { }
                SaveFile(2,"trousers.txt");
            }
            repaint();
            if (qwerty.getX() >= 1550 && qwerty.getX()<= (190+1550) && qwerty.getY() >= 583 && qwerty.getY()<= (583+165) && l==1 )
            {
                try {Bear._image3 = ImageIO.read(new File("src/image/void.png")); }catch (IOException e) { }
                SaveFile(1,"trousers.txt");
            }
            repaint();
            if (qwerty.getX() >= 1550 && qwerty.getX()<= (190+1550) && qwerty.getY() >= 783 && qwerty.getY()<= (783+165) && m==2 )
            {
                try {Bear._image4 = ImageIO.read(new File("src/image/boots.png")); }catch (IOException e) { }
                SaveFile(2,"boots.txt");
            }
            repaint();
            if (qwerty.getX() >= 1550 && qwerty.getX()<= (190+1550) && qwerty.getY() >= 783 && qwerty.getY()<= (783+165) && m==1 )
            {
                try {Bear._image4 = ImageIO.read(new File("src/image/void.png")); }catch (IOException e) { }
                SaveFile(1,"boots.txt");
            }
            repaint();
            if(m==1)
            {
                SaveFile(1,"boots.txt");
            }
            if(p==1)
            {
                SaveFile(1,"head.txt");
            }
            if(i==1)
            {
                SaveFile(1,"top.txt");
            }
            if(l==1)
            {
                SaveFile(1,"trousers.txt");
            }
            if(qwerty.getX() >= 623 && qwerty.getX()<= 977 && qwerty.getY() >= 27 && qwerty.getY()<= 153 )
            {
                dispose();//закрывает окно
                try {
                    new Bath_room1();
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
    public static void SaveFile(int counter, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath);) {//чтобы не закрывать поток
            fileWriter.write(String.valueOf(counter));//запишет не символ по номеру, а сам текст
            fileWriter.flush();  // ← ПРИНУДИТЕЛЬНАЯ запись!
        } catch (IOException a) {
            throw new RuntimeException(a);
        }
    }
}