package edp.engine.webservice.restclient.interfaces;

import edp.engine.httpclient.HttpResponseWrapper;

public interface IKubernetesRestClient {
    HttpResponseWrapper sendRequestToGetAcCreatorSecret();

    HttpResponseWrapper sendRequestToGetAdminConsoleClientSecret();
}
