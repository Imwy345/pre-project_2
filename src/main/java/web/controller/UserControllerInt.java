package web.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import web.model.User;

import javax.validation.Valid;

public interface UserControllerInt {
    String allUsers(Model model);

    String getUser(int id, Model model);

    String addUser(User user);

    String add(User user, BindingResult bindingResult);

    String updateUser(int id, Model model);

    String update(User user, BindingResult bindingResult);
    String delete( int id);
}
