DROP TABLE IF EXISTS asteroid;

CREATE TABLE asteroid (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  safe BOOLEAN,
  diameter_km DECIMAL,
  diameter_m DECIMAL,
  distance_km DECIMAL,
  date DATE
);