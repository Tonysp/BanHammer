package name.richardson.james.bukkit.banhammer.ban.event;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import name.richardson.james.bukkit.banhammer.ban.OldBanRecord;
import name.richardson.james.bukkit.banhammer.ban.OldPlayerRecord;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BanHammerPlayerEventTest extends TestCase {

	private BanHammerPlayerEvent event;

	@Test
	public void testIsSilent()
	throws Exception {
		Assert.assertTrue("Event should be silent!", event.isSilent());
	}

	@Test
	public void testGetRecord()
	throws Exception {
		Assert.assertNotNull("OldBanRecord should not be null!", event.getRecord());

	}

	@Test
	public void testGetPlayerName()
	throws Exception {
		Assert.assertEquals("Player name is inconsistent!", "frank", event.getPlayerName());
	}

	@Test
	public void testGetHandlers()
	throws Exception {
		Assert.assertNotNull("Handlers have not been set correctly!", event.getHandlers());
	}

	@Before
	public void setUp()
	throws Exception {
		OldBanRecord banRecord = mock(OldBanRecord.class);
		OldPlayerRecord playerRecord = mock(OldPlayerRecord.class);
		when(banRecord.getPlayer()).thenReturn(playerRecord);
		when(playerRecord.getName()).thenReturn("frank");
		event = new BanHammerPlayerBannedEvent(banRecord, true);
	}
}
