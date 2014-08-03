package name.richardson.james.bukkit.banhammer;

import javax.persistence.*;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.validation.NotNull;

import name.richardson.james.bukkit.utilities.persistence.AbstractRecord;

@Entity
@Table(name = "banhammer_" + "comments")
public class CommentRecord extends AbstractRecord {

	public enum Type {
		NORMAL,
		BAN_REASON,
		PARDON_REASON,
	}

	private static EbeanServer database;
	@ManyToOne
	@JoinColumn(name = "ban_id")
	private BanRecord ban;
	@NotNull
	private String comment;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "creator_id")
	private PlayerRecord creator;
	@ManyToOne
	@JoinColumn(name = "player_id")
	private PlayerRecord player;
	private Type type;


	protected static EbeanServer getRecordDatabase() {
		return CommentRecord.database;
	}

	protected static void setRecordDatabase(final EbeanServer database) {
		CommentRecord.database = database;
	}

	public static CommentRecord create(PlayerRecord creator, PlayerRecord target, String comment) {
 		CommentRecord record = create(creator, comment);
		record.setPlayer(target);
		return record;
	}

	private static CommentRecord create(PlayerRecord creator, String comment) {
		CommentRecord record = new CommentRecord();
		record.setType(Type.NORMAL);
		record.setCreator(creator);
		record.setComment(comment);
		return record;
	}

	public static CommentRecord create(PlayerRecord creator, BanRecord target, String comment) {
	 	CommentRecord record = create(creator, comment);
		record.setBan(target);
		return record;
	}

	public void delete() {
		getDatabase().delete(this);
	}

	public BanRecord getBan() {
		return ban;
	}

	public String getComment() {
		return comment;
	}

	public PlayerRecord getCreator() {
		return creator;
	}

	public PlayerRecord getPlayer() {
		return player;
	}

	public Type getType() {
		return type;
	}

	public void setBan(final BanRecord ban) {
		this.ban = ban;
	}

	public void setComment(final String comment) {
		this.comment = comment;
	}

	public void setCreator(final PlayerRecord creator) {
		this.creator = creator;
		if (player != null) this.creator.getComments().add(this);
	}

	@Override public String toString() {
		final StringBuilder sb = new StringBuilder("CommentRecord{");
		if (ban != null) sb.append("ban=").append(ban.getState());
		sb.append(", comment='").append(comment).append('\'');
		sb.append(", creator=").append(creator.getName());
		if (player != null) sb.append(", player=").append(player.getName());
		sb.append(", type=").append(type);
		sb.append(", ").append(super.toString());
		sb.append('}');
		return sb.toString();
	}

	public void setPlayer(final PlayerRecord player) {
		this.player = player;
		if (player != null) this.player.getComments().add(this);
	}

	public void setType(final Type type) {
		this.type = type;
	}

	@Override protected EbeanServer getDatabase() {
		return getRecordDatabase();
	}


}
