package com.cciric.show_of_hands.controller;

import com.cciric.show_of_hands.data.entity.BasePollEntity;
import com.cciric.show_of_hands.data.entity.FourChoicePollEntity;
import com.cciric.show_of_hands.data.entity.ThreeChoicePollEntity;
import com.cciric.show_of_hands.data.entity.UserEntity;
import com.cciric.show_of_hands.models.BasePoll;
import com.cciric.show_of_hands.service.service.PollService;
import com.cciric.show_of_hands.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping(value = "/polls")
public class PollController {

    @Autowired
    private PollService pollService;

    @GetMapping(value = "/all_surveys")
    public List<BasePoll> getAllPollsForUser(@RequestBody UserEntity entity){
        return pollService.getAllPollsForUser(entity);
    }

//    @GetMapping(value = "/{id}")
    @GetMapping
    public BasePoll getPoll( @RequestParam("surveyId") int id){
        return pollService.getPoll(id);
    }

    @PostMapping
    public BasePoll createPollBase(@RequestBody BasePollEntity entity){
        return pollService.createPoll(entity);
    }

    @PostMapping(value = "/threepoll")
    public BasePoll createPollThreeChoice(@RequestBody ThreeChoicePollEntity entity){
        return pollService.createPoll(entity);
    }

    @PostMapping(value = "/fourpoll")
    public BasePoll createPollFourChoice(@RequestBody FourChoicePollEntity entity){
        return pollService.createPoll(entity);
    }

}
