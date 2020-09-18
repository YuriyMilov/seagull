package ap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.jsoup.Jsoup;

import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

public class _info {
	public static String ss = "<a href='http://www.example.com'><b><i>123411567890</i></b></a>";

	public static void main(String[] args) throws Exception {

		// byte[] b = ss.getBytes("UTF-8");

		String s = "http://gamesnews.quicklydone.com/p/news.html";
		s = _info.get_random_rss(s);
		s = _info.get_andr2(s);
		
		System.out.println(s);
	}

	static public final String get_andr3(String s) throws Exception {
		URL feedSource = new URL(s);
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(new XmlReader(feedSource));

		String ss = "<b>" + feed.getTitle().toString() + "</b><hr/>qqqqqq", date = "", link = "", title = "",
				content = "", description = "", cont_desc = "";
		System.out.println(feed.getTitle().toString());

		List<SyndEntry> eee = feed.getEntries();

		int i = eee.size();
		if (i >= 0) { // --- Entries > 0

			List<SyndContent> ee = eee.get(0).getContents();

			i = ee.size(); // System.out.println(i);

			for (SyndEntry e : eee) {

				// System.out.println(e.toString());

				link = e.getLink();
				link = Jsoup.parse(link).text();
				title = e.getTitle();
				title = Jsoup.parse(title).text();

				if (i > 0) // content = getContents().get(0).getValue();

				{

					cont_desc = e.getContents().get(0).getValue();

					 System.out.println(cont_desc); 
					//System.out.println();
					System.out.println("======= 11111111 =======");
				}

				else // DESCRIPTION = e.getDescription().getValue();

				{
					cont_desc = e.getDescription().getValue(); // System.out.println(cont_desc);
					 System.out.println(cont_desc);
					//System.out.println();
					System.out.println("======= 222222 =======");
				}
			

			cont_desc = Jsoup.parse(cont_desc).text();

			if (cont_desc.length() > 333)
				cont_desc = cont_desc.substring(0, 333) + " ...";
			
			
			ss = ss + "qqq<br/><br/><a href='" + link + "'><b>" + title + "</b></a><br/><br/>qqq" + cont_desc
					+ "qqqqqq";
			}

		}

		ss = ss.replace("qqq", "\r\n");

		return ss;

	}

	static public final String get_andr2(String s) throws Exception {
		URL feedSource = new URL(s);
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(new XmlReader(feedSource));

		String ss = "<b>" + feed.getTitle().toString() + "</b><hr/>qqqqqq", date = "", link = "", title = "",
				content = "", description = "", cont_desc = "";
		List<SyndEntry> eee = feed.getEntries();

		int i = eee.size();
		if (i >= 0) { // --- Entries > 0

			List<SyndContent> ee = eee.get(0).getContents();

			i = ee.size();

			for (SyndEntry e : eee) {

				link = e.getLink();
				link = Jsoup.parse(link).text();
				title = e.getTitle();
				title = Jsoup.parse(title).text();

				if (i > 0) // content = getContents().get(0).getValue();
					cont_desc = e.getContents().get(0).getValue();
				else // DESCRIPTION = e.getDescription().getValue();
					cont_desc = e.getDescription().getValue();

				cont_desc = Jsoup.parse(cont_desc).text();

				if (cont_desc.length() > 333)
					cont_desc = cont_desc.substring(0, 333) + " ...";

				ss = ss + "qqq<br/><br/><a href='" + link + "'><b>" + title + "</b></a><br/><br/>qqq" + cont_desc
						+ "qqqqqq";

			}

		}

		ss = ss.replace("qqq", "\r\n");
		return ss;
	}

	
	public static String m2a(String subject, String body) {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		Message msg = new MimeMessage(session);
		String s = "ymilov@gmail.com";
		try {
			msg.setFrom(new InternetAddress(s, "Admin"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress("admins"));
			msg.setSubject(subject);
			msg.setContent(body, "text/html");
			//msg.setText(body);

			//Multipart mp = new MimeMultipart();
			//MimeBodyPart textPart = new MimeBodyPart();
			//textPart.setContent(body, "text/html;charset=utf-8");
			// textPart.setContent(body, "text/html");
			//mp.addBodyPart(textPart);
			Transport.send(msg);
		} catch (Exception e) {
			return e.toString();
		}

		return "email to " + s + " sent";
	}

	public static String send_mail(String from_name, String from_address, String to_name, String to_address,
			String subj, String body) throws Exception {
		String s = "emailing started," + to_address;
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(from_address, MimeUtility.encodeText(from_name, "utf-8", "B")));
		msg.addRecipient(Message.RecipientType.TO,
				new InternetAddress(to_address, MimeUtility.encodeText(to_name, "utf-8", "B")));
		msg.setSubject(MimeUtility.encodeText(MimeUtility.encodeText(subj, "utf-8", "B"), "utf-8", "B"));

		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent(body, "text/html;charset=utf-8");
		Multipart mp = new MimeMultipart();
		mp.addBodyPart(textPart);
		msg.setContent(mp);
		Transport.send(msg);
		s = s + " " + "... finished and sent";
		return s;

	}


	static public final String get_random_rss(String s) throws Exception {
		s = rfu_utf(s);
		int i = s.indexOf("<!--qqq-rss-begin-qqq-->");
		s = s.substring(i);
		i = s.indexOf("<!--qqq-rss-end-qqq-->");
		s = s.substring(26, i).trim();
		String[] sss = s.split("<br />");
		i = new Random().nextInt(sss.length);
		s = sss[i];
		s = Jsoup.parse(s).text();
		return s;
	}

	static public final String rfu_utf(String s) {
		try {
			URL url = new URL(s);

			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf8"));
			s = "";
			String thisLine = "";
			while ((thisLine = br.readLine()) != null) {
				s = s + thisLine + "\r\n";
			}
			br.close();
			return s.toString();

		} catch (Exception e) {
			return e.toString();
		}
	}

}
