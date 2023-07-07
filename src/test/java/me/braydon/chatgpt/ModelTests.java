package me.braydon.chatgpt;

import me.braydon.chatgpt.web.response.impl.Model;
import me.braydon.chatgpt.web.response.impl.ModelList;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Braydon
 */
public final class ModelTests {
    /**
     * Test listing of {@link Model}'s.
     */
    @Test @DisplayName("List Models")
    public void list() {
        ModelList models = Constants.TEST_CLIENT.models(); // List models
        Assumptions.assumeTrue(models.getData().length > 0, "No models to list");
    }
}