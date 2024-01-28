package api.config.endpoints;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Config.LoadPolicy;

@LoadPolicy(Config.LoadType.MERGE)
@Sources({"classpath:platform.api.properties"})
public interface BaseConfig extends Config {

    String url();
    String username();
    String password();
}
