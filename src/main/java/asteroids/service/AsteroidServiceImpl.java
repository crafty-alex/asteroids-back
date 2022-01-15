package asteroids.service;


import asteroids.entity.Asteroid;
import asteroids.mapper.AsteroidMapper;
import asteroids.model.AsteroidDTO;
import asteroids.model.AsteroidWrapperDTO;
import asteroids.model.AsteroidsCalculatedDTO;
import asteroids.repository.AsteroidRepository;
import asteroids.util.ModelValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AsteroidServiceImpl implements AsteroidService {


    private final AsteroidRepository asteroidRepository;

    private final AsteroidMapper asteroidMapper;


    @Override
    public void saveAsteroids(AsteroidWrapperDTO asteroids, BindingResult bindingResult){
        ModelValidation.checkFields(bindingResult);
        asteroidRepository.saveAll(asteroidMapper.asteroidsToEntities(asteroids.getAsteroidDTOList()));
    }

    @Override
    public AsteroidsCalculatedDTO getAsteroids() {
        AsteroidsCalculatedDTO calculatedDTO = new AsteroidsCalculatedDTO();

        Asteroid biggest = asteroidRepository.findTopByOrderByDiameterKmDesc();
        calculatedDTO.setBiggestAsteroid(asteroidMapper.asteroidToDTO(biggest));

        Asteroid smallest = asteroidRepository.findTopByOrderByDiameterKmAsc();
        calculatedDTO.setSmallestAsteroid(asteroidMapper.asteroidToDTO(smallest));

        Asteroid closest = asteroidRepository.findTopByOrderByDistanceKmAsc();
        calculatedDTO.setClosestAsteroid(asteroidMapper.asteroidToDTO(closest));

        Asteroid farthest = asteroidRepository.findTopByOrderByDistanceKmDesc();
        calculatedDTO.setFarthestAsteroid(asteroidMapper.asteroidToDTO(farthest));

        return calculatedDTO;
    }
}
