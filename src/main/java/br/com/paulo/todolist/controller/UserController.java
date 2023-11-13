package br.com.paulo.todolist.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.paulo.todolist.model.UserModel;
import br.com.paulo.todolist.model.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired //gerenciar e instanciar
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) {
        var user = this.userRepository.findByUsername(userModel.getUsername());
        if(user != null) {
            //Status code http request
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já Existe");
        }
        
        // Hash Password
        var passwordHashred  = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(passwordHashred);

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
