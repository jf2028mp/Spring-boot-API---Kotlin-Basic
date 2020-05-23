package com.example.drop.services

import com.example.drop.models.User
import com.example.drop.repositories.UserRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {

    override fun getUsers(): List<User> = userRepository.findAll()

    override fun getUserById(id: Long): User = userRepository.findById(id).orElseThrow()

    override fun deleteUser(id: Long) {
        val user = userRepository.findById(id)
        userRepository.delete(user.orElseThrow())
    }

    @Transactional
    override fun saveUser(user: User) {
        userRepository.save(user)
    }

    @Transactional
    override fun updateUser(user: User) {
        val currentUser = userRepository.findById(user.id).orElseThrow()
        currentUser.apply {
            name = user.name
            email = user.email

        }?.let {
            userRepository.save(currentUser)
        }

    }


}