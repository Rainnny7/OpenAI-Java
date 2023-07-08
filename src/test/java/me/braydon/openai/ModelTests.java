package me.braydon.openai;

import lombok.NonNull;
import me.braydon.openai.web.response.impl.model.Model;
import me.braydon.openai.web.response.impl.model.ModelList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

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
        assumeTrue(models.getData().length > 0, "No models to list");
    }
    
    /**
     * Get {@link Model} fetching.
     *
     * @param modelEnum the model to fetch
     */
    @ParameterizedTest @DisplayName("Get Model")
    @EnumSource(value = ModelEnum.class, names = { "GPT_3_5_TURBO" })
    public void get(@NonNull ModelEnum modelEnum) {
        Constants.TEST_CLIENT.getModel(modelEnum); // Get the model
    }
}