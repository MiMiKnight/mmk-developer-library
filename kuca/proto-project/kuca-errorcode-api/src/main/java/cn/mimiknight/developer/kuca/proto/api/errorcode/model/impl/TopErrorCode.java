package cn.mimiknight.developer.kuca.proto.api.errorcode.model.impl;

import cn.mimiknight.developer.kuca.proto.api.errorcode.model.standard.IKucaErrorCode;
import cn.mimiknight.developer.kuca.proto.api.errorcode.utils.KucaECUtils;

/**
 * 错误码接口
 * <p>
 * 错误码组成：AA.BBBCCDDDD
 * <p>
 * 错误码案例：HD.201320000
 * <p>
 * AA：团队标识
 * <p>
 * BBB：项目标识
 * <p>
 * CCDDDD：错误码
 * <p>
 * CC：错误码分类标识
 * <p>
 * DDDD：具体错误码
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2024-01-20 08:19:55
 */
public interface TopErrorCode extends IKucaErrorCode {

    /**
     * 默认成功
     */
    String OK = KucaECUtils.getOkResponseCode(() -> {
        return "11";
    });

    /**
     * 默认失败
     */
    String BAD = KucaECUtils.getBadResponseCode(() -> {
        return "9999999";
    });
}
