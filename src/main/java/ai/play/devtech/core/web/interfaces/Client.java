package ai.play.devtech.core.web.interfaces;

public interface Client {
	
	void sendMessage(String leader, String title, String message, String... CC);
	
	
}
