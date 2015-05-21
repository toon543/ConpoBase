package project.config;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;
import java.util.Properties;

/**
 * Created by kourin.pear on 15/5/2558.
 */
public class SerializableResourceBundleMessageSource extends ReloadableResourceBundleMessageSource{
    public Properties getAllProperties(Locale locale) {
            clearCacheIncludingAncestors();
            PropertiesHolder propertiesHolder = getMergedProperties(locale);
            Properties properties = propertiesHolder.getProperties();
            return properties;
        }
}
