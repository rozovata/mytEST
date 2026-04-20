import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameManager {
    public static Needs sleepNeeds;
    public static Needs showerNeeds;
    public static Needs foodNeeds;
    public static Needs gameNeeds;

    public static Timer globalNeedsTimer;
    public static Timer globalDeathTimer;
    //таймеры запущены
    private static boolean timersStarted = false;
    //комната
    private static JFrame currentRoom;
    //инициализация
    public static void init() throws IOException {
            String[] sleepImages = {
                    "src/image/sleep1.png", "src/image/sleep2.png",
                    "src/image/sleep3.png", "src/image/sleep4.png", "src/image/sleep5.png"
            };
            String[] showerImages = {
                    "src/image/shower1.png", "src/image/shower2.png",
                    "src/image/shower3.png", "src/image/shower4.png", "src/image/shower5.png"
            };
            String[] foodImages = {
                    "src/image/food1.png", "src/image/food2.png",
                    "src/image/food3.png", "src/image/food4.png", "src/image/food5.png"
            };
            String[] gameImages = {
                    "src/image/game1.png", "src/image/game2.png",
                    "src/image/game3.png", "src/image/game4.png", "src/image/game5.png"
            };

            sleepNeeds = new Needs("test.txt", sleepImages);
            showerNeeds = new Needs("test2.txt", showerImages);
            foodNeeds = new Needs("test1.txt", foodImages);
            gameNeeds = new Needs("test3.txt", gameImages);
    }

    public static void startGlobalTimers() {
        if (timersStarted) {
            return; //запущены
        }
        globalNeedsTimer = new Timer(15000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sleepNeeds.next();
                    showerNeeds.next();
                    foodNeeds.next();
                    gameNeeds.next();

                    // обновляем картинки в текущей комнате
                    updateCurrentRoomImages();

                    if (currentRoom != null) {
                        currentRoom.repaint();
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        //смерть
        globalDeathTimer = new Timer(15000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Needs.res(sleepNeeds, showerNeeds, foodNeeds, gameNeeds,
                        "sleep_death.txt", "shower_death.txt",
                        "food_death.txt", "game_death.txt")) {
                    try {
                        globalNeedsTimer.stop();
                        globalDeathTimer.stop();
                        timersStarted = false;
                        new Death();
                        if (currentRoom != null) {
                            currentRoom.dispose();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        globalNeedsTimer.start();
        globalDeathTimer.start();
        timersStarted = true;
    }

    //обновить ссылку на текущую комнату
    public static void setCurrentRoom(JFrame room) {
        currentRoom = room;
        updateCurrentRoomImages();  //обновляем картинки
        if (currentRoom != null) {
            currentRoom.repaint();
        }
    }
    public static void refreshImage() {
        updateCurrentRoomImages();
        if (currentRoom != null) {
            currentRoom.repaint();
        }
    }

    //обновления картинок в любой комнате
    private static void updateCurrentRoomImages() {
        if (currentRoom == null) return;

        if (currentRoom instanceof Living_room1) {
            Living_room1 r = (Living_room1) currentRoom; //ссылается на этот обьект
            r.sleep._image = sleepNeeds.image;
            r.shower._image = showerNeeds.image;
            r.food._image = foodNeeds.image;
            r.game._image = gameNeeds.image;
        }
        else if (currentRoom instanceof Cook_room) {
            Cook_room r = (Cook_room) currentRoom;
            r.sleep._image = sleepNeeds.image;
            r.shower._image = showerNeeds.image;
            r.food._image = foodNeeds.image;
            r.game._image = gameNeeds.image;
        }
        else if (currentRoom instanceof Bath_room1) {
            Bath_room1 r = (Bath_room1) currentRoom;
            r.sleep._image = sleepNeeds.image;
            r.shower._image = showerNeeds.image;
            r.food._image = foodNeeds.image;
            r.game._image = gameNeeds.image;
        }
        else if (currentRoom instanceof Game_room) {
            Game_room r = (Game_room) currentRoom;
            r.sleep._image = sleepNeeds.image;
            r.shower._image = showerNeeds.image;
            r.food._image = foodNeeds.image;
            r.game._image = gameNeeds.image;
        }
    }

    //остановить все таймеры (выход из игры)
    public static void stopAllTimers() {
        if (globalNeedsTimer != null && globalNeedsTimer.isRunning()) {
            globalNeedsTimer.stop();
        }
        if (globalDeathTimer != null && globalDeathTimer.isRunning()) {
            globalDeathTimer.stop();
        }
        timersStarted = false;
    }

    // получить потребности (чтобы комнаты могли их читать)
    public static Needs getSleepNeeds() { return sleepNeeds; }
    public static Needs getShowerNeeds() { return showerNeeds; }
    public static Needs getFoodNeeds() { return foodNeeds; }
    public static Needs getGameNeeds() { return gameNeeds; }
}