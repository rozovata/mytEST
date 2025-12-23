import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class character {
    BufferedImage _image;
    int x, y;

    character(String s, int _x, int _y) {
        x = _x;
        y = _y;
        try {
            _image = ImageIO.read(new File(s));
        } catch (IOException e) {
            System.out.println("нет поля");
        }

    }

    public boolean bam(Rectangle temp) {
        Rectangle boarder = new Rectangle(x, y, _image.getWidth(), _image.getHeight());
        if (boarder.intersects(temp)) {
            System.out.println("boom!!!!!");
            return true;
        }
        return false;

    }
}