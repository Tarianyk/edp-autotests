package edp.core.enums.testcachemanagement;

import lombok.Getter;

public enum TestCacheKey {
    ACCESS_TOKEN("access_token"),
    AC_CREATOR_PASSWORD("password"),
    ADMIN_CONSOLE_CLIENT_PASSWORD("password");
    @Getter
    private final String key;
    TestCacheKey(String key) {
        this.key = key;
    }
}
