package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/quote")
public class Quote extends HttpServlet {

  String[] quotes = {
    "\"Do You Like Scary Movies?\" - Scream", 
    "\"Do You Want To Play A Game?\" - Saw", 
    "\"It Rubs The Lotion On Its Skin Or Else It Gets The Hose Again.\" - The Silence Of The Lambs",
    "\"Groovy\" - Evil Dead II", "\"Nobody trusts anybody now…and we\'re all very tired.\" - The Thing", 
    "\"It\'s Halloween; I guess everyone\'s entitled to one good scare.\" - Halloween"
  };

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    Gson gson = new Gson();
    String json = gson.toJson(quotes);
    
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }
}
