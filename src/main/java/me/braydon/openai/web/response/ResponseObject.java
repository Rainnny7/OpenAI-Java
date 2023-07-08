package me.braydon.openai.web.response;

import lombok.Getter;
import lombok.ToString;

/**
 * An object representing a response
 * from the OpenAI API. Each object
 * containing the type of the object.
 *
 * @author Braydon
 */
@Getter @ToString
public class ResponseObject {
    /**
     * The type of this object.
     */
    private String object;
}
