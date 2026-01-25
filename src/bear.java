import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


class bear {
    BufferedImage _image;
    BufferedImage _image1;
    BufferedImage _image2;
    BufferedImage _image3;
    BufferedImage _image4;
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
    public static int CounterFile(String filePath) {
        File f = new File(filePath);

        try (Scanner s = new Scanner(f)) {
            if (s.hasNext()) { // есть ли слово для чтения
                String text = s.next();//читает слово, токен, разделенный пробелом
                return text.charAt(0) - '0';
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static String trousers()//l
    {
        switch(CounterFile("trousers.txt")) {
            case 2:return "src/image/trousers.png";
            default:return "src/image/void.png";
        }
    }
    public static String top()//i
    {
        switch(CounterFile("top.txt")) {
            case 2:return "src/image/top.png";
            case 3:return "src/image/top2.png";
            default:return "src/image/void.png";
        }
    }
    public static String head()//p
    {
        switch(CounterFile("head.txt")) {
            case 2:return "src/image/head1.png";
            case 3:return "src/image/head2.png";
            case 4:return "src/image/head.png";
            default:return "src/image/void.png";
        }
    }
    public static String boots()//m
    {
        switch(CounterFile("boots.txt")) {
            case 2:return "src/image/boots.png";
            default:return "src/image/void.png";
        }
    }

}