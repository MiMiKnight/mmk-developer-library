package cn.mimiknight.developer.kuca.proto.api.errorcode.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 错误返回类
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @date 2024-09-21 13:31:18
 */
@Setter
@Getter
@Accessors(chain = true)
public class KucaErrorReturn {


    /**
     * 错误码
     */
    private String code;

    /**
     * 错误类型
     */
    private KucaErrorType type;

    /**
     * 错误消息
     */
    private String message;
}
