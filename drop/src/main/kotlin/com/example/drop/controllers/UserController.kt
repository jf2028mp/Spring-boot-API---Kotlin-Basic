package com.example.drop.controllers

import com.example.drop.models.User
import com.example.drop.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/api/users")
class UserController(private val userService: UserService){
    @GetMapping
    fun getUsers():List<User> = userService.getUsers()

    @GetMapping("/{id}")
    fun getById(@PathVariable id:Long):User = userService.getUserById(id)

    @PutMapping
    fun updateUser(@RequestBody user:User) = userService.updateUser(user)

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id:Long) = userService.deleteUser(id);

    @PostMapping
    fun saveUser(@RequestBody user:User) = userService.saveUser(user)
}