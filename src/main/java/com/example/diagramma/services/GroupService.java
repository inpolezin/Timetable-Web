package com.example.diagramma.services;


import com.example.diagramma.dto.GroupDTO;
import com.example.diagramma.dto.SubjectDTO;
import com.example.diagramma.entities.GroupEntity;
import com.example.diagramma.entities.SubjectEntity;

import java.util.List;

public interface GroupService {
    GroupEntity createGroup(GroupDTO groupDTO);
    List<GroupDTO> getAllGroupDTO();
    void deleteGroupById(Long id);
    GroupDTO getGroupById(Long id);

}
