package org.DAO;

import com.fasterxml.classmate.TypeBindings;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.Domain.user;
import org.Service.config;
import org.View.AlertBox;
import org.hibernate.Transaction;

import java.util.List;

public class userDAO {
    user u;
    static config c=new config();


    public userDAO(user u){
        this.u=u;
    }

    public void CreateU(){
        try {
            user mergedUser = c.getSession().merge(u);
            c.getSession().persist(mergedUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void ReadU(){
        c.getSession().get(user.class,u.getId());
    }

    public void UpdateU(String name){
        u.setUserName(name);
        c.getSession().merge(u);
    }

    public void DeleteU(){
        try {
            c.getSession().remove(u);
            c.getSession().getTransaction().commit();
        }
        catch(Exception ex){
            if (c.getSession().getTransaction()!=null){
                c.getSession().getTransaction().rollback();
            }
            ex.printStackTrace();
        }
        finally {
            c.getSession().close();
        }

    }

    public static boolean userExist(String userName, String Password) {
        return userExist(userName, null, Password);
    }

    public static boolean userExist(String userName, String Email, String Password){

        List<user> allUsers;

        if (Email==null) {
            allUsers = userDAO.getAllUser(userName, Password);
        }
        else {
            allUsers=userDAO.getAllUser(userName,Email,Password);
        }


        return !allUsers.isEmpty();

    }

    public static user getUser(String userName, String Password) {
        return getUser(userName, null, Password);
    }

    public static user getUser(String userName, String Email, String Password){

        List<user> allUsers;

        if (Email==null){
            allUsers=userDAO.getAllUser(userName,Password);
        }
        else {
            allUsers=userDAO.getAllUser(userName,Email,Password);
        }

        return allUsers.get(0);

    }

    public static List<user> getAllUser(String userName,String Password) {
        return getAllUser(userName, null, Password);
    }

    public static List<user> getAllUser(String userName, String Email, String Password){
        c.getSession().beginTransaction();

        CriteriaBuilder cb=c.getSession().getCriteriaBuilder();

        CriteriaQuery<user> cr=cb.createQuery(user.class);

        Root<user> root = cr.from(user.class);

        Predicate userNamePredicate=cb.equal(root.get("userName"),userName);

        Predicate emailPredicate=cb.equal(root.get("email"),Email);

        Predicate passPredicate=cb.equal(root.get("password"),Password);

        if (Email!=null){
            cr.select(root).where(cb.and(userNamePredicate,emailPredicate,passPredicate));
        }
        else cr.select(root).where(cb.and(userNamePredicate,passPredicate));

        Query query = c.getSession().createQuery(cr);
        List<user> resultList = query.getResultList();

        c.getSession().getTransaction().commit();

        return resultList;
    }

}
