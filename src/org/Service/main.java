package org.Service;

import org.DAO.userDAO;
import org.Domain.user;

public class main {
    public static void main(String[] args) {
        user u=new user("qdscqsdcqsd","vkv,sldkv","test@gmail.com","passsssswoooorddd");

        config c=new config();

        userDAO uDao=new userDAO(u,c);

        c.getSession().beginTransaction();

        uDao.CreateU();

        c.getSession().getTransaction().commit();
        System.out.println("donnee");

        c.getSession().close();

    }

}
