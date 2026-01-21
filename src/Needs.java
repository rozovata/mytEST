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

    //Сохраняет значение в файл
    public void CounteSaveFile() {
        try (FileWriter fileWriter = new FileWriter(filePath);) {//чтобы не закрывать поток
            fileWriter.write(String.valueOf(counter));//запишет не символ по номеру, а сам текст
            fileWriter.flush();  // ← ПРИНУДИТЕЛЬНАЯ запись!
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

    // Добавляем метод для получения пути к текущему изображению
    public String getCurrentImagePath() {
        if (images != null && counter >= 0 && counter < images.length) {
            return images[counter];
        }
        return "src/image/void.png"; // fallback
    }



}