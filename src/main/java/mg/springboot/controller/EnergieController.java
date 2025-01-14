package mg.springboot.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import mg.springboot.entity.Energie;
import mg.springboot.entity.Pays;
import mg.springboot.security.Response;
import mg.springboot.service.EnergieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Getter
@Setter
@RequestMapping("/admin")
public class EnergieController {
    EnergieService energieService;

    public EnergieController(EnergieService energieService) {
        this.energieService = energieService;
    }


    @GetMapping("/energies")
    public Response<?> getEnergies() {
        return Response.send(HttpStatus.OK, "success", energieService.findAll());
    }

    @GetMapping("/energies/{id}")
    public Response<?> getEnergies(@PathVariable int id) {
        return Response.send(HttpStatus.OK, "success", energieService.findById(id));
    }

    @PostMapping("/energies")
    public Response<?> addEnergies(@Valid Energie energie) {
        return Response.send(HttpStatus.OK, "success", "L'energie a été ajouté",
                energieService.save(energie));
    }

    @PutMapping("/energies/{id}")
    public Response<?> modifyEnergies(@PathVariable int id, @Valid Energie energie) {
        return Response.send(HttpStatus.OK, "success", "L' energie a été modifié",
                energieService.modify(id, energie));
    }

    @DeleteMapping("/energies/{id}")
    public Response<?> deleteEnergies(@PathVariable int id) {
        return Response.send(HttpStatus.OK, "success", "Le pays a été supprimé",
                energieService.delete(id));
    }
}
