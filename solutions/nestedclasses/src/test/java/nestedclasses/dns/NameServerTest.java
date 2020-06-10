package nestedclasses.dns;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class NameServerTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private NameServer nameServer;

    @Before
    public void initialize() {
        nameServer = new NameServer();
        nameServer.addEntry("aa.bb.hu", "111.111.111.111");
        nameServer.addEntry("cc.dd.hu", "111.111.111.112");
        nameServer.addEntry("ee.dd.hu", "111.111.111.113");
    }

    @Test
    public void addEntryNameAlreadyExistsShouldThrowException() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Already exists");

        nameServer.addEntry("cc.dd.hu", "1");
    }

    @Test
    public void addEntryIpAlreadyExistsShouldThrowException() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Already exists");

        nameServer.addEntry("c", "111.111.111.112");
    }

    @Test
    public void getIpByNameNotFoundShouldThrowException() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Element not found");

        nameServer.getIpByName("aa");
    }

    @Test
    public void getIpByName() {
        assertThat(nameServer.getIpByName("cc.dd.hu"), equalTo("111.111.111.112"));
    }

    @Test
    public void getNameByIpNotFoundShouldThrowException() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Element not found");

        nameServer.getNameByIp("1");
    }
    @Test
    public void getNameByIp() {
        assertThat(nameServer.getNameByIp("111.111.111.113"), equalTo("ee.dd.hu"));
    }

    @Test
    public void removeEntryByName() {
        nameServer.removeEntryByName("aa.bb.hu");

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Element not found");

        nameServer.getIpByName("aa.bb.hu");
    }

    @Test
    public void removeEntryByIp() {
        nameServer.removeEntryByIp("111.111.111.113");

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Element not found");

        nameServer.getNameByIp("111.111.111.113");
    }

}