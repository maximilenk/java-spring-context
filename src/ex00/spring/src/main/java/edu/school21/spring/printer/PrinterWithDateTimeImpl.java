package edu.school21.spring.printer;

import edu.school21.spring.renderer.Renderer;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer{
    private Renderer renderer;
    private LocalDateTime localDateTime;

    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;
        localDateTime = LocalDateTime.now();
    }

    @Override
    public void print(String output) {
        renderer.render(localDateTime + " : " + output);
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public String toString() {
        return "PrinterWithDateTimeImpl{" +
                "renderer=" + renderer +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
