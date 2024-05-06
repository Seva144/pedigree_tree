package com.example.pedigreetree.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import lombok.AllArgsConstructor
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "t_role")
open class Role() : GrantedAuthority {
    @Id
    private var id: Long? = null

    private var name: String? = null

    @Transient
    @ManyToMany(mappedBy = "roles")
    val users: MutableSet<User> = mutableSetOf()

    constructor(id: Long?) : this() {
        this.id = id
    }

    constructor(id: Long?, name: String?) : this() {
        this.id = id
        this.name = name
    }

    override fun getAuthority(): String? {
        return name
    }

    fun getId(): Long?{
        return id
    }

    fun setId(id: Long) {
        this.id=id
    }

    fun getName(): String?{
        return name
    }

    fun setName(name: String){
        this.name = name
    }




}