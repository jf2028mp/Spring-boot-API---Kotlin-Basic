package com.example.drop.services

import com.example.drop.models.User

interface UserService {
    fun getUsers():List<User>
    fun getUserById(id:Long):User
    fun deleteUser(id:Long)
    fun saveUser(user:User)
    fun updateUser(user:User)
}