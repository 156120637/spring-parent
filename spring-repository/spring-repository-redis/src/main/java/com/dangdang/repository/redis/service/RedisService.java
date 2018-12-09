package com.dangdang.repository.redis.service;

import com.dangdang.repository.redis.constants.RedisDbEnum;
import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.SortingParams;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * redis工具类
 */
public interface RedisService {
    
    /**
     * 清空所有key
     */
    String flushAll(RedisDbEnum db);
    
    /**
     * 更改key
     *
     * @param db
     * @param oldkey
     * @param newkey
     * @return 返回值是状态吗
     */
    String rename(RedisDbEnum db, String oldkey, String newkey);
    
    /**
     * 更改key，仅当新key不存在时才执行
     *
     * @param db
     * @param oldkey
     * @param newkey
     * @return
     */
    long renamenx(RedisDbEnum db, String oldkey, String newkey);
    
    String rename(RedisDbEnum db, byte[] oldkey, byte[] newkey);
    
    /**
     * 设置key的过期时间，以秒为单位
     *
     * @param db
     * @param key
     * @param seconds
     * @return 影响的记录数
     */
    long expired(RedisDbEnum db, String key, int seconds);
    
    /**
     * 设置key的过期时间，它是距历元（即格林威治标准时间 1970年1月1日的00:00:00,格里高利历)的偏移量
     */
    long expireAt(RedisDbEnum db, String key, long timestamp);
    
    /**
     * 查询key的过期时间，以秒为单位的时间表示返回的是指定key的剩余的生存时间
     */
    long ttl(RedisDbEnum db, String key);
    
    /**
     * 取消对key过期时间的设置. 将带生存时间的key转换成一个永不过期的key
     * <p>
     * 当移除成功时返回1，key不存在或者移除不成功时返回0
     */
    long persist(RedisDbEnum db, String key);
    
    /**
     * 删除keys对应的记录，可以是多个key
     * <p>
     * 返回值是被删除的数量
     */
    long del(RedisDbEnum db, String... keys);
    
    long del(RedisDbEnum db, byte[]... keys);
    
    /**
     * 判断key是否存在
     */
    boolean exists(RedisDbEnum db, String key);
    
    /**
     * 对List，set，SortSet 进行排序，如果集合数据较大应避免使用这个方法
     * <p>
     * 返回排序后的结果，默认升序
     */
    List<String> sort(RedisDbEnum db, String key);
    
    /**
     * 对List，set，SortSet 进行排序，如果集合数据较大应避免使用这个方法
     * <p>
     * 返回排序后的结果，默认升序 sort key Desc为降序
     */
    List<String> sort(RedisDbEnum db, String key, SortingParams params);
    
    /**
     * 返回指定key的存储类型
     */
    String type(RedisDbEnum db, String key);
    
    /**
     * 查找所有匹配模式的键
     * <p>
     * key的查询表达式 *代表任意多个 ？代表一个
     */
    Set<String> Keys(RedisDbEnum db, String pattern);
    
    /**************************set部分*******************************/
    /**
     * 向set添加一条记录，如果member已经存在则返回0，否则返回1
     */
    long sadd(RedisDbEnum db, String key, String... member);
    
    long sadd(RedisDbEnum db, byte[] key, byte[]... member);
    
    /**
     * 获取给定key中元素个数
     *
     * @return 元素个数
     */
    long scard(RedisDbEnum db, String key);
    
    /**
     * 返回从第一组和所有的给定集合之间的有差异的成员
     *
     * @return 有差异成员的集合
     */
    Set<String> sdiff(RedisDbEnum db, String... keys);
    
    /**
     * 这个命令的作用和 SDIFF 类似，但它将结果保存到 destination 集合，而不是简单地返回结果集,如果目标已存在，则覆盖
     *
     * @return 新集合的记录数
     */
    long sdiffstore(RedisDbEnum db, String newKey, String... keys);
    
    /**
     * 返回给定集合交集成员，如果其中一个集合为不存在或为空，则返回空set
     *
     * @return 交集成员的集合
     */
    Set<String> sinter(RedisDbEnum db, String... keys);
    
    /**
     * 这个命令类似于 SINTER 命令，但它将结果保存到 destination 集合，而不是简单地返回结果集.
     * 如果 destination 集合已经存在，则将其覆盖. destination 可以是 key 本身
     *
     * @return 新集合的记录数
     */
    long sinterstore(RedisDbEnum db, String dstkey, String... keys);
    
