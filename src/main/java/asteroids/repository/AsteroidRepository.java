package asteroids.repository;

import asteroids.entity.Asteroid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AsteroidRepository extends JpaRepository<Asteroid, Integer> {

    Asteroid findTopByOrderByDiameterKmDesc();

    Asteroid findTopByOrderByDiameterKmAsc();

    Asteroid findTopByOrderByDistanceKmDesc();

    Asteroid findTopByOrderByDistanceKmAsc();
}
