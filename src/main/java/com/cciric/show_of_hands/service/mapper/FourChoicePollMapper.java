package com.cciric.show_of_hands.service.mapper;

import com.cciric.show_of_hands.data.entity.FourChoicePollEntity;
import com.cciric.show_of_hands.data.entity.ThreeChoicePollEntity;
import com.cciric.show_of_hands.models.FourChoicePoll;
import com.cciric.show_of_hands.models.ThreeChoicePoll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class FourChoicePollMapper implements EntityModelMapper<FourChoicePollEntity, FourChoicePoll>{
    @Autowired
    UserMapper um;

    @Override
    public FourChoicePoll entityToModel(FourChoicePollEntity entity) {
        Assert.notNull(entity, "entity is null");

        FourChoicePoll fc = new FourChoicePoll();

        fc.setId(entity.getId());
        fc.setQuestion(entity.getQuestion());
        fc.setUser(um.entityToModel(entity.getUser()));
        fc.setChoiceOne(entity.getChoiceOne());
        fc.setChoiceTwo(entity.getChoiceTwo());
        fc.setChoiceThree(entity.getChoiceThree());
        fc.setChoiceFour(entity.getChoiceFour());
        fc.setResultOne(entity.getResultOne());
        fc.setResultTwo(entity.getResultTwo());
        fc.setResultThree(entity.getResultThree());
        fc.setResultFour(entity.getResultFour());

        return fc;
    }

    @Override
    public FourChoicePollEntity modelToEntity(FourChoicePoll model) {
        Assert.notNull(model, "entity is null");

        FourChoicePollEntity fc = new FourChoicePollEntity();

        fc.setId(model.getId());
        fc.setQuestion(model.getQuestion());
        //fc.setUser(model.getUser());
        fc.setChoiceOne(model.getChoiceOne());
        fc.setChoiceTwo(model.getChoiceTwo());
        fc.setChoiceThree(model.getChoiceThree());
        fc.setChoiceFour(model.getChoiceFour());
        fc.setResultOne(model.getResultOne());
        fc.setResultTwo(model.getResultTwo());
        fc.setResultThree(model.getResultThree());
        fc.setResultFour(model.getResultFour());

        return fc;
    }
}
