package edp.core.service.interfaces;

import io.fabric8.kubernetes.api.model.Secret;

public interface INativeResource {

    Secret GetSecret(String name, String namespace);

}
