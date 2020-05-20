package ru.itis.sem1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.sem1.Models.DestinationPoint;

import java.util.Optional;

public interface DestinationPointRepository extends JpaRepository<DestinationPoint, Integer>{
    Optional<DestinationPoint> findDestinationPointByShortName(String shortName);

    DestinationPoint findOneById(Integer id);
}
