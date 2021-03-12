package edp.utils.strings;

import java.util.Base64;

public class Strings {

    public static String encodeValue(String decodedValue) {
        return new String(Base64.getDecoder().decode(decodedValue));
    }

}
