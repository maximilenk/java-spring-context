package edu.school21.spring.printer;

import edu.school21.spring.renderer.Renderer;

public class PrinterWithPrefixImpl implements Printer {
    private Renderer renderer;
    private String prefix;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
        prefix = "";
    }

    @Override
    public void print(String output) {
        renderer.render(prefix + " " + output);
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public String toString() {
        return "PrinterWithPrefixImpl{" +
                "renderer=" + renderer +
                ", prefix='" + prefix + '\'' +
                '}';
    }
}
