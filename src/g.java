import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class g extends JFrame {
    KeyListener KL=new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    } ;



    MouseListener ML = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent qwerty) {
            if (qwerty.getX() >= 800 && qwerty.getX()<= 1050 && qwerty.getY() >= 300 && qwerty.getY()<= 500 )
            {
                dispose();
                new osn1();

            }
            if (qwerty.getX() >= 820 && qwerty.getX()<= 1000 && qwerty.getY() >= 500 && qwerty.getY()<= 700 )
            {
                System.exit(0);

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


    Image save;
    Image fon;
    Image sitting;
    Image sit;


    g() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(2000, 1000);
        setVisible(true);
        addKeyListener(KL);
        addMouseListener(ML);

        fon = Toolkit.getDefaultToolkit().createImage("H:/ros/me_1project/5438484227139173417.jpg");
        save = Toolkit.getDefaultToolkit().createImage("H:/ros/me_1project/save.png");
        sitting = Toolkit.getDefaultToolkit().createImage("H:/ros/me_1project/sitting.png");
        sit = Toolkit.getDefaultToolkit().createImage("H:/ros/me_1project/sitting.png");
    }

    public void paint(Graphics g)
    {
        g.drawImage(fon, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(save,800,300,this);
        g.drawImage(sitting,820,500,this);
        g.drawImage(sit,820,700,this);
    }

    //"C:TATIANA/Users/Tom/IdeaProjects/my_game/5438484227139173417.jpg"
    public static void main(String[] args) {
        g w=new g();

    }


}

































/*import javax.swing.*;
import java.awt.*;

public class work extends JFrame
{


    Image _image;
    Image fon;


    work()
    {
        setSize(500,500);
        setVisible(true);
        _image= Toolkit.getDefaultToolkit().createImage("H:/ros/me_1project/my2/src/im.jpg");
        fon=Toolkit.getDefaultToolkit().createImage("H:/ros/me_1project/my2/src/Фон.jpg");
    }


    public void paint(Graphics g)
    {
        g.drawImage(fon,100,100,this);
        g.drawImage(_image,200,100,this);


    }



    //"H:/ros/me_1project/my2/src/im.jpg"
    public static void main(String[] args) {
        work w=new work();



    }


}
*/