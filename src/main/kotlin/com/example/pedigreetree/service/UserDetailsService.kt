package com.example.pedigreetree.service

interface UserDetailsService {

    fun loadUserByUsername(username: String): UserDetails

}