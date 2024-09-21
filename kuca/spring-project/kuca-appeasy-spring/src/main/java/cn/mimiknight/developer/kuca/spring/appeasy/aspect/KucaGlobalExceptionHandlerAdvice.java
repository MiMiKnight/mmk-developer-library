package cn.mimiknight.developer.kuca.spring.appeasy.aspect;

import cn.mimiknight.developer.kuca.proto.api.common.utils.KucaLogUtils;
import cn.mimiknight.developer.kuca.proto.api.common.utils.KucaMsgPayloadUtils;
import cn.mimiknight.developer.kuca.proto.api.errorcode.exception.KucaBizException;
import cn.mimiknight.developer.kuca.spring.appeasy.exception.KucaServiceException;
import cn.mimiknight.developer.kuca.spring.appeasy.model.response.KucaServiceResponse;
import cn.mimiknight.developer.kuca.spring.appeasy.utils.KucaAppEasyUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
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
     * @return {@link KucaServiceResponse }
     */
    @ExceptionHandler(value = Throwable.class)
    public KucaServiceResponse handle(Throwable e) {
        log.error(KucaLogUtils.buildExceptionLogTip(e));
        return KucaAppEasyUtils.buildBadServiceResponse();
    }

    /**
     * Exception
     *
     * @param e e
     * @return {@link KucaServiceResponse }
     */
    @ExceptionHandler(value = Exception.class)
    public KucaServiceResponse handle(Exception e) {
        log.error(KucaLogUtils.buildExceptionLogTip(e));
        return KucaAppEasyUtils.buildBadServiceResponse();
    }

    /**
     * RuntimeException
     *
     * @param e e
     * @return {@link KucaServiceResponse }
     */
    @ExceptionHandler(value = RuntimeException.class)
    public KucaServiceResponse handle(RuntimeException e) {
        log.error(KucaLogUtils.buildExceptionLogTip(e));
        return KucaAppEasyUtils.buildBadServiceResponse();
    }

    /**
     * NullPointerException异常处理
     *
     * @param e {@link NullPointerException}异常
     * @return {@link KucaServiceResponse}
     */
    @ExceptionHandler(value = NullPointerException.class)
    public KucaServiceResponse handle(NullPointerException e) {
        log.error(KucaLogUtils.buildExceptionLogTip(e));
        return KucaAppEasyUtils.buildNullPointServiceResponse();
    }

    /**
     * NoHandlerFoundException异常处理
     *
     * @param e {@link NoHandlerFoundException}异常
     * @return {@link KucaServiceResponse}
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public KucaServiceResponse handle(NoHandlerFoundException e, HttpServletRequest servletRequest) {
        log.error(KucaLogUtils.buildExceptionLogTip(e));
        return KucaAppEasyUtils.buildApi404ServiceResponse(() ->
                KucaMsgPayloadUtils.load("api_path", servletRequest.getRequestURI()).finished()
        );
    }

    /**
     * HttpMediaTypeNotSupportedException异常处理
     *
     * @param e {@link HttpMediaTypeNotSupportedException}异常
     * @return {@link KucaServiceResponse}
     */
    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    public KucaServiceResponse handle(HttpMediaTypeNotSupportedException e) {
        log.error(KucaLogUtils.buildExceptionLogTip(e));
        return KucaAppEasyUtils.buildMediaTypeNotSupportedServiceResponse();
    }

    /**
     * HttpMessageNotReadableException异常处理
     *
     * @param e {@link HttpMessageNotReadableException}异常
     * @return {@link KucaServiceResponse}
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public KucaServiceResponse handle(HttpMessageNotReadableException e) {
        log.error(KucaLogUtils.buildExceptionLogTip(e));
        return KucaAppEasyUtils.buildHttpMessageNotReadableServiceResponse();
    }

    /**
     * KucaServiceException
     *
     * @param e ServiceException
     * @return {@link KucaServiceResponse }
     */
    @ExceptionHandler(value = KucaServiceException.class)
    public KucaServiceResponse handle(KucaServiceException e) {
        log.error(KucaLogUtils.buildExceptionLogTip(e));
        return KucaAppEasyUtils.buildBadServiceResponse();
    }

    /**
     * KucaBizException
     *
     * @param e KucaBizException
     * @return {@link KucaServiceResponse }
     */
    @ExceptionHandler(value = KucaBizException.class)
    public KucaServiceResponse handle(KucaBizException e) {
        log.error(KucaLogUtils.buildExceptionLogTip(e));
        return KucaAppEasyUtils.buildServiceResponse(e.getErrorReturn());
    }

}
