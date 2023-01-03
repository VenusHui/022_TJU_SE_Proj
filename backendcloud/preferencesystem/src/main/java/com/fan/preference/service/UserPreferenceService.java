package com.fan.preference.service;

import com.fan.preference.pojo.Preference;
import com.fan.preference.utils.Response;

import java.util.Map;

public interface UserPreferenceService {
    public Response getAllUserPreferences();
    public Response getUserPreference(String preferenceId);
    public Response getUserPreferenceByUserId(Integer userId);
    public Response addUserPreference(Integer userId);
    public Response setReligion(String preferenceId, String religion);
    public Response setPreference(String preferenceId, Map<String, Object> preferenceMap);
    public Response addLikedDish(String preferenceId, String dishId);
    public Response addAteDishCommented(String preferenceId, String dishId);
    public Response addAteDishNotCommented(String preferenceId, String dishId);
    public Response addAllergen(String preferenceId, String ingredient);
    public Response deleteLikedDish(String preferenceId, String dishId);
    public Response deleteAteDishCommented(String preferenceId, String dishId);
    public Response deleteAteDishNotCommented(String preferenceId, String dishId);
    public Response deleteAllergen(String preferenceId, String ingredient);
}
