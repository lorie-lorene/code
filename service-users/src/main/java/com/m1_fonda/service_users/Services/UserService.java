package com.m1_fonda.service_users.Services;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m1_fonda.service_users.Repositories.UserRepository;
import com.m1_fonda.service_users.event.Userevent;
import com.m1_fonda.service_users.models.Userbanque;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    // Ajout d'un utilisateur
    // mise en place de PUBSUB pour que lors qu'une instance enregistre un user ca publie l'evenement
    public void addUser(Userbanque user){
        try {
            // enregisrer le user
            Userbanque saveUser = userRepository.save(user);
            // publier l'evenement
            Userevent event = new Userevent();
            event.setUsername(saveUser.getUsername());
            event.setPassword(saveUser.getPassword());
            event.setSurname(saveUser.getSurname());
            event.setCni(saveUser.getCni());
            event.setEmail(saveUser.getEmail());
            event.setNumero(saveUser.getNumero());

            rabbitTemplate.convertAndSend("userExchange","user.create",event);
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException("erreur lors de l'insertion de l'utilisation");
        }
        
    }

    // Suppression d'un utilisateur
    public List<Userbanque> deleteById(int id){
        userRepository.deleteById(id);
        return userRepository.findAll();
    }

    // Liste de tous les utilisateurs
    public List<Userbanque> findUser(){
        return userRepository.findAll();
    }

    // Rechercher un utilisateur son par l'Id
    public Userbanque getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }
    
}
