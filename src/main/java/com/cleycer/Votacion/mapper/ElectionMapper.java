package com.cleycer.Votacion.mapper;

import com.cleycer.Votacion.dto.ElectionResponseDto;
import com.cleycer.Votacion.model.Election;

public class ElectionMapper {
    private ElectionMapper() {
    }

    public static ElectionResponseDto toDto(Election election) {
        if (election == null) {
            return null;
        }
        Long codUserCreate = null;
        if (election.getUserCreateEntity() != null) {
            codUserCreate = election.getUserCreateEntity().getCodUser();
        } else if (election.getUserCreate() != null) {
            // fallback if getter returns Long
            Object val = election.getUserCreate();
            if (val instanceof Long) {
                codUserCreate = (Long) val;
            }
        }
        return new ElectionResponseDto(
                election.getCodElection(),
                election.getTitle(),
                election.getDescription(),
                election.getStartDate(),
                election.getEndDate(),
                election.getState(),
                election.getTimestamp(),
                codUserCreate
        );
    }
}
