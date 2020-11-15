package com.cciric.show_of_hands.service.mapper;

import com.cciric.show_of_hands.data.entity.ThreeChoicePollEntity;
import com.cciric.show_of_hands.models.ThreeChoicePoll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class ThreeChoicePollMapper implements EntityModelMapper<ThreeChoicePollEntity, ThreeChoicePoll> {

    @Autowired
    UserMapper um;

    @Override
    public ThreeChoicePoll entityToModel(ThreeChoicePollEntity entity) {
        Assert.notNull(entity, "entity is null");

        ThreeChoicePoll tc = new ThreeChoicePoll();

        tc.setId(entity.getId());
        tc.setQuestion(entity.getQuestion());
        tc.setUser(um.entityToModel(entity.getUser()));
        tc.setChoiceOne(entity.getChoiceOne());
        tc.setChoiceTwo(entity.getChoiceTwo());
        tc.setChoiceThree(entity.getChoiceThree());
        tc.setResultOne(entity.getResultOne());
        tc.setResultTwo(entity.getResultTwo());
        tc.setResultThree(entity.getResultThree());



        return tc;
    }

    @Override
    public ThreeChoicePollEntity modelToEntity(ThreeChoicePoll model) {
        Assert.notNull(model, "entity is null");

        ThreeChoicePollEntity tc = new ThreeChoicePollEntity();

        tc.setId(model.getId());
        tc.setQuestion(model.getQuestion());
        tc.setUser(um.modelToEntity(model.getUser()));
        tc.setChoiceOne(model.getChoiceOne());
        tc.setChoiceTwo(model.getChoiceTwo());
        tc.setChoiceThree(model.getChoiceThree());
        tc.setResultOne(model.getResultOne());
        tc.setResultTwo(model.getResultTwo());
        tc.setResultThree(model.getResultThree());



        return tc;
    }
}
