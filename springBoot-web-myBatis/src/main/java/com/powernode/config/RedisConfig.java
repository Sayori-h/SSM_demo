package com.powernode.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Arrays;

@Configuration
public class RedisConfig implements CachingConfigurer {  // 修改继承关系

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);

        // 创建并配置 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        // 设置可见性
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 启用默认类型作为属性
        objectMapper.activateDefaultTyping(
                LaissezFaireSubTypeValidator.instance,
                ObjectMapper.DefaultTyping.NON_FINAL,
                JsonTypeInfo.As.PROPERTY
        );
        // 处理日期格式
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.registerModule(new JavaTimeModule());

        RedisSerializer<String> stringSerializer = new StringRedisSerializer();//序列化为String
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();

        // 设置key和value的序列化规则
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(serializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(serializer);

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean("myKeyGenerator")
    @Override  // 保持注解位置
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            Cacheable annotation = method.getAnnotation(Cacheable.class);
            if (annotation != null) {
                String[] cacheNames = annotation.cacheNames();
                sb.append(String.join(".", cacheNames));
            }
            return sb.append("::")
                    .append(target.getClass().getSimpleName())
                    .append("::")
                    .append(method.getName())
                    .append("::")
                    .append(Arrays.toString(params))
                    .toString();
        };
    }
}
