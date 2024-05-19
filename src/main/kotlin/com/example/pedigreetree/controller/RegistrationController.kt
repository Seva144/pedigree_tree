package com.example.pedigreetree.controller

import com.example.pedigreetree.entity.User
import com.example.pedigreetree.service.UserService
import org.springframework.ui.Model
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import javax.validation.Valid

@Controller
class RegistrationController(private val userService: UserService) {

    @GetMapping("/registration")
    fun registration(model: Model){
        model.addAttribute("userForm", User())
    }

    @PostMapping
    fun addUser(@ModelAttribute("userForm") @Valid userForm: User,
                bindingResult: BindingResult, model: Model) : String{
        if(bindingResult.hasErrors()) {
            return "registration"
        }
        if(userForm.password != userForm.getPasswordConfirm()){
            model.addAttribute("passwordError", "Пароли не совпадают")
            return "regitsration"
        }
        if(!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует")
            return "regitsration"
        }
        return "redirect:/"
    }

}