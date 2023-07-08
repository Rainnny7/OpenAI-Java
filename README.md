# OpenAI-Java

A Java library to interact with the OpenAI API.
## Examples

### Create the client
```java
OpenAI openAi = new OpenAI(ApiCredentials.builder()
                    .apiKey("YOUR_API_KEY")
                    .organization("OPTIONAL_ORG")
                    .build());
```

### List Models
```java
for (Model model : openAi.models()) {
    System.out.println(String.format("Model %s is owned by %s", model.getId(), model.getOwnedBy()));
    // Model gpt-3.5-turbo is owned by openai
}
```

### Get Specific Model
```java
Model model = openAi.getModel(ModelEnum.GPT_3_5_TURBO);
System.out.println("Found " + model.getId());
// Found gpt-3.5-turbo
```

### Chat Completion
```java
ChatCompletion completion = openAi.chatCompletion(ModelEnum.GPT_3_5_TURBO,
    new ChatMessage("user", "Do a dice roll")
);
System.out.println("Got " + completion.choiceCount() + " choice(s):");
for (ChatCompletion.Choice choice : completion) {
    ChatMessage message = choice.getMessage();
    System.out.println(String.format("  %s (%s): %s", choice.getIndex(), message.getRole(), message.getContent()));
}
/**
 * Got 1 choice(s):
 *   0 (assistant): Sure! Here's a dice roll for you:
 *                  You rolled a 4.
 */
```
## Environment Variables
*Environment variables are required for running tests.*

| Variable       | Description                         |
| :------------: | :---------------------------------: |
| `TEST_API_KEY` | **Required**. Your OpenAI API key   |