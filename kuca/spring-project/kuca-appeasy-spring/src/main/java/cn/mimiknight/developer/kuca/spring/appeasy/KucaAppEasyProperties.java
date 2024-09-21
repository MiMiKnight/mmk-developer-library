package cn.mimiknight.developer.kuca.spring.appeasy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KucaAppEasyProperties {

    /**
     * 项目ID
     * <p>
     * 作为错误码前缀
     */
    private String appId;

    /**
     * 默认OK错误码
     */
    private String okErrorCode;

    /**
     * 默认Bad错误码
     */
    private String badErrorCode;

    /**
     * 接口路径404错误码
     */
    private String api404ErrorCode;

    /**
     * 空指针错误码
     */
    private String nullPointErrorCode;

    /**
     * 媒体类型不支持错误码
     */
    private String mediaTypeNotSupportedErrorCode;

    /**
     * Http消息不可读错误码
     */
    private String httpMessageNotReadableErrorCode;

}
