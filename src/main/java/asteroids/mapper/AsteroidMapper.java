package asteroids.mapper;

import asteroids.entity.Asteroid;
import asteroids.model.AsteroidDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AsteroidMapper {

    List<Asteroid> asteroidsToEntities(List<AsteroidDTO> asteroids);

    AsteroidDTO asteroidToDTO(Asteroid asteroid);
}
