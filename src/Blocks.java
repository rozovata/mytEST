import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Blocks {
    BufferedImage image1;
    BufferedImage image2;
    BufferedImage image3;
    int x,x2, y1, y2, y3;
    static int xx1=1920;
    static int xx2=1920+1005;
    static int yy1=0;
    static int yy2=250;
    static int yy3=525;
    static int yy4=800;


    Blocks(String s1,String s2, String s3, int _y1, int _y2, int _y3) {
        x = xx1;
        x2 =xx2;
        y1 = _y1;
        y2 = _y2;
        y3 = _y3;
        try {
            image1 = ImageIO.read(new File(s1));
            image2 = ImageIO.read(new File(s2));
            image3 = ImageIO.read(new File(s3));

        } catch (IOException e) {}
    }
}
