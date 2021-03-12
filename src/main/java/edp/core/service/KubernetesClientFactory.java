package edp.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import edp.core.model.autotestintegration.Cluster;
import edp.core.service.interfaces.INativeResource;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import static edp.utils.consts.AutotestIntegration.AUTOTEST_INTEGRATION_SECRET_NAME;

@Getter
@Slf4j
@Service
public class KubernetesClientFactory {

    private DefaultKubernetesClient client;

    @Autowired
    private INativeResource nativeResource;

    @Value("${namespace}")
    private String targetNamespace;

    @PostConstruct
    public void init() throws JsonProcessingException {
        log.info("init kubernetes client by agents' sa");
        client = new DefaultKubernetesClient();
        client = initKubernetesClient();
    }

    private DefaultKubernetesClient initKubernetesClient() throws JsonProcessingException {
        Secret secret = nativeResource.GetSecret(AUTOTEST_INTEGRATION_SECRET_NAME, targetNamespace);
        Cluster cluster = Cluster.getCluster(secret);

        log.info("init kubernetes client for {} server", cluster.getServer());
        Config kubeConfig = new ConfigBuilder()
                .withMasterUrl(cluster.getServer())
                .withTrustCerts(true)
                .withOauthToken(cluster.getBearerToken().replaceAll("(\\r|\\n)", ""))
                .build();
        return new DefaultKubernetesClient(kubeConfig);
    }

}