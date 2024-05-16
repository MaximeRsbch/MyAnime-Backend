package com.rossbach.service;

import com.rossbach.entities.User;
import com.rossbach.entities.Vue;
import com.rossbach.repositories.UserRepository;
import com.rossbach.repositories.VueRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VueService {

    private VueRepository vueRepository;


    public VueService(VueRepository vueRepository) {
        this.vueRepository = vueRepository;

    }

    public void createService (Vue vue){
        this.vueRepository.save(vue);
    }

    public Vue showVueById(int id) {
        Optional<Vue> showVue = this.vueRepository.findById(id);
        return showVue.orElse(null);
    }

    public void deleteVueByUserId(int userId){
        this.vueRepository.deleteByUserId(userId);
    }

    // Verif si l'userId existe bien dans la table Vue
    public boolean checkIfUserIdExistsInVue(int userId) {
        List<Vue> vues = vueRepository.findByUserId(userId);
        return !vues.isEmpty();
    }


    // Verif si une vue est bien associé à cet utilisateur
    public boolean checkIfVueBelongsToUser(int userId, int vueId) {
        Optional<Vue> vueOptional = vueRepository.findByIdAndUserId(vueId, userId);
        return vueOptional.isPresent();
    }

    // Supprimer une vue avec un userId
    public void deleteSingleVueByUserId(int userId, int vueId) {
        Optional<Vue> vueOptional = vueRepository.findByIdAndUserId(vueId, userId);
        vueOptional.ifPresent(vue -> vueRepository.delete(vue));
    }

}
