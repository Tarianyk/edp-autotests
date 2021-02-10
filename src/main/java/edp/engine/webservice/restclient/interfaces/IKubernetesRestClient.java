package edp.engine.webservice.restclient.interfaces;

import edp.engine.httpclient.HttpResponseWrapper;

import java.util.Map;

public interface IKubernetesRestClient {
    HttpResponseWrapper sendRequestToGetAcCreatorSecret();

    HttpResponseWrapper sendRequestToGetAdminConsoleClientSecret();
}
