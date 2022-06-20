package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String firstName = Jsoup.clean(request.getParameter("first-name"), Safelist.none());
    String lastName = Jsoup.clean(request.getParameter("last-name"), Safelist.none());
    String message = Jsoup.clean(request.getParameter("message"), Safelist.none());
    Boolean secret = false;
    long timestamp = System.currentTimeMillis();

    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("ForumPost");
    FullEntity<IncompleteKey> taskEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("firstName", firstName)
            .set("lastName", lastName)
            .set("message", message)
            .set("secret", secret)
            .set("timestamp", timestamp)
            .build();
    datastore.put(taskEntity);

    // Print the value so you can see it in the server logs.
    System.out.println("Name: " + firstName + lastName + "\nMessage: " + message + "\nSecret:" + secret);

    // Write the value to the response so the user can see it.
    response.getWriter().println("Name: " + firstName + lastName + "\nMessage: " + message + "\nSecret:" + secret);

    response.sendRedirect("https://mherrera-sps-summer22.uc.r.appspot.com/#forum");
  }
}

