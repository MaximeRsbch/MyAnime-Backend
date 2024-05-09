package com.rossbach.service;

import com.rossbach.entities.User;
import com.rossbach.entities.Vue;
import com.rossbach.repositories.VueRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
