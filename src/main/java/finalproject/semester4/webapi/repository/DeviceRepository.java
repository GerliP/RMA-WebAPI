package finalproject.semester4.webapi.repository;

import finalproject.semester4.webapi.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by gerli on 16/05/2018.
 */
public interface DeviceRepository extends JpaRepository<Device, Integer> {

    Device findById(int id);
    Device findByProductId(String productId);

}
