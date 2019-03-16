package ai.play.devtech.core.web.clients;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import ai.play.devtech.DLogger;
import ai.play.devtech.core.errors.TooManyCCException;
import ai.play.devtech.util.files.SaveUtil;
import ai.play.devtech.util.logic.DoNothing;

/**
 * A virtual "player", used for messaging, city shtuff, and all around coolness
 * 
 * @author devan
 *
 */
public class PoliticsAndJavaClient implements Closeable {
	CloseableHttpClient client;
	String email;
	String password;
	int nid;

	public PoliticsAndJavaClient(String email, String password, int nationid) {
		this.email = email;
		this.password = password;
		nid = nationid;
		client = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
		try {
			login();
		} catch (IOException e) {
			DLogger.error("Error on login!");
			e.printStackTrace();
		}
	}
	
	public void sendReply(String reciever, int msgid, String body) {
		try {
			post("https://politicsandwar.com/inbox/message/id="+msgid, 
					new Val("body", body),
					new Val("convoid", Integer.toString(msgid)),
					new Val("receiver", reciever),
					new Val("sndmsg", "Send Message"));
		} catch (IOException e) {
			DLogger.error("unable to send message!");
			e.printStackTrace();
		}
	}
	
	void post(String url, Val...vals) throws IOException {
		HttpPost msg = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<>();
		for(Val v : vals)
			nvps.add(new BasicNameValuePair(v.a, v.b));
		msg.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response = client.execute(msg);
		HttpEntity entity = response.getEntity();
		EntityUtils.consume(entity);
		response.close();
	}

	/**
	 * Sends a message to the specified player(s)
	 * @param reciever
	 * 		The main reciever
	 * @param subject
	 * 		The subject line
	 * @param body
	 * 		The actual contents of the message
	 * @param cc
	 * 		Carbon copy people
	 */
	public void sendMessage(String reciever, String subject, String body, String... cc) {
		String[] sc = cc;
		DLogger.debug(reciever);
		if(DoNothing.retTrue())
			return;
		if(sc.length > 20)
			throw new TooManyCCException("Too many carbon copy targets "+Arrays.toString(sc)+": "+ sc.length);
		try {
			post("https://politicsandwar.com/inbox/message/", 
					new Val("body", body),
					new Val("carboncopy", StringUtils.join(sc, ",")),
					new Val("newconversation", "true"),
					new Val("receiver", reciever),
					new Val("sndmsg", "Send Message"),
					new Val("subject", subject));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test: it just opens p&w in your desktop. :P
	 * 
	 * @throws IOException
	 */
	public void test() throws IOException {
		HttpGet get = new HttpGet("https://politicsandwar.com/");
		CloseableHttpResponse response1 = client.execute(get);
		System.out.println(response1.getStatusLine());
		HttpEntity ent = response1.getEntity();
		SaveUtil.open(ent.getContent(), ".html");
		EntityUtils.consume(ent);
	}

	void login() throws IOException {
		post("https://politicsandwar.com/login/", 
				new Val("email", email), 
				new Val("password", password), 
				new Val("loginform", "Login"));
	}

	@Override
	public void close() {
		try {
			client.close();
		} catch (IOException e) {
			DLogger.warn("Failed to close Politics And Java client");
			e.printStackTrace();
		}
	}
}
class Val {
	String a;
	String b;
	Val(String a, String b) {
		this.a = a;
		this.b = b;
	}
}
