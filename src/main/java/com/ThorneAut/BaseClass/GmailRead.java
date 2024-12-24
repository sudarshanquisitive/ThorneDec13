package com.ThorneAut.BaseClass;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class GmailRead {
	
	public static String PwdinEmail;
	   // Your Gmail credentials
	public static String username = "menlohyd2b@gmail.com";
	public static String password = "zhxhehxlqmeqjcxh"; // Use App Password if 2FA is enabled
	public static String hostData = "imap.gmail.com";
    
	
    public static void Email() {
     
     
        // Configure mail properties
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imaps");
     
        try {
            // Connect to the IMAP store
            Session session = Session.getDefaultInstance(properties, null);
            Store store = session.getStore();
            store.connect(hostData, username, password);

            // Open the inbox folder
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Get messages from the inbox
            Message[] messages = inbox.getMessages();
            System.out.println("Number of emails: " + messages.length);

            if (messages.length > 0) {
                // Fetch the most recent email
                Message recentMessage = messages[messages.length - 1];
                String subject = recentMessage.getSubject();
                if (subject.equals("Thorne Lab -- Welcome")) {
                	Address FromAddress = recentMessage.getFrom()[0];
                    String Data = getTextFromMessage(recentMessage).replaceAll("\\<.*?>","").trim();
                     
                    System.out.println("Subject: " + subject);
                    System.out.println("From: " + FromAddress);
                    System.out.println("Content: " + Data);
                    
                    String[] PwdTxtOne = Data.split("Password:");
    				String PwdinEmail1 = PwdTxtOne[1].replace("&rarr;", "").replace("&nbsp;", "").trim();
    				System.out.println("Email 1 is "+PwdinEmail1);
    				String[] PwdinEmail2 = PwdinEmail1.split("Sincerely");
    				PwdinEmail = PwdinEmail2[0].trim();
    				System.out.println("Email 2 Pwd is: " +PwdinEmail);
				}
            }

            // Close connections
            inbox.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to extract the text content from an email
    private static String getTextFromMessage(Message message) throws Exception {
        if (message.isMimeType("text/plain")) {
            return message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            return getTextFromMimeMultipart(mimeMultipart);
        }
        return "";
    }

    private static String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
        StringBuilder result = new StringBuilder();
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result.append(bodyPart.getContent());
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result.append(html); // Or parse HTML as needed
            }
        }
        return result.toString();
    }
}