    /**
     * 确定一个给定的值是否存在
     *
     * @param member 要判断的值
     * @return 存在返回1，不存在返回0
     */
    boolean sismember(RedisDbEnum db, String key, String member);
    
    /**
     * 返回集合中的所有成员
     *
     * @return 成员集合
     */
    
    Set<String> smembers(RedisDbEnum db, String key);
    
    Set<byte[]> smembers(RedisDbEnum db, byte[] key);

    /**
     * 从集合中随机取一个数，并且集合中不删除
     *
     * @param db
     * @param key
     * @return
     */
    String srandmember(RedisDbEnum db, String key);

    /**
     * 从集合中随机取指定数量的数据，并且集合中不删除
     *
     * @param db
     * @param key
     * @param count
     * @return
     */
    List<String> srandmember(RedisDbEnum db, String key, int count);

    /**
     * 将成员从源集合移除放入目标集合
     * 如果源集合不存在或不包含指定成员，不进行任何操作，返回0
     * 否则该成员从源集合上删除，并添加到目标集合，如果目标集合成员以存在，则只在源集合进行删除
     *
     * @param srckey 源集合  dstkey目标集合   member源集合中的成员
     * @return 状态码 1成功 0失败
     */
    long smove(RedisDbEnum db, String srckey, String dstkey, String member);
    
    /**
     * 从集合中删除成员  移除并返回集合中的一个随机元素.
     *
     * @return 被删除的随机成员
     */
    String spop(RedisDbEnum db, String key);
    
    /**
     * 从集合中删除指定成员
     * 移除集合 key 中的一个或多个 member 元素，不存在的 member 元素会被忽略. 当 key 不是集合类型，返回一个错误.
     *
     * @param key member要删除的成员
     * @return 状态码 成功返回1，成员不存在返回0
     */
    long srem(RedisDbEnum db, String key, String... member);
    
    /**
     * 合并多个集合并将合并后的结果集保存在指定的新集合中，如果新集合已经存在则覆盖
     */
    Set<String> sunion(RedisDbEnum db, String... keys);
    
    /**
     * 这个命令类似于 SUNION 命令，但它将结果保存到 destination 集合，而不是简单地返回结果集.
     * 如果 destination 已经存在，则将其覆盖.   destination 可以是 key 本身
     */
    long sunionstore(RedisDbEnum db, String dstkey, String... keys);
    
    
    /*******************************SortSet******************************/
    
    /**
     * zadd 向集合中增加一条记录，如果这个值已经存在，这个值对应的权重将被置为新的权重
     *
     * @param score 权重 member要加入的值
     * @return 状态码 1成功 0已经存在member值
     */
    long zadd(RedisDbEnum db, String key, double score, String member);
    
    /**
     * 获取集合中元素的数量
     *
     * @param key
     * @return 当 key 存在且是有序集类型时，返回有序集的基数.  当 key 不存在时，返回 0 .
     */
    long zcard(RedisDbEnum db, String key);
    
    /**
     * zcount 获取指定权重区间内的集合数量
     *
     * @param min 最小排序位置
     * @param max 最大排序位置
     */
    long zcount(RedisDbEnum db, String key, double min, double max);
    
    /**
     * zrange 返回有序集合key中，指定区间的成员0，-1指的是整个区间的成员
     */
    Set<String> zrange(RedisDbEnum db, String key, int start, int end);
    
    
    /**
     * zrevrange  返回有序集 key 中，指定区间内的成员. 其中成员的位置按 score 值递减(从大到小)来排列
     */
    Set<String> zrevrange(RedisDbEnum db, String key, int start, int end);
    
    /**
     * zrangeByScore  根据上下权重查询集合
     */
    Set<String> zrangeByScore(RedisDbEnum db, String key, double min, double max);
    
    /**
     * 接上面方法，获取有序集合长度
     */
    long zlength(RedisDbEnum db, String key);
    
    /**
     * zincrby  为有序集 key 的成员 member 的 score 值加上增量 increment
     *
     * @return member 成员的新 score 值，以字符串形式表示
     */
    
    double zincrby(RedisDbEnum db, String key, double score, String member);
    
