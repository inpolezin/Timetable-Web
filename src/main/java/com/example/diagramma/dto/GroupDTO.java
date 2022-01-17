package com.example.diagramma.dto;

import com.example.diagramma.entities.GroupEntity;
import com.example.diagramma.entities.SubjectEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GroupDTO {
    private Long id;
    private String name;

    public GroupDTO(GroupEntity groupEntity) {
        fromGroupEntity(groupEntity);
    }

    public void fromGroupEntity(GroupEntity groupEntity) {
        this.id = groupEntity.getId();
        this.name = groupEntity.getGroupName();
    }
}
