package finalproject.semester4.webapi.controller;

import finalproject.semester4.webapi.exception.ResourceNotFoundException;
import finalproject.semester4.webapi.model.Device;
import finalproject.semester4.webapi.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by gerli on 16/05/2018.
 */
@RestController
@RequestMapping("/api")
public class DeviceController {

    @Autowired
    DeviceRepository deviceRepository;

    @GetMapping("/products")
    public List<Device> getAllProducts() {
        return deviceRepository.findAll();
    }

    @PostMapping("/products")
    public Device createProduct(@Valid @RequestBody Device device) {
        return deviceRepository.save(device);
    }



    @GetMapping("/products/{id}")
    public ResponseEntity<Device> getDevice(@PathVariable(value = "id") int id) {
        try {
            Device device = deviceRepository.findById(id);
            return ResponseEntity.ok(device);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "id") int id) {
        try {
            Device device = deviceRepository.findById(id);
            deviceRepository.delete(device);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
