package cn.mimiknight.developer.kuca.boot.autoconfigure.ecology;

import cn.mimiknight.developer.kuca.spring.ecology.KucaEcologyParamValidationProcessor;
import cn.mimiknight.developer.kuca.spring.ecology.KucaEcologyProperties;
import cn.mimiknight.developer.kuca.spring.ecology.KucaEcologyRequestExecutor;
import cn.mimiknight.developer.kuca.spring.ecology.handler.KucaEcologyRequestHandlerBox;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * ecology auto configuration
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @date 2024-08-31 22:08:56
 * @since v1.0
 */
@AutoConfiguration
@Import(value = {KucaEcologyRequestExecutor.class, KucaEcologyRequestHandlerBox.class,
        KucaEcologyParamValidationProcessor.class})
public class KucaEcologyAutoConfiguration {

    @Bean
    @ConditionalOnClass(KucaEcologyProperties.class)
    @ConfigurationProperties(prefix = "kuca.ecology", ignoreInvalidFields = true)
    public KucaEcologyProperties getEcologyProperties() {
        return new KucaEcologyProperties();
    }
}
