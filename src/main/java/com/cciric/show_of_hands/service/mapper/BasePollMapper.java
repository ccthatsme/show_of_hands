package com.cciric.show_of_hands.service.mapper;

import com.cciric.show_of_hands.data.entity.BasePollEntity;
import com.cciric.show_of_hands.data.entity.ThreeChoicePollEntity;
import com.cciric.show_of_hands.models.BasePoll;
import com.cciric.show_of_hands.models.ThreeChoicePoll;
import com.cciric.show_of_hands.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

//basepoll is abstract so really no need for this
@Component
public class BasePollMapper implements EntityModelMapper<BasePollEntity, BasePoll> {
   @Autowired
   UserMapper userMapper;

    @Override
    public BasePoll entityToModel(BasePollEntity entity) {
        Assert.notNull(entity, "entity is null");
        BasePoll bp = new BasePoll();

        bp.setId(entity.getId());
        bp.setQuestion(entity.getQuestion());
        bp.setChoiceOne(entity.getChoiceOne());
        bp.setResultOne(entity.getResultOne());
        bp.setUser(userMapper.entityToModel(entity.getUser()));

        return bp;
    }

    @Override
    public BasePollEntity modelToEntity(BasePoll model) {
        Assert.notNull(model, "entity is null");
        BasePollEntity bp = new BasePollEntity();

        bp.setId(model.getId());
        bp.setQuestion(model.getQuestion());
        bp.setChoiceOne(model.getChoiceOne());
        bp.setResultOne(model.getResultOne());
        bp.setUser(userMapper.modelToEntity(model.getUser()));

        return bp;
    }


}
