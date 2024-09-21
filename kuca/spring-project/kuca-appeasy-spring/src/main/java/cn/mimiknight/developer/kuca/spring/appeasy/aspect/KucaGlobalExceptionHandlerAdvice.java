package cn.mimiknight.developer.kuca.spring.appeasy.aspect;

import cn.mimiknight.developer.kuca.proto.api.common.utils.KucaLogUtils;
import cn.mimiknight.developer.kuca.spring.appeasy.exception.BizException;
import cn.mimiknight.developer.kuca.spring.appeasy.exception.ServiceException;
import cn.mimiknight.developer.kuca.spring.appeasy.model.response.ServiceResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

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
        return AppEasyUtils.buildBadServiceResponse();
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
        return AppEasyUtils.buildBadServiceResponse();
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
        return AppEasyUtils.buildBadServiceResponse();
    }

    /**
     * NoHandlerFoundException
     *
     * @param hsr hsr
     * @param e   e
     * @return {@link ServiceResponse }
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ServiceResponse handle(HttpServletRequest hsr, NoHandlerFoundException e) {
        log.warn(KucaLogUtils.buildExceptionLogTip(e));
        // 接口访问路径
        ErrorTip errorTip = new ErrorTip().setTip(hsr.getRequestURI());
        return AppEasyUtils.buildServiceResponse(AppErrorReturn.API_NOT_FOUND, errorTip);
    }

    /**
     * ServiceException
     *
     * @param e e
     * @return {@link ServiceResponse }
     */
    @ExceptionHandler(value = ServiceException.class)
    public ServiceResponse handle(ServiceException e) {
        log.warn(KucaLogUtils.buildExceptionLogTip(e));
        return AppEasyUtils.buildBadServiceResponse();
    }

    /**
     * BizException
     *
     * @param e e
     * @return {@link ServiceResponse }
     */
    @ExceptionHandler(value = BizException.class)
    public ServiceResponse handle(BizException e) {
        log.warn(KucaLogUtils.buildExceptionLogTip(e));
        return AppEasyUtils.buildServiceResponse(e.getErrorReturn());
    }

}
