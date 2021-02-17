package edp.stepdefs;

import edp.core.cache.TestCache;
import edp.core.config.SecretsConfig;
import edp.core.enums.testcachemanagement.TestCacheKey;
import edp.engine.httpclient.HttpResponseWrapper;
import edp.engine.webservice.parser.IParser;
import edp.engine.webservice.restclient.interfaces.ICodebaseRestClient;
import edp.engine.webservice.restclient.interfaces.IKeycloakRestClient;
import edp.engine.webservice.restclient.interfaces.IKubernetesRestClient;
import io.cucumber.java.en.And;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class WebServiceCodebaseDefinitionSteps {
    @Autowired
    private ICodebaseRestClient codebaseRestClient;
    @Autowired
    private SecretsConfig secretsConfig;
    @Autowired
    private IKeycloakRestClient keycloakRestClient;
    @Autowired
    private IKubernetesRestClient kuberketesRestClient;

    @And("User deletes {string} codebase by request")
    public void deleteCodebaseByRequest(String codebaseName) {
        Map<String, String> params = new HashMap<>();
        params.put("name", codebaseName);
        codebaseRestClient.deleteCodebaseRequest(IParser.toJson(params));


    }

    @And("User sends request to get token")
    public void sendRequestToGetToken() {
        Map<String, String> params = new HashMap<>();
        params.put("password", TestCache.get(TestCacheKey.AC_CREATOR_PASSWORD,String.class));
//        params.put("password", secretsConfig.getAcCreatorPassword());
        params.put("username", secretsConfig.getUserName());
        params.put("client_id", secretsConfig.getClientId());
        params.put("client_secret", TestCache.get(TestCacheKey.ADMIN_CONSOLE_CLIENT_PASSWORD,String.class));
//        params.put("client_secret", secretsConfig.getClientSecret());
        params.put("grant_type", secretsConfig.getGrantType());
        HttpResponseWrapper responseWrapper = keycloakRestClient.sendGetTokenRequest(params);
        JSONObject body = new JSONObject(responseWrapper.getBody());
        TestCache.putDataInCache(TestCacheKey.ACCESS_TOKEN, body.getString("access_token"));

    }

    @And("User sends request to get ac-creator secret")
    public void sendRequestToGetAcCreatorSecret() {
        HttpResponseWrapper responseWrapper = kuberketesRestClient.sendRequestToGetAcCreatorSecret();
        JSONObject body = new JSONObject(responseWrapper.getBodyEncoded());
        TestCache.putDataInCache(TestCacheKey.AC_CREATOR_PASSWORD, new String(Base64.getDecoder().decode
                (new JSONObject(body.get("data").toString()).getString("password")), StandardCharsets.UTF_8));


    }

    @And("User sends request to get admin-console-client secret")
    public void sendRequestToGetAdminConsoleClientSecret() {
        HttpResponseWrapper responseWrapper = kuberketesRestClient.sendRequestToGetAdminConsoleClientSecret();
        JSONObject body = new JSONObject(responseWrapper.getBodyEncoded());
        TestCache.putDataInCache(TestCacheKey.ADMIN_CONSOLE_CLIENT_PASSWORD, new String(Base64.getDecoder().decode
                (new JSONObject(body.get("data").toString()).getString("password")), StandardCharsets.UTF_8));

    }
}
