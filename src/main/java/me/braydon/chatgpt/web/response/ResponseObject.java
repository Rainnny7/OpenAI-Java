package me.braydon.chatgpt.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * @author Braydon
 */
@Getter @ToString
public class ResponseObject {
    /**
     * The type of this object.
     */
    private String object;
}
