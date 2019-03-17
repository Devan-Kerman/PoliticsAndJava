package ai.play.devtech;

import com.google.gson.Gson;
import java.io.Serializable;

/**
 * An object that can be returned from the API
 *
 * @author devan
 */
public abstract class APIObject implements Serializable, Cloneable {
	private static final long serialVersionUID = -4744850309641999485L;
	static final Gson GSON = new Gson();

	@Override
	public String toString() {
		return GSON.toJson(this);
	}

	@Override
	public boolean equals(Object obj) {
		return GSON.toJson(this).equals(GSON.toJson(obj));
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	protected Object clone() {
		return GSON.fromJson(GSON.toJson(this), this.getClass());
	}

	public abstract long getID();

}
