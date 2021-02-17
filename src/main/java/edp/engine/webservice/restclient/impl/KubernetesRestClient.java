package edp.engine.webservice.restclient.impl;

import edp.core.annotations.RestClient;
import edp.core.config.TestConfiguration;
import edp.core.exceptions.EnvironmentException;
import edp.engine.httpclient.HttpRequest;
import edp.engine.httpclient.HttpResponseWrapper;
import edp.engine.webservice.restclient.interfaces.IKubernetesRestClient;
import io.vavr.control.Try;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

@Lazy
@RestClient
@Log4j

public class KubernetesRestClient implements IKubernetesRestClient {

    @Autowired
    private TestConfiguration configuration;
    private static final String GET_AC_CREATOR_SECRET_URL = "%s/api/v1/namespaces/edp-delivery-edp-delivery-qa/secrets/ac-creator";
    private static final String ADMIN_CONSOLE_CLIENT_SECRET_URL = "%s/api/v1/namespaces/edp-delivery-edp-delivery-qa/secrets/admin-console-client";

    @Override
    public HttpResponseWrapper sendRequestToGetAcCreatorSecret() {
        String url = String.format(GET_AC_CREATOR_SECRET_URL, configuration.getEnvironmentConfig().getKubernetesUrl());
        return Try.of(() ->
                HttpRequest.get(url)
                        .sendAndGetResponse(200))
                .onFailure(exception -> {
                    log.error(String.format("Failed to execute ac-creator request by following url %s", url));
                    throw new EnvironmentException(String.format("Failed to execute ac-creator request by following url %s", url), exception);
                })
                .get();


    }

    @Override
    public HttpResponseWrapper sendRequestToGetAdminConsoleClientSecret() {
        String url = String.format(ADMIN_CONSOLE_CLIENT_SECRET_URL, configuration.getEnvironmentConfig().getKubernetesUrl());
        return Try.of(() ->
                HttpRequest.get(url)
                        .sendAndGetResponse(200))
                .onFailure(exception -> {
                    log.error(String.format("Failed to execute admin-console-client request by following url %s", url));
                    throw new EnvironmentException(String.format("Failed to execute admin-console-client request by following url %s", url), exception);
                })
                .get();
    }
}
