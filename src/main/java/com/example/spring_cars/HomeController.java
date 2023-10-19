package com.example.spring_cars;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/") // This method shows the start page
    public String getHome(Model model){

        // Connect to the db
        Database db = new Database();

        // Get all cars from database
        List<Car> cars = db.getCars();

        // Send cars to template
        model.addAttribute("cars", cars);

        // Show home template
        return "home";
    }

    @PostMapping("/")
    public String postHome(String make, String model, int year){
        Car car = new Car(make, model, year);

        Database db = new Database();

        db.saveCar(car);
        return "redirect:/";
    }
}
