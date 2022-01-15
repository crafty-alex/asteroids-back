package asteroids.controller;

import asteroids.model.AsteroidDTO;
import asteroids.model.AsteroidWrapperDTO;
import asteroids.model.AsteroidsCalculatedDTO;
import asteroids.service.AsteroidService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("${client.server.origin}")
@RequiredArgsConstructor
public class AsteroidController {

    private final AsteroidService asteroidService;


    @PostMapping(value = "/save-asteroids", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveAsteroids(@Valid @RequestBody AsteroidWrapperDTO asteroids, BindingResult bindingResult) {
        asteroidService.saveAsteroids(asteroids, bindingResult);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-calculated-asteroids", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AsteroidsCalculatedDTO> getAsteroids() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(asteroidService.getAsteroids());
    }

}
