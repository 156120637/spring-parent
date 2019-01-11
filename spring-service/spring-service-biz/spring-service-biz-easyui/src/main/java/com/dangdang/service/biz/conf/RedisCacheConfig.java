package com.dangdang.service.biz.conf;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.DigestUtils;

import java.net.UnknownHostException;

@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

    /**
     * 项目中只在goods中加了缓存 , @CacheAble @CachePut @CacheEvit
     */
    /**
     * 键的生成策略
     * @return
     */
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator(){
            @Override
            public Object generate(Object target, java.lang.reflect.Method method, Object... params) {
                StringBuffer sb = new StringBuffer();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for(Object obj:params){
                    sb.append(obj.toString());
                }// 使用md5之后的结果作为key值
                return DigestUtils.md5DigestAsHex(sb.toString().getBytes());
            }
        };
    }

    /**
     * 自定义序列化对象模板
     * @param redisConnectionFactory
     * @return
     * @throws UnknownHostException
     */
    /*@Bean
    public RedisTemplate<Object, Object> redisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Goods.class);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        return template;
    }*/



}
