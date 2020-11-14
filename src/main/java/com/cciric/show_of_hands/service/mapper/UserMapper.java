package com.cciric.show_of_hands.service.mapper;

import com.cciric.show_of_hands.data.entity.UserEntity;
import com.cciric.show_of_hands.models.User;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class UserMapper implements EntityModelMapper<UserEntity, User> {
    @Override
    public User entityToModel(UserEntity entity) {
        Assert.notNull(entity, "entity is null");
        User user = new User();

        user.setId(entity.getId());
        user.setEmail(entity.getEmail());
        user.setPassword(entity.getPassword());
        user.setUserName(entity.getUserName());

        return user;
    }

    @Override
    public UserEntity modelToEntity(User model) {
        Assert.notNull(model, "entity is null");
        UserEntity user = new UserEntity();

        user.setId(model.getId());
        user.setEmail(model.getEmail());
        user.setPassword(model.getPassword());
        user.setUserName(model.getUserName());

        return user;
    }
}
