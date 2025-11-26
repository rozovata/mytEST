/*import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

class osn extends JFrame implements KeyListener {
    public static void main(String[] args) {
        osn game = new osn();
    }

    character fon = new character("H:/ros/me_1project/fon.png", 0, 0);
    //Image fon = Toolkit.getDefaultToolkit().createImage("C:/Users/Tom/Documents/Школа/fon1.png");
    //character no = new character("H:/ros/me_1project/no.png", 0, 0);
    character cat = new character("H:/ros/me_1project/m.png", 0, 0);
    //character yes = new character("C:/Users/Tom/Documents/Школа/project/yes.png", 0, 0);
    //character panel = new character("C:/Users/Tom/Documents/Школа/project/panel1.png", 0, 0);
    //character name = new character("C:/Users/Tom/Documents/Школа/project/name.png", 0, 0);
    botton pole = new botton("H:/ros/me_1project/panel.png");
    botton arrow = new botton("H:/ros/me_1project/arrow.png");
    botton arrow1 = new botton("H:/ros/me_1project/arrow1.png");
    botton top = new botton("H:/ros/me_1project/top.png");
    botton top2 = new botton("H:/ros/me_1project/top2.png");
    botton hat = new botton("H:/ros/me_1project/hat.png");
    botton hat1 = new botton("H:/ros/me_1project/hat1.png");
    botton hat2 = new botton("H:/ros/me_1project/hat2.png");
    botton bottom = new botton("H:/ros/me_1project/bottom.png");
    botton shoes = new botton("H:/ros/me_1project/m.png");
    int i = 1;
    int p = 1;
    int l = 1;
    int m = 1;

    osn() {
        setSize(1920, 1080);
        setVisible(true);
        setTitle("The best game");
        addKeyListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(ML);
    }
    //BufferedImage bi = new BufferedImage(cat.x,cat.y,6);

    public void paint(Graphics g) {
        //g.drawImage(fon, 0, 0, this);
        g.drawImage(fon._image, fon.x, fon.y, this);
        g.drawImage(cat._image, cat.x, cat.y, this);
        //g.drawImage(bi,0,0,this);
        //g.drawImage(no._image, no.x, no.y, this);
        //g.drawImage(yes._image, yes.x, yes.y, this);
        //g.drawImage(panel._image, panel.x, panel.y, this);
        //g.drawImage(name._image, name.x, name.y, this);
        g.drawImage(pole._image, 0, 0, this);
        g.drawImage(pole._image, 0, 200, this);
        g.drawImage(pole._image, 0, 400, this);
        g.drawImage(pole._image, 0, -200, this);
        g.drawImage(arrow._image, 0, 0, this);
        g.drawImage(arrow._image, 0, 200, this);
        g.drawImage(arrow._image, 0, 400, this);
        g.drawImage(arrow._image, 0, 600, this);
        g.drawImage(arrow1._image, 0, 0, this);
        g.drawImage(arrow1._image, 0, 200, this);
        g.drawImage(arrow1._image, 0, 400, this);
        g.drawImage(arrow1._image, 0, 600, this);


        switch (i) {
            case 2:
                g.drawImage(top._image, 0, 0, this);
                break;
            case 3:
                g.drawImage(top2._image, 0, 0, this);
                break;
            default:
                i = 1;
        }
        switch (p) {
            case 2:
                g.drawImage(hat._image, 0, -30, this);
                break;
            case 3:
                g.drawImage(hat1._image, 0, -30, this);
                break;
            case 4:
                g.drawImage(hat2._image, 0, -30, this);
                break;
            default:
                p = 1;
        }
        switch (p) {
            case 2:
                g.drawImage(hat._image, 0, -30, this);
                break;
            case 3:
                g.drawImage(hat1._image, 0, -30, this);
                break;
            case 4:
                g.drawImage(hat2._image, 0, -30, this);
                break;
            default:
                p = 1;

        }
        switch (l) {
            case 2:
                g.drawImage(bottom._image, 0, -50, this);
                break;
            default:
                l = 1;

        }
        switch (m) {
            case 2:
                g.drawImage(shoes._image, 0, -70, this);
                break;
            default:
                m = 1;

        }
    }

        @Override
        public void keyTyped (KeyEvent e){
        }
        @Override
        public void keyPressed (KeyEvent e){
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT && cat.x - 2 > 0) {
                cat.x -= 2;
            }
            if (key == KeyEvent.VK_RIGHT) {
                cat.x += 2;
            }
            if (key == KeyEvent.VK_SPACE) {
                System.out.println("Ты нажал на мишку");
            }
            repaint();
        }
        @Override
        public void keyReleased (KeyEvent e){

        }
        MouseListener ML = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent qwerty) {
                if (qwerty.getX() >= 1770 && qwerty.getX() <= (1770 + 60) && qwerty.getY() >= 200 && qwerty.getY() <= (200 + 100)) {
                    System.out.println("мишка!!!");
                    i += 1;
                }
                repaint();
                if (qwerty.getX() >= 1770 && qwerty.getX() <= (1770 + 60) && qwerty.getY() >= 400 && qwerty.getY() <= (400 + 100)) {
                    p += 1;

                }
                repaint();
                if (qwerty.getX() >= 1770 && qwerty.getX() <= (1770 + 60) && qwerty.getY() >= 600 && qwerty.getY() <= (600 + 100)) {
                    l += 1;

                }
                repaint();
                if (qwerty.getX() >= 1770 && qwerty.getX() <= (1770 + 60) && qwerty.getY() >= 800 && qwerty.getY() <= (800 + 100)) {
                    m += 1;
                }
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

        class botton {
            Image _image;

            botton(String s) {
                _image = Toolkit.getDefaultToolkit().createImage(s);
            }
        }
    }
*/
