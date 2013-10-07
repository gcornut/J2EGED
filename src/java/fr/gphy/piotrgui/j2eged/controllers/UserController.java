/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.controllers;

import fr.gphy.piotrgui.j2eged.helpers.UserHelper;
import fr.gphy.piotrgui.j2eged.hibernate.HibernateUtil;
import fr.gphy.piotrgui.j2eged.model.User;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Piotr
 */
@Named("UserController")
@SessionScoped
public class UserController implements Serializable {

    private User user;
    private UserHelper helper;

    public UserController() {
        this.user = new User();
        this.helper = new UserHelper();
    }

    public String affiche() {
        return "etudiant";
    }

    public String retour() {
        return "index";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String checkDB() {
        return (this.helper.getConnection(user.getLogin(), user.getPassword())) ? "browser" : "index";
    }
}
