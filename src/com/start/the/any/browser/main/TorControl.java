package com.start.the.any.browser.main;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TorControl {

	public static final String TOR_IP = "127.0.0.1", TOR_PORT = "9150";
	public static final int CONTROLPORT = 9151;
	// Used for magic number
	private static final char[] NYBBLES = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	private OutputStreamWriter out;
	private TorReader in;
	private String magic;

	public TorControl() throws IOException {
		this(new Socket(TOR_IP, CONTROLPORT), OpenTorBrowser.COOKIE_FILE);
	}

	public TorControl(Socket s, String controlFile) throws IOException {
		// Get Magic Cookie
		Path path = Paths.get(controlFile);
		magic = hex(Files.readAllBytes(path));

		in = new TorReader(s.getInputStream());
		out = new OutputStreamWriter(s.getOutputStream());
	}

	public static String hex(byte[] ba) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < ba.length; ++i) {
			int b = (ba[i]) & 0xff;
			buf.append(NYBBLES[b >> 4]);
			buf.append(NYBBLES[b & 0x0f]);
		}
		return buf.toString();
	}

	public String write(String data) throws IOException {
		out.write(data + "\r\n");
		out.flush();
		return in.read();
	}

	public String newIdentity() throws IOException {
		return write("SIGNAL NEWNYM");
	}

	public String authenticate() throws IOException {
		return write("AUTHENTICATE " + magic + "\r\n");
	}

	public void useProxy() {
		System.setProperty("java.net.preferIPv4Stack", "true");
		System.setProperty("socksProxyHost", TOR_IP);
		System.setProperty("socksProxyPort", TOR_PORT);
	}
}