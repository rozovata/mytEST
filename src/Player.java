import java.awt.*;
import java.awt.image.BufferedImage;

class Player
{
    int x;
    int y;
    BufferedImage image;
    public Player (int x_, int y_, BufferedImage image_)
    {
        x = x_;
        y = y_;
        image = image_;
    }
    public boolean bam (Rectangle temp)
    {
        Rectangle boarder= new Rectangle(x,y,image.getWidth(), image.getHeight() );
        if (boarder.intersects(temp))
        {
            return true;
        }
        return false;
    }
}