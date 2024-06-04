package edu.school21.spring.renderer;

import edu.school21.spring.preprocessor.Preprocessor;

public class RendererErrImpl implements Renderer {
    private Preprocessor preprocessor;

    public RendererErrImpl(Preprocessor preprocessor) {
        this.preprocessor = preprocessor;
    }

    @Override
    public void render(String message) {
        System.err.println(preprocessor.process(message));
    }

    public Preprocessor getPreprocessor() {
        return preprocessor;
    }

    public void setPreprocessor(Preprocessor preprocessor) {
        this.preprocessor = preprocessor;
    }

    @Override
    public String toString() {
        return "RendererErrImpl{" +
                "preprocessor=" + preprocessor +
                '}';
    }
}
