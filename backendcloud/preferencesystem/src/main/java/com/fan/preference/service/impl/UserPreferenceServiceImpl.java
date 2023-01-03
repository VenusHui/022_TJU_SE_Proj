package com.fan.preference.service.impl;

import com.fan.preference.pojo.Preference;
import com.fan.preference.service.UserPreferenceService;
import com.fan.preference.utils.Response;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2023/1/3 16:18
 * @version: 1.0
 */
public class UserPreferenceServiceImpl implements UserPreferenceService {

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
        return null;
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
