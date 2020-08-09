package redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;

public class RedissonBean {
    @Bean
    public Redisson redisson() {
        Config config = new Config();
        config.useClusterServers()
                .addNodeAddress("redis://10.0.0.7:6379")
                .addNodeAddress("redis://10.0.0.8:6379")
                .addNodeAddress("redis://10.0.0.9:6379");
        RedissonClient redissonClient = Redisson.create(config);
        return (Redisson) redissonClient;

    }
}
