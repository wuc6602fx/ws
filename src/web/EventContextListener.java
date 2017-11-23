package com.web; /**
 * Created by WeiRenChen on 2016/6/13.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.*;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.io.*;
import java.util.ArrayList;


public class EventContextListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public EventContextListener() {

    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent event) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        ServletContext context = event.getServletContext();
        /*-----------------------------Set ImgPath-----------------------------*/
        String imgPath = context.getInitParameter("ImgPath");
        context.setAttribute("ImgPath", imgPath);
        /*-----------------------------End set ImgPath-----------------------------*/

        /*-----------------------------Set EventFilePath-----------------------------*/
        String eventFilePath = context.getInitParameter("EventFilePath");
        context.setAttribute("EventFilePath", eventFilePath);
        /*-----------------------------End set EventFilePath-----------------------------*/

        /*-----------------------------Set PasswordFilePath-----------------------------*/
        String passwordFilePath = context.getInitParameter("PasswordFile");
        context.setAttribute("PasswordFilePath", passwordFilePath);
        /*-----------------------------End set PasswordFilePath-----------------------------*/

         /* Sets the context in a static variable */
        EventProcess.setServletContext(context);


        /*-----------------------Get file realPath-----------------------*/
        String path = (String) context.getAttribute("EventFilePath");
        String realPath = context.getRealPath(path);
            /*----------------測試輸出----------------*/
                //System.out.println(realPath);
            /*----------------測試輸出----------------*/
        /*-----------------------End get file realPath-----------------------*/
        try {
            /*-----------------------Start read json file-----------------------*/
            File file = new File(realPath);
            BufferedReader bufferedReader = new BufferedReader(new UnicodeReader(new FileInputStream(file), "UTF-8"));
            StringBuilder strBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strBuilder.append(line);
            }
            bufferedReader.close();
            /*-----------------------End read json file-----------------------*/

            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(strBuilder.toString());


            Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();

            /*----------------測試輸出----------------*/
            // System.out.println(gson.toJson(jsonArray));
            /*----------------測試輸出----------------*/

            ArrayList<Event> eventList = new ArrayList<Event>();
            for(int i = 0; i < jsonArray.size(); i++) {
                Event eventObj = gson.fromJson(gson.toJson(jsonArray.get(i)), Event.class);
                //System.out.println(eventObj);
                eventList.add(eventObj);
                /*--------------------測試輸出--------------------*/
                /*
                if(!eventObj.getApplicantList().isEmpty()) {
                    for(Applicant applicant : eventObj.getApplicantList()) {
                        System.out.println(applicant);
                    }
                }
                */
                /*--------------------測試輸出--------------------*/
            }
            EventProcess eventProcess = new EventProcess();
            eventProcess.setEventList(eventList);

            ApplicantProcess applicantProcess = new ApplicantProcess();
            applicantProcess.setServletContext(context);
            Event.setServletContext(context);
            context.setAttribute("apply", applicantProcess);
            context.setAttribute("EventList", eventList);
            context.setAttribute("event", eventProcess);

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        realPath = context.getRealPath(passwordFilePath);

        File file = new File(realPath);
        try {
            BufferedReader bufferedReader = new BufferedReader(new UnicodeReader(new FileInputStream(file), "UTF-8"));
            StringBuilder strBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strBuilder.append(line);
            }
            bufferedReader.close();
            /*-----------------------End read json file-----------------------*/

            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(strBuilder.toString());


            Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();

            ArrayList<Account> accountList = new ArrayList<Account>();
            for(int i = 0; i < jsonArray.size(); i++) {
                Account accountObj = gson.fromJson(gson.toJson(jsonArray.get(i)), Account.class);
                //System.out.println(eventObj);
                accountList.add(accountObj);
            }
            System.out.println(accountList);
            context.setAttribute("Account", accountList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Applicant a = new Applicant("Chen", "3", "00257148", Sex.FEMALE);
        Applicant b = new Applicant("Chen", "3", "00257148", Sex.FEMALE);
        Applicant c = new Applicant("Chen", "2", "00257148", Sex.FEMALE);
        if(a.equals(b)){
            System.out.println("a == b");
        }
        if(!a.equals(c)){
            System.out.println("a != c");
        }
    }
    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context
         (the Web application) is undeployed or
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
