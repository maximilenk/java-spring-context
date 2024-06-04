package edu.school21.spring.preprocessor;

public class PreProcessorToLowerImpl implements Preprocessor {
    @Override
    public String process(String message) {
        return message.toLowerCase();
    }
}
