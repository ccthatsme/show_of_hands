package com.cciric.show_of_hands.service.service;

import com.cciric.show_of_hands.data.entity.BasePollEntity;
import com.cciric.show_of_hands.data.repository.BasePollRepo;
import com.cciric.show_of_hands.data.repository.FourPollRepo;
import com.cciric.show_of_hands.data.repository.ThreePollRepo;
import com.cciric.show_of_hands.models.BasePoll;
import com.cciric.show_of_hands.service.mapper.BasePollMapper;
import com.cciric.show_of_hands.service.mapper.FourChoicePollMapper;
import com.cciric.show_of_hands.service.mapper.ThreeChoicePollMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service("PollService")
public class PollService {

    @Autowired
    BasePollRepo basePollRepo;

    @Autowired
    ThreePollRepo threePollRepo;

    @Autowired
    FourPollRepo fourPollRepo;

    @Autowired
    ThreeChoicePollMapper threeChoicePollMapper;

    @Autowired
    FourChoicePollMapper fourChoicePollMapper;

    @Autowired
    BasePollMapper basePollMapper;


    public List<BasePoll> getAllPolls() {
        List<BasePollEntity> list = new ArrayList<>();
        List<BasePoll> modelList = new ArrayList<>();

        basePollRepo.findAll().stream().collect(Collectors.toList()).forEach(basePollEntity -> {
            modelList.add(basePollMapper.entityToModel(basePollEntity));
        });
        threePollRepo.findAll().stream().collect(Collectors.toList()).forEach(basePollEntity -> {
            modelList.add(threeChoicePollMapper.entityToModel(basePollEntity));
        });
        fourPollRepo.findAll().stream().collect(Collectors.toList()).forEach(basePollEntity -> {
            modelList.add(fourChoicePollMapper.entityToModel(basePollEntity));
        });
        //List<BasePollEntity> listThreePoll = threePollRepo.findAll().stream().collect(Collectors.toList());
        //List<BasePollEntity> listFourPoll = fourPollRepo.findAll().stream().collect(Collectors.toList());

       // List<BasePollEntity> newEntityList = Stream.of(listBasePoll, listThreePoll, listFourPoll).flatMap(Collection::stream).collect(Collectors.toList());

//        newEntityList.stream().forEach(basePollEntity -> {
//            modelList.add()
//        });

        return modelList;
    }
}
