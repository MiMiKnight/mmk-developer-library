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
     * 错误码
     */
    private ErrorCode errorCode = new ErrorCode();

    @Getter
    @Setter
    public static class ErrorCode {

        /**
         * 默认OK错误码
         */
        private String ok;

        /**
         * 默认Bad错误码
         */
        private String bad;

        /**
         * 接口路径404错误码
         */
        private String api404;

        /**
         * 空指针错误码
         */
        private String nullPoint;

        /**
         * 媒体类型不支持错误码
         */
        private String mediaTypeNotSupported;

        /**
         * Http消息不可读错误码
         */
        private String httpMessageNotReadable;

    }

}
