import javax.swing.Spring;

import org.jibble.*;
import org.jibble.pircbot.*;

class MeBot extends PircBot {
	// new instance of the bot
	static MeBot bot = new MeBot();
	
	// the owner of the irc chat
	static String owner = "";
	 
	// server variable
	static private String server = "irc.quakenet.org";
	
	// channel variable
	static private String channel = "#etho";
	
	// port by default is always 6667, change if other type
	static private int port = 6667;
	
	// password for the <stream_twitch_name>.jtvirc.com
	static private String password = "";
	
	// construct the bot, here you can add more info for the bot itself
	public MeBot() {
		this.setName("PircBot");
	}
	
	public Boolean isOp(String username) {
		if (username.startsWith("@")) {
			return true;
		} else {
			return false;
		}
	}
	
	protected void onConnect(String server, String channel, int port, String password) {
		
	}
	
	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		if (message.equalsIgnoreCase("!online")) {
			// number of users online
			int totalUsersOnline = bot.getUsers(channel).length;
			
			// user friendly message
			bot.sendMessage(channel, "The bot has been online for: " + RPL_STATSUPTIME / 60 + " seconds" + ", and the total users online are: " + totalUsersOnline);
		}
	}
	
	// main method for the bot
	public static void main(String[] args) throws Exception {
		// enable debbuging output
		bot.setVerbose(true);
		
		// try connecting to the
		try {
			// connection to server
			bot.connect(server, port);
			
			// connection to channel
			bot.joinChannel(channel);
			
			// send a message about connecting
			bot.sendMessage(channel, "Connected to: " + channel);
		} catch (Exception Error) {
			// print the error in the console
			System.out.println(Error);
		}
	}
}