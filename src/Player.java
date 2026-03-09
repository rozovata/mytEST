import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Player
{
    int x;
    int y;
    BufferedImage image;
    public Player (int x_, int y_, String s)
    {
        x = x_;
        y = y_;
        try {image = ImageIO.read(new File(s)); }catch (IOException e) { }
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