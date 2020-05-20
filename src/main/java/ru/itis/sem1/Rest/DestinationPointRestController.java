package ru.itis.sem1.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.sem1.Models.DestinationPoint;
import ru.itis.sem1.Repositories.DestinationPointRepository;
import springfox.documentation.service.ResponseMessage;

import java.util.Optional;

@RestController
public class DestinationPointRestController {
    @Autowired
    private DestinationPointRepository destinationPointRepository;

    @PostMapping("/rest/dest-point")
    public ResponseEntity addNewDestinationPoint(@RequestParam String name, @RequestParam String shortName,
                                                  Model model) {
        if (shortName.length() != 3) {
            model.addAttribute("wrongLength", true);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        DestinationPoint dp = new DestinationPoint();
        DestinationPoint dp_example = new DestinationPoint();
        dp_example.setShortName(shortName);
        Example<DestinationPoint> example = Example.of(dp_example);
        Optional<DestinationPoint> existing_dp = destinationPointRepository.findOne(example);
        if(existing_dp.isPresent()) {
            model.addAttribute("exist", true);
            return ResponseEntity.status(HttpStatus.FOUND).build();
        } else {
            dp.setName(name);
            dp.setShortName(shortName);
            dp = destinationPointRepository.save(dp);
            model.addAttribute("success", true);
        }
        System.out.println(model.getAttribute("success"));
        return ResponseEntity.ok(dp);
    }

    @GetMapping("/rest/dest-point")
    public ResponseEntity getAllDestinationPoints() {
        return ResponseEntity.ok(destinationPointRepository.findAll());
    }
    @GetMapping("/rest/dest-point/{id}")
    public ResponseEntity getDestinationPoint(@PathVariable Integer id) {
        return ResponseEntity.ok(destinationPointRepository.findOneById(id));

    }
    @DeleteMapping("/rest/dest-point/{id}")
    public ResponseEntity deleteDestinationPoint(@PathVariable Integer id) {
        destinationPointRepository.deleteById(id);
        DestinationPoint dp = destinationPointRepository.findOneById(id);
        if (dp == null) return ResponseEntity.status(HttpStatus.ACCEPTED).build();
            else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
