package redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

public class RedissonLockDemo {

    private static Redisson redisson;

    public static void main(String[] args) {
        RLock redissonLock = redisson.getLock("key");
        try {
            redissonLock.lock(30, TimeUnit.SECONDS);
        } finally {
            redissonLock.unlock();
        }
    }

}
