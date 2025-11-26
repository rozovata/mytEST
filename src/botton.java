import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class botton{
    BufferedImage _image;
    botton(String s) {
        try {_image = ImageIO.read(new File(s)); }catch (IOException e) { }
    }

}