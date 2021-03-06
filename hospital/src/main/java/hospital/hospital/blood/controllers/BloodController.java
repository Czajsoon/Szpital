package hospital.hospital.blood.controllers;

import hospital.hospital.blood.entity.Blood;
import hospital.hospital.blood.models.BloodREQ;
import hospital.hospital.blood.models.BloodResults;
import hospital.hospital.blood.repository.BloodRepository;
import hospital.hospital.user.entity.User;
import hospital.hospital.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/blood")
public class BloodController {
    @Autowired
    private BloodRepository bloodRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> blood(@RequestBody BloodREQ req){
        Optional<User> user = userRepository.findById(req.getUser());
        if(user.isPresent()){
            Blood save = bloodRepository.save(Blood.of(req, user.get()));
            return ResponseEntity.ok(save);
        }
        else return ResponseEntity.ok("error");
    }

    //TODO zmienic dla uzytkownika ktory poda token!!!
    @GetMapping
    public ResponseEntity<BloodResults> blood(){
        User user = userRepository.getById(1L);//tutaj uzytkownik
        Blood blood = bloodRepository.max(user);
        if(blood != null){
            BloodResults results = new BloodResults();
            results = results.buildResults(blood,blood.getUser().getSex());
            return ResponseEntity.ok(results);
        }
        else return ResponseEntity.ok(null);
    }
}
