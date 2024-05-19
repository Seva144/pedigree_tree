package com.example.pedigreetree.controller

import com.example.pedigreetree.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam

@Controller
class AdminController(private val userService: UserService) {

    @GetMapping("/admin")
    fun userList(model: Model): String {
        model.addAttribute("allUsers", userService.allUsers())
        return "admin"
    }

    @PostMapping("/admin")
    fun deleteUser(
        @RequestParam(required = true, defaultValue = "") userId: Long,
        @RequestParam(required = true, defaultValue = "") action: String
    ) : String {
        if (action == ("delete")) {
            userService.deleteUser(userId)
        }
        return "redirect:/admin"
    }

    @GetMapping("/admin/get/{userId}")
    fun getUser (@PathVariable("userId") userId: Long, model: Model) : String{
        return "admin"
    }

}