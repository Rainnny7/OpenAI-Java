package me.braydon.chatgpt.web.exception;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import me.braydon.chatgpt.web.ApiWebRequest;

/**
 * This exception is raised when there is
 * an error when processing a request to
 * the OpenAI API.
 *
 * @author Braydon
 * @see ApiWebRequest for impl
 */
@Getter @ToString(callSuper = true)
public final class ApiException extends RuntimeException {
    /**
     * The HTTP code of this error.
     */
    private final int httpCode;
    
    /**
     * The code of this error.
     */
    private final String code;
    
    /**
     * The type of error this is.
     */
    @NonNull private final String type;
    
    public ApiException(int httpCode, String code, @NonNull String type, @NonNull String message) {
        super(message);
        this.httpCode = httpCode;
        this.code = code;
        this.type = type;
    }
}
