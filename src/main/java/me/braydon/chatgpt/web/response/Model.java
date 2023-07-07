package me.braydon.chatgpt.web.response;

import lombok.Getter;
import lombok.ToString;

/**
 * Represents an OpenAI model.
 *
 * @author Braydon
 */
@Getter @ToString
public final class Model extends ResponseObject {
    /**
     * The id of this model.
     */
    private String id;
    
    /**
     * The owner of this model.
     */
    private String owned_by;
    
    /**
     * The permissions of this model.
     */
    private String[] permission;
}