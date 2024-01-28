package api.config.endpoints;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Config.LoadPolicy;

@LoadPolicy(Config.LoadType.MERGE)
@Sources({"classpath:user.properties"})
public interface UserConfig extends BaseConfig {
    String userId();
    String generateToken();
    String getUser();
}
