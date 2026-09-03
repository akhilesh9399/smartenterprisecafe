package corporate.Scafe.service;


import corporate.Scafe.dto.FloorRequest;
import corporate.Scafe.dto.KitchenRequest;
import corporate.Scafe.dto.LocationRequest;
import corporate.Scafe.dto.TowerRequest;

public interface LocationService {

    String createLocation(LocationRequest request);

    String createTower(TowerRequest request);

    String createFloor(FloorRequest request);

    String createKitchen(KitchenRequest request);
}