import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class testik extends JFrame implements KeyListener {

    public static void main(String[] args) {
        testik game = new testik();
    }
    character fon = new character("C:/Users/Tom/Documents/Школа/project/fon1.png", 0, 0);

    //Image fon = Toolkit.getDefaultToolkit().createImage("C:/Users/Tom/Documents/Школа/fon1.png");
    character no = new character("C:/Users/Tom/Documents/Школа/project/no.png", 0, 0);
    bear bear = new bear("C:/Users/Tom/Documents/Школа/project/Мишка1.png",
            "C:/Users/Tom/Documents/Школа/project/void.png",
            "C:/Users/Tom/Documents/Школа/project/void.png",
            "C:/Users/Tom/Documents/Школа/project/void.png",
            "C:/Users/Tom/Documents/Школа/project/void.png",
            0, 0);
    character yes = new character("C:/Users/Tom/Documents/Школа/project/yes.png", 0, 0);
    character panel = new character("C:/Users/Tom/Documents/Школа/project/panel1.png", 0, 0);
    character name = new character("C:/Users/Tom/Documents/Школа/project/name.png", 0, 0);
    botton pole = new botton("C:/Users/Tom/Documents/Школа/project/pole.png");
    botton arrow = new botton("C:/Users/Tom/Documents/Школа/project/arrow.png");
    botton arrow1 = new botton("C:/Users/Tom/Documents/Школа/project/arrow1.png");
    botton top = new botton("C:/Users/Tom/Documents/Школа/project/top.png");
    botton top2 = new botton("C:/Users/Tom/Documents/Школа/project/top2.png");
    botton hat = new botton("C:/Users/Tom/Documents/Школа/project/hat.png");
    botton hat1 = new botton("C:/Users/Tom/Documents/Школа/project/hat1.png");
    botton hat2 = new botton("C:/Users/Tom/Documents/Школа/project/hat2.png");
    botton bottom = new botton("C:/Users/Tom/Documents/Школа/project/bottom.png");
    botton shoes = new botton("C:/Users/Tom/Documents/Школа/project/shoes.png");

    int i=1;
    int p=1;
    int l=1;
    int m=1;


    testik() {

        setSize(1920, 1080);
        setVisible(true);
        setTitle("The best game");
        addKeyListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(ML);
    }

    public void paint(Graphics g) {
        //g.drawImage(fon, 0, 0, this);
        g.drawImage(fon._image, fon.x, fon.y, this);
        g.drawImage(bear._image, bear.x, bear.y, this);
        g.drawImage(bear._image1, bear.x, bear.y, this);
        g.drawImage(bear._image2, bear.x, bear.y, this);
        g.drawImage(bear._image3, bear.x, bear.y, this);
        g.drawImage(bear._image4, bear.x, bear.y, this);
        g.drawImage(no._image, no.x, no.y, this);
        g.drawImage(yes._image, yes.x, yes.y, this);
        g.drawImage(panel._image, panel.x, panel.y, this);
        g.drawImage(name._image, name.x, name.y, this);
        g.drawImage(pole._image, 0, 0, this);
        g.drawImage(pole._image,0,200, this);
        g.drawImage(pole._image, 0,400 ,this);
        g.drawImage(pole._image, 0,600, this);
        g.drawImage(arrow._image, 0,0, this);
        g.drawImage(arrow._image, 0,200, this);
        g.drawImage(arrow._image, 0,400, this);
        g.drawImage(arrow._image, 0,600, this);
        g.drawImage(arrow1._image, 0,0, this);
        g.drawImage(arrow1._image, 0,200, this);
        g.drawImage(arrow1._image, 0,400, this);
        g.drawImage(arrow1._image, 0,600, this);
        if (i==2) {
            g.drawImage(top._image, 0, 0, this);

        }
        if (i==3){
            g.drawImage(top2._image, 0, 0, this);
        }
        if (i>3 || i<1){
            i=1;
        }
        if (p==2) {
            g.drawImage(hat._image, 0, -30, this);

        }
        if (p==3){
            g.drawImage(hat1._image, 0, -30, this);
        }
        if (p==4 ){
            g.drawImage(hat2._image, 0, -30, this);
        }
        if (p>4 || p<1){
            p=1;
        }
        if (l==2){
            g.drawImage(bottom._image, 0, -50, this);
        }
        if (l>2 || l<1){
            l=1;
        }
        if (m==2){
            g.drawImage(shoes._image, 0, -70, this);
        }
        if (m>2 || m<1){
            m=1;
        }


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
            if (qwerty.getX() >= 1770 && qwerty.getX()<= (1770 + 60) && qwerty.getY() >= 200 && qwerty.getY()<= (200+ 100) )
            {
                i+=1;

            }
            repaint();
            if (qwerty.getX() >= 1770 && qwerty.getX()<= (1770 + 60) && qwerty.getY() >= 400 && qwerty.getY()<= (400+ 100) )
            {
                p+=1;

            }
            repaint();
            if (qwerty.getX() >= 1770 && qwerty.getX()<= (1770 + 60) && qwerty.getY() >= 600 && qwerty.getY()<= (600+ 100) )
            {
                l+=1;

            }
            repaint();
            if (qwerty.getX() >= 1770 && qwerty.getX()<= (1770 + 60) && qwerty.getY() >= 800 && qwerty.getY()<= (800+ 100) )
            {
                m+=1;

            }


            if (qwerty.getX() >= 1495 && qwerty.getX()<= (1495 + 60) && qwerty.getY() >= 200 && qwerty.getY()<= (200+ 100) )
            {
                i-=1;

            }
            repaint();
            if (qwerty.getX() >= 1495 && qwerty.getX()<= (1495 + 60) && qwerty.getY() >= 400 && qwerty.getY()<= (400+ 100) )
            {
                p-=1;

            }
            repaint();
            if (qwerty.getX() >= 1495 && qwerty.getX()<= (1495 + 60) && qwerty.getY() >= 600 && qwerty.getY()<= (600+ 100) )
            {
                l-=1;

            }
            repaint();
            if (qwerty.getX() >= 1495 && qwerty.getX()<= (1495 + 60) && qwerty.getY() >= 800 && qwerty.getY()<= (800+ 100) )
            {
                m-=1;

            }




            repaint();
            if (qwerty.getX() >= 1550 && qwerty.getX()<= (190+1550) && qwerty.getY() >= 183 && qwerty.getY()<= (183+165) && i==2 )
            {
                bear._image1=Toolkit.getDefaultToolkit().createImage("C:/Users/Tom/Documents/Школа/project/ts1.png");

            }
            repaint();
            if (qwerty.getX() >= 1550 && qwerty.getX()<= (190+1550) && qwerty.getY() >= 183 && qwerty.getY()<= (183+165) && i==3 )
            {
                bear._image1=Toolkit.getDefaultToolkit().createImage("C:/Users/Tom/Documents/Школа/project/ts2.png");

            }
            repaint();
            if (qwerty.getX() >= 1550 && qwerty.getX()<= (190+1550) && qwerty.getY() >= 183 && qwerty.getY()<= (183+165) && i==1 )
            {
                bear._image1=Toolkit.getDefaultToolkit().createImage("C:/Users/Tom/Documents/Школа/project/void.png");

            }
            repaint();
            if (qwerty.getX() >= 1550 && qwerty.getX()<= (190+1550) && qwerty.getY() >= 383 && qwerty.getY()<= (383+165) && p==2 )
            {
                bear._image2=Toolkit.getDefaultToolkit().createImage("C:/Users/Tom/Documents/Школа/project/head1.png");

            }
            repaint();
            if (qwerty.getX() >= 1550 && qwerty.getX()<= (190+1550) && qwerty.getY() >= 383 && qwerty.getY()<= (383+165) && p==3 )
            {
                bear._image2=Toolkit.getDefaultToolkit().createImage("C:/Users/Tom/Documents/Школа/project/head2.png");

            }
            repaint();
            if (qwerty.getX() >= 1550 && qwerty.getX()<= (190+1550) && qwerty.getY() >= 383 && qwerty.getY()<= (383+165) && p==4 )
            {
                bear._image2=Toolkit.getDefaultToolkit().createImage("C:/Users/Tom/Documents/Школа/project/head.png");

            }
            repaint();
            if (qwerty.getX() >= 1550 && qwerty.getX()<= (190+1550) && qwerty.getY() >= 383 && qwerty.getY()<= (383+165) && p==1 )
            {
                bear._image2=Toolkit.getDefaultToolkit().createImage("C:/Users/Tom/Documents/Школа/project/void.png");

            }
            repaint();
            if (qwerty.getX() >= 1550 && qwerty.getX()<= (190+1550) && qwerty.getY() >= 583 && qwerty.getY()<= (583+165) && l==2 )
            {
                bear._image3=Toolkit.getDefaultToolkit().createImage("C:/Users/Tom/Documents/Школа/project/trousers.png");

            }
            repaint();
            if (qwerty.getX() >= 1550 && qwerty.getX()<= (190+1550) && qwerty.getY() >= 583 && qwerty.getY()<= (583+165) && l==1 )
            {
                bear._image3=Toolkit.getDefaultToolkit().createImage("C:/Users/Tom/Documents/Школа/project/void.png");

            }
            repaint();
            if (qwerty.getX() >= 1550 && qwerty.getX()<= (190+1550) && qwerty.getY() >= 783 && qwerty.getY()<= (783+165) && m==2 )
            {
                bear._image4=Toolkit.getDefaultToolkit().createImage("C:/Users/Tom/Documents/Школа/project/boots.png");

            }
            repaint();
            if (qwerty.getX() >= 1550 && qwerty.getX()<= (190+1550) && qwerty.getY() >= 783 && qwerty.getY()<= (783+165) && m==1 )
            {
                bear._image4=Toolkit.getDefaultToolkit().createImage("C:/Users/Tom/Documents/Школа/project/void.png");

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
}


