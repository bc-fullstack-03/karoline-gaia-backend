package api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.user.CreateUserRequest;
import service.user.IUserService;

@RestController
public class UserController {
    private IUserService _userService;
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest request){
        if (request.name.length() < 3){
            return ResponseEntity.unprocessableEntity().body("Invalid user");
        }
        var response = _userService.createUser(request);

        return ResponseEntity.ok().body(response);
    }

}
