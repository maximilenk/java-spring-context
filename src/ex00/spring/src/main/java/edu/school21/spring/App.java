package edu.school21.spring;

import edu.school21.spring.printer.Printer;
import edu.school21.spring.printer.PrinterWithDateTimeImpl;
import edu.school21.spring.printer.PrinterWithPrefixImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        PrinterWithPrefixImpl printer = context.getBean("printerWithPrefixImpl", PrinterWithPrefixImpl.class);
        printer.setPrefix("Hello!");
        printer.print("World");

        PrinterWithDateTimeImpl printer1 = context.getBean("printerWithDateTimeImpl", PrinterWithDateTimeImpl.class);
        printer1.print("World");
        context.close();
    }
}
