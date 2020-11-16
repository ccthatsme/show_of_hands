package com.cciric.show_of_hands.controller;

import com.cciric.show_of_hands.models.BasePoll;
import com.cciric.show_of_hands.service.service.PollService;
import com.cciric.show_of_hands.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/polls")
public class PollController {

    @Autowired
    private PollService pollService;

    @GetMapping
    public List<BasePoll> getAllPolls(){
        return pollService.getAllPolls();
    }

}
