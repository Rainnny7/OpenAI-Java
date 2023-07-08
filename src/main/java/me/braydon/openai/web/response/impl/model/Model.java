package me.braydon.openai.web.response.impl.model;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import me.braydon.openai.web.response.ResponseObject;

/**
 * Represents an OpenAI model.
 *
 * @author Braydon
 */
@Getter @EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false) @ToString(callSuper = true)
public final class Model extends ResponseObject {
    /**
     * The id of this model.
     */
    @EqualsAndHashCode.Include private String id;
    
    /**
     * The owner of this model.
     */
    @SerializedName("owned_by")
    private String ownedBy;
    
    /**
     * The timestamp (in seconds) of when this model was created.
     */
    private long created;
    
    /**
     * The permissions of this model.
     *
     * @see ModelPermission for permission
     */
    private ModelPermission[] permission;
}