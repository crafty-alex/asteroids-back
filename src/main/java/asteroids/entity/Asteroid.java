package asteroids.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "asteroid")
@Data
@NoArgsConstructor
public class Asteroid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "safe")
    private Boolean safe;

    @Column(name = "diameter_km")
    private BigDecimal diameterKm;

    @Column(name = "diameter_m")
    private BigDecimal diameterM;

    @Column(name = "distance_km")
    private BigDecimal distanceKm;

    @Column(name = "date")
    private LocalDate date;

}
