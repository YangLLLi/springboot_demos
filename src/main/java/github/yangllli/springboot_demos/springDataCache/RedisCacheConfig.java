package github.yangllli.springboot_demos.springDataCache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;

/**
 * @EnableCaching  本质是使用RedisTemplate
 * redisCacheConfiguration  redisConnectionFactory
 * CacheManager
 *
 * redis持久化 RDB(快照） AOF(日志）
 * 淘汰 LRU
 * 单线程
 * 缓存穿透 缓存雪崩
 */


@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration configuration = RedisCacheConfiguration
                .defaultCacheConfig().entryTtl(Duration.ofHours(1))  //有效期一小时
                .disableCachingNullValues()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.string()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json())); //序列化方式
        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(configuration).build();
    }
}
