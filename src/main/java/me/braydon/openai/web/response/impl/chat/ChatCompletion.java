package me.braydon.openai.web.response.impl.chat;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import me.braydon.openai.web.response.ChatMessage;
import me.braydon.openai.web.response.ResponseObject;

import java.util.Iterator;

/**
 * @author Braydon
 */
@Getter @EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false) @ToString(callSuper = true)
public final class ChatCompletion extends ResponseObject implements Iterable<ChatCompletion.Choice> {
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
     * The completion token usage.
     */
    private TokenUsage usage;
    
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
     * Get the iterator for the choices.
     *
     * @return the choice iterator
     * @see ChoiceIterator for iterator
     */
    @Override @NonNull
    public Iterator<Choice> iterator() {
        return new ChoiceIterator();
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
    
    /**
     * Token usage for {@link ChatCompletion}'s.
     *
     * @link <a href="https://platform.openai.com/docs/introduction/tokens">Token Docs</a>
     */
    @Getter @ToString
    public static class TokenUsage {
        /**
         * The tokens gathered from the initial prompt.
         */
        @SerializedName("prompt_tokens")
        private int promptTokens;
        
        /**
         * The tokens from the completion {@link Choice}'s.
         */
        @SerializedName("completion_tokens")
        private int completionTokens;
        
        /**
         * The total number of tokens of
         * both prompt and completion tokens
         */
        @SerializedName("total_tokens")
        private int totalTokens;
    }
    
    /**
     * The {@link Iterator} to use for {@link Choice}'s.
     */
    public class ChoiceIterator implements Iterator<Choice> {
        private int index; // The current choice index
        
        @Override
        public boolean hasNext() {
            return index < choices.length;
        }
        
        @Override @NonNull
        public Choice next() {
            return choices[index++];
        }
    }
}
