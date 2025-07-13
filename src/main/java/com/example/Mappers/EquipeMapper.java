package com.example.Mappers;

import com.example.entite.Equipe;
import com.example.entite.EquipeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EquipeMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "ville", target = "ville")
    EquipeDto toDto(Equipe match);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "ville", target = "ville")
    Equipe toEntity(EquipeDto dto);

}
