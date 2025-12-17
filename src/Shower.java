import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Shower {
    BufferedImage _image;
    int x, y;

    Shower(String s, int _x, int _y) {
        x = _x;
        y = _y;
        try {
            _image = ImageIO.read(new File(s));
        } catch (IOException e) {}
    }
}