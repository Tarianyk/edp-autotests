package edp.groovy.service.impl.provisioner;

import edp.groovy.service.interfaces.provisioner.IProvisionerGroovyService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import static edp.groovy.service.interfaces.IBaseGroovyScriptReader.scriptReader;


@Service
@Lazy
public class ProvisionerGroovyService implements IProvisionerGroovyService {

    @Override
    public String getProvisionerScript() {
        return scriptReader("provisioner/provisionerCode.groovy");
    }

    @Override
    public String getGithubProvisionerScript() {
        return scriptReader("provisioner/githubProvisionerCode.groovy");
    }
}
