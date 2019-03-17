package ai.play.devtech.core.objects.manipulation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * The name of the variable that is expected in the provided data set (often Map<String, Object>)
 *
 * @author devan
 */
@Retention (RetentionPolicy.RUNTIME)
public @interface DataName {
	String name();
}
