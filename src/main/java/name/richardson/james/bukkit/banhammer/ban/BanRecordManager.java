package name.richardson.james.bukkit.banhammer.ban;

import java.util.List;

import com.avaje.ebean.EbeanServer;

public class BanRecordManager {

	private EbeanServer database;

	public BanRecordManager(EbeanServer database) {
		if (this.database == null) throw new IllegalArgumentException();
		this.database = database;
	}

	public void delete(BanRecord ban) {
		this.database.delete(ban);
	}

	public int delete(List<BanRecord> bans) {
		return this.database.delete(bans);
	}

	public boolean save(BanRecord record) {
		if (record.getPlayer().isBanned()) return false;
		this.database.save(record);
		return true;
	}

	public void update(BanRecord record) {
		this.database.update(record);
	}

	public List<BanRecord> list() {
		return this.database.find(BanRecord.class).findList();
	}

	public List<BanRecord> list(int limit) {
		return this.database.find(BanRecord.class).setMaxRows(limit).findList();
	}

	public int count() {
		return this.database.find(BanRecord.class).findRowCount();
	}
}