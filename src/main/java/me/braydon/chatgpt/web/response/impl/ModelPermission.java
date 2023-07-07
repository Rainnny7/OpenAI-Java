package me.braydon.chatgpt.web.response.impl;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import me.braydon.chatgpt.web.response.ResponseObject;

/**
 * Represent a permission for a {@link Model}.
 *
 * @author Braydon
 */
@Getter @EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false) @ToString(callSuper = true)
public final class ModelPermission extends ResponseObject {
    /**
     * The id of this permission.
     */
    @EqualsAndHashCode.Include private String id;
    
    /**
     * The organization to which this permission applies.
     */
    private String organization;
    
    /**
     * TODO: doc, idk what this does exactly
     */
    private String group;
    
    /**
     * TODO: doc, idk what this does exactly
     */
    @SerializedName("allow_create_engine")
    private boolean allowCreateEngine;
    
    /**
     * TODO: doc, idk what this does exactly
     */
    @SerializedName("allow_sampling")
    private boolean allowSampling;
    
    /**
     * TODO: doc, idk what this does exactly
     */
    @SerializedName("allow_logprobs")
    private boolean allowLogProbs;
    
    /**
     * TODO: doc, idk what this does exactly
     */
    @SerializedName("allow_search_indices")
    private boolean allowSearchIndices;
    
    /**
     * TODO: doc, idk what this does exactly
     */
    @SerializedName("allow_view")
    private boolean allowView;
    
    /**
     * TODO: doc, idk what this does exactly
     */
    @SerializedName("allow_fine_tuning")
    private boolean allowFineTuning;
    
    /**
     * TODO: doc, idk what this does exactly
     */
    @SerializedName("is_blocking")
    private boolean isBlocking;
    
    /**
     * The timestamp (in seconds) of
     * when this permission was created.
     */
    private long created;
}