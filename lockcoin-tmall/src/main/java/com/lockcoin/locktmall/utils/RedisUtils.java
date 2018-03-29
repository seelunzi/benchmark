package com.lockcoin.locktmall.utils;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author tangwenbo
 * @date 2018/2/5
 * @since JDK1.8
 */
@Slf4j
public class RedisUtils {

    @Autowired
    private static RedisTemplate<String, Serializable> redisTemplate;

    private static Logger log = LoggerFactory.getLogger(RedisUtils.class);

    /**
     * 是否需要redis
     */
    private static boolean isNeedRedis = false;

    /**
     * 根据key删除缓存
     *
     * @param key
     * @return
     */
    public static void delete(final String key) {


        // 如果redis 不需要 则直接返回
        if (!isNeedRedis) {
            return;
        }
        try {
            redisTemplate.delete(key);
        } catch (Exception e) {

            log.error("Delete cache fail and key : " + key);
        }
    }

    /**
     * 保存数据到redis中
     */
    public static boolean put(final String key, final Serializable value) {
        if (!isNeedRedis) {
            return true;
        }

        try {
            return redisTemplate.execute(new RedisCallback<Boolean>() {
                @Override
                public Boolean doInRedis(RedisConnection connection)
                        throws DataAccessException {
                    connection.set(redisTemplate.getStringSerializer().serialize(key), new JdkSerializationRedisSerializer().serialize(value));
                    return true;
                }
            });
        } catch (Exception e) {
            log.error("Put value to redis fail...", e);
        }

        return false;
    }

    /**
     * 保存字符串到redis中
     */
    public static boolean setString(final String key, final String value) {
        if (!isNeedRedis) {
            return true;
        }

        try {
            return redisTemplate.execute((RedisCallback<Boolean>) redisConnection -> {
                redisConnection.set(redisTemplate.getStringSerializer().serialize(key),
                        redisTemplate.getStringSerializer().serialize(value));
                return true;
            });
        } catch (Exception e) {
            log.error("putString value to redis fail...", e);
        }

        return false;
    }

    /**
     * 保存字符串到redis中
     */
    public static boolean setString(final String key, final String value, long liveTime) {
        if (!isNeedRedis) {
            return true;
        }

        try {
            return redisTemplate.execute((RedisCallback<Boolean>) redisConnection -> {
                byte[] keyBytes = redisTemplate.getStringSerializer().serialize(key);
                redisConnection.set(keyBytes, redisTemplate.getStringSerializer().serialize(value));
                if (liveTime > 0) {
                    redisConnection.expire(keyBytes, liveTime);
                }
                return true;
            });
        } catch (Exception e) {
            log.error("putString value to redis fail...", e);
        }

        return false;
    }

    public static boolean hset(final String key, final String field, final String value) {
        if (!isNeedRedis) {
            return true;
        }

        try {
            return redisTemplate.execute(new RedisCallback<Boolean>() {
                @Override
                public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                    return redisConnection.hSet(redisTemplate.getStringSerializer().serialize(key),
                            redisTemplate.getStringSerializer().serialize(field),
                            redisTemplate.getStringSerializer().serialize(value));
                }
            });
        } catch (Exception e) {
            log.error("hset value to redis fail...", e);
        }

