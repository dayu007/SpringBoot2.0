package firstweb.controller;

import firstweb.domain.User;
import firstweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/user/save")
    public User save(@RequestParam String name) {
        User user = new User();
        user.setName(name);

        if (repository.save(user)) {
            System.out.printf("用户对象：%s保存成功\n", user);
        }

        return user;
    }




}
