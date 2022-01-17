package com.example.diagramma.services.impl;

import com.example.diagramma.dto.GroupDTO;
import com.example.diagramma.dto.SubjectDTO;
import com.example.diagramma.entities.GroupEntity;
import com.example.diagramma.entities.SubjectEntity;
import com.example.diagramma.repositories.GroupRepository;
import com.example.diagramma.repositories.SubjectRepository;
import com.example.diagramma.services.GroupService;
import com.example.diagramma.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    @Override
    public GroupEntity createGroup(GroupDTO groupDTO) {
        GroupEntity groupEntity = new GroupEntity(groupDTO);
        return groupRepository.save(groupEntity);
    }

    @Override
    public List<GroupDTO> getAllGroupDTO() {
        return groupRepository.findAll()
                .stream()
                .map(GroupDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteGroupById(Long id) {
        groupRepository.deleteById(id);
    }

    @Override
    public GroupDTO getGroupById(Long id) {
        return new GroupDTO(groupRepository.findGroupEntityById(id));
    }
}