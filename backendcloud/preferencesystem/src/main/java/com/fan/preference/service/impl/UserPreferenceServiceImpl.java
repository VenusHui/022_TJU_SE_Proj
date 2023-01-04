package com.fan.preference.service.impl;

import com.fan.preference.pojo.Preference;
import com.fan.preference.pojo.UserPreference;
import com.fan.preference.repository.UserPreferenceRepository;
import com.fan.preference.service.UserPreferenceService;
import com.fan.preference.service.utils.assembler.UserPreferenceModelAssembler;
import com.fan.preference.utils.Response;
import com.fan.preference.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2023/1/3 16:18
 * @version: 1.0
 */
public class UserPreferenceServiceImpl implements UserPreferenceService {

    @Autowired
    private UserPreferenceRepository userPreferenceRepository;

    private UserPreferenceModelAssembler userPreferenceModelAssembler;

    public UserPreferenceServiceImpl(UserPreferenceModelAssembler userPreferenceModelAssembler){
        this.userPreferenceModelAssembler = userPreferenceModelAssembler;
    }

    @Override
    public Response getAllUserPreferences() {
        return null;
    }

    @Override
    public Response getUserPreference(String preferenceId) {
        return null;
    }

    @Override
    public Response getUserPreferenceByUserId(Integer userId) {
        return null;
    }

    @Override
    public Response addUserPreference(Integer userId) {
        Preference preference = new Preference(1,1,1,1);
        UserPreference userPreference = new UserPreference(null,userId,"华东",preference,null,null,null,null);
        userPreferenceRepository.insert(userPreference);
        Map<String,Object> data = new HashMap<>();
        data.put("preference",userPreferenceModelAssembler.toModel(userPreference));
        return new Response(ResponseCode.SUCCESS,"添加用户偏好信息成功",data);
    }

    @Override
    public Response setReligion(String preferenceId, String religion) {
        return null;
    }

    @Override
    public Response setPreference(String preferenceId, Map<String, Object> preferenceMap) {
        return null;
    }

    @Override
    public Response addLikedDish(String preferenceId, String dishId) {
        return null;
    }

    @Override
    public Response addAteDishCommented(String preferenceId, String dishId) {
        return null;
    }

    @Override
    public Response addAteDishNotCommented(String preferenceId, String dishId) {
        return null;
    }

    @Override
    public Response addAllergen(String preferenceId, String ingredient) {
        return null;
    }

    @Override
    public Response deleteLikedDish(String preferenceId, String dishId) {
        return null;
    }

    @Override
    public Response deleteAteDishCommented(String preferenceId, String dishId) {
        return null;
    }

    @Override
    public Response deleteAteDishNotCommented(String preferenceId, String dishId) {
        return null;
    }

    @Override
    public Response deleteAllergen(String preferenceId, String ingredient) {
        return null;
    }
}
