package asteroids.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Data
public class AsteroidsCalculatedDTO {

    private AsteroidDTO biggestAsteroid;

    private AsteroidDTO smallestAsteroid;

    private AsteroidDTO closestAsteroid;

    private AsteroidDTO farthestAsteroid;

}
