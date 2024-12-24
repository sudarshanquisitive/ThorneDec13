package com.ThorneAut.BaseClass;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Arrays;

import java.util.List;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;

import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.AndTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.FromTerm;
import javax.mail.search.SearchTerm;
import org.apache.commons.io.IOUtils;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPStore;

public class GmailTextReading {

	public static String PwdinEmail;
	public static String hostData = "imap.gmail.com";
	public static String usernameData = "menlohyd2b@gmail.com";
	public static String passwordData = "zhxhehxlqmeqjcxh";

	public static void GetPasswordToSignIn() throws IOException
	{
		Properties props = new Properties();
		props.setProperty("mail.store.protocol", "imaps");
		Session session = Session.getDefaultInstance(props,null);
		IMAPStore imapstore = null;

		try {
			try {
				imapstore = (IMAPStore) session.getStore("imaps");
			} catch (NoSuchProviderException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			imapstore.connect(hostData, usernameData, passwordData);
			IMAPFolder folder;
			folder = (IMAPFolder) imapstore.getFolder("INBOX");
			folder.open(IMAPFolder.READ_WRITE);
			Message[] messages;
			messages = folder.getMessages();
			SearchTerm sender = new FromTerm(new InternetAddress("no-reply@thornehealthlab.com"));

			FlagTerm   flagTerm =new FlagTerm(new Flags(Flags.Flag.SEEN), false);

			SearchTerm searchTerm = new AndTerm(flagTerm,sender);      

			System.out.println(messages);
			System.out.println("messages.length---" + messages.length);
			List<Message> messagesa = Arrays.asList(folder.search(searchTerm));

			if(!(messages.length == 0)) {
				Message message = messagesa.get(0);  

				if(message.getSubject().contains("Welcome")){

					System.out.println("---------------------------------");
					// System.out.println("Email Number " + (i + 1));
					System.out.println("Subject: " + message.getSubject());
					System.out.println("Email #" );
					System.out.println("Subject: " + message.getSubject());
					System.out.println("From: " + message.getFrom()[0]);
					//                  System.out.println("Text: " + message.getContent());
					Object mp;
					try{
						mp = (Object) message.getContent();
						if (mp instanceof String) {  
							String body = (String)mp;
							System.out.println("MSG Body : " + body);
						}  else if (mp instanceof MimeMultipart) { 
							MimeMultipart mpp = (MimeMultipart)mp;
							for(int count =0;count<mpp.getCount();count++){
								MimeBodyPart bp = (MimeBodyPart)mpp.getBodyPart(count);
								InputStream fileNme = bp.getInputStream();
								StringWriter writer = new StringWriter();
								IOUtils.copy(fileNme, writer, "UTF-8");
								String UrltheString = writer.toString();
								
								System.out.println("Text: " +UrltheString);
								String[] PwdTxtOne = UrltheString.split("Password:");
								PwdinEmail = PwdTxtOne[1].trim().replaceAll("&amp;", "&");
								System.out.println("Pwd is: " +PwdinEmail);
								if(UrltheString.contains("Password")) {
									break;
								}

							}
						} else if (mp instanceof Multipart) {
							Multipart mpp = (Multipart)mp;
							for(int count =0;count<mpp.getCount();count++){
								MimeBodyPart bp = (MimeBodyPart)mpp.getBodyPart(count);
								InputStream fileNme = bp.getInputStream();
								StringWriter writer = new StringWriter();
								IOUtils.copy(fileNme, writer, "UTF-8");
								String UrltheString = writer.toString();
								System.out.println("Text if else: " +UrltheString);
								String[] UrlOne = UrltheString.split("link:");
								PwdinEmail = UrlOne[1].trim().replaceAll("&amp;", "&");
								System.out.println("URL is: " +PwdinEmail);

							}
						} 
					}catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}


			}


		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	





}
