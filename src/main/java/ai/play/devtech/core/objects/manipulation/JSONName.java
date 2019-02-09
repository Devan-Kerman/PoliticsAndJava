package main.java.ai.play.devtech.core.objects.manipulation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface JSONName {
	String name();
}
