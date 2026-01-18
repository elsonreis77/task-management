package com.elsonreis.task_management.controller;

import com.elsonreis.task_management.entity.User;
import com.elsonreis.task_management.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ===============================
 * CONTROLLER: UserController
 * ===============================
 *
 * Esta classe expõe endpoints HTTP relacionados a usuários.
 * Ela recebe requisições REST (JSON) e devolve respostas REST (JSON).
 */
@RestController // Indica que esta classe é um controller REST
@RequestMapping("/users") // Prefixo base da URL
public class UserController {

    private final UserService userService;

    /**
     * Injeção de dependência do UserService.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * ===============================
     * POST /users
     * ===============================
     *
     * Cria um novo usuário.
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User createdUser = userService.createUser(user);

        // Retorna HTTP 201 (Created) + usuário criado no corpo
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    /**
     * ===============================
     * GET /users
     * ===============================
     *
     * Retorna todos os usuários.
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = userService.getAllUsers();

        return ResponseEntity.ok(users); // HTTP 200
    }

    /**
     * ===============================
     * GET /users/{id}
     * ===============================
     *
     * Busca um usuário pelo ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {

        User user = userService.getUserById(id);

        return ResponseEntity.ok(user);
    }

    /**
     * ===============================
     * DELETE /users/{id}
     * ===============================
     *
     * Remove um usuário.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        // Retorna HTTP 204 (No Content)
        return ResponseEntity.noContent().build();
    }
}