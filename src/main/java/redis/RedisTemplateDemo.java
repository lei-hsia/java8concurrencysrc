package redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RedisTemplateDemo {
    public static void main(String[] args) {

        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();

        try {
            stringRedisTemplate.setEnableTransactionSupport(true);
            stringRedisTemplate.multi();
            Boolean res = stringRedisTemplate.opsForValue().setIfAbsent("lockKey", "val");
            if (res) {
                stringRedisTemplate.expire("lockKey", 10, TimeUnit.SECONDS);
            }
            List<Object> execRes = stringRedisTemplate.exec();
            if (execRes.get(0) != null) {
                // do something ...
            }
        } finally {
            stringRedisTemplate.delete("lockKey");
        }
    }
}
