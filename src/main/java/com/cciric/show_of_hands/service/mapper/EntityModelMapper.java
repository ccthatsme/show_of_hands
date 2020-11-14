package com.cciric.show_of_hands.service.mapper;


public interface EntityModelMapper<E,M> {

    M entityToModel(E entity);

    E modelToEntity(M model);
}
