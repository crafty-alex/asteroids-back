package asteroids.mapper;

import asteroids.entity.Asteroid;
import asteroids.model.AsteroidDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-15T17:54:45+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.10 (AdoptOpenJDK)"
)
@Component
public class AsteroidMapperImpl implements AsteroidMapper {

    @Override
    public List<Asteroid> asteroidsToEntities(List<AsteroidDTO> asteroids) {
        if ( asteroids == null ) {
            return null;
        }

        List<Asteroid> list = new ArrayList<Asteroid>( asteroids.size() );
        for ( AsteroidDTO asteroidDTO : asteroids ) {
            list.add( asteroidDTOToAsteroid( asteroidDTO ) );
        }

        return list;
    }

    @Override
    public AsteroidDTO asteroidToDTO(Asteroid asteroid) {
        if ( asteroid == null ) {
            return null;
        }

        AsteroidDTO asteroidDTO = new AsteroidDTO();

        if ( asteroid.getId() != null ) {
            asteroidDTO.setId( asteroid.getId() );
        }
        asteroidDTO.setName( asteroid.getName() );
        asteroidDTO.setSafe( asteroid.getSafe() );
        asteroidDTO.setDiameterKm( asteroid.getDiameterKm() );
        asteroidDTO.setDiameterM( asteroid.getDiameterM() );
        asteroidDTO.setDistanceKm( asteroid.getDistanceKm() );
        asteroidDTO.setDate( asteroid.getDate() );

        return asteroidDTO;
    }

    protected Asteroid asteroidDTOToAsteroid(AsteroidDTO asteroidDTO) {
        if ( asteroidDTO == null ) {
            return null;
        }

        Asteroid asteroid = new Asteroid();

        asteroid.setId( asteroidDTO.getId() );
        asteroid.setName( asteroidDTO.getName() );
        asteroid.setSafe( asteroidDTO.getSafe() );
        asteroid.setDiameterKm( asteroidDTO.getDiameterKm() );
        asteroid.setDiameterM( asteroidDTO.getDiameterM() );
        asteroid.setDistanceKm( asteroidDTO.getDistanceKm() );
        asteroid.setDate( asteroidDTO.getDate() );

        return asteroid;
    }
}
