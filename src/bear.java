import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


class bear {
    BufferedImage _image,_image1,_image2,_image3,_image4;
    int x, y;

    bear(String s,String s1, String s2, String s3, String s4, int _x, int _y) {
        x = _x;
        y = _y;
        try {_image = ImageIO.read(new File(s)); }catch (IOException e) { }
        try {_image1 = ImageIO.read(new File(s1)); }catch (IOException e) { }
        try {_image2 = ImageIO.read(new File(s2)); }catch (IOException e) { }
        try {_image3 = ImageIO.read(new File(s3)); }catch (IOException e) { }
        try {_image4 = ImageIO.read(new File(s4)); }catch (IOException e) { }

    }
}