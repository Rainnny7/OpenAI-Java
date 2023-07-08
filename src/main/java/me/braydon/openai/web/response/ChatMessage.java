package me.braydon.openai.web.response;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import me.braydon.openai.web.response.impl.chat.ChatCompletion;

/**
 * A message returned in a {@link ChatCompletion.Choice}.
 *
 * @author Braydon
 */
@Getter @ToString
public final class ChatMessage {
    /**
     * The role of the author of this message.
     */
    private String role;
    
    /**
     * The content contained within this message.
     */
    private String content;
    
    public ChatMessage(@NonNull String role, @NonNull String content) {
        this.role = role;
        this.content = content;
    }
    
    /**
     * Was this message sent by the system?
     *
     * @return true if system, otherwise false
     */
    public boolean isSystem() {
        return role.equals("system");
    }
    
    /**
     * Was this message sent by the user?
     *
     * @return true if user, otherwise false
     */
    public boolean isUser() {
        return role.equals("user");
    }
    
    /**
     * Was this message sent by the assistant?
     *
     * @return true if assistant, otherwise false
     */
    public boolean isAssistant() {
        return role.equals("assistant");
    }
    
    /**
     * Was this message sent by a function?
     *
     * @return true if function, otherwise false
     */
    public boolean isFunction() {
        return role.equals("function");
    }
}