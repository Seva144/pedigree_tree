package com.example.pedigreetree.entity

interface GrantedAuthority {

    fun getAuthority(): String?
}