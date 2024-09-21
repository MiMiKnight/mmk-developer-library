package cn.mimiknight.developer.kuca.spring.appeasy.utils;

import cn.mimiknight.developer.kuca.proto.api.errorcode.model.standard.IKucaErrorReturn;
import cn.mimiknight.developer.kuca.proto.api.errorcode.utils.KucaECUtils;
import cn.mimiknight.developer.kuca.spring.appeasy.model.response.ServiceResponse;

import java.time.ZonedDateTime;
import java.util.UUID;
import java.util.function.Supplier;

/**
 * 系统公共工具类
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2024-01-20 19:18:32
 */
public final class KucaAppEasyUtils {

    private KucaAppEasyUtils() {
    }

    /**
     * 构建服务响应
     *
     * @param er   错误返回对象
     * @param data 数据
     * @return {@link ServiceResponse}
     */
    public static ServiceResponse buildServiceResponse(IKucaErrorReturn er, Object data) {
        ServiceResponse response = new ServiceResponse();
        response.setHttpStatus(er.getType().getStatus());
        response.setErrorType(er.getType().getDesc());
        // TODO 添加错误码前缀
        response.setErrorCode(KucaECUtils.getErrorCode(er.getCode(), () -> "HD.127"));
        response.setErrorMsg(er.getMessage());
        response.setData(data);
        response.setTimestamp(ZonedDateTime.now());
        return response;
    }

    /**
     * 构建服务响应
     *
     * @param errorReturn 错误返回对象
     * @return {@link ServiceResponse}
     */
    public static ServiceResponse buildServiceResponse(IKucaErrorReturn errorReturn) {
        return buildServiceResponse(errorReturn, new Object());
    }

    /**
     * 构建Ok服务响应
     *
     * @param okErrorReturn OK错误返回对象
     * @param data          数据
     * @return {@link ServiceResponse}
     */
    public static ServiceResponse buildOkServiceResponse(Supplier<IKucaErrorReturn> okErrorReturn, Object data) {
        return buildServiceResponse(okErrorReturn.get(), data);
    }

    /**
     * 构建Bad服务响应
     *
     * @param badErrorReturn Bad错误返回对象
     * @return {@link ServiceResponse}
     */
    public static ServiceResponse buildBadServiceResponse(Supplier<IKucaErrorReturn> badErrorReturn) {
        return buildServiceResponse(badErrorReturn.get());
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
