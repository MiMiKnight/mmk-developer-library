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

}
