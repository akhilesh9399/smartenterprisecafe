package corporate.Scafe.controller;
import corporate.Scafe.dto.FloorRequest;
import corporate.Scafe.dto.KitchenRequest;
import corporate.Scafe.dto.LocationRequest;
import corporate.Scafe.dto.TowerRequest;
import corporate.Scafe.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/manager")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping("/location")
    public String createLocation(
            @RequestBody LocationRequest request) {

        return locationService.createLocation(request);
    }

    @PostMapping("/tower")
    public String createTower(
            @RequestBody TowerRequest request) {

        return locationService.createTower(request);
    }

    @PostMapping("/floor")
    public String createFloor(
            @RequestBody FloorRequest request) {

        return locationService.createFloor(request);
    }

    @PostMapping("/kitchen")
    public String createKitchen(
            @RequestBody KitchenRequest request) {

        return locationService.createKitchen(request);
    }
}