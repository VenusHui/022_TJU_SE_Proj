package com.fan.preference.service.utils.assembler;

import com.fan.preference.pojo.UserPreference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
/**
 * @author: VenusHui
 * @description: TODO
 * @date: 2023/1/3 16:18
 * @version: 1.0
 */
public class UserPreferenceModelAssembler implements RepresentationModelAssembler<UserPreference, EntityModel<UserPreference>> {
    @Override
    public EntityModel<UserPreference> toModel(UserPreference userPreference) {
        return EntityModel.of(userPreference);
    }

    public CollectionModel<EntityModel<UserPreference>> toCollectionModel(List<UserPreference> userPreferenceList) {
        List<EntityModel<UserPreference>> userPreferences = userPreferenceList.stream()
                .map(this::toModel).toList();
        return CollectionModel.of(userPreferences);
    }
}
