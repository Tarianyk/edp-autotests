package edp.core.service;

import edp.core.config.EnvironmentConfig;
import edp.core.exceptions.CustomResourceIsNotFoundException;
import edp.core.service.interfaces.INativeResource;
import io.fabric8.kubernetes.api.model.Secret;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class NativeResource implements INativeResource {

    @Autowired
    private EnvironmentConfig environmentConfig;

    @Autowired
    private KubernetesClientFactory factory;

    @Override
    public Secret GetSecret(String name, String namespace) {
        log.info("getting {} secret from cluster", name);
        if (Strings.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("the passed 'name' variable cannot be null or empty.");
        }

        Secret secret = factory.getClient()
                .secrets()
                .inNamespace(namespace)
                .withName(name)
                .get();
        if (Objects.isNull(secret)) {
            throw new CustomResourceIsNotFoundException(String.format("%s secret was not found", name));
        }
        return secret;
    }
}
