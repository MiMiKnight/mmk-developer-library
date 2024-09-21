package cn.mimiknight.developer.kuca.spring.appeasy.aspect;

import cn.mimiknight.developer.kuca.proto.api.common.utils.KucaLogUtils;
import cn.mimiknight.developer.kuca.proto.api.errorcode.exception.KucaBizException;
import cn.mimiknight.developer.kuca.spring.appeasy.exception.KucaServiceException;
import cn.mimiknight.developer.kuca.spring.appeasy.model.response.ServiceResponse;
import cn.mimiknight.developer.kuca.spring.appeasy.utils.KucaAppEasyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * kuca global exception handler advice
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @date 2024-09-21 14:11:17
 */
@Slf4j
@RestControllerAdvice
public class KucaGlobalExceptionHandlerAdvice implements Ordered {

    @Override
    public int getOrder() {
        return Byte.MAX_VALUE;
    }

    /**
     * Throwable
     *
     * @param e e
     * @return {@link ServiceResponse }
     */
    @ExceptionHandler(value = Throwable.class)
    public ServiceResponse handle(Throwable e) {
        log.warn(KucaLogUtils.buildExceptionLogTip(e));
        // TODO 待完善
        return KucaAppEasyUtils.buildBadServiceResponse(() -> null);
    }

    /**
     * Exception
     *
     * @param e e
     * @return {@link ServiceResponse }
     */
    @ExceptionHandler(value = Exception.class)
    public ServiceResponse handle(Exception e) {
        log.warn(KucaLogUtils.buildExceptionLogTip(e));
        // TODO 待完善
        return KucaAppEasyUtils.buildBadServiceResponse(() -> null);
    }

    /**
     * RuntimeException
     *
     * @param e e
     * @return {@link ServiceResponse }
     */
    @ExceptionHandler(value = RuntimeException.class)
    public ServiceResponse handle(RuntimeException e) {
        log.warn(KucaLogUtils.buildExceptionLogTip(e));
        // TODO 待完善
        return KucaAppEasyUtils.buildBadServiceResponse(() -> null);
    }

    /**
     * ServiceException
     *
     * @param e ServiceException
     * @return {@link ServiceResponse }
     */
    @ExceptionHandler(value = KucaServiceException.class)
    public ServiceResponse handle(KucaServiceException e) {
        log.warn(KucaLogUtils.buildExceptionLogTip(e));
        // TODO 待完善
        return KucaAppEasyUtils.buildBadServiceResponse(() -> null);
    }

    /**
     * KucaBizException
     *
     * @param e KucaBizException
     * @return {@link ServiceResponse }
     */
    @ExceptionHandler(value = KucaBizException.class)
    public ServiceResponse handle(KucaBizException e) {
        log.warn(KucaLogUtils.buildExceptionLogTip(e));
        return KucaAppEasyUtils.buildServiceResponse(e.getErrorReturn());
    }

}
