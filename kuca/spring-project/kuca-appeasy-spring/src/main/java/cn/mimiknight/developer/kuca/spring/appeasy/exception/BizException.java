package cn.mimiknight.developer.kuca.spring.appeasy.exception;

import java.io.Serial;

/**
 * service exception
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @date 2024-09-21 14:03:46
 */
public class BizException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -1404195234238113609L;

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Object... args) {
        super(String.format(message, args));
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(String message, Throwable cause, Object... args) {
        super(String.format(message, args), cause);
    }

}
