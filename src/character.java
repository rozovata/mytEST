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
        try {_image = ImageIO.read(new File(s)); }catch (IOException e) { System.out.println("нет поля");}
    }
}