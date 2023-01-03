package com.fan.preference.repository;

import com.fan.preference.pojo.UserPreference;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserPreferenceRepository extends MongoRepository<UserPreference, String> {
}
