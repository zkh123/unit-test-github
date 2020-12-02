package com.example.unit.test.github.redissonCache;


import com.google.common.base.Preconditions;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

/**
 * Redis key util.
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RedisKeyUtil {

    public static final String LOCK_REG_USER_TEMPLATE = "huangDig:LOCK_REG_USER_%s_%s_%s";
    public static final String REDIS_REG_USER_TEMPLATE = "huangDig_REDIS_REG_USER_%s_%s";

    private static final String ACCESS_TOKEN = "huangDig:uso:token:accessToken:%s";
    public static String getTokenKey(String token) {
        Preconditions.checkArgument(!StringUtils.isEmpty(token), "非法请求token参数不存在");
        return String.format(ACCESS_TOKEN, token);
    }

    private static final String USER_TOKEN = "huangDig:uso:token:userId:%s";
    public static String getUserTokenKey(Long userId) {
        Preconditions.checkArgument(userId != null && userId > 0, "userId不能为空");
        return String.format(USER_TOKEN, userId);
    }

}
