package com.m1_fonda.service_users.userbroker;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m1_fonda.service_users.Repositories.UserRepository;
import com.m1_fonda.service_users.event.Userevent;
import com.m1_fonda.service_users.models.Userbanque;

@Service
public class Userconsumer {

   @Autowired
    private UserRepository userRepository;

    @RabbitListener(queues = "userQueue")
    public void receiveUserEvent(Userevent event){
         try {
            Userbanque userbanque = new Userbanque();
            userbanque.setUsername(event.getUsername());
            userbanque.setSurname(event.getSurname());
            userbanque.setCni(event.getCni());
            userbanque.setEmail(event.getEmail());
            userbanque.setPassword(event.getPassword());
            userbanque.setNumero(event.getNumero());
            userRepository.save(userbanque);

         } catch (Exception e) {
            System.err.println("erreur lors du traitement de l'evenement:"+e.getMessage());
            // TODO: handle exception
         }
    }

}
