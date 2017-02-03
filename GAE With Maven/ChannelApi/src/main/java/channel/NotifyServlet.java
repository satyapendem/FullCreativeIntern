package channel;
import java.io.IOException;

import javax.servlet.http.*;

import org.json.JSONException;


import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;

public class NotifyServlet extends HttpServlet{
		
		private static ChannelService channelService=ChannelServiceFactory.getChannelService();
			
				public void doPost(HttpServletRequest req, HttpServletResponse resp)
						throws IOException {
					String txt=(String)req.getParameter("txt");
					String to=(String)req.getParameter("to");
					String name=(String)req.getParameter("name");
					String message="";
					
					try{
						org.json.JSONObject j=new org.json.JSONObject();
						j.put("to", to);
						j.put("from",name);
						j.put("txt",txt);
						message=j.toString();
					}
					catch(JSONException e){
						System.out.println("JSON exception");
					}
	
					
					System.out.println(message+" to: "+to);
					channelService.sendMessage(new ChannelMessage(to,message));
				}
}
