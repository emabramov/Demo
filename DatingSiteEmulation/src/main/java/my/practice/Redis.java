package my.practice;

import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Redis {
    // Объект для работы с Redis
    private RedissonClient redisson;

    // Объект для работы с ключами
    private RKeys rKeys;

    // Объект для работы с Sorted Set'ом
    public RScoredSortedSet<String> registerUsers;

    private final static String KEY = "ONLINE_USERS";

    private double getTs() {
        return new Date().getTime();
    }

    // Пример вывода всех ключей
    public void listKeys() {
        Iterable<String> keys = rKeys.getKeys();
        for(String key: keys) {
            System.out.println("KEY: " + key + ", type:" + rKeys.getType(key));
        }
    }

    void init() throws IOException {
        Config config = Config.fromYAML(new File("resources/redisson.yaml"));
        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            System.out.println("Не удалось подключиться к Redis");
            System.out.println(Exc.getMessage());
        }
        rKeys = redisson.getKeys();
        registerUsers = redisson.getScoredSortedSet(KEY);
        rKeys.delete(KEY);
    }


    void shutdown() {
        redisson.shutdown();
    }

    // Фиксирует посещение пользователем страницы
    void logPageVisit(int user_id)
    {
        //ZADD ONLINE_USERS
        registerUsers.add(getTs(), String.valueOf(user_id));
    }

    void deleteOldEntries(int secondsAgo)
    {
        //ZREVRANGEBYSCORE ONLINE_USERS 0 <time_5_seconds_ago>
        registerUsers.removeRangeByScore(0, true, getTs() - secondsAgo, true);


    }
    int calculateUsersNumber()
    {
        //ZCOUNT ONLINE_USERS
        return registerUsers.count(Double.NEGATIVE_INFINITY, true, Double.POSITIVE_INFINITY, true);
    }
}
