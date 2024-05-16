package com.rossbach.controller;

import com.rossbach.entities.Favoris;
import com.rossbach.service.FavorisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "favoris")
public class FavorisController {

    private FavorisService favorisService;

    public FavorisController(FavorisService favorisService) {
        this.favorisService = favorisService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createFavoris(@RequestBody Favoris favoris){
        this.favorisService.createFavoris(favoris);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Favoris> showFavoris(){
        return this.favorisService.showFavoris();
    }


    @GetMapping(path = "{id}")
    public Favoris showFavorisByID(@PathVariable int id){
        return this.favorisService.showFavorisByID(id);
    }

    @DeleteMapping(path = "/user/{userId}/all")
    public ResponseEntity<String> deleteFavorisByUserId(@PathVariable int userId){
        boolean userIdExistInVue = this.favorisService.checkIfUserIdExistsInFavoris(userId);
        if(!userIdExistInVue){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Aucun favoris n'est associée à l'utilisateur avec l'ID " + userId);
        }
        this.favorisService.deleteFavorisByUserId(userId);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Les favoris associées à l'utilisateur avec l'ID \" + userId + \" ont été supprimées avec succès\"");
    }

    @DeleteMapping(path = "{favorisId}/user/{userId}")
    public ResponseEntity<String> deleteSingleVueByUserId(@PathVariable("userId") int userId, @PathVariable("favorisId") int favorisId) {
        // Vérifier si la vue appartient à l'utilisateur
        boolean favorisBelongsToUser = this.favorisService.checkIfFavorisBelongsToUser(userId, favorisId);
        if (!favorisBelongsToUser) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("La vue spécifiée n'appartient pas à l'utilisateur avec l'ID " + userId);
        }

        // Supprimer la vue spécifique
        this.favorisService.deleteSingleFavorisByUserId(userId, favorisId);

        return ResponseEntity.status(HttpStatus.OK)
                .body("La vue avec l'ID " + favorisId + " de l'utilisateur avec l'ID " + userId + " a été supprimée avec succès");
    }

}
