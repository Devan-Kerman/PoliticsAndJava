package ai.play.devtech.core.api;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.enums.Continents;
import ai.play.devtech.core.objects.manipulation.DataName;

/**
 * An object representing a nation that has the rank of applicant in an alliance
 *
 * @author devan
 */
public class Applicant extends APIObject {
	private static final long serialVersionUID = 1L;

	/**
	 * The nation's id
	 */
	@DataName (name = "nationid")
	public int nationid;

	/**
	 * Nation's name
	 */
	@DataName (name = "nation")
	public String nation;

	/**
	 * Leader's name
	 */
	@DataName (name = "leader")
	public String leader;

	/**
	 * Continent that the person is on
	 */
	@DataName (name = "continent")
	public Continents continent;

	/**
	 * The number of cities the person has
	 */
	@DataName (name = "cities")
	public byte cities;

	/**
	 * Nation score
	 */
	@DataName (name = "score")
	public float score;

	@Override
	public long getID() {
		return nationid;
	}
}
