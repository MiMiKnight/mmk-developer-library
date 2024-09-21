package cn.mimiknight.developer.kuca.proto.api.errorcode.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


/**
 * kuca error type
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @date 2024-09-21 13:32:14
 */
@Setter
@Getter
@Accessors(chain = true)
public class KucaErrorType {


    /**
     * id
     */
    private String id;

    /**
     * status
     */
    private int status;

    /**
     * desc
     */
    private String desc;
}
