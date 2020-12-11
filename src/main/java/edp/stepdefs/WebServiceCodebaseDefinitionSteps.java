package edp.stepdefs;

import edp.engine.webservice.parser.IParser;
import edp.engine.webservice.restclient.interfaces.ICodebaseRestClient;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class WebServiceCodebaseDefinitionSteps {
    @Autowired
    private ICodebaseRestClient codebaseRestClient;

    @And("User deletes {string} codebase by request")
    public void deleteCodebaseByRequest(String codebaseName) {
        Map<String,String>params=new HashMap<>();
        params.put("name", codebaseName);
        codebaseRestClient.deleteCodebaseRequest(IParser.toJson(params));

    }
}
