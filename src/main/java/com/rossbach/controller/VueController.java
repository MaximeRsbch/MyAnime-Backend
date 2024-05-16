package com.rossbach.controller;

import com.rossbach.entities.*;
import com.rossbach.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "vue")
public class VueController {

    private VueService vueService;

    private UserService userService;


    public VueController(VueService vueService, UserService userService) {
        this.vueService = vueService;
        this.userService = userService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createVue(@RequestBody Vue vue){
        User userExist = this.userService.showUserById(vue.getUser().getId());
        if (userExist == null ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("L'user avec l'id " + vue.getUser().getId() + " n'existe pas.");
        }
        this.vueService.createService(vue);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("La vue a bien été créer");
    }

    @DeleteMapping(path = "/user/{userId}/all")
    public ResponseEntity<String> deleteVueByUserId(@PathVariable("userId") int userId) {
        boolean userIdExistsInVue = this.vueService.checkIfUserIdExistsInVue(userId);
        if(!userIdExistsInVue) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Aucune vue n'est associée à l'utilisateur avec l'ID " + userId);
        }
         this.vueService.deleteVueByUserId(userId);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Les vues associées à l'utilisateur avec l'ID \" + userId + \" ont été supprimées avec succès\"");
    }

    @DeleteMapping(path = "{vueId}/user/{userId}")
    public ResponseEntity<String> deleteSingleVueByUserId(@PathVariable("userId") int userId, @PathVariable("vueId") int vueId) {
        // Vérifier si la vue appartient à l'utilisateur
        boolean vueBelongsToUser = this.vueService.checkIfVueBelongsToUser(userId, vueId);
        if (!vueBelongsToUser) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("La vue spécifiée n'appartient pas à l'utilisateur avec l'ID " + userId);
        }

        // Supprimer la vue spécifique
        this.vueService.deleteSingleVueByUserId(userId, vueId);

        return ResponseEntity.status(HttpStatus.OK)
                .body("La vue avec l'ID " + vueId + " de l'utilisateur avec l'ID " + userId + " a été supprimée avec succès");
    }


}
