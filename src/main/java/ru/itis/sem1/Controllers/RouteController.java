package ru.itis.sem1.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.sem1.Models.DestinationPoint;
import ru.itis.sem1.Models.Route;
import ru.itis.sem1.Repositories.DestinationPointRepository;
import ru.itis.sem1.Repositories.RouteRepository;

import java.util.Optional;

@Controller
@RequestMapping(path="/route")
public class RouteController {

    @Autowired
    RouteRepository routeRepository;
    @Autowired
    DestinationPointRepository destinationPointRepository;

    @PostMapping("/add")
    public String addNewRoute(@RequestParam String dp1SN, @RequestParam String dp2SN,
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
            return "adminpanel";
        }
        if(existing_route.isPresent()) {
            model.addAttribute("exist_route", true);
        } else {
            route.setDp1(dp1.get());
            route.setDp2(dp2.get());
            route.setDistance(distance);
            route.setCost(cost);
            routeRepository.save(route);
            model.addAttribute("success_route", true);
        }
        return "adminpanel";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Route> getAllRoutes() {
        return routeRepository.findAll();
    }
}
