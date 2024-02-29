package org.DAO;

import org.Service.config;
import org.Domain.user;
import org.hibernate.Transaction;

public class userDAO {
    user u;
    config c;


    public userDAO(user u, config c){
        this.u=u;
        this.c=c;
    }

    public void CreateU(){
        user mergedUser = c.getSession().merge(u);
        c.getSession().persist(mergedUser);
    }

    public void ReadU(){
        c.getSession().get(user.class,u.getId());
    }

    public void UpdateU(String name){
        u.setFirstName(name);
        c.getSession().merge(u);
    }

    public void DeleteU(){
        Transaction transaction=c.getSession().beginTransaction();
        try {
            c.getSession().remove(u);
            transaction.commit();
        }
        catch(Exception ex){
            if (transaction!=null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }

    }
}
