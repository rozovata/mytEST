import java.awt.*;

public class character {
    Image _image;
    int x, y;


    character(String s, int _x, int _y) {
        x = _x;
        y = _y;
        _image = Toolkit.getDefaultToolkit().createImage(s);
    }
}