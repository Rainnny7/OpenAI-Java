package me.braydon.openai.web.response.impl.chat;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import me.braydon.openai.web.response.ChatMessage;
import me.braydon.openai.web.response.ResponseObject;

/**
 * @author Braydon
 */
@Getter @EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false) @ToString(callSuper = true)
public final class ChatCompletion extends ResponseObject {
    /**
     * The id of this completion.
     */
    @EqualsAndHashCode.Include private String id;
    
    /**
     * The {@link Choice}'s of this completion.
     */
    private Choice[] choices;
    
    /**
     * The timestamp (in seconds) of when this model was created.
     */
    private long created;
    
    /**
     * Get the amount of choices
     * in this completion.
     *
     * @return the number of choices
     */
    public int choiceCount() {
        return choices.length;
    }
    
    /**
     * A choice in a {@link ChatCompletion}.
     */
    @Getter @ToString
    public static class Choice {
        /**
         * The index of this choice.
         */
        private int index;
        
        /**
         * The {@link ChatMessage} in this choice.
         */
        private ChatMessage message;
        
        /**
         * The reason this choice finished.
         */
        @SerializedName("finish_reason")
        private String finishReason;
    }
}
