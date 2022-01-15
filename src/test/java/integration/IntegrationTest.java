package integration;


import asteroids.AsteroidApplication;
import asteroids.entity.Asteroid;
import asteroids.model.AsteroidDTO;
import asteroids.model.AsteroidWrapperDTO;
import asteroids.repository.AsteroidRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.hamcrest.core.Is.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith({SpringExtension.class})
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.MOCK, classes = AsteroidApplication.class)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.yml")
class IntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private AsteroidRepository asteroidRepository;

    @BeforeEach
    void init() {
        asteroidRepository.deleteAll();
    }

    @Test
    void when_get_calculated_asteroids_then_200() throws Exception {
        Asteroid bigAndClose = new Asteroid();
        bigAndClose.setName("X42X");
        bigAndClose.setDiameterKm(BigDecimal.valueOf(999999.99999));
        bigAndClose.setDistanceKm(BigDecimal.valueOf(6000.456));
        asteroidRepository.save(bigAndClose);

        Asteroid smallAndFar = new Asteroid();
        smallAndFar.setName("ABC");
        smallAndFar.setDiameterKm(BigDecimal.valueOf(2222.99999));
        smallAndFar.setDistanceKm(BigDecimal.valueOf(564466000.456));
        asteroidRepository.save(smallAndFar);

        mvc.perform(get("http://9090/get-calculated-asteroids")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", isA(LinkedHashMap.class)))
                .andExpect(jsonPath("$.*", isA(JSONArray.class)))
                .andExpect(jsonPath("$.biggestAsteroid.name").value("X42X"))
                .andExpect(jsonPath("$.smallestAsteroid.name").value("ABC"))
                .andExpect(jsonPath("$.closestAsteroid.name").value("X42X"))
                .andExpect(jsonPath("$.farthestAsteroid.name").value("ABC"));
    }

    @Test
    void when_save_asteroids_then_201() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        AsteroidWrapperDTO wrapper = new AsteroidWrapperDTO();
        List<AsteroidDTO> list = new ArrayList<>();
        AsteroidDTO asteroidDTO = new AsteroidDTO();
        asteroidDTO.setName("X42X");
        list.add(asteroidDTO);
        wrapper.setAsteroidDTOList(list);
        String asteroidString = objectMapper.writeValueAsString(wrapper);

        mvc.perform(post("http://9090/save-asteroids")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asteroidString)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

}