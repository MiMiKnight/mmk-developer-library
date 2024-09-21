package cn.mimiknight.developer.kuca.spring.appeasy.utils;

import cn.mimiknight.developer.kuca.proto.api.errorcode.model.KucaErrorReturn;
import cn.mimiknight.developer.kuca.proto.api.errorcode.model.KucaErrorType;
import cn.mimiknight.developer.kuca.spring.appeasy.model.response.ServiceResponse;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * 系统公共工具类
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2024-01-20 19:18:32
 */
public final class AppEasyUtils {

    private AppEasyUtils() {
    }

    /**
     * 构建服务响应
     *
     * @param er   错误返回对象
     * @param data 数据
     * @return {@link ServiceResponse}
     */
    public static ServiceResponse buildServiceResponse(KucaErrorReturn er, Object data) {
        ServiceResponse sr = new ServiceResponse();
        sr.setHttpStatus(er.getType().getStatus());
        sr.setErrorType(er.getType().getDesc());
        // TODO 添加错误码前缀
        sr.setErrorCode(er.getCode());
        sr.setErrorMsg(er.getMessage());
        sr.setData(data);
        sr.setTimestamp(ZonedDateTime.now());
        return sr;
    }

    /**
     * 构建服务响应
     *
     * @param er 错误返回对象
     * @return {@link ServiceResponse}
     */
    public static ServiceResponse buildServiceResponse(KucaErrorReturn er) {
        return buildServiceResponse(er, new Object());
    }

    /**
     * 构建Ok服务响应
     *
     * @param data 数据
     * @return {@link ServiceResponse}
     */
    public static ServiceResponse buildOkServiceResponse(Object data) {
        KucaErrorType okType = new KucaErrorType()
                .setStatus(HttpStatus.OK.value())
                .setDesc("OK");
        KucaErrorReturn okErrorReturn = new KucaErrorReturn().setCode("000000")
                .setMessage("success")
                .setType(okType);
        return buildServiceResponse(okErrorReturn, data);
    }

    /**
     * UUID
     *
     * @return {@link String}
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }


}
