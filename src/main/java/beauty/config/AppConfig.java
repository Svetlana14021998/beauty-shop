package beauty.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@Getter
public class AppConfig {

    @Value("${app.service-photo-path}")
    private String servicePhotoPath;
}
