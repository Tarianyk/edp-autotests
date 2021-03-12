package edp.core.model.autotestintegration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edp.utils.strings.Strings;
import io.fabric8.kubernetes.api.model.Secret;
import lombok.Getter;

import static edp.utils.consts.AutotestIntegration.CLUSTER_PROPERTY_NAME;
import static edp.utils.consts.AutotestIntegration.CONFIG_PROPERTY_NAME;

@Getter
public class Cluster {
    public String name;
    public String server;
    public String bearerToken;
    public TlsClientConfig tlsClientConfig;

    @Getter
    public static class TlsClientConfig {
        public boolean insecure;
        public String caData;
    }

    public static Cluster getCluster(Secret secret) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String config = secret.getData().get(CONFIG_PROPERTY_NAME);
        JsonNode configJson = mapper
                .readTree(Strings.encodeValue(config));
        return mapper.readValue(configJson.get(CLUSTER_PROPERTY_NAME).toString(), Cluster.class);
    }
}

