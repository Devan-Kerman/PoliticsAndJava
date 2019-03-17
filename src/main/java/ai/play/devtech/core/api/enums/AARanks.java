package ai.play.devtech.core.api.enums;

/**
 * This is not an enum because the rank of -3 means of a inexisting alliance, and can't be put in enum form that's easily parsable
 * this is purely a reference class
 *
 * @author devan
 */
public class AARanks {
	public static final byte NONEXISTANT_ALLIANCE = -3;
	public static final byte NONE = 0;
	public static final byte APPLICANT = 1;
	public static final byte MEMBER = 2;
	public static final byte OFFICER = 3;
	public static final byte HEIR = 4;
	public static final byte LEADER = 5;

	private AARanks() {throw new UnsupportedOperationException("STATIC CLASS!!!");}
}
