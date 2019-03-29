package ai.play.devtech.core.api;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.objects.manipulation.DataName;

/**
 * The object in the Cities API
 *
 * @author devan
 */
public class CityExcerpt extends APIObject {
	private static final long serialVersionUID = 1L;

	@DataName (name = "nation_id")
	public int nationid;

	@DataName (name = "city_id")
	public int cityid;

	@DataName (name = "city_name")
	public String name;

	@DataName (name = "capital")
	public boolean capital;

	@DataName (name = "infrastructure")
	public float infra;

	@DataName (name = "maxinfra")
	public float maxinfra;

	@DataName (name = "land")
	public float land;

	@Override
	public long getID() {
		return cityid;
	}

}