    /**
     * zrank 返回有序集 key 中成员 member 的排名. 其中有序集成员按 score 值递增(从小到大)顺序排列
     */
    
    long zrank(RedisDbEnum db, String key, String member);
    
    /**
     * zrevrank   返回有序集 key 中成员 member 的排名. 其中有序集成员按 score 值递减(从大到小)排序.
     */
    long zrevrank(RedisDbEnum db, String key, String member);
    
    /**
     * zrem 移除有序集 key 中的一个或多个成员，不存在的成员将被忽略.
     * 当 key 存在但不是有序集类型时，返回一个错误. 在 Redis 2.4 版本以前， ZREM 每次只能删除一个元素.
     *
     * @return 被成功移除的成员的数量，不包括被忽略的成员
     */
    long zrem(RedisDbEnum db, String key, String... member);
    
    /**
     * zremrangebyrank 移除有序集 key 中，指定排名(rank)区间内的所有成员.
     *
     * @return 被移除成员的数量
     */
    long zremrangeByRank(RedisDbEnum db, String key, int start, int end);
    
    
    /**
     * zremrangeByScore  删除指定权重区间的元素
     */
    long zremrangeByScore(RedisDbEnum db, String key, double min, double max);
    
    
    /**
     * 获取给定值在集合中的权重
     */
    double zscore(RedisDbEnum db, String key, String member);
    
    
    /********************************hash***********************************/
    /***
     * 从hash中删除指定的存储
     *
     * @param  key
     * @param  field 存储的名字
     * @return 状态码，1成功，0失败
     */
    long hdel(RedisDbEnum db, String key, String... field);
    
    long hdel(RedisDbEnum db, String key);
    
    /***
     * 测试hash中指定的存储是否存在
     *
     * @param  key
     * @param  field 存储的名字
     * @return 1存在，0不存在
     */
    boolean hexists(RedisDbEnum db, String key, String field);
    
    /***
     * 返回hash中指定存储位置的值
     *
     * @param  key
     * @param  field 存储的名字
     * @return 存储对应的值
     */
    String hget(RedisDbEnum db, String key, String field);
    
    byte[] hget(RedisDbEnum db, byte[] key, byte[] field);
    
    /***
     * 以Map的形式返回hash中的存储和值
     *
     * @param  key
     * @return Map<String ,   String>
     */
    Map<String, String> hgetAll(RedisDbEnum db, String key);
    
    /***
     * 添加一个对应关系
     *
     * @param  key
     * @param  field
     * @param  value
     * @return 状态码 1成功，0失败，field已存在将更新，也返回0
     **/
    long hset(RedisDbEnum db, String key, String field, String value);
    
    long hset(RedisDbEnum db, String key, String field, byte[] value);
    
    /***
     * 添加对应关系，只有在field不存在时才执行
     *
     * @param   key
     * @param field
     * @param value
     * @return 状态码 1成功，0失败field已存
     * **/
    long hsetnx(RedisDbEnum db, String key, String field, String value);
    
    /***
     * 获取hash中value的集合
     *
     * @param key
     * @return List<String>
     */
    List<String> hvals(RedisDbEnum db, String key);
    
    /***
     * 在指定的存储位置加上指定的数字，存储位置的值必须可转为数字类型
     *
     * @param  key
     * @param  field 存储位置
     * @param  value 要增加的值,可以是负数
     * @return 增加指定数字后，存储位置的值
     */
    long hincrby(RedisDbEnum db, String key, String field, long value);
    
    /***
     * 返回指定hash中的所有存储名字,类似Map中的keySet方法
     *
     * @param  key
     * @return Set<String> 存储名称的集合
     */
    Set<String> hkeys(RedisDbEnum db, String key);
    
    /***
     * 获取hash中存储的个数，类似Map中size方法
     *
     * @param  key
     * @return long 存储的个数
     */
    long hlen(RedisDbEnum db, String key);
    
    /***
     * 根据多个key，获取对应的value，返回List,如果指定的key不存在,List对应位置为null
     *
     * @param  key
     * @param   fields 存储位置
     * @return List<String>
     */
    List<String> hmget(RedisDbEnum db, String key, String... fields);
    
    List<byte[]> hmget(RedisDbEnum db, byte[] key, byte[]... fields);
    
