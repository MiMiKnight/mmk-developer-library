package cn.mimiknight.developer.kuca.proto.api.errorcode.model;

import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * kuca error code
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @date 2024-09-21 13:32:05
 */
@Getter
@Accessors(chain = true)
public class KucaErrorCode {


    /**
     * id
     */
    private String id;

    /**
     * type id
     */
    private String typeId;

    /**
     * desc
     */
    private String desc;
}
