package cn.mimiknight.developer.kuca.spring.appeasy.exception;

import java.io.Serial;

/**
 * service exception
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @date 2024-09-21 14:03:46
 */
public class ServiceException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -1404195234238113609L;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Object... args) {
        super(String.format(message, args));
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message, Throwable cause, Object... args) {
        super(String.format(message, args), cause);
    }

}
