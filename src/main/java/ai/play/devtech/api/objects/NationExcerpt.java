package ai.play.devtech.api.objects;

import ai.play.devtech.APIObject;
import ai.play.devtech.api.enums.Colors;
import ai.play.devtech.core.objects.manipulation.DataName;
import java.awt.Color;

/**
 * A class that represents a nation, provided by the nations api
 *
 * @author devan
 */
public class NationExcerpt extends APIObject {
	private static final long serialVersionUID = 1L;

	@DataName (name = "nationid")
	public int nationid;

	@DataName (name = "nation")
	public String name;

	@DataName (name = "leader")
	public String leader;

	@DataName (name = "continent")
	public String continent;

	@DataName (name = "war_policy")
	public String war;

	@DataName (name = "color")
	public Colors color;

	public Color rgb;

	@DataName (name = "alliance")
	public String allaince;

	@DataName (name = "allianceid")
	public int aaid;

	@DataName (name = "allianceposition")
	public byte aarank;

	@DataName (name = "cities")
	public byte cities;

	@DataName (name = "infrastructure")
	public float infra;

	@DataName (name = "offensivewars")
	public byte offwars;

	@DataName (name = "defensivewars")
	public byte defwars;

	@DataName (name = "score")
	public float score;

	@DataName (name = "rank")
	public int rank;

	@DataName (name = "vacmode")
	public int vacturns;

	@DataName (name = "minutessinceactive")
	public long mininactive;

	@Override
	public long getID() {
		return nationid;
	}

	/**
	 * Checks if the target nation's score is within war declaration range of the player
	 *
	 * @param targetScore the target's score
	 * @return
	 */
	public boolean canAttack(float targetScore) {
		return score * 1.75 < targetScore && score * .75 > targetScore;
	}

	/**
	 * Checks if the aggressor is in range of this nation
	 *
	 * @param aggScore aggressors score
	 * @return
	 */
	public boolean shouldDefend(float aggScore) {
		return aggScore * 1.75 < score && aggScore * .75 > score;
	}
}
