package com.google.sps.servlets;

import java.io.IOException;
// import com.google.gson.Gson;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String name = request.getParameter("name");
    String message = request.getParameter("message");

    // Print the value so you can see it in the server logs.
    System.out.println("Name: " + name + "\nMessage: " + message);

    // Write the value to the response so the user can see it.
    response.getWriter().println("Name: " + name + "\nMessage: " + message);

    response.sendRedirect("https://mherrera-sps-summer22.uc.r.appspot.com/#footer");
  }
}

