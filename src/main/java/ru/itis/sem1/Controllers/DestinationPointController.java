package ru.itis.sem1.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.sem1.Models.DestinationPoint;
import ru.itis.sem1.Repositories.DestinationPointRepository;

import java.util.Optional;

@Controller
@RequestMapping(path="/dest-point")
public class DestinationPointController {
    @Autowired
    private DestinationPointRepository destinationPointRepository;

    @PostMapping("/add")
    public String addNewDestinationPoint(@RequestParam String name, @RequestParam String shortName,
                                         Model model) {
        if (shortName.length() != 3) {
            model.addAttribute("wrongLength", true);
            return "adminpanel";
        }
        DestinationPoint dp = new DestinationPoint();
        DestinationPoint dp_example = new DestinationPoint();
        dp_example.setShortName(shortName);
        Example<DestinationPoint> example = Example.of(dp_example);
        Optional<DestinationPoint> existing_dp = destinationPointRepository.findOne(example);
        if(existing_dp.isPresent()) {
            model.addAttribute("exist", true);
        } else {
            dp.setName(name);
            dp.setShortName(shortName);
            destinationPointRepository.save(dp);
            model.addAttribute("success", true);
        }
        System.out.println(model.getAttribute("success"));
        return "adminpanel";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<DestinationPoint> getAllDestinationPoints() {
        return destinationPointRepository.findAll();
    }
}
