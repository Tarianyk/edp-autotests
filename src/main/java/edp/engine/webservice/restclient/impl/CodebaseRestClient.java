package edp.engine.webservice.restclient.impl;

import edp.core.annotations.RestClient;
import edp.core.config.TestConfiguration;
import edp.core.exceptions.EnvironmentException;
import edp.engine.httpclient.HttpRequest;
import edp.engine.webservice.restclient.interfaces.ICodebaseRestClient;
import io.vavr.control.Try;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import static edp.engine.httpclient.HttpRequest.ContentType.APPLICATION_JSON;

@Lazy
@RestClient
@Log4j
public class CodebaseRestClient implements ICodebaseRestClient {
    @Autowired
    private TestConfiguration configuration;

    private static final String DELETE_CODEBASE_URL = "%s/api/v1/edp/codebase";
    @Override
    public void deleteCodebaseRequest(String body) {
        String url = String.format(DELETE_CODEBASE_URL,configuration.getEnvironmentConfig().getAdminConsoleUrl());
        Try.run(()->
                HttpRequest.deleteWithBody(url).addAccept(APPLICATION_JSON.toString())
        .addContentType(APPLICATION_JSON.toString())
        .addBody(body)
                        .addAccessToken()
        .sendAndGetResponse(200))
                .onFailure(exception->{
                  log.error(String.format("Failed to execute delete codebase request by following url %s",url));
                  throw new EnvironmentException(String.format("Failed to execute delete codebase request by following url %s",url),exception);
                });

    }
}
