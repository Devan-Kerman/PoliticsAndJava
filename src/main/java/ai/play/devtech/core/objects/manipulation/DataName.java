package ai.play.devtech.core.objects.manipulation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DataName {
	String name();
}
