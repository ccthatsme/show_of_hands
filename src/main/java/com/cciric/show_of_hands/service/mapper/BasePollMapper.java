package com.cciric.show_of_hands.service.mapper;

import com.cciric.show_of_hands.data.entity.BasePollEntity;
import com.cciric.show_of_hands.data.entity.ThreeChoicePollEntity;
import com.cciric.show_of_hands.models.BasePoll;
import com.cciric.show_of_hands.models.ThreeChoicePoll;
import com.cciric.show_of_hands.models.User;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

//basepoll is abstract so really no need for this
//@Component
//public class BasePollMapper implements EntityModelMapper<BasePollEntity, BasePoll> {
//    @Override
//    public BasePoll entityToModel(BasePollEntity entity) {
////        Assert.notNull(entity, "entity is null");
////        BasePoll bp = new BasePoll();
////
////        user.setId(entity.getId());
////        user.setEmail(entity.getEmail());
////        user.setPassword(entity.getPassword());
////        user.setUserName(entity.getUserName());
////
////        return user;
//    }
//
//    @Override
//    public BasePollEntity modelToEntity(BasePoll model) {
//        return null;
//    }
//
//
//}
