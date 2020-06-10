package dynamicproxy;

import org.junit.Test;

public class AuthorizeHandlerTest {

    @Test
    public void testProxyAuthenticatedPrinter() {
        Printer realPrinter = new HpPrinter();
        Printer printer = (Printer) AuthorizeHandler.createProxy(realPrinter);
        printer.print("Jane Doe");
    }

    @Test(expected = SecurityException.class)
    public void testProxyNotAuthenticatedPrinter() {
        Printer realPrinter = new HpPrinter();
        Printer printer = (Printer) AuthorizeHandler.createProxy(realPrinter);
        printer.print("John Doe");
    }

    @Test
    public void testProxyAuthenticatedDoor() {
        Door realDoor = new EntryDoor();
        Door door = (Door) AuthorizeHandler.createProxy(realDoor);
        door.open("John Doe");
    }

    @Test(expected = SecurityException.class)
    public void testProxyNotAuthenticatedDoor() {
        Door realDoor = new EntryDoor();
        Door door = (Door) AuthorizeHandler.createProxy(realDoor);
        door.open("Jane Doe");
    }

}