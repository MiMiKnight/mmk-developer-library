package cn.mimiknight.developer.kuca.proto.api.errorcode.utils;

import java.util.function.Supplier;

/**
 * 错误码工具类
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2024-03-10 23:41:25
 */
public class KucaECUtils {

    private KucaECUtils() {
    }

    /**
     * 获取OK响应错误码
     *
     * @param ok ok
     * @return {@link String}
     */
    public static String getOkResponseCode(Supplier<String> ok) {
        return ok.get();
    }

    /**
     * 获取Bad响应默认错误码
     *
     * @param bad bad
     * @return {@link String}
     */
    public static String getBadResponseCode(Supplier<String> bad) {
        return bad.get();
    }

    /**
     * 获取错误码前缀
     *
     * @param prefix prefix
     * @return {@link String}
     */
    public static String getErrorCodePrefix(Supplier<String> prefix) {
        return prefix.get();
    }

    /**
     * 拼接错误码前缀，获取完整的错误码
     *
     * @param code   code
     * @param prefix prefix
     * @return {@link String}
     */
    public static String getErrorCode(String code, Supplier<String> prefix) {
        return getErrorCodePrefix(prefix) + code;
    }

}
