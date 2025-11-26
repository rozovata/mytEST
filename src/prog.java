import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class prog extends Frame implements KeyListener {
    ActionListener AL=new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (y<500)
            {
                y+=100;
            }
            if (y>=500)
            {
                y=0;
            }
            repaint();

        }
    };

    int x=50,y=50;
    public Image fox2 = Toolkit.getDefaultToolkit().getImage("H:/ros/me_1project/fon.png");
    public Image fox1 = Toolkit.getDefaultToolkit().getImage("H:/ros/me_1project/bear.png");
    int p=1;
    Timer my_timer=new Timer(500,AL);

    public prog()
    {
        addKeyListener(this);

        setSize(500,500);
        setVisible(true);
        my_timer.start();

    }

    public static void main(String[] args) {
        new prog();
    }

    public void paint(Graphics my_g)
    {
        if (p==1) {
            my_g.drawImage(fox1, x, y, this);
        }
        else {
            my_g.drawImage(fox2, x, y, this);
        }
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int myCode = e.getKeyCode();
        if (myCode == KeyEvent.VK_LEFT) {
            x--;
        }
        if (myCode == KeyEvent.VK_RIGHT) {
            x++;
        }
        if (myCode == KeyEvent.VK_SPACE)
        {
            p = p* (-1);
        }
        repaint();
        if (x>=getSize().width-200)
        {
            x=getSize().width-200;

        }
        if (x<=0)  {
            x=0;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
