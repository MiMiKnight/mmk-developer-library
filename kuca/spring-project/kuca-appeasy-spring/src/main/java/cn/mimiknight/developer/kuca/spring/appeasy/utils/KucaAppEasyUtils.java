package cn.mimiknight.developer.kuca.spring.appeasy.utils;

import cn.mimiknight.developer.kuca.proto.api.errorcode.AbstractKucaErrorReturnFactory;
import cn.mimiknight.developer.kuca.proto.api.errorcode.model.standard.IKucaErrorReturn;
import cn.mimiknight.developer.kuca.spring.api.common.utils.KucaSpringContextUtils;
import cn.mimiknight.developer.kuca.spring.appeasy.KucaAppEasyProperties;
import cn.mimiknight.developer.kuca.spring.appeasy.model.response.KucaServiceResponse;

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
     * 获取项目唯一标识（错误码前缀）
     *
     * @return {@link String}
     */
    public static String getAppId() {
        KucaAppEasyProperties config = KucaSpringContextUtils.getBean(KucaAppEasyProperties.class);
        return config.getAppId();
    }

    /**
     * 拼接错误码前缀，获取完整的错误码
     *
     * @param code code
     * @return {@link String}
     */
    public static String getFullErrorCode(String code) {
        return getAppId() + code;
    }

    /**
     * get error return
     *
     * @param okErrorCode ok error code
     * @return {@link IKucaErrorReturn }
     */
    private static IKucaErrorReturn getErrorReturn(String okErrorCode) {
        AbstractKucaErrorReturnFactory errorReturnFactory = KucaSpringContextUtils.getBean(AbstractKucaErrorReturnFactory.class);
        return errorReturnFactory.getErrorReturn(okErrorCode);
    }

    /**
     * 构建服务响应
     *
     * @param errorReturn 错误返回对象
     * @param data        数据
     * @return {@link KucaServiceResponse}
     */
    public static KucaServiceResponse buildServiceResponse(IKucaErrorReturn errorReturn, Object data) {
        KucaServiceResponse response = new KucaServiceResponse();
        response.setHttpStatus(errorReturn.getType().getStatus());
        response.setErrorType(errorReturn.getType().getDesc());
        response.setErrorCode(getFullErrorCode(errorReturn.getCode()));
        response.setErrorMsg(errorReturn.getMessage());
        response.setData(data);
        response.setTimestamp(ZonedDateTime.now());
        return response;
    }

    /**
     * 构建服务响应
     *
     * @param errorReturn 错误返回对象
     * @return {@link KucaServiceResponse}
     */
    public static KucaServiceResponse buildServiceResponse(IKucaErrorReturn errorReturn) {
        return buildServiceResponse(errorReturn, new Object());
    }

    /**
     * 构建服务响应
     *
     * @param errorCode 错误码
     * @param data      数据
     * @return {@link KucaServiceResponse}
     */
    public static KucaServiceResponse buildServiceResponse(String errorCode, Supplier<Object> data) {
        return buildServiceResponse(getErrorReturn(errorCode), data.get());
    }

    /**
     * 构建Ok服务响应
     *
     * @param data 数据
     * @return {@link KucaServiceResponse}
     */
    public static KucaServiceResponse buildOkServiceResponse(Object data) {
        KucaAppEasyProperties config = KucaSpringContextUtils.getBean(KucaAppEasyProperties.class);
        String errorCode = config.getErrorCode().getOk();
        return buildServiceResponse(errorCode, () -> data);
    }

    /**
     * 构建Bad异常时服务响应
     *
     * @return {@link KucaServiceResponse}
     */
    public static KucaServiceResponse buildBadServiceResponse() {
        KucaAppEasyProperties config = KucaSpringContextUtils.getBean(KucaAppEasyProperties.class);
        String errorCode = config.getErrorCode().getBad();
        return buildServiceResponse(errorCode, Object::new);
    }

    /**
     * 构建接口404异常时服务响应
     *
     * @param data 数据
     * @return {@link KucaServiceResponse}
     */
    public static KucaServiceResponse buildApi404ServiceResponse(Supplier<Object> data) {
        KucaAppEasyProperties config = KucaSpringContextUtils.getBean(KucaAppEasyProperties.class);
        String errorCode = config.getErrorCode().getApi404();
        return buildServiceResponse(errorCode, data);
    }

    /**
     * 构建空指针异常时服务响应
     *
     * @return {@link KucaServiceResponse}
     */
    public static KucaServiceResponse buildNullPointServiceResponse() {
        KucaAppEasyProperties config = KucaSpringContextUtils.getBean(KucaAppEasyProperties.class);
        String errorCode = config.getErrorCode().getNullPoint();
        return buildServiceResponse(errorCode, Object::new);
    }

    /**
     * 构建媒体类型不支持异常时服务响应
     *
     * @return {@link KucaServiceResponse}
     */
    public static KucaServiceResponse buildMediaTypeNotSupportedServiceResponse() {
        KucaAppEasyProperties config = KucaSpringContextUtils.getBean(KucaAppEasyProperties.class);
        String errorCode = config.getErrorCode().getMediaTypeNotSupported();
        return buildServiceResponse(errorCode, Object::new);
    }

    /**
     * 构建Http消息不可读异常时服务响应
     *
     * @return {@link KucaServiceResponse}
     */
    public static KucaServiceResponse buildHttpMessageNotReadableServiceResponse() {
        KucaAppEasyProperties config = KucaSpringContextUtils.getBean(KucaAppEasyProperties.class);
        String errorCode = config.getErrorCode().getHttpMessageNotReadable();
        return buildServiceResponse(errorCode, Object::new);
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
