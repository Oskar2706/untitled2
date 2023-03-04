package by.tms.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Listener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }

    public void attributeAdded(HttpSessionBindingEvent event) {
        HttpSessionAttributeListener.super.attributeAdded(event);
    }

    public void attributeRemoved(HttpSessionBindingEvent event) {
        HttpSessionAttributeListener.super.attributeRemoved(event);
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
        HttpSessionAttributeListener.super.attributeReplaced(event);
    }

    public void sessionCreated(HttpSessionEvent se) {
        HttpSessionListener.super.sessionCreated(se);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSessionListener.super.sessionDestroyed(se);
    }
}
