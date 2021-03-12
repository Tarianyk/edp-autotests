package edp.stepdefs;

import edp.core.cache.TestCache;
import edp.core.config.EnvironmentConfig;
import edp.core.config.KeycloakAuthConfig;
import edp.core.enums.testcachemanagement.TestCacheKey;
import edp.core.service.interfaces.ICodebaseResource;
import edp.core.service.interfaces.INativeResource;
import edp.engine.httpclient.HttpResponseWrapper;
import edp.engine.webservice.restclient.interfaces.IKeycloakRestClient;
import io.cucumber.java.en.And;
import io.fabric8.kubernetes.api.model.Secret;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class WebServiceCodebaseDefinitionSteps {

    public static final String GRANT_TYPE_PASSWORD = "password";

    @Autowired
    private EnvironmentConfig environmentConfig;

    @Autowired
    private KeycloakAuthConfig keycloakAuthConfig;

    @Autowired
    private IKeycloakRestClient keycloakRestClient;

    @Autowired
    private INativeResource nativeResource;

    @Autowired
    private ICodebaseResource codebaseResource;

    @And("User deletes {string} codebase by request")
    public void deleteCodebaseByRequest(String codebaseName) {
        codebaseResource.DeleteCodebaseResource(codebaseName);
    }

    @And("User sends request to get token")
    public void sendRequestToGetToken() {
        Map<String, String> params = new HashMap<>();
        params.put("username", keycloakAuthConfig.getAcCreatorId());
        params.put("password", TestCache.get(TestCacheKey.AC_CREATOR_PASSWORD, String.class));
        params.put("client_id", keycloakAuthConfig.getClientId());
        params.put("client_secret", TestCache.get(TestCacheKey.ADMIN_CONSOLE_CLIENT_PASSWORD, String.class));
        params.put("grant_type", GRANT_TYPE_PASSWORD);
        HttpResponseWrapper responseWrapper = keycloakRestClient.sendGetTokenRequest(params);
        JSONObject body = new JSONObject(responseWrapper.getBody());
        TestCache.putDataInCache(TestCacheKey.ACCESS_TOKEN, body.getString("access_token"));

    }

    @And("User sends request to get ac-creator secret")
    public void sendRequestToGetAcCreatorSecret() {
        Secret secret = nativeResource.GetSecret(keycloakAuthConfig.getAcCreatorId(), environmentConfig.getNamespace());
        String password = secret.getData().get("password");
        TestCache.putDataInCache(TestCacheKey.AC_CREATOR_PASSWORD, new String(Base64.getDecoder().decode(password), StandardCharsets.UTF_8));
    }

    @And("User sends request to get admin-console-client secret")
    public void sendRequestToGetAdminConsoleClientSecret() {
        Secret secret = nativeResource.GetSecret(keycloakAuthConfig.getClientId(), environmentConfig.getNamespace());
        String password = secret.getData().get("password");
        TestCache.putDataInCache(TestCacheKey.ADMIN_CONSOLE_CLIENT_PASSWORD, new String(Base64.getDecoder().decode(password), StandardCharsets.UTF_8));
    }
}
