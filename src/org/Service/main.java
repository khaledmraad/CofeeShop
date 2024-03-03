package org.Service;

import org.DAO.userDAO;
import org.Domain.user;

import java.util.List;

public class main {
        public static void main(String[] args) {
            user u=new user("jnclsjndcsqlkdjcn","test@gmail.com","passsssswoooorddd");

        userDAO uDao=new userDAO(u);
        uDao.CreateU();

        List<String> userCred=List.of("khaled","passsssswoooorddd");
        if(userDAO.userExist(userCred.get(0),userCred.get(1))){

            System.out.println("exist");

            System.out.println(userDAO.getUser(userCred.get(0),userCred.get(1)).getId());

        }
        else {
            System.out.println("dont exist");

        }


    }

}
