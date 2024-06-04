package edu.school21.spring.renderer;

import edu.school21.spring.preprocessor.Preprocessor;

public class RendererStandardImpl implements Renderer {
    private Preprocessor preprocessor;
    public RendererStandardImpl(Preprocessor preprocessor) {
        this.preprocessor = preprocessor;
    }

    @Override
    public void render(String message) {
        System.out.println(preprocessor.process(message));
    }

    public Preprocessor getPreprocessor() {
        return preprocessor;
    }

    public void setPreprocessor(Preprocessor preprocessor) {
        this.preprocessor = preprocessor;
    }

    @Override
    public String toString() {
        return "RendererStandardImpl{" +
                "preprocessor=" + preprocessor +
                '}';
    }
}
