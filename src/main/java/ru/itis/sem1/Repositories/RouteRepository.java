package ru.itis.sem1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.sem1.Models.Route;

public interface RouteRepository extends JpaRepository<Route, Integer>{
}
