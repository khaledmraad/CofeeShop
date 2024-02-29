package org.Service;

import org.DAO.userDAO;
import org.Domain.user;

public class main {
    public static void main(String[] args) {
        user u=new user("khaled","mard","test@gmail.com","passsssswoooorddd");

        config c=new config();

        userDAO uDao=new userDAO(u,c);

        c.session.beginTransaction();

        uDao.CreateU();

        c.session.getTransaction().commit();
        System.out.println("donnee");

        c.session.close();

    }

}
