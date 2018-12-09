package com.dangdang.repository.redis.service.impl;

import com.dangdang.repository.redis.constants.RedisDbEnum;
import com.dangdang.repository.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.SortingParams;
import redis.clients.util.SafeEncoder;

import java.util.List;
import java.util.Map;
import java.util.Set;

/***
 * redis工具类
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private JedisSentinelPool jedisSentinelPool;

    /**
     * 清空所有key
     */
    @Override
    public String flushAll(RedisDbEnum db) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        String result = resource.flushAll();
        resource.close();
        return result;
    }
    
    /**
     * 更改key
     *
     * @param db
     * @param oldkey
     * @param newkey
     * @return 返回值是状态吗
     */
    @Override
    public String rename(RedisDbEnum db, String oldkey, String newkey) {
        return rename(db, SafeEncoder.encode(oldkey), SafeEncoder.encode(newkey));
    }
    
    /**
     * 更改key，仅当新key不存在时才执行
     *
     * @param db
     * @param oldkey
     * @param newkey
     * @return
     */
    @Override
    public long renamenx(RedisDbEnum db, String oldkey, String newkey) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.renamenx(oldkey, newkey);
        resource.close();
        return result;
        
    }
    
    @Override
    public String rename(RedisDbEnum db, byte[] oldkey, byte[] newkey) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        String result = resource.rename(oldkey, newkey);
        resource.close();
        return result;
    }
    
    /**
     * 设置key的过期时间，以秒为单位
     *
     * @param db
     * @param key
     * @param seconds
     * @return 影响的记录数
     */
    @Override
    public long expired(RedisDbEnum db, String key, int seconds) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.expire(key, seconds);
        resource.close();
        return result;
    }
    
    /**
     * 设置key的过期时间，它是距历元（即格林威治标准时间 1970年1月1日的00:00:00,格里高利历)的偏移量
     */
    @Override
    public long expireAt(RedisDbEnum db, String key, long timestamp) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.expireAt(key, timestamp);
        resource.close();
        return result;
    }
    
    /**
     * 查询key的过期时间，以秒为单位的时间表示返回的是指定key的剩余的生存时间
     */
    @Override
    public long ttl(RedisDbEnum db, String key) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.ttl(key);
        resource.close();
        return result;
        
    }
    
    /**
     * 取消对key过期时间的设置. 将带生存时间的key转换成一个永不过期的key
     * <p>
     * 当移除成功时返回1，key不存在或者移除不成功时返回0
     */
    @Override
    public long persist(RedisDbEnum db, String key) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.persist(key);
        resource.close();
        return result;
    }
    
    /**
     * 删除keys对应的记录，可以是多个key
     * <p>
     * 返回值是被删除的数量
     */
    @Override
    public long del(RedisDbEnum db, String... keys) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.del(keys);
        resource.close();
        return result;
    }
    
    @Override
    public long del(RedisDbEnum db, byte[]... keys) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.del(keys);
        resource.close();
        return result;
    }
    
    /**
     * 判断key是否存在
     */
    @Override
    public boolean exists(RedisDbEnum db, String key) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        boolean result = resource.exists(key);
        resource.close();
        return result;
    }
    
    /**
     * 对List，set，SortSet 进行排序，如果集合数据较大应避免使用这个方法
     * <p>
     * 返回排序后的结果，默认升序
     */
    @Override
    public List<String> sort(RedisDbEnum db, String key) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        List<String> result = resource.sort(key);
        resource.close();
        return result;
    }
    
    /**
     * 对List，set，SortSet 进行排序，如果集合数据较大应避免使用这个方法
     * <p>
     * 返回排序后的结果，默认升序 sort key Desc为降序
     */
    @Override
    public List<String> sort(RedisDbEnum db, String key, SortingParams params) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        List<String> result = resource.sort(key, params);
        resource.close();
        return result;
    }
    
    /**
     * 返回指定key的存储类型
     */
    @Override
    public String type(RedisDbEnum db, String key) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        String result = resource.type(key);
        resource.close();
        return result;
    }
    
    /**
     * 查找所有匹配模式的键
     * <p>
     * key的查询表达式 *代表任意多个 ？代表一个
     */
    @Override
    public Set<String> Keys(RedisDbEnum db, String pattern) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        Set<String> result = resource.keys(pattern);
        resource.close();
        return result;
    }
    
    /**************************set部分*******************************/
    /**
     * 向set添加一条记录，如果member已经存在则返回0，否则返回1
     */
    @Override
    public long sadd(RedisDbEnum db, String key, String... member) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        Long result = resource.sadd(key, member);
        resource.close();
        return result;
    }
    
    @Override
    public long sadd(RedisDbEnum db, byte[] key, byte[]... member) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        Long result = resource.sadd(key, member);
        resource.close();
        return result;
    }
    
    /**
     * 获取给定key中元素个数
     *
     * @return 元素个数
     */
    @Override
    public long scard(RedisDbEnum db, String key) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        Long result = resource.scard(key);
        resource.close();
        return result;
    }
    
    /**
     * 返回从第一组和所有的给定集合之间的有差异的成员
     *
     * @return 有差异成员的集合
     */
    @Override
    public Set<String> sdiff(RedisDbEnum db, String... keys) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        Set<String> result = resource.sdiff(keys);
        resource.close();
        return result;
    }
    
    /**
     * 这个命令的作用和 SDIFF 类似，但它将结果保存到 destination 集合，而不是简单地返回结果集,如果目标已存在，则覆盖
     *
     * @return 新集合的记录数
     */
    @Override
    public long sdiffstore(RedisDbEnum db, String newKey, String... keys) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        Long result = resource.sdiffstore(newKey, keys);
        resource.close();
        return result;
    }
    
    /**
     * 返回给定集合交集成员，如果其中一个集合为不存在或为空，则返回空set
     *
     * @return 交集成员的集合
     */
    @Override
    public Set<String> sinter(RedisDbEnum db, String... keys) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        Set<String> result = resource.sinter(keys);
        resource.close();
        return result;
    }
    
    /**
     * 这个命令类似于 SINTER 命令，但它将结果保存到 destination 集合，而不是简单地返回结果集.
     * 如果 destination 集合已经存在，则将其覆盖. destination 可以是 key 本身
     *
     * @return 新集合的记录数
     */
    @Override
    public long sinterstore(RedisDbEnum db, String dstkey, String... keys) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.sinterstore(dstkey, keys);
        resource.close();
        return result;
    }
    
    /**
     * 确定一个给定的值是否存在
     *
     * @param member 要判断的值
     * @return 存在返回1，不存在返回0
     */
    @Override
    public boolean sismember(RedisDbEnum db, String key, String member) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        Boolean result = resource.sismember(key, member);
        resource.close();
        return result;
    }
    
    /**
     * 返回集合中的所有成员
     *
     * @return 成员集合
     */
    
    @Override
    public Set<String> smembers(RedisDbEnum db, String key) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        Set<String> result = resource.smembers(key);
        resource.close();
        return result;
    }
    
    @Override
    public Set<byte[]> smembers(RedisDbEnum db, byte[] key) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        Set<byte[]> result = resource.smembers(key);
        resource.close();
        return result;
    }

    @Override
    public String srandmember(RedisDbEnum db, String key) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        String result = resource.srandmember(key);
        resource.close();
        return result;
    }

    @Override
    public List<String> srandmember(RedisDbEnum db, String key, int count) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        List<String> result = resource.srandmember(key, count);
        resource.close();
        return result;
    }

    /**
     * 将成员从源集合移除放入目标集合
     * 如果源集合不存在或不包含指定成员，不进行任何操作，返回0
     * 否则该成员从源集合上删除，并添加到目标集合，如果目标集合成员以存在，则只在源集合进行删除
     *
     * @param srckey 源集合  dstkey目标集合   member源集合中的成员
     * @return 状态码 1成功 0失败
     */
    @Override
    public long smove(RedisDbEnum db, String srckey, String dstkey, String member) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        Long result = resource.smove(srckey, dstkey, member);
        resource.close();
        return result;
    }
    
    /**
     * 从集合中删除成员  移除并返回集合中的一个随机元素.
     *
     * @return 被删除的随机成员
     */
    @Override
    public String spop(RedisDbEnum db, String key) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        String result = resource.spop(key);
        resource.close();
        return result;
    }
    
    /**
     * 从集合中删除指定成员
     * 移除集合 key 中的一个或多个 member 元素，不存在的 member 元素会被忽略. 当 key 不是集合类型，返回一个错误.
     *
     * @param key member要删除的成员
     * @return 状态码 成功返回1，成员不存在返回0
     */
    @Override
    public long srem(RedisDbEnum db, String key, String... member) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        Long result = resource.srem(key, member);
        resource.close();
        return result;
    }
    
    /**
     * 合并多个集合并将合并后的结果集保存在指定的新集合中，如果新集合已经存在则覆盖
     */
    @Override
    public Set<String> sunion(RedisDbEnum db, String... keys) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        Set<String> result = resource.sunion(keys);
        resource.close();
        return result;
    }
    
    /**
     * 这个命令类似于 SUNION 命令，但它将结果保存到 destination 集合，而不是简单地返回结果集.
     * 如果 destination 已经存在，则将其覆盖.   destination 可以是 key 本身
     */
    @Override
    public long sunionstore(RedisDbEnum db, String dstkey, String... keys) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        Long result = resource.sunionstore(dstkey, keys);
        resource.close();
        return result;
    }
    
    
    /*******************************SortSet******************************/
    
    /**
     * zadd 向集合中增加一条记录，如果这个值已经存在，这个值对应的权重将被置为新的权重
     *
     * @param score 权重 member要加入的值
     * @return 状态码 1成功 0已经存在member值
     */
    @Override
    public long zadd(RedisDbEnum db, String key, double score, String member) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.zadd(key, score, member);
        resource.close();
        return result;
    }
    
    /**
     * 获取集合中元素的数量
     *
     * @param key
     * @return 当 key 存在且是有序集类型时，返回有序集的基数.  当 key 不存在时，返回 0 .
     */
    @Override
    public long zcard(RedisDbEnum db, String key) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.zcard(key);
        resource.close();
        return result;
    }
    
    /**
     * zcount 获取指定权重区间内的集合数量
     *
     * @param min 最小排序位置
     * @param max 最大排序位置
     */
    @Override
    public long zcount(RedisDbEnum db, String key, double min, double max) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.zcount(key, min, max);
        resource.close();
        return result;
    }
    
    /**
     * zrange 返回有序集合key中，指定区间的成员0，-1指的是整个区间的成员
     * start，有序集合索引起始位置（非分数）end，有序集合索引结束位置（非分数）)
     */
    @Override
    public Set<String> zrange(RedisDbEnum db, String key, int start, int end) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        Set<String> result = resource.zrange(key, start, end);
        resource.close();
        return result;
    }
    
    
    /**
     * zrevrange  返回有序集 key 中，指定区间内的成员. 其中成员的位置按 score 值递减(从大到小)来排列
     */
    @Override
    public Set<String> zrevrange(RedisDbEnum db, String key, int start, int end) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        Set<String> result = resource.zrevrange(key, start, end);
        resource.close();
        return result;
    }
    
    /**
     * zrangeByScore  根据上下权重查询集合
     */
    @Override
    public Set<String> zrangeByScore(RedisDbEnum db, String key, double min, double max) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        Set<String> result = resource.zrangeByScore(key, min, max);
        resource.close();
        return result;
    }
    
    /**
     * 接上面方法，获取有序集合长度
     */
    @Override
    public long zlength(RedisDbEnum db, String key) {
        Set<String> result = zrange(db, key, 0, -1);
        return result.size();
    }
    
    /**
     * zincrby  为有序集 key 的成员 member 的 score 值加上增量 increment
     *
     * @return member 成员的新 score 值，以字符串形式表示
     */
    
    @Override
    public double zincrby(RedisDbEnum db, String key, double score, String member) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        double result = resource.zincrby(key, score, member);
        resource.close();
        return result;
    }
    
    /**
     * zrank 返回有序集 key 中成员 member 的排名. 其中有序集成员按 score 值递增(从小到大)顺序排列
     */
    
    @Override
    public long zrank(RedisDbEnum db, String key, String member) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.zrank(key, member);
        resource.close();
        return result;
    }
    
    /**
     * zrevrank   返回有序集 key 中成员 member 的排名. 其中有序集成员按 score 值递减(从大到小)排序.
     */
    @Override
    public long zrevrank(RedisDbEnum db, String key, String member) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.zrevrank(key, member);
        resource.close();
        return result;
    }
    
    /**
     * zrem 移除有序集 key 中的一个或多个成员，不存在的成员将被忽略.
     * 当 key 存在但不是有序集类型时，返回一个错误. 在 Redis 2.4 版本以前， ZREM 每次只能删除一个元素.
     *
     * @return 被成功移除的成员的数量，不包括被忽略的成员
     */
    @Override
    public long zrem(RedisDbEnum db, String key, String... member) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.zrem(key, member);
        resource.close();
        return result;
    }
    
    /**
     * zremrangebyrank 移除有序集 key 中，指定排名(rank)区间内的所有成员.
     *
     * @return 被移除成员的数量
     */
    @Override
    public long zremrangeByRank(RedisDbEnum db, String key, int start, int end) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.zremrangeByRank(key, start, end);
        resource.close();
        return result;
    }
    
    
    /**
     * zremrangeByScore  删除指定权重区间的元素
     */
    @Override
    public long zremrangeByScore(RedisDbEnum db, String key, double min, double max) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.zremrangeByScore(key, min, max);
        resource.close();
        return result;
    }
    
    
    /**
     * 获取给定值在集合中的权重
     */
    @Override
    public double zscore(RedisDbEnum db, String key, String member) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        Double result = resource.zscore(key, member);
        resource.close();
        return result;
    }
    
    
    /********************************hash***********************************/
    /***
     * 从hash中删除指定的存储
     *
     * @param  key
     * @param  field 存储的名字
     * @return 状态码，1成功，0失败
     */
    @Override
    public long hdel(RedisDbEnum db, String key, String... field) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.hdel(key, field);
        resource.close();
        return result;
    }
    
    @Override
    public long hdel(RedisDbEnum db, String key) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.del(key);
        resource.close();
        return result;
    }
    
    /***
     * 测试hash中指定的存储是否存在
     *
     * @param  key
     * @param  field 存储的名字
     * @return 1存在，0不存在
     */
    @Override
    public boolean hexists(RedisDbEnum db, String key, String field) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        boolean result = resource.hexists(key, field);
        resource.close();
        return result;
    }
    
    /***
     * 返回hash中指定存储位置的值
     *
     * @param  key
     * @param  field 存储的名字
     * @return 存储对应的值
     */
    @Override
    public String hget(RedisDbEnum db, String key, String field) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        String result = resource.hget(key, field);
        resource.close();
        return result;
    }
    
    @Override
    public byte[] hget(RedisDbEnum db, byte[] key, byte[] field) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        byte[] result = resource.hget(key, field);
        resource.close();
        return result;
    }
    
    /***
     * 以Map的形式返回hash中的存储和值
     *
     * @param  key
     * @return Map<String               ,                               String>
     */
    @Override
    public Map<String, String> hgetAll(RedisDbEnum db, String key) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        Map<String, String> result = resource.hgetAll(key);
        resource.close();
        return result;
    }
    
    /***
     * 添加一个对应关系
     *
     * @param  key
     * @param  field
     * @param  value
     * @return 状态码 1成功，0失败，field已存在将更新，也返回0
     **/
    @Override
    public long hset(RedisDbEnum db, String key, String field, String value) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.hset(key, field, value);
        resource.close();
        return result;
    }
    
    @Override
    public long hset(RedisDbEnum db, String key, String field, byte[] value) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.hset(key.getBytes(), field.getBytes(), value);
        resource.close();
        return result;
    }
    
    /***
     * 添加对应关系，只有在field不存在时才执行
     *
     * @param   key
     * @param field
     * @param value
     * @return 状态码 1成功，0失败field已存
     * **/
    @Override
    public long hsetnx(RedisDbEnum db, String key, String field, String value) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.hsetnx(key, field, value);
        resource.close();
        return result;
    }
    
    /***
     * 获取hash中value的集合
     *
     * @param key
     * @return List<String>
     */
    @Override
    public List<String> hvals(RedisDbEnum db, String key) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        List<String> result = resource.hvals(key);
        resource.close();
        return result;
    }
    
    /***
     * 在指定的存储位置加上指定的数字，存储位置的值必须可转为数字类型
     *
     * @param  key
     * @param  field 存储位置
     * @param  value 要增加的值,可以是负数
     * @return 增加指定数字后，存储位置的值
     */
    @Override
    public long hincrby(RedisDbEnum db, String key, String field, long value) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.hincrBy(key, field, value);
        resource.close();
        return result;
    }
    
    /***
     * 返回指定hash中的所有存储名字,类似Map中的keySet方法
     *
     * @param  key
     * @return Set<String> 存储名称的集合
     */
    @Override
    public Set<String> hkeys(RedisDbEnum db, String key) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        Set<String> result = resource.hkeys(key);
        resource.close();
        return result;
    }
    
    /***
     * 获取hash中存储的个数，类似Map中size方法
     *
     * @param  key
     * @return long 存储的个数
     */
    @Override
    public long hlen(RedisDbEnum db, String key) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.hlen(key);
        resource.close();
        return result;
    }
    
    /***
     * 根据多个key，获取对应的value，返回List,如果指定的key不存在,List对应位置为null
     *
     * @param  key
     * @param   fields 存储位置
     * @return List<String>
     */
    @Override
    public List<String> hmget(RedisDbEnum db, String key, String... fields) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        List<String> result = resource.hmget(key, fields);
        resource.close();
        return result;
    }
    
    @Override
    public List<byte[]> hmget(RedisDbEnum db, byte[] key, byte[]... fields) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        List<byte[]> result = resource.hmget(key, fields);
        resource.close();
        return result;
    }
    
    /***
     * 添加对应关系，如果对应关系已存在，则覆盖
     *
     * @param  key
     * @param    map 对应关系
     * @return 状态，成功返回OK
     */
    @Override
    public String hmset(RedisDbEnum db, String key, Map<String, String> map) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        String result = resource.hmset(key, map);
        resource.close();
        return result;
    }
    
    @Override
    public String hmset(RedisDbEnum db, byte[] key, Map<byte[], byte[]> map) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        String result = resource.hmset(key, map);
        resource.close();
        return result;
    }
    
    // *******************************************Strings*******************************************//
    
    /***
     * 根据key获取记录
     *
     * @param key
     * @return 值
     * */
    @Override
    public String get(RedisDbEnum db, String key) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        String result = resource.get(key);
        resource.close();
        return result;
    }
    
    @Override
    public byte[] get(RedisDbEnum db, byte[] key) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        byte[] result = resource.get(key);
        resource.close();
        return result;
    }
    
    /***
     * 添加有过期时间的记录
     *
     * @param  key
     * @param     seconds 过期时间，以秒为单位
     * @param  value
     * @return String 操作状态
     */
    @Override
    public String setEx(RedisDbEnum db, String key, int seconds, String value) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        String result = resource.setex(key, seconds, value);
        resource.close();
        return result;
    }
    
    @Override
    public String setEx(RedisDbEnum db, byte[] key, int seconds, byte[] value) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        String result = resource.setex(key, seconds, value);
        resource.close();
        return result;
    }
    
    /***
     * 添加一条记录，仅当给定的key不存在时才插入
     *
     * @param key
     * @param value
     * @return long 状态码，1插入成功且key不存在，0未插入，key存在
     * */
    @Override
    public long setnx(RedisDbEnum db, String key, String value) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.setnx(key, value);
        resource.close();
        return result;
    }
    
    /***
     * 添加记录,如果记录已存在将覆盖原有的value
     *
     * @param  key
     * @param  value
     * @return 状态码
     */
    @Override
    public String set(RedisDbEnum db, String key, String value) {
        return set(db, SafeEncoder.encode(key), SafeEncoder.encode(value));
    }
    
    @Override
    public String set(RedisDbEnum db, String key, byte[] value) {
        return set(db, SafeEncoder.encode(key), value);
    }
    
    @Override
    public String set(RedisDbEnum db, byte[] key, byte[] value) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        String result = resource.set(key, value);
        resource.close();
        return result;
    }
    
    /***
     * 从指定位置开始插入数据，插入的数据会覆盖指定位置以后的数据<br/>
     * 例:String str1="123456789";<br/>
     * 对str1操作后setRange(key,4,0000)，str1="123400009";
     *
     * @param  key
     * @param    offset
     * @param  value
     * @return long value的长度
     */
    @Override
    public long setRange(RedisDbEnum db, String key, long offset, String value) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.setrange(key, offset, value);
        resource.close();
        return result;
    }
    
    /***
     * 在指定的key中追加value
     *
     * @param  key
     * @param  value
     * @return long 追加后value的长度
     **/
    @Override
    public long append(RedisDbEnum db, String key, String value) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.append(key, value);
        resource.close();
        return result;
    }
    
    /***
     * 将key对应的value减去指定的值，只有value可以转为数字时该方法才可用
     *
     * @param  key
     * @param    number 要减去的值
     * @return long 减指定值后的值
     */
    @Override
    public long decrBy(RedisDbEnum db, String key, long number) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.decrBy(key, number);
        resource.close();
        return result;
    }
    
    /***
     * <b>可以作为获取唯一id的方法</b><br/>
     * 将key对应的value加上指定的值，只有value可以转为数字时该方法才可用
     *
     * @param  key
     * @param    number 要减去的值
     * @return long 相加后的值
     */
    @Override
    public long incrBy(RedisDbEnum db, String key, long number) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.incrBy(key, number);
        resource.close();
        return result;
    }
    
    /***
     * 对指定key对应的value进行截取
     *
     * @param  key
     * @param    startOffset 开始位置(包含)
     * @param    endOffset 结束位置(包含)
     * @return String 截取的值
     */
    @Override
    public String getrange(RedisDbEnum db, String key, long startOffset, long endOffset) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        String result = resource.getrange(key, startOffset, endOffset);
        resource.close();
        return result;
    }
    
    /***
     * 获取并设置指定key对应的value<br/>
     * 如果key存在返回之前的value,否则返回null
     *
     * @param  key
     * @param  value
     * @return String 原始value或null
     */
    @Override
    public String getSet(RedisDbEnum db, String key, String value) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        String result = resource.getSet(key, value);
        resource.close();
        return result;
    }
    
    /***
     * 批量获取记录,如果指定的key不存在返回List的对应位置将是null
     *
     * @param  keys
     * @return List<String> 值得集合
     */
    @Override
    public List<String> mget(RedisDbEnum db, String... keys) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        List<String> result = resource.mget(keys);
        resource.close();
        return result;
    }
    
    /***
     * 批量存储记录
     *
     * @param  keysvalues 例:keysvalues="key1","value1","key2","value2";
     * @return String 状态码
     */
    @Override
    public String mset(RedisDbEnum db, String... keysvalues) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        String result = resource.mset(keysvalues);
        resource.close();
        return result;
    }
    
    /***
     * 获取key对应的值的长度
     *
     * @param  key
     * @return value值得长度
     */
    @Override
    public long strlen(RedisDbEnum db, String key) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.strlen(key);
        resource.close();
        return result;
    }
    
    // *******************************************Lists*******************************************//
    
    /***
     * List长度
     *
     * @param  key
     * @return 长度
     */
    @Override
    public long llen(RedisDbEnum db, String key) {
        return llen(db, SafeEncoder.encode(key));
    }
    
    /***
     * List长度
     *
     * @param  key
     * @return 长度
     */
    @Override
    public long llen(RedisDbEnum db, byte[] key) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.llen(key);
        resource.close();
        return result;
    }
    
    /***
     * 覆盖操作,将覆盖List中指定位置的值
     *
     * @param  key
     * @param  index 位置
     * @param  value 值
     * @return 状态码
     */
    @Override
    public String lset(RedisDbEnum db, byte[] key, int index, byte[] value) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        String result = resource.lset(key, index, value);
        resource.close();
        return result;
    }
    
    /***
     * 覆盖操作,将覆盖List中指定位置的值
     *
     * @param   key
     * @param   index 位置
     * @param   value 值
     * @return 状态码
     */
    @Override
    public String lset(RedisDbEnum db, String key, int index, String value) {
        return lset(db, SafeEncoder.encode(key), index, SafeEncoder.encode(value));
    }
    
    /***
     * 在value的相对位置插入记录
     *
     * @param   key
     * @param   where 前面插入或后面插入
     * @param   pivot 相对位置的内容
     * @param   value 插入的内容
     * @return 记录总数
     */
    @Override
    public long linsert(RedisDbEnum db, String key, BinaryClient.LIST_POSITION where, String pivot, String value) {
        return linsert(db, SafeEncoder.encode(key), where, SafeEncoder.encode(pivot), SafeEncoder.encode(value));
    }
    
    /***
     * 在指定位置插入记录
     *
     * @param   key
     * @param   where 前面插入或后面插入
     * @param   pivot 相对位置的内容
     * @param   value 插入的内容
     * @return 记录总数
     */
    @Override
    public long linsert(RedisDbEnum db, byte[] key, BinaryClient.LIST_POSITION where, byte[] pivot, byte[] value) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.linsert(key, where, pivot, value);
        resource.close();
        return result;
    }
    
    /***
     * 获取List中指定位置的值
     *
     * @param   key
     * @param   index 位置
     * @return 值
     **/
    @Override
    public String lindex(RedisDbEnum db, String key, int index) {
        return SafeEncoder.encode(lindex(db, SafeEncoder.encode(key), index));
    }
    
    /***
     * 获取List中指定位置的值
     *
     * @param   key
     * @param   index 位置
     * @return 值
     **/
    @Override
    public byte[] lindex(RedisDbEnum db, byte[] key, int index) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        byte[] result = resource.lindex(key, index);
        resource.close();
        return result;
    }
    
    /***
     * 将List中的第一条记录移出List
     *
     * @param  key
     * @return 移出的记录
     */
    @Override
    public String lpop(RedisDbEnum db, String key) {
        return SafeEncoder.encode(lpop(db, SafeEncoder.encode(key)));
    }
    
    /***
     * 将List中的第一条记录移出List
     *
     * @param  key
     * @return 移出的记录
     */
    @Override
    public byte[] lpop(RedisDbEnum db, byte[] key) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        byte[] result = resource.lpop(key);
        resource.close();
        return result;
    }
    
    /***
     * 将List中最后第一条记录移出List
     *
     * @param  key
     * @return 移出的记录
     */
    @Override
    public String rpop(RedisDbEnum db, String key) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        String result = resource.rpop(key);
        resource.close();
        return result;
    }
    
    /***
     * 向List尾部追加记录
     *
     * @param  key
     * @param  value
     * @return 记录总数
     */
    @Override
    public long rpush(RedisDbEnum db, String key, String... value) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.rpush(key, value);
        resource.close();
        return result;
    }
    
    /***
     * 向List尾部追加记录
     *
     * @param  key
     * @param  value
     * @return 记录总数
     */
    @Override
    public long rpush(RedisDbEnum db, byte[] key, byte[]... value) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.rpush(key, value);
        resource.close();
        return result;
    }
    
    /***
     * 向List头部追加记录
     *
     * @param  key
     * @param  value
     * @return 记录总数
     */
    @Override
    public long lpush(RedisDbEnum db, String key, String... value) {
        byte[][] values = new byte[value.length][];
        for (int i = 0; i < value.length; i++) {
            values[i] = SafeEncoder.encode(value[i]);
        }
        return lpush(db, SafeEncoder.encode(key), values);
    }
    
    /***
     * 向List头部追加记录
     *
     * @param  key
     * @param  value
     * @return 记录总数
     */
    @Override
    public long lpush(RedisDbEnum db, byte[] key, byte[]... value) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.lpush(key, value);
        resource.close();
        return result;
    }
    
    /***
     * 获取指定范围的记录，可以做为分页使用，从头部开始取
     *
     * @param   key
     * @param   start
     * @param   end
     * @return List
     */
    @Override
    public List<String> lrange(RedisDbEnum db, String key, long start, long end) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        List<String> result = resource.lrange(key, start, end);
        resource.close();
        return result;
    }
    
    /***
     * 获取指定范围的记录，可以做为分页使用
     *
     * @param   key
     * @param   start
     * @param   end 如果为负数，则尾部开始计算
     * @return List
     */
    @Override
    public List<byte[]> lrange(RedisDbEnum db, byte[] key, int start, int end) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        List<byte[]> result = resource.lrange(key, start, end);
        resource.close();
        return result;
    }
    
    /***
     * 删除List中c条记录，被删除的记录值为value
     *
     * @param  key
     * @param  c 要删除的数量，如果为负数则从List的尾部检查并删除符合的记录
     * @param  value 要匹配的值
     * @return 删除后的List中的记录数
     * */
    @Override
    public long lrem(RedisDbEnum db, byte[] key, int c, byte[] value) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        long result = resource.lrem(key, c, value);
        resource.close();
        return result;
    }
    
    /***
     * 删除List中c条记录，被删除的记录值为value
     *
     * @param  key
     * @param  c 要删除的数量，如果为负数则从List的尾部检查并删除符合的记录
     * @param             value 要匹配的值
     * @return 删除后的List中的记录数
     * */
    @Override
    public long lrem(RedisDbEnum db, String key, int c, String value) {
        return lrem(db, SafeEncoder.encode(key), c, SafeEncoder.encode(value));
    }
    
    /***
     * 算是删除吧，只保留start与end之间的记录
     *
     * @param  key
     * @param  start 记录的开始位置(0表示第一条记录)
     * @param  end 记录的结束位置（如果为-1则表示最后一个，-2，-3以此类推）
     * @return 执行状态码
     * */
    @Override
    public String ltrim(RedisDbEnum db, byte[] key, int start, int end) {
        Jedis resource = jedisSentinelPool.getResource();
        resource.select(db.getCode());
        String result = resource.ltrim(key, start, end);
        resource.close();
        return result;
    }
    
    /***
     * 算是删除吧，只保留start与end之间的记录
     *
     * @param   key
     * @param   start 记录的开始位置(0表示第一条记录)
     * @param   end 记录的结束位置（如果为-1则表示最后一个，-2，-3以此类推）
     * @return 执行状态码
     */
    @Override
    public String ltrim(RedisDbEnum db, String key, int start, int end) {
        return ltrim(db, SafeEncoder.encode(key), start, end);
    }
}
