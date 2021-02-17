package edp.types;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterByTypeTransformer;
import io.cucumber.cucumberexpressions.ParameterType;
import org.springframework.beans.factory.annotation.Configurable;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static java.util.Locale.ENGLISH;

@Configurable
public class TypeRegistryConfiguration implements ParameterByTypeTransformer, TypeRegistryConfigurer {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Object transform(String fromValue, Type toValueType) {
        return objectMapper.convertValue(fromValue, objectMapper.constructType(toValueType));
    }

    @Override
    public Locale locale() {
        return ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineParameterType(new ParameterType<>("stringList", ".*", List.class,
                this::transformStrings
        ));
    }

    private List<String> transformStrings(String integers) {
        List<String> stringList = Arrays.asList(integers.split(","));
        return stringList.stream().map(String::trim).collect(Collectors.toList());
    }

}
