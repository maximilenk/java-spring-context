package edu.school21.spring.preprocessor;

public class PreProcessorToUpperImpl implements Preprocessor{
    @Override
    public String process(String message) {
        return message.toUpperCase();
    }
}
