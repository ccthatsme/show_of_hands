package com.cciric.show_of_hands.service.service;

import com.cciric.show_of_hands.data.entity.BasePollEntity;
import com.cciric.show_of_hands.data.entity.FourChoicePollEntity;
import com.cciric.show_of_hands.data.entity.ThreeChoicePollEntity;
import com.cciric.show_of_hands.data.entity.UserEntity;
import com.cciric.show_of_hands.data.repository.BasePollRepo;
import com.cciric.show_of_hands.data.repository.FourPollRepo;
import com.cciric.show_of_hands.data.repository.ThreePollRepo;
import com.cciric.show_of_hands.models.BasePoll;
import com.cciric.show_of_hands.models.FourChoicePoll;
import com.cciric.show_of_hands.models.ThreeChoicePoll;
import com.cciric.show_of_hands.service.mapper.BasePollMapper;
import com.cciric.show_of_hands.service.mapper.FourChoicePollMapper;
import com.cciric.show_of_hands.service.mapper.ThreeChoicePollMapper;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
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

    private static final String[] resultArray = new String[]{"resultOne", "resultTwo", "resultThree", "resultFour"};


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

        return modelList;
    }

    public BasePoll createPoll(BasePollEntity entity) {

        basePollRepo.save(entity);
        return basePollMapper.entityToModel(entity);


    }

    public ThreeChoicePoll createPoll(ThreeChoicePollEntity entity) {

        threePollRepo.save(entity);
        return threeChoicePollMapper.entityToModel(entity);
    }

    public FourChoicePoll createPoll(FourChoicePollEntity entity) {

        fourPollRepo.save(entity);
        return fourChoicePollMapper.entityToModel(entity);
    }

    public BasePoll getPoll(int id) {
        ThreeChoicePollEntity entity = threePollRepo.getOne(id);

        return threeChoicePollMapper.entityToModel(entity);
    }

    public List<BasePoll> getAllPollsForUser(int id) {

        List<BasePollEntity> list = new ArrayList<>();
        List<BasePoll> modelList = new ArrayList<>();

//        basePollRepo.findAllByUser(entity.getId()).stream().collect(Collectors.toList()).forEach(basePollEntity -> {
//            modelList.add(basePollMapper.entityToModel(basePollEntity));
//        });
        threePollRepo.findAllByUserId(id).stream().collect(Collectors.toList()).forEach(basePollEntity -> {
            modelList.add(threeChoicePollMapper.entityToModel(basePollEntity));
        });
//        fourPollRepo.findAllByUser(entity.getId()).stream().collect(Collectors.toList()).forEach(basePollEntity -> {
//            modelList.add(fourChoicePollMapper.entityToModel(basePollEntity));
//        });

        return modelList;
    }

    public BasePoll recordChoiceThreePoll(ThreeChoicePollEntity entity) {
//        ThreeChoicePollEntity entityToUpdate = threePollRepo.getOne(entity.getId());
//        entityToUpdate.setResultOne(entity.getResultOne() + entityToUpdate.getResultOne());
//        entityToUpdate.setResultTwo(entity.getResultTwo() + entityToUpdate.getResultTwo());
//        entityToUpdate.setResultThree(entity.getResultThree() + entityToUpdate.getResultThree());
//
//        threePollRepo.saveAndFlush(entityToUpdate);

        return checkIfEntityDifferent(entity);

    };

    public BasePoll checkIfEntityDifferent(ThreeChoicePollEntity entity){

        Optional<ThreeChoicePollEntity> entityToUpdate = Optional.of(threePollRepo.findById(entity.getId()).get());

        String result = entityToUpdate.get().findDifferentResult(entity, entityToUpdate.get());

        System.out.println(entity.toString());
        System.out.println(entityToUpdate.toString());
        System.out.println(result);



        switch (result){
            case "resultOne":
                entityToUpdate.get().setResultOne(entity.getResultOne());
                threePollRepo.saveAndFlush(entityToUpdate.get());
                return threeChoicePollMapper.entityToModel(entityToUpdate.get());
            case "resultTwo":
                entityToUpdate.get().setResultTwo(entity.getResultTwo());
                threePollRepo.saveAndFlush(entityToUpdate.get());
                return threeChoicePollMapper.entityToModel(entityToUpdate.get());
            case "resultThree":
                entityToUpdate.get().setResultThree(entity.getResultThree());
                threePollRepo.saveAndFlush(entityToUpdate.get());
                return threeChoicePollMapper.entityToModel(entityToUpdate.get());

            default:
            return threeChoicePollMapper.entityToModel(entityToUpdate.get());

        }
    }
}
