package com.example.pedigreetree.service

import com.example.pedigreetree.PedigreeTreeApplication
import com.example.pedigreetree.entity.Role
import com.example.pedigreetree.entity.User
import com.example.pedigreetree.repository.RoleRepository
import com.example.pedigreetree.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository
) : UserDetailsService {

    var bCryptPasswordEncoder = BCryptPasswordEncoder()

    override fun loadUserByUsername(username: String): User? {
        val user = userRepository.findByUsername(username)

        if (user != null) {
            throw UsernameNotFoundException("User $username not found")
        }
        return user
    }

    fun findUserById(id: Long): User {
        val userFromDb = userRepository.findById(id)
        return userFromDb.orElse(User())
    }

    fun allUsers(): List<User> {
        return userRepository.findAll()
    }

    fun saveUser(user: User): Boolean {
        val userFromDb = userRepository.findByUsername(user.username)
        if (userFromDb != null) {
            return false
        }
        user.setRoles(Collections.singleton(Role(1L, "ROLE_USER")))
        user.setPassword(bCryptPasswordEncoder.encode(user.password))
        userRepository.save(user)
        return true
    }
}