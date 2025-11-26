import java.awt.*;

class bear {
    Image _image,_image1,_image2,_image3,_image4;
    int x, y;

//bear
    bear(String s,String s1, String s2, String s3, String s4, int _x, int _y) {
        x = _x;
        y = _y;
        _image = Toolkit.getDefaultToolkit().createImage(s);
        _image1 = Toolkit.getDefaultToolkit().createImage(s1);
        _image2= Toolkit.getDefaultToolkit().createImage(s2);
        _image3 = Toolkit.getDefaultToolkit().createImage(s3);
        _image3 = Toolkit.getDefaultToolkit().createImage(s4);

    }
}
