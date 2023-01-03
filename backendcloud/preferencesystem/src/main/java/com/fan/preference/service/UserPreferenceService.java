package com.fan.preference.service;

import com.fan.preference.pojo.Preference;
import com.fan.preference.utils.Response;

public interface UserPreferenceService {
    public Response getAllUserPreferences();
    public Response getUserPreference(String userPreferenceId);
    public Response getUserPreferenceByUserId(Integer userId);
    public Response setReligion(String userPreferenceId, String religion);
    public Response setPreference(String userPreferenceId, Preference preference);
    public Response addLikedDish(String userPreferenceId, String dishId);
    public Response addAteDishCommented(String userPreferenceId, String dishId);
    public Response addAteDishNotCommented(String userPreferenceId, String dishId);
    public Response addAllergen(String userPreferenceId, String ingredient);
    public Response deleteAteDishCommented(String userPreferenceId, String dishId);
    public Response deleteAteDishNotCommented(String userPreferenceId, String dishId);
    public Response deleteAllergen(String userPreferenceId, String ingredient);
}