    /***
     * 添加对应关系，如果对应关系已存在，则覆盖
     *
     * @param  key
     * @param    map 对应关系
     * @return 状态，成功返回OK
     */
    String hmset(RedisDbEnum db, String key, Map<String, String> map);
    
    String hmset(RedisDbEnum db, byte[] key, Map<byte[], byte[]> map);
    
    // *******************************************Strings*******************************************//
    
    /***
     * 根据key获取记录
     *
     * @param key
     * @return 值
     * */
    String get(RedisDbEnum db, String key);
    
    byte[] get(RedisDbEnum db, byte[] key);
    
    /***
     * 添加有过期时间的记录
     *
     * @param  key
     * @param     seconds 过期时间，以秒为单位
     * @param  value
     * @return String 操作状态
     */
    String setEx(RedisDbEnum db, String key, int seconds, String value);
    
    String setEx(RedisDbEnum db, byte[] key, int seconds, byte[] value);
    
    /***
     * 添加一条记录，仅当给定的key不存在时才插入
     *
     * @param key
     * @param value
     * @return long 状态码，1插入成功且key不存在，0未插入，key存在
     * */
    long setnx(RedisDbEnum db, String key, String value);
    
    /***
     * 添加记录,如果记录已存在将覆盖原有的value
     *
     * @param  key
     * @param  value
     * @return 状态码
     */
    String set(RedisDbEnum db, String key, String value);
    
    String set(RedisDbEnum db, String key, byte[] value);
    
    String set(RedisDbEnum db, byte[] key, byte[] value);
    
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
    long setRange(RedisDbEnum db, String key, long offset, String value);
    
    /***
     * 在指定的key中追加value
     *
     * @param  key
     * @param  value
     * @return long 追加后value的长度
     **/
    long append(RedisDbEnum db, String key, String value);
    
    /***
     * 将key对应的value减去指定的值，只有value可以转为数字时该方法才可用
     *
     * @param  key
     * @param    number 要减去的值
     * @return long 减指定值后的值
     */
    long decrBy(RedisDbEnum db, String key, long number);
    
    /***
     * <b>可以作为获取唯一id的方法</b><br/>
     * 将key对应的value加上指定的值，只有value可以转为数字时该方法才可用
     *
     * @param  key
     * @param    number 要减去的值
     * @return long 相加后的值
     */
    long incrBy(RedisDbEnum db, String key, long number);
    
    /***
     * 对指定key对应的value进行截取
     *
     * @param  key
     * @param    startOffset 开始位置(包含)
     * @param    endOffset 结束位置(包含)
     * @return String 截取的值
     */
    String getrange(RedisDbEnum db, String key, long startOffset, long endOffset);
    
    /***
     * 获取并设置指定key对应的value<br/>
     * 如果key存在返回之前的value,否则返回null
     *
     * @param  key
     * @param  value
     * @return String 原始value或null
     */
    String getSet(RedisDbEnum db, String key, String value);
    
    /***
     * 批量获取记录,如果指定的key不存在返回List的对应位置将是null
     *
     * @param  keys
     * @return List<String> 值得集合
     */
    List<String> mget(RedisDbEnum db, String... keys);
    
    /***
     * 批量存储记录
     *
     * @param  keysvalues 例:keysvalues="key1","value1","key2","value2";
     * @return String 状态码
     */
    String mset(RedisDbEnum db, String... keysvalues);
    
    /***
     * 获取key对应的值的长度
     *
     * @param  key
     * @return value值得长度
     */
    long strlen(RedisDbEnum db, String key);
    
    // *******************************************Lists*******************************************//
    
    /***
     * List长度
     *
     * @param  key
     * @return 长度
     */
    long llen(RedisDbEnum db, String key);
    
    /***
     * List长度
     *
     * @param  key
     * @return 长度
     */
    long llen(RedisDbEnum db, byte[] key);
    
    /***
     * 覆盖操作,将覆盖List中指定位置的值
     *
     * @param  key
     * @param  index 位置
     * @param  value 值
     * @return 状态码
     */
    String lset(RedisDbEnum db, byte[] key, int index, byte[] value);
    
    /***
     * 覆盖操作,将覆盖List中指定位置的值
     *
     * @param   key
     * @param   index 位置
     * @param   value 值
     * @return 状态码
     */
    String lset(RedisDbEnum db, String key, int index, String value);
    
