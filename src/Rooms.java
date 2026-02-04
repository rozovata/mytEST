import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Rooms {
    public static void room_next(boolean k) throws IOException {
        int room = read("rooms.txt");

        try (FileWriter fileWriter = new FileWriter("rooms.txt")) {
            int nextRoom;

            if (k) { // движение вперед
                nextRoom = (room == 4) ? 1 : room + 1;
            } else { // движение назад
                nextRoom = (room == 1) ? 4 : room - 1;
            }

            // ЗАПИСЫВАЕМ результат в файл:
            fileWriter.write(String.valueOf(nextRoom));
            fileWriter.flush();
        }
    }

    public static int read(String filePath) {
        File f = new File(filePath);
        try (Scanner s = new Scanner(f)) {
            if (s.hasNext()) {
                String text = s.next();
                return text.charAt(0) - '0';
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void class_room() throws IOException {
        int room = read("rooms.txt");
        if (room == 1)
            new Living_room1();
        if (room == 2)
            new Cook_room();
        if (room == 3)
            new Bath_room1();
        if (room == 4)
            new Game_room();
    }

 /*   public static void NEXT() {

        MouseListener ML = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent qwerty) {
                boolean n = false;
                if (qwerty.getX() >= 25 && qwerty.getX() <= 171 && qwerty.getY() >= 500 && qwerty.getY() <= 683) {
                    try {
                        Rooms.room_next(n);
                        dispose();
                        Rooms.class_room();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (qwerty.getX() >= 1750 && qwerty.getX() <= 1893 && qwerty.getY() >= 500 && qwerty.getY() <= 683) {
                    n = true;
                    try {
                        Rooms.room_next(n);
                        dispose();
                        Rooms.class_room();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }


            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
    }*/

}
