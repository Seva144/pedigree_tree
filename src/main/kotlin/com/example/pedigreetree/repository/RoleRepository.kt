package com.example.pedigreetree.repository

import com.example.pedigreetree.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository: JpaRepository<Role, Long> {
}