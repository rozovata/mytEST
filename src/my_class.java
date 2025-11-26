//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.awt.*;//библиотека
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;//окно
public class my_class extends  JPanel{//Main {
    public int x = 50;
    public int y = 100;

    public void paintComponent(Graphics brush)
    {
        int x,y;
        x=50;
        y=50;

        Graphics2D g2d = (Graphics2D) brush;
        g2d.fillOval(x,y,50,50);
            //g2d.clearRect(0,0,600,400);
        Image my_image;
        try {
            my_image = ImageIO.read(new File("H:/ros/me_1project/my2/Мишка.png/"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g2d.drawImage(my_image,x,y,this);
        /*g2d.setColor(Color.BLACK);
        g2d.drawLine(50,50,100,50);
        g2d.drawLine(100,50,100,100);
        g2d.drawLine(100,100,50,100);
        g2d.drawLine(50,100,50,50);
        g2d.drawLine(50,50,75,25);
        g2d.drawLine(75,25,100,50);
        g2d.drawLine(80,100,80,70);
        g2d.drawLine(80,100,90,100);
        g2d.drawLine(90,100,90,100);


        */



    }
    public static void main(String[] args) {
        JFrame my_window = new JFrame("first game");//окно, показывает
        my_window.setSize(600,400);
        my_class Drawing_ = new my_class();
        my_window.setVisible(true);
        //my_window.setMaximumSize();
        my_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//завершить нажав на крестик
        my_window.add(Drawing_);


        }

    @Override
    public synchronized void addKeyListener(KeyListener l) {
        super.addKeyListener(l);
        //myPressed(new KeyEvent());
    }


    public void handleKeyPress(KeyEvent my_event)
        {
            int myCode = my_event.getKeyCode();
            if (myCode == KeyEvent.VK_LEFT)
            {
                x--;
            }
            if (myCode == KeyEvent.VK_RIGHT)
            {
                x++;
            }
            repaint();
        }

    }