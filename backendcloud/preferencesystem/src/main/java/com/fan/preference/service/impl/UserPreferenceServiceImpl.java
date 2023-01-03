package com.fan.preference.service.impl;

import com.fan.preference.pojo.Preference;
import com.fan.preference.service.UserPreferenceService;
import com.fan.preference.utils.Response;
import org.springframework.stereotype.Service;

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
    public Response getUserPreference(String userPreferenceId) {
        return null;
    }

    @Override
    public Response getUserPreferenceByUserId(Integer userId) {
        return null;
    }

    @Override
    public Response setReligion(String userPreferenceId, String religion) {
        return null;
    }

    @Override
    public Response setPreference(String userPreferenceId, Preference preference) {
        return null;
    }

    @Override
    public Response addLikedDish(String userPreferenceId, String dishId) {
        return null;
    }

    @Override
    public Response addAteDishCommented(String userPreferenceId, String dishId) {
        return null;
    }

    @Override
    public Response addAteDishNotCommented(String userPreferenceId, String dishId) {
        return null;
    }

    @Override
    public Response addAllergen(String userPreferenceId, String ingredient) {
        return null;
    }

    @Override
    public Response deleteAteDishCommented(String userPreferenceId, String dishId) {
        return null;
    }

    @Override
    public Response deleteAteDishNotCommented(String userPreferenceId, String dishId) {
        return null;
    }

    @Override
    public Response deleteAllergen(String userPreferenceId, String ingredient) {
        return null;
    }
}
