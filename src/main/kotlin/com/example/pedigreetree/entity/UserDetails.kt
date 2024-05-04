package com.example.pedigreetree.entity

import org.springframework.security.core.GrantedAuthority

interface UserDetails {

    fun getUserName(): String?

    fun isAccountNonExpired(): Boolean

    fun isAccountNonLocked(): Boolean

    fun isCredentialsNonExpired(): Boolean

    fun isEnabled(): Boolean

    fun getAuthorities(): MutableSet<Role>

    fun getPassword(): String?






}