        return false;
    }

    /**
     * 从redis 中查询数据
     */
    public static Object get(final String key) {
        if (!isNeedRedis) {
            return null;
        }

        try {
            return redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    return new JdkSerializationRedisSerializer().deserialize(connection.get(redisTemplate.getStringSerializer().serialize(key)));
                }
            });
        } catch (Exception e) {
            log.error("Get value from  redis fail...", e);
        }
        return null;
    }

    /**
     * 从redis 中查询字符串对象
     */
    public static String getString(final String key) {
        if (!isNeedRedis) {
            return null;
        }

        try {
            return redisTemplate.execute((RedisCallback<String>) connection -> {
                byte[] bytes = connection.get(redisTemplate.getStringSerializer().serialize(key));
                return null != bytes ? redisTemplate.getStringSerializer().deserialize(bytes) : null;
            });
        } catch (Exception e) {
            log.error("getString value from  redis fail...", e);
        }
        return null;
    }


    public static boolean hasKey(final String key) {
        if (!isNeedRedis) {
            return false;
        }
        return redisTemplate.hasKey(key);

    }

    /**
     * 以毫秒为单位设置key的超时时间
     *
     * @param key        key
     * @param expireTime 超时时间
     * @return boolean
     */
    public static boolean expireByMilliseconds(String key, Long expireTime) {
        if (!isNeedRedis) {
            return false;
        }
        return redisTemplate.expire(key, expireTime, TimeUnit.MILLISECONDS);
    }

    /**
     * 对存储在指定key的数值执行原子的加1操作
     *
     * @param key
     * @return
     */
    public static Long incrKey(String key) {
        if (!isNeedRedis) {
            return 1L;
        }

        return redisTemplate.execute((RedisCallback<Long>) connection ->
                connection.incr(redisTemplate.getStringSerializer().serialize(key))
        );
    }

    /**
     * 保存数据到redis中
     */
    public static boolean lpush(final String key, final Serializable value) {
        if (!isNeedRedis) {
            return true;
        }

        try {
            return redisTemplate.execute(new RedisCallback<Boolean>() {
                @Override
                public Boolean doInRedis(RedisConnection connection)
                        throws DataAccessException {
                    connection.lPush(new JdkSerializationRedisSerializer().serialize(key), new JdkSerializationRedisSerializer().serialize(value));
                    return true;
                }
            });
        } catch (Exception e) {
            log.error("Put value to redis fail...", e);
        }

        return false;
    }

    /**
     * 从redis 中查询数据
     */
    public static Object lpop(final String key) {
        // 如果redis 不需要 则直接返回
        if (!isNeedRedis) {
            return null;
        }

        try {
            return redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    return new JdkSerializationRedisSerializer().deserialize(connection.lPop(new JdkSerializationRedisSerializer().serialize(key)));
                }
            });
        } catch (Exception e) {
            log.error("Get value from  redis fail...", e);
        }
        return null;
    }

    /**
     * 从redis 中查询数据
     */
    public static Object lrange(final String key, int start, int end) {
        // 如果redis 不需要 则直接返回
        if (!isNeedRedis) {
            return null;
        }

        try {
            return redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    List<Object> lst = new ArrayList<>();
                    JdkSerializationRedisSerializer jser = new JdkSerializationRedisSerializer();
                    List<byte[]> byteLst = connection.lRange(jser.serialize(key), start, end);
                    for (int i = 0; i < byteLst.size(); i++) {
                        // byte[] byteOjb =
                        lst.add(jser.deserialize(byteLst.get(i)));
                    }
                    return lst;
                }
            });
        } catch (Exception e) {
            log.error("Get value from  redis fail...", e);
        }
        return null;
    }

    /**
     * 从redis队列中删除数据
     */
    public static Object lRem(final String key, int count, String value) {
        if (!isNeedRedis) {
            return null;
        }

        try {
            return redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    JdkSerializationRedisSerializer jser = new JdkSerializationRedisSerializer();
                    return connection.lRem(jser.serialize(key), count, jser.serialize(value));
                }
            });
        } catch (Exception e) {
            log.error("remove items from  redis queue fail...", e);
        }
        return null;
    }


    /**
     * 设置过期时间
     */
    public static boolean expir(final String key, final Long value) {
        try {
            redisTemplate.execute(new RedisCallback<Object>() {

                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    return connection.expire(new JdkSerializationRedisSerializer().serialize(key), value);
                }
            });
        } catch (Exception e) {
            log.error("Get value from  redis fail...", e);
        }
        return false;
    }


    /**
     * 删除用可以删除字节数组key的集合
     */
    public static Long delKey(final String key) {
        byte[][] byKey = new byte[0][];
        byKey[0] = rawKey(key);
        try {
            redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {

                    return connection.del(byKey);
                }
            });
        } catch (Exception e) {
            log.error("Get value from  redis fail...", e);
        }
        return null;
    }

    private static byte[] rawKey(Object key) {
        Assert.notNull(key, "non null key required");
        return new JdkSerializationRedisSerializer().serialize(key);
    }

}
