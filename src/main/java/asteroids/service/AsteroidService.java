package asteroids.service;

import asteroids.model.AsteroidDTO;
import asteroids.model.AsteroidWrapperDTO;
import asteroids.model.AsteroidsCalculatedDTO;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface AsteroidService {

    void saveAsteroids(AsteroidWrapperDTO asteroidDTO, BindingResult bindingResult);

    AsteroidsCalculatedDTO getAsteroids();

}
