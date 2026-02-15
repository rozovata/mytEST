import java.io.*;
import java.io.FileReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {
    public static void SaveTime(LocalDateTime now) throws FileNotFoundException {
        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");//dd день месяца MM месяц yyyy год HH часы mm минуты
        String time = now.format(form);
        try (FileWriter FR = new FileWriter("time.txt"))
        {
            FR.write(time);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static LocalDateTime ReadTime()
    {
        String text= "";
        try (FileReader fr = new FileReader("time.txt")){
            int m;
            while ((m=fr.read())!=-1)
            {
                text = text + (char)m;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        text.trim();
        //  Создаем форматер для даты
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        //  Преобразуем строку в дату
        return LocalDateTime.parse(text, formatter);
    }
    public static int Duration() throws FileNotFoundException {
        LocalDateTime end = ReadTime();
        LocalDateTime now = LocalDateTime.now();
        Time.SaveTime(now);
        // Вычисляем разницу
        Duration duration = Duration.between(end, now);
        return Math.toIntExact(duration.toHours());//вернет сколько часов прошло
    }
    public static int Duration2() throws FileNotFoundException {
        LocalDateTime end = ReadTime();
        LocalDateTime now = LocalDateTime.now();
        Time.SaveTime(now);
        // Вычисляем разницу
        Duration duration = Duration.between(end, now);
        return Math.toIntExact(duration.toMinutes());//вернет сколько часов прошло
    }
   /* public static void NeedsTime(Needs need) throws FileNotFoundException {
        int duration = Time.Duration2();
        int t = need.CounterFromFile();
        if(t==4)
            return;

    }*/
}
