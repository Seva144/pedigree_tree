package com.example.pedigreetree.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.security.core.GrantedAuthority
import javax.validation.constraints.Size;


@Entity
@Table(name = "t_user")
@NoArgsConstructor
open class User : UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    @Size(min=2, message = "Не меньше 5 знаков")
    private var username: String? = null

    @Size(min=2, message = "Не меньше 5 знаков")
    private var password: String? = null

    @Transient
    private var passwordConfirm: String? = null

    @ManyToMany(fetch = FetchType.EAGER)
    private var roles: MutableSet<Role> =  mutableSetOf()

    fun getId(): Long?{
        return id
    }

    fun setId(id: Long){
        this.id = id
    }

    override fun getUserName(): String? {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    fun setUsername(username: String){
        this.username = username
    }

    override fun getAuthorities(): MutableSet<Role> {
        return getRoles()
    }

    override fun getPassword(): String? {
        return password
    }

    fun setPassword(password: String){
        this.password = password
    }



    fun getPasswordConfirm(): String? {
        return passwordConfirm
    }

    fun setPasswordConfirm(passwordConfirm: String){
        this.passwordConfirm = passwordConfirm
    }

    fun getRoles(): MutableSet<Role>{
        return roles
    }


    fun setRoles(roles: MutableSet<Role>){
        this.roles = roles
    }
}