## shardingsphare
### shardingsphare 相关概念学习分析
#### 1.SQL
    - SQL在路由的时候要注意一点： 绑定表，如果不做绑定表的话在in 查询的时候是按照笛卡尔积的个数执行SQL，在线上时一定要做绑定表
#### 2.分片
    - 是数据库水平拆分的关键字段，现有的shardingsphare支持单个分片和多个分片，当查询的条件中没有分片键的时候，则是强制路由每个库
    
    - 分片算法
        - PreciseShardingAlgorithm（精准分片）
            - 用于处理单一键作为分片片键的=和in场景（SQL中的BETWEEN AND将按照全库路由处理）
            - 配合着 StandardShardingStrategy 使用
        - RangeShardingAlgorithm（范围分片算法）
            - 用于使用单一键作为分片键的BETWEEN AND进行分片的场景
            - 配合着 StandardShardingStrategy 使用
        - ComplexKeysShardingAlgorithm（复合分片算法）   
            - 用于处理使用多键作为分片键进行分片的场景
            - 配合着 ComplexShardingStrategy 使用
        - HintShardingAlgorithm（hint分算法）
            - 用于处理使用hit进行分片
            - 配合着 HintShardingStrategy 使用
    
    - 分片策略（包含分片键和分片算法）
        - StandardShardingStrategy（标准分片策略）
            - 提供对SQL语句中的=, IN和BETWEEN AND的分片操作支持。
            - 标准分片策略只支持单分片键
            - 包含 PreciseShardingAlgorithm和RangeShardingAlgorithm两个分片算法
        - ComplexShardingStrategy（符合分片策略）
            - 提供对SQL语句中的=, IN和BETWEEN AND的分片操作支持
            - 支持多个片键
            - 需要自行实现
        - InlineShardingStrategy（行表达式分片策略）       
            - 使用Groovy的表达式，提供对SQL语句中的=和IN的分片操作支持
            - 只支持单分片键
            - 类似于 t_user_$->{u_id % 8} 这样的写法
        - HintShardingStrategy（Hint分片策略）
            - 通过命中的方式，而不是通过SQL解析实现。
            - 对于分片字段非SQL决定，而由其他外置条件决定的场景
            - SQL Hint支持通过Java API和SQL注释(待实现)两种方式使用。
            - 局限 只分库不分表的前提下
        - NoneShardingStrategy（不分片的策略）    
            - 不分片的策略。 
            
    - 分片策略的配置
        - 包含两个部分： 数据源分片策略和表分片策略（两种策略的API完全相同）
        - 数据源分片策略
            - DatabaseShardingStrategy（用于配置数据被分配的目标数据源）
        - 表分片策略
            - TableShardingStrategy（用于配置数据被分配的目标表） 
            - 依赖于数据源分片策略的结果
#### 路由规则
    - 分片路由
        - 用于根据分片键进行路由的场景，又细分为直接路由、标准路由和笛卡尔积路由这3种类型。
        - 直接路由（直接就知道该路由到哪个库表中 Hint）     
        - 标准路由（根据分批键查询为 = 时，如果为in和between时则不知路由到哪个上）
    - 广播路由
        - 对于不携带分片键的SQL，则采取广播路由的方式。根据SQL类型又可以划分为全库表路由、全库路由、全实例路由、单播路由和阻断路由这5种类型。
        - 全库表路由
            - 全库表路由（最常使用）： 用于处理对数据库中与其逻辑表相关的所有真实表的操作，主要包括不带分片键的DQL和DML，以及DDL等。（不是分批键的查询方式）
            - 全库路由： 全库路由用于处理对数据库的操作（没使用过）
            - 全实例路由： （全实例路由用于DCL操作，授权语句针对的是数据库的实例。无论一个实例中包含多少个Schema，每个数据库的实例只执行一次。）
            - 单播路由
            - 阻断路由
        
#### Groovy 表达式的使用
    - ${begin..end}表示范围区间
    - ${[unit1, unit2, unit_x]}表示枚举值
    - ${ expression } 表示取值
    - 写法
        - db${0..1}.t_order${0..1}
#### 分布式主键
    - 使用UUID方式（UUID.randomUUID()）
    - 使用雪花算法（SNOWFLAKE）
    
#### 读写分离
    - 负载均衡策略
        - 通过负载均衡策略将查询请求疏导至不同从库。
          
#### apm扩展
    - 建议使用skywalking，个人用习惯这个apm，与shadingsphare有协作版本
        - https://github.com/apache/skywalking/blob/5.x/docs/cn/Quick-start-CN.md
#### 注册中心
    - 公司内部使用的config-toolkit
    - shardingsphare 使用的是 http://curator.apache.org/ 没有见过，之后再了解。

#### 数据脱敏
    - 两种加解密接口 即ShardingEncryptor和ShardingQueryAssistedEncryptor。            
    
### shardingsphare生产使用
        