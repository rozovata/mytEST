import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;


public class Needs {
    BufferedImage image;
    public String filePath;
    public String[] images;
    public int counter;


    public Needs(String filePath, String[] images) throws IOException {
        this.filePath = filePath;
        this.images = images;
        this.counter = CounterFromFile();
        updateImage();
    }

    // Загружает значение из файла
    public int CounterFromFile() {
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
    public static int CounterFromFile2(String filePath) {
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

    //Сохраняет значение в файл
    public void CounteSaveFile() {
        try (FileWriter fileWriter = new FileWriter(filePath);) {//чтобы не закрывать поток
            fileWriter.write(String.valueOf(counter));//запишет не символ по номеру, а сам текст
            fileWriter.flush();  // ← ПРИНУДИТЕЛЬНАЯ запись!
        } catch (IOException a) {
            throw new RuntimeException(a);
        }
    }
    public static void CounteSaveFile2(int count, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath);) {//чтобы не закрывать поток
            fileWriter.write(String.valueOf(count));//запишет не символ по номеру, а сам текст
            fileWriter.flush();
        } catch (IOException a) {
            throw new RuntimeException(a);
        }
    }

    //Загружает картинку для текущего состояния
    public void updateImage() throws IOException {
        if(images != null && counter<images.length){
            this.image=ImageIO.read(new File(images[counter]));
        }
    }

    //Все обновляет, увеличивая состояние
    public void next() throws IOException {
        if( counter>=4){
            counter=4;
        }
        if (counter<4)
        {
            counter++;
        }
        if (counter < 0)
        {
            counter=0;
        }
        CounteSaveFile();
        updateImage();
    }

    // путь к изображению
    public String getCurrentImagePath() {
        if (images != null && counter >= 0 && counter < images.length) {
            return images[counter];
        }
        return "src/image/void.png"; // fallback
    }

    public boolean Death1()
    {
        boolean fl = false;
        int count=CounterFromFile();
        if (count==4)
        {
            fl=true;
        }
        return fl;
    }
    public static boolean  Death2( Needs sleep, Needs shower, Needs food, Needs game)
    {
        boolean fl1 = sleep.Death1();
        boolean fl2 = shower.Death1();
        boolean fl3 = food.Death1();
        boolean fl4 = game.Death1();
        boolean fl = false;
        if (fl1 && fl2 && fl3 && fl4)
        {
            fl=true;
        }
        return fl;
    };
    public static boolean need_death(Needs need, String file)
    {
        boolean y = false;
        int death = Needs.CounterFromFile2(file);
        if (death<4) {
            if (need.Death1())
                death++;
            else
                death = 0;
        }
        else
        {
            death = 0;
            y=true;
        }
        System.out.println(death);
        CounteSaveFile2(death, file);
        return y;
    }
    public static boolean res(Needs need1,Needs need2, Needs need3, Needs need4, String t1, String t2, String t3, String t4)
    {
        if(need_death(need1, t1))
        {
            CounteSaveFile2(0, t1);
            CounteSaveFile2(0, t2);
            CounteSaveFile2(0, t3);
            CounteSaveFile2(0, t4);
            return true;}
        if(need_death(need2, t2))
        {
            CounteSaveFile2(0, t1);
            CounteSaveFile2(0, t2);
            CounteSaveFile2(0, t3);
            CounteSaveFile2(0, t4);
            return true;}
        if(need_death(need3, t3))
        {
            CounteSaveFile2(0, t1);
            CounteSaveFile2(0, t2);
            CounteSaveFile2(0, t3);
            CounteSaveFile2(0, t4);
            return true;}
        if(need_death(need4, t4))
        {
            CounteSaveFile2(0, t1);
            CounteSaveFile2(0, t2);
            CounteSaveFile2(0, t3);
            CounteSaveFile2(0, t4);
            return true;}
        return false;
    }


}