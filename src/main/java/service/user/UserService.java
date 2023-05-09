package service.user;

import data.UserRepository;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository _userREpository;
    public String createUser(CreateUserRequest request){
        var user = new User(request.name, request.email, request.password);

       _userREpository.save(user);

        return user.getId().toString();
    }

}
