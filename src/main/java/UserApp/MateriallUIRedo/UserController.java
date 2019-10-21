package UserApp.MateriallUIRedo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *  @author Adam Renak
 */

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class UserController {

    @Autowired
    private UserRepository repo;

    
    /** 
     * @return Iterable<User>
     */
    @GetMapping("/user")
    public Iterable<User> getAllUsers() {
        return repo.findAll();
    }

    
    /** 
     * @param id
     * @return User
     */
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        Optional<User> user = repo.findById(id);
        if (id == -1) {
            User newUser = new User();
            return newUser;
        }
        
        if (user == null) {
            return null;
        }

        return user.get();
    }

    
    /** 
     * @param id
     * @return User
     */
    @DeleteMapping("/user/{id}")
    public User deleteUser(@PathVariable Long id) {
        Optional<User> user = repo.findById(id);
        if (user == null) {
            return null;
        }
            
        repo.delete(user.get());
        return user.get();  
    } 

    
    /** 
     * @param user
     * @return User
     */
    @PutMapping("user/{id}")
    public User updateUser(@RequestBody User user) {
        User updatedUser = repo.save(user);
        return updatedUser;
    }

    
    /** 
     * @param user
     * @return User
     */
    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        if (user == null) {
            return null;
        }

        User createdUser = repo.save(user);
        return createdUser;
    }
}