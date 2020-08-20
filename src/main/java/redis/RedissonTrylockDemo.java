package redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

public class RedissonTrylockDemo {
    private static RedissonClient redissonClient;

    // 由配置config创建一个redissonClient, 然后getLock获得分布式锁对象，tryLock加锁，unlock解锁
    static {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        redissonClient = Redisson.create(config);
    }

    public static void main(String[] args) throws InterruptedException {
        // 本地存入了一个hash, key是锁名称"key", field是线程名称，value是1
        RLock rLock = redissonClient.getLock("key");
        if (rLock.tryLock(100, 10, TimeUnit.SECONDS)){
            System.out.println("获取锁成功");
        }
        rLock.unlock();

        redissonClient.shutdown();
    }
}
