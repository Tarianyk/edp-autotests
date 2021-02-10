package edp.engine.webservice.restclient.interfaces;

import edp.engine.httpclient.HttpResponseWrapper;

import java.util.Map;

public interface IKeycloakRestClient {
    HttpResponseWrapper sendGetTokenRequest(Map<String,String>params);
}
