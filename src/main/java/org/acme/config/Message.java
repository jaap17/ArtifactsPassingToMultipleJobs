package org.acme.config;

import io.smallrye.config.ConfigMapping;

/**
 * Maps the message properties.
 */
@ConfigMapping(prefix = "message")
public interface Message {

    Error error();

    /**
     * Maps the error messages
     */
    interface Error {
        String bearerTokenIsMissing();

        String bearerTokenIsInvalid();
    }
}
