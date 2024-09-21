package cn.mimiknight.developer.kuca.spring.appeasy.utils;

import cn.mimiknight.developer.kuca.proto.api.errorcode.AbstractKucaErrorReturnFactory;
import cn.mimiknight.developer.kuca.proto.api.errorcode.AbstractKucaErrorTypeFactory;
import cn.mimiknight.developer.kuca.proto.api.errorcode.model.impl.KucaErrorReturn;
import cn.mimiknight.developer.kuca.proto.api.errorcode.model.impl.KucaErrorType;
import cn.mimiknight.developer.kuca.proto.api.errorcode.model.standard.IKucaErrorReturn;
import cn.mimiknight.developer.kuca.proto.api.errorcode.utils.KucaECUtils;
import cn.mimiknight.developer.kuca.spring.api.common.utils.KucaSpringContextUtils;
import cn.mimiknight.developer.kuca.spring.appeasy.KucaAppEasyProperties;
import cn.mimiknight.developer.kuca.spring.appeasy.model.response.ServiceResponse;

import java.time.ZonedDateTime;
import java.util.UUID;

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
        response.setErrorCode(KucaECUtils.getErrorCode(er.getCode(), () -> {
            KucaAppEasyProperties config = KucaSpringContextUtils.getBean(KucaAppEasyProperties.class);
            return config.getAppId();
        }));
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
     * @param data 数据
     * @return {@link ServiceResponse}
     */
    public static ServiceResponse buildOkServiceResponse(Object data) {
        KucaAppEasyProperties config = KucaSpringContextUtils.getBean(KucaAppEasyProperties.class);
        String okErrorCode = config.getOkErrorCode();
        String okErrorTypeId = config.getOkErrorTypeId();
        return buildServiceResponse(getErrorReturn(okErrorCode, okErrorTypeId), data);
    }

    /**
     * 构建Bad服务响应
     *
     * @return {@link ServiceResponse}
     */
    public static ServiceResponse buildBadServiceResponse() {
        KucaAppEasyProperties config = KucaSpringContextUtils.getBean(KucaAppEasyProperties.class);
        String badErrorCode = config.getBadErrorCode();
        String badErrorTypeId = config.getBadErrorTypeId();
        return buildServiceResponse(getErrorReturn(badErrorCode, badErrorTypeId));
    }


    /**
     * get error return
     *
     * @param okErrorCode   ok error code
     * @param okErrorTypeId ok error type id
     * @return {@link KucaErrorReturn }
     */
    private static KucaErrorReturn getErrorReturn(String okErrorCode, String okErrorTypeId) {

        AbstractKucaErrorReturnFactory errorReturnFactory = KucaSpringContextUtils.getBean(AbstractKucaErrorReturnFactory.class);
        KucaErrorReturn okErrorReturn = (KucaErrorReturn) errorReturnFactory.getErrorReturn(okErrorCode);

        AbstractKucaErrorTypeFactory errorTypeFactory = KucaSpringContextUtils.getBean(AbstractKucaErrorTypeFactory.class);
        KucaErrorType errorType = (KucaErrorType) errorTypeFactory.getErrorType(okErrorTypeId);

        okErrorReturn.setType(errorType);

        return okErrorReturn;
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
