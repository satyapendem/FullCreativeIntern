package channelapi;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;

public class loginServlet extends HttpServlet{
	
private static ChannelService channelService=ChannelServiceFactory.getChannelService();
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String name=(String)req.getParameter("name");
		String token=channelService.createChannel(name);
		
		System.out.println("Name: "+name+" Token: "+token);
		resp.getWriter().print(token);
	}
}

