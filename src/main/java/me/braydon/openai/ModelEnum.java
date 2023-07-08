package me.braydon.openai;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import me.braydon.openai.common.TimeUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * Represents an OpenAI model.
 *
 * @author Braydon
 * @link <a href="https://platform.openai.com/docs/models">Model Docs</a>
 * @link <a href="https://openai.com/policies/usage-policies">Usage Policies</a>
 * TODO: legacy models (text-davinci-003 and below)?
 */
@AllArgsConstructor @Getter @ToString
public enum ModelEnum {
    // GPT 4
    GPT_4("gpt-4", "GPT 4",
        "More capable than any GPT-3.5 model, able to do more complex tasks, " +
            "and optimized for chat. Will be updated with our latest model iteration 2" +
            " weeks after it is released.",
        TimeUtils.getDate(Calendar.SEPTEMBER, 2021),
        new ModelCompatibility[] {
            ModelCompatibility.NATIVE_CHAT_COMPLETIONS
        }),
    GPT_4_0613("gpt-4-0613", "GPT 4 (0613)",
        "Snapshot of gpt-4 from June 13th 2023 with function calling data. Unlike" +
            " gpt-4, this model will not receive updates, and will be deprecated 3 months after" +
            " a new version is released.",
        TimeUtils.getDate(Calendar.SEPTEMBER, 2021),
        new ModelCompatibility[] {
            ModelCompatibility.NATIVE_CHAT_COMPLETIONS
        }),
    GPT_4_32K("gpt-4-32k", "GPT 4 (32k)",
        "Same capabilities as the base gpt-4 mode but with 4x the context length." +
            " Will be updated with our latest model iteration.",
        TimeUtils.getDate(Calendar.SEPTEMBER, 2021),
        new ModelCompatibility[] {
            ModelCompatibility.NATIVE_CHAT_COMPLETIONS
        }),
    GPT_4_32K_0613("gpt-4-32k-0613", "GPT 4 (32k-0613)",
        "Snapshot of gpt-4-32 from June 13th 2023. Unlike gpt-4-32k, this model will" +
            " not receive updates, and will be deprecated 3 months after a new version is released.",
        TimeUtils.getDate(Calendar.SEPTEMBER, 2021),
        new ModelCompatibility[] {
            ModelCompatibility.NATIVE_CHAT_COMPLETIONS
        }),
    
    // GPT 3.5
    GPT_3_5_TURBO("gpt-3.5-turbo", "GPT 3.5 Turbo",
        "Most capable GPT-3.5 model and optimized for chat at 1/10th the cost of" +
            " text-davinci-003. Will be updated with our latest model iteration 2 weeks after" +
            " it is released.",
        TimeUtils.getDate(Calendar.SEPTEMBER, 2021),
        new ModelCompatibility[] {
            ModelCompatibility.NATIVE_CHAT_COMPLETIONS
        }),
    GPT_3_5_TURBO_16K("gpt-3.5-turbo-16k", "GPT 3.5 Turbo (16k)",
        "Same capabilities as the standard gpt-3.5-turbo model but with 4 times" +
            " the context.",
        TimeUtils.getDate(Calendar.SEPTEMBER, 2021),
        new ModelCompatibility[] {
            ModelCompatibility.NATIVE_CHAT_COMPLETIONS
        }),
    GPT_3_5_TURBO_0613("gpt-3.5-turbo-0613", "GPT 3.5 Turbo (0613)",
        "Snapshot of gpt-3.5-turbo from June 13th 2023 with function calling data." +
            " Unlike gpt-3.5-turbo, this model will not receive updates, and will be deprecated" +
            " 3 months after a new version is released.",
        TimeUtils.getDate(Calendar.SEPTEMBER, 2021),
        new ModelCompatibility[] {
            ModelCompatibility.NATIVE_CHAT_COMPLETIONS
        }),
    GPT_3_5_TURBO_16K_0613("gpt-3.5-turbo-16k-0613", "GPT 3.5 Turbo (16k-0613)",
        "Snapshot of gpt-3.5-turbo-16k from June 13th 2023. Unlike gpt-3.5-turbo-16k, this" +
            " model will not receive updates, and will be deprecated 3 months after a new version is" +
            " released.",
        TimeUtils.getDate(Calendar.SEPTEMBER, 2021),
        new ModelCompatibility[] {
            ModelCompatibility.NATIVE_CHAT_COMPLETIONS
        }),
    
    // Moderation (Check whether content complies with OpenAI's usage policies)
    TEXT_MODERATION_LATEST("text-moderation-latest", "Text Moderation (Latest)",
        "Most capable moderation model. Accuracy will be slighlty higher than the stable model.",
        null,
        new ModelCompatibility[] {
            ModelCompatibility.MODERATION
        }),
    TEXT_MODERATION_STABLE("text-moderation-stable", "Text Moderation (Stable)",
        "Almost as capable as the latest model, but slightly older.",
        null,
        new ModelCompatibility[] {
            ModelCompatibility.MODERATION
        });
    
    /**
     * The id of this model.
     */
    @NonNull private final String id;
    
    /**
     * The friendly name of this model.
     */
    @NonNull private final String friendlyName;
    
    /**
     * The description of this model.
     */
    @NonNull private final String description;
    
    /**
     * The {@link Date} training data ended on
     * this model, if null, training is still
     * ongoing.
     */
    private final Date trainingEnd;
    
    /**
     * The compatibilities of this model.
     *
     * @see ModelCompatibility for compatibility
     */
    @NonNull private final ModelCompatibility[] compatibilities;
    
    /**
     * Check if this model has
     * the given compatibility.
     *
     * @param compatibility the compatibility
     * @return true if has compatibility, otherwise false
     */
    public boolean hasCompatibilityFor(@NonNull ModelCompatibility compatibility) {
        for (ModelCompatibility modelCompatibility : compatibilities) {
            if (modelCompatibility == compatibility) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Compatibility options for models.
     *
     * @link <a href="https://platform.openai.com/docs/models/model-endpoint-compatibility">Model Compatibility</a>
     */
    public enum ModelCompatibility {
        NATIVE_CHAT_COMPLETIONS,
        LEGACY_CHAT_COMPLETIONS,
        AUDIO_TRANSCRIPTIONS,
        AUDIO_TRANSLATIONS,
        FINE_TUNES,
        EMBEDDINGS,
        MODERATION,
    }
}