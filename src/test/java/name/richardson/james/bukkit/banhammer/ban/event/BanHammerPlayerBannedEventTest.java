package name.richardson.james.bukkit.banhammer.ban.event;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import name.richardson.james.bukkit.banhammer.ban.OldBanRecord;
import name.richardson.james.bukkit.banhammer.ban.OldPlayerRecord;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BanHammerPlayerBannedEventTest extends TestCase {

	private BanHammerPlayerBannedEvent event;

	@Test
	public void testGetHandlers()
	throws Exception {
		Assert.assertEquals("Handler lists should be set!", BanHammerPlayerBannedEvent.getHandlerList(), event.getHandlers());
	}

	@Before
	public void setUp()
	throws Exception {
		OldBanRecord banRecord = mock(OldBanRecord.class);
		OldPlayerRecord playerRecord = mock(OldPlayerRecord.class);
		when(banRecord.getPlayer()).thenReturn(playerRecord);
		event = new BanHammerPlayerBannedEvent(banRecord, true);
	}

}
