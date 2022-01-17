package com.example.diagramma.entities;

import com.example.diagramma.dto.GroupDTO;
import com.example.diagramma.dto.SubjectDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data
@Table(name = "groups")
public class GroupEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "group_name")
    private String groupName;

    public GroupEntity(GroupDTO groupDTO) {
        fromGroupDTO(groupDTO);
    }

    public void fromGroupDTO(GroupDTO groupDTO) {
        this.groupName = groupDTO.getName();
    }
}
