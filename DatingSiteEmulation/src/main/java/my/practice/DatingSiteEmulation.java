package my.practice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

public class DatingSiteEmulation
{
    private static final int USERS = 20;

    // Также мы добавим задержку между посещениями
    private static final int SLEEP = 1000; // 1 секунда

    private static final SimpleDateFormat DF = new SimpleDateFormat("HH:mm:ss:SSS");

    private static void log(int UsersOnline) {
        String log = String.format("[%s] Пользователей онлайн: %d", DF.format(new Date()), UsersOnline);
        System.out.println(log);
    }

    public static void main(String[] args) throws InterruptedException {
        List<User> users = new ArrayList<>();

        Redis redis = new Redis();

        try {
            redis.init();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Заполнение списка пользователей и добавление в очередь Redis
        for(int i =1; i < USERS+1; i++){
            User user = new User(whatSex(), i);
            try {
                setNameAndSurname(user);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            users.add(user);
            redis.logPageVisit((int)user.getId());
        }


        //Цикл, показывающий пользователя
        int count = 0;
        for(;;){
            int userId;
            if(count == 10){
                userId = (int) ((Math.random() * 20) + 1);
                System.out.println("Пользователь " + getUser(userId, users).getSurname() + " " +
                                                        getUser(userId, users).getName() + " c id " + getUser(userId, users).getId() + "\nоплатил(а) показ вне очереди\n");
            } else {
                userId = Integer.valueOf(redis.registerUsers.first());
                System.out.println("Показываем пользователя:\n" + getUser(userId, users).toString() + "\n");
            }

            Thread.sleep(SLEEP);
            redis.logPageVisit(userId);

            count++;
            if(count == 19){
                count = 0;
            }
        }


//        User user = getUser(Long.parseLong(id), users);
//        System.out.println(user.getSurname() + " " + user.getName());
    }


    /*            МЕТОДЫ       */
    // присвоение пола
    public static User.Sex whatSex(){
        User.Sex sex = null;
        int[] numbers = new int[User.Sex.values().length];
        Random random = new Random();
        if (random.nextInt(numbers.length) != 0) {
            sex = User.Sex.F;
        } else {
            sex = User.Sex.M;
        }
        return sex;
    }

    // присвоение имени
    public static void setNameAndSurname(User user) throws IOException {
        File file = new File(Path.of("resources").toUri());
        List<String> femaleNames = Files.readAllLines(file.listFiles()[0].toPath());
        List<String> maleNames = Files.readAllLines(file.listFiles()[1].toPath());
        List<String> maleSurnames = Files.readAllLines(file.listFiles()[2].toPath());
        if(user.getSex() == User.Sex.M){
            user.setName(maleNames.get((int)(Math.random() * maleNames.size())));
            user.setSurname(maleSurnames.get((int)(Math.random() * maleSurnames.size())));
        } else {
            user.setName(femaleNames.get((int) (Math.random() * femaleNames.size())));
            String surname = maleSurnames.get((int) (Math.random() * maleSurnames.size()));
            if (surname.matches(".+[вн]$")) {
                surname = surname + "а";
            } else if (surname.matches(".+ий$")) {
                surname = surname.substring(0, surname.length() - 2) + "ая";
            }
            user.setSurname(surname);
        }
    }

    // получение пользователя по id
    public static User getUser(int id, List<User> users){
        User user = null;
        Iterator usersIterator = users.iterator();
        while(usersIterator.hasNext()){
            user = (User) usersIterator.next();
            if(user.getId() == id){
                return user;
            }
        }
        return user;
    }
}