    /***
     * 在value的相对位置插入记录
     *
     * @param   key
     * @param   where 前面插入或后面插入
     * @param   pivot 相对位置的内容
     * @param   value 插入的内容
     * @return 记录总数
     */
    long linsert(RedisDbEnum db, String key, BinaryClient.LIST_POSITION where, String pivot, String value);
    
    /***
     * 在指定位置插入记录
     *
     * @param   key
     * @param   where 前面插入或后面插入
     * @param   pivot 相对位置的内容
     * @param   value 插入的内容
     * @return 记录总数
     */
    long linsert(RedisDbEnum db, byte[] key, BinaryClient.LIST_POSITION where, byte[] pivot, byte[] value);
    
    /***
     * 获取List中指定位置的值
     *
     * @param   key
     * @param   index 位置
     * @return 值
     **/
    String lindex(RedisDbEnum db, String key, int index);
    
    /***
     * 获取List中指定位置的值
     *
     * @param   key
     * @param   index 位置
     * @return 值
     **/
    byte[] lindex(RedisDbEnum db, byte[] key, int index);
    
    /***
     * 将List中的第一条记录移出List
     *
     * @param  key
     * @return 移出的记录
     */
    String lpop(RedisDbEnum db, String key);
    
    /***
     * 将List中的第一条记录移出List
     *
     * @param  key
     * @return 移出的记录
     */
    byte[] lpop(RedisDbEnum db, byte[] key);
    
    /***
     * 将List中最后第一条记录移出List
     *
     * @param  key
     * @return 移出的记录
     */
    String rpop(RedisDbEnum db, String key);
    
    /***
     * 向List尾部追加记录
     *
     * @param  key
     * @param  value
     * @return 记录总数
     */
    long rpush(RedisDbEnum db, String key, String... value);
    
    /***
     * 向List尾部追加记录
     *
     * @param  key
     * @param  value
     * @return 记录总数
     */
    long rpush(RedisDbEnum db, byte[] key, byte[]... value);
    
    /***
     * 向List头部追加记录
     *
     * @param  key
     * @param  value
     * @return 记录总数
     */
    long lpush(RedisDbEnum db, String key, String... value);
    
    /***
     * 向List头部追加记录
     *
     * @param  key
     * @param  value
     * @return 记录总数
     */
    long lpush(RedisDbEnum db, byte[] key, byte[]... value);
    
    /***
     * 获取指定范围的记录，可以做为分页使用，从头部开始取
     *
     * @param   key
     * @param   start
     * @param   end
     * @return List
     */
    List<String> lrange(RedisDbEnum db, String key, long start, long end);
    
    /***
     * 获取指定范围的记录，可以做为分页使用
     *
     * @param   key
     * @param   start
     * @param   end 如果为负数，则尾部开始计算
     * @return List
     */
    List<byte[]> lrange(RedisDbEnum db, byte[] key, int start, int end);
    
    /***
     * 删除List中c条记录，被删除的记录值为value
     *
     * @param  key
     * @param  c 要删除的数量，如果为负数则从List的尾部检查并删除符合的记录
     * @param  value 要匹配的值
     * @return 删除后的List中的记录数
     * */
    long lrem(RedisDbEnum db, byte[] key, int c, byte[] value);
    
    /***
     * 删除List中c条记录，被删除的记录值为value
     *
     * @param  key
     * @param  c 要删除的数量，如果为负数则从List的尾部检查并删除符合的记录
     * @param  value 要匹配的值
     * @return 删除后的List中的记录数
     * */
    long lrem(RedisDbEnum db, String key, int c, String value);
    
    /***
     * 算是删除吧，只保留start与end之间的记录
     *
     * @param  key
     * @param  start 记录的开始位置(0表示第一条记录)
     * @param  end 记录的结束位置（如果为-1则表示最后一个，-2，-3以此类推）
     * @return 执行状态码
     * */
    String ltrim(RedisDbEnum db, byte[] key, int start, int end);
    
    /***
     * 算是删除吧，只保留start与end之间的记录
     *
     * @param   key
     * @param   start 记录的开始位置(0表示第一条记录)
     * @param   end 记录的结束位置（如果为-1则表示最后一个，-2，-3以此类推）
     * @return 执行状态码
     */
    String ltrim(RedisDbEnum db, String key, int start, int end);
}
