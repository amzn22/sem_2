package ru.itis.sem1.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;
import ru.itis.sem1.Models.DestinationPoint;
import ru.itis.sem1.Models.Route;
import ru.itis.sem1.Repositories.DestinationPointRepository;
import ru.itis.sem1.Repositories.RouteRepository;

import java.util.Optional;

@RestController
public class RouteRestController {

    @Autowired
    RouteRepository routeRepository;
    @Autowired
    DestinationPointRepository destinationPointRepository;

    @PostMapping("/rest/route")
    public ResponseEntity addNewRoute(@RequestParam String dp1SN, @RequestParam String dp2SN,
                                      @RequestParam Integer distance, @RequestParam Integer cost,
                                      Model model) {
        Route route = new Route();
        Route route_example = new Route();
        Optional<DestinationPoint> dp1 = destinationPointRepository.findDestinationPointByShortName(dp1SN);
        Optional<DestinationPoint> dp2 = destinationPointRepository.findDestinationPointByShortName(dp2SN);

        dp1.ifPresent(route_example::setDp1);
        dp2.ifPresent(route_example::setDp2);
        Example<Route> example = Example.of(route_example);
        Optional<Route> existing_route = routeRepository.findOne(example);
        if (dp1.isEmpty() || dp2.isEmpty()) {
            if(dp1.isEmpty()) model.addAttribute("dp1", dp1SN);
            if(dp2.isEmpty()) model.addAttribute("dp2", dp2SN);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if(existing_route.isPresent()) {
            model.addAttribute("exist_route", true);
            return ResponseEntity.status(HttpStatus.FOUND).build();
        } else {
            route.setDp1(dp1.get());
            route.setDp2(dp2.get());
            route.setDistance(distance);
            route.setCost(cost);
            return ResponseEntity.ok(routeRepository.save(route));
        }
    }

    @GetMapping("/rest/route")
    public ResponseEntity getAllRoutes() {
        return ResponseEntity.ok(routeRepository.findAll());
    }
    @GetMapping("/rest/route/{id}")
    public ResponseEntity getRoute(@PathVariable Integer id) {
        return ResponseEntity.ok(routeRepository.findOneById(id));

    }
    @DeleteMapping("/rest/route/{id}")
    public ResponseEntity deleteDestinationPoint(@PathVariable Integer id) {
        routeRepository.deleteById(id);
        Route route = routeRepository.findOneById(id);
        if (route == null) return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
