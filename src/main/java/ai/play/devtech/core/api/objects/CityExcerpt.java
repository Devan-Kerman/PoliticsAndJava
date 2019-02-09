package main.java.ai.play.devtech.core.api.objects;

import main.java.ai.play.devtech.APIObject;
import main.java.ai.play.devtech.core.objects.manipulation.JSONName;

/**
 * The object in the Cities API
 * @author devan
 *
 */
public class CityExcerpt extends APIObject {
	private static final long serialVersionUID = 1L;

	@JSONName(name = "nation_id")
	public int nationid;
	
	@JSONName(name = "city_id")
	public int cityid;
	
	@JSONName(name = "city_name")
	public String name;
	
	@JSONName(name = "capital")
	public boolean capital;
	
	@JSONName(name = "infrastructure")
	public float infra;
	
	@JSONName(name = "maxinfra")
	public float maxinfra;
	
	@JSONName(name = "land")
	public float land;

	@Override
	public long getID() {
		return cityid;
	}

}
