package channelapi;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.*;

import org.json.JSONException;

import com.google.appengine.api.channel.*;

@SuppressWarnings("serial")
public class ChannelAPIServlet extends HttpServlet {

	private static ChannelService channelService = ChannelServiceFactory.getChannelService();
	static ArrayList<String> updateList = new ArrayList<String>();
	private static int noOfUsers = -1;

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		/*
		 * resp.setContentType("text/plain");
		 * resp.getWriter().println("Hello, world");
		 */
		String message = "";
		String name = (String) req.getParameter("name");
		String no = (String) req.getParameter("no");
		String to = (String) req.getParameter("to");
		String txt = (String) req.getParameter("txt");
		System.out.println("Text:  " + txt);

		if (txt instanceof String) {
			if ((txt.equals("logout"))) {
				noOfUsers--;
				updateList.remove(name);
				System.out.println("Does " + name + " still exist?: "
						+ updateList.contains(name));
				StringBuilder str = new StringBuilder(updateList.get(0));
				for (int j = 1; j < updateList.size(); j++) {
					str.append("*" + updateList.get(j));
				}
				System.out.println(str);

				int i = 0;
				for (; i < updateList.size(); i++) {
					try {
						org.json.JSONObject j = new org.json.JSONObject();
						// j.put("to", updateList[noOfUsers]);
						// j.put("name",name);
						j.put("size", updateList.size());
						j.put("txt", "update");
						j.put("ulist", str);

						message = j.toString();
					} catch (JSONException e) {
						System.out.println("JSON exception");
					}
					System.out.println("Updating User " + (i + 1));
					System.out.println(message);
					System.out.println("request received from " + name
							+ " and sent to " + updateList.get(i));
					channelService.sendMessage(new ChannelMessage(updateList
							.get(i), message));
					System.out.println("here");

				}
				i = 0;
				return;
			}
		}

		if (to.equals("updateList")) {
			noOfUsers++;
			updateList.add(name);
			// constructing new String for list of names
			StringBuilder str = new StringBuilder(updateList.get(0));
			for (int j = 1; j < updateList.size(); j++) {
				str.append("*" + updateList.get(j));
			}
			System.out.println(str);

			int i = 0;
			for (; i < updateList.size(); i++) {
				try {
					org.json.JSONObject j = new org.json.JSONObject();
					// j.put("to", updateList[noOfUsers]);
					// j.put("name",name);
					j.put("size", updateList.size());
					j.put("txt", "update");
					j.put("ulist", str);

					message = j.toString();
				} catch (JSONException e) {
					System.out.println("JSON exception");
				}
				System.out.println("Updating User " + (i + 1));
				System.out.println(message);
				System.out.println("request received from " + name
						+ " and sent to "
						+ updateList.get(updateList.indexOf(name)));
				channelService.sendMessage(new ChannelMessage(
						updateList.get(i), message));
				System.out.println("here");

			}
			i = 0;
			return;
		}

		try {
			org.json.JSONObject j = new org.json.JSONObject();
			j.put("to", to);
			j.put("name", name);
			j.put("no", no);
			j.put("txt", txt);
			message = j.toString();
		} catch (JSONException e) {
			System.out.println("JSON exception");
		}
		System.out.println(message);
		System.out.println("request received from " + name + " and sent to "
				+ to);
		channelService.sendMessage(new ChannelMessage(to, message));
		System.out.println("here");
	}
}
