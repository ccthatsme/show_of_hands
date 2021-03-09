package com.cciric.show_of_hands.service;

import com.cciric.show_of_hands.data.entity.UserEntity;
import com.cciric.show_of_hands.data.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@ComponentScan(basePackages = "com.cciric.show_of_hands")
public class UserDetailsServiceImpl  implements UserDetailsService {

    private UserRepo userRepo = new UserRepo() {
        @Override
        public UserEntity findByUserName(String userName) {
            return null;
        }

        @Override
        public List<UserEntity> findAll() {
            return null;
        }

        @Override
        public List<UserEntity> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<UserEntity> findAllById(Iterable<Integer> integers) {
            return null;
        }

        @Override
        public <S extends UserEntity> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends UserEntity> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public void deleteInBatch(Iterable<UserEntity> entities) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public UserEntity getOne(Integer integer) {
            return null;
        }

        @Override
        public <S extends UserEntity> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends UserEntity> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<UserEntity> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends UserEntity> S save(S s) {
            return null;
        }

        @Override
        public Optional<UserEntity> findById(Integer integer) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Integer integer) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Integer integer) {

        }

        @Override
        public void delete(UserEntity entity) {

        }

        @Override
        public void deleteAll(Iterable<? extends UserEntity> iterable) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends UserEntity> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends UserEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends UserEntity> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends UserEntity> boolean exists(Example<S> example) {
            return false;
        }
    };

//    @Autowired
//    public UserDetailsServiceImpl(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }

    public UserDetailsServiceImpl() {

    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //UserEntity applicationUser = userRepo.findByUserName(userName);
        UserEntity applicationUser = userRepo.getOne(3);
        if (applicationUser == null){
            throw new UsernameNotFoundException(userName);
        }

        return new User(applicationUser.getUserName(), applicationUser.getPassword(), Collections.emptyList());
    }
}
