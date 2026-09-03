package corporate.Scafe.serviceImpl;


import corporate.Scafe.dto.FloorRequest;
import corporate.Scafe.dto.KitchenRequest;
import corporate.Scafe.dto.LocationRequest;
import corporate.Scafe.dto.TowerRequest;
import corporate.Scafe.entity.Floor;
import corporate.Scafe.entity.Kitchen;
import corporate.Scafe.entity.Location;
import corporate.Scafe.entity.Tower;
import corporate.Scafe.exception.custom.ResourceNotFoundException;

import corporate.Scafe.repository.FloorRepository;
import corporate.Scafe.repository.KitchenRepository;
import corporate.Scafe.repository.LocationRepository;
import corporate.Scafe.repository.TowerRepository;
import corporate.Scafe.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final TowerRepository towerRepository;
    private final FloorRepository floorRepository;
    private final KitchenRepository kitchenRepository;

    @Override
    public String createLocation(LocationRequest request) {

        Location location = Location.builder()
                .cityName(request.getCityName())
                .active(true)
                .build();

        locationRepository.save(location);

        return "Location Created Successfully";
    }

    @Override
    public String createTower(TowerRequest request) {

        Location location = locationRepository
                .findById(request.getLocationId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Location Not Found"));

        Tower tower = Tower.builder()
                .towerName(request.getTowerName())
                .location(location)
                .active(true)
                .build();

        towerRepository.save(tower);

        return "Tower Created Successfully";
    }

    @Override
    public String createFloor(FloorRequest request) {

        Tower tower = towerRepository
                .findById(request.getTowerId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Tower Not Found"));

        Floor floor = Floor.builder()
                .floorNumber(request.getFloorNumber())
                .tower(tower)
                .active(true)
                .build();

        floorRepository.save(floor);

        return "Floor Created Successfully";
    }

    @Override
    public String createKitchen(KitchenRequest request) {

        Tower tower = towerRepository
                .findById(request.getTowerId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Tower Not Found"));

        Kitchen kitchen = Kitchen.builder()
                .kitchenName(request.getKitchenName())
                .tower(tower)
                .active(true)
                .build();

        kitchenRepository.save(kitchen);

        return "Kitchen Created Successfully";
    }
}