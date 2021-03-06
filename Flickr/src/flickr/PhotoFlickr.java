/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flickr;
package org.scribe.builder;

import java.awt.Desktop;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.xml.stream.XMLStreamException;
import org.scribe.builder.*;
import org.scribe.builder.api.*;
import org.scribe.model.*;
import org.scribe.oauth.*;

/**
 *
 * @author Vincent
 */
public class PhotoFlickr{
        URLConnection uc;
        String key = "0df97da130a63f27f476cbe1be9f3141";
        int nbImages = 1;
        String tag = "Geek";
        String secret = "51a739c72455365d";

    public PhotoFlickr() throws IOException, XMLStreamException {
       /* try {
            uc = new URL("http://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=" +
            key + "&secret=" + secret + "&per_page=" + nbImages +
            "&text=" + tag).openConnection();
            FileWriter fw;
            try (BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()))) {
                fw = new FileWriter(new File("/Users/Vincent/Desktop/flickr.xml"));
                String nextline;
                while ((nextline = in.readLine()) != null) {
                    fw.append(nextline); }
            }
            fw.close();
        }
        catch(IOException i){
            System.out.println(i);
        }*/
        
        // Replace these with your own api key and secret
    String apiKey = "0df97da130a63f27f476cbe1be9f3141";
    String apiSecret = "51a739c72455365d";
    OAuthService service = new ServiceBuilder().provider(FlickrApi.class).apiKey(apiKey).apiSecret(apiSecret).build();
    Scanner in = new Scanner(System.in);

    System.out.println("=== Flickr's OAuth Workflow ===");
    System.out.println();

    // Obtain the Request Token
    System.out.println("Fetching the Request Token...");
    Token requestToken = service.getRequestToken();
    System.out.println("Got the Request Token!");
    System.out.println();

    System.out.println("Now go and authorize Scribe here:");
    String authorizationUrl = service.getAuthorizationUrl(requestToken);
    System.out.println(authorizationUrl + "&perms=read");
    System.out.println("And paste the verifier here");
    System.out.print(">>");
    Verifier verifier = new Verifier(in.nextLine());
    System.out.println();

    // Trade the Request Token and Verfier for the Access Token
    System.out.println("Trading the Request Token for an Access Token...");
    Token accessToken = service.getAccessToken(requestToken, verifier);
    System.out.println("Got the Access Token!");
    System.out.println("(if your curious it looks like this: " + accessToken + " )");
    System.out.println("(you can get the username, full name, and nsid by parsing the rawResponse: " + accessToken.getRawResponse() + ")");
    System.out.println();

    // Now let's go and ask for a protected resource!
    System.out.println("Now we're going to access a protected resource...");
    OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
    request.addQuerystringParameter("method", "flickr.test.login");
    service.signRequest(accessToken, request);
    Response response = request.send();
    System.out.println("Got it! Lets see what we found...");
    System.out.println();
    System.out.println(response.getBody());

    System.out.println();
    System.out.println("Thats it man! Go and build something awesome with Scribe! :)");
    }
}
