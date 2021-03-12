package edp.core.service;

import edp.core.config.EnvironmentConfig;
import edp.core.crd.Codebase;
import edp.core.service.interfaces.ICodebaseResource;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CodebaseResource implements ICodebaseResource {

    @Autowired
    private EnvironmentConfig environmentConfig;

    @Autowired
    private KubernetesClientFactory factory;

    @Override
    public Boolean DeleteCodebaseResource(String name) {
        log.info("deleting {} codebase from cluster", name);
        if (Strings.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("the passed 'name' variable cannot be null or empty.");
        }

        return factory.getClient()
                .customResources(Codebase.class)
                .inNamespace(environmentConfig.getNamespace())
                .withName(name)
                .withPropagationPolicy(DeletionPropagation.FOREGROUND)
                .delete();
    }

}
