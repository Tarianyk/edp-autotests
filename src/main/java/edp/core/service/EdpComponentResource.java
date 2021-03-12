package edp.core.service;

import edp.core.config.EnvironmentConfig;
import edp.core.crd.EDPComponent;
import edp.core.exceptions.CustomResourceIsNotFoundException;
import edp.core.service.interfaces.IEdpComponentResource;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class EdpComponentResource implements IEdpComponentResource {

    @Autowired
    private EnvironmentConfig environmentConfig;

    @Autowired
    private KubernetesClientFactory factory;

    @Override
    public EDPComponent GetEdpComponent(String name) {
        log.info("getting {} EDP component from cluster", name);
        if (Strings.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("the passed 'name' variable cannot be null or empty.");
        }

        EDPComponent edpComponent = factory.getClient()
                .customResources(EDPComponent.class)
                .inNamespace(environmentConfig.getNamespace())
                .withName(name)
                .get();
        if (Objects.isNull(edpComponent)) {
            throw new CustomResourceIsNotFoundException(String.format("%s EDP component was not found", name));
        }
        return edpComponent;
    }
}
