package com.clubmanagement.agoraz.services;


import com.clubmanagement.agoraz.dto.MemberDTO;
import com.clubmanagement.agoraz.models.Member;
import com.clubmanagement.agoraz.repositories.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MemberServiceImplementation implements MemberService {
    private MemberRepository repository;
    private ModelMapper modelMapper;

    public MemberServiceImplementation(MemberRepository repository, ModelMapper mapper){
        this.repository= repository;
        this.modelMapper= mapper;
    }

    @Override
    public List<MemberDTO> getAllMember() {
        List<Member> members = repository.findAll();
        List<MemberDTO> memberDTOS = new ArrayList<>();

        for(Member member : members){
            MemberDTO memberDTO= modelMapper.map(member, MemberDTO.class);
            memberDTOS.add(memberDTO);
        }

        return memberDTOS;
    }

    @Override
    public MemberDTO getMemberById(int id) {
        Member member = repository.findById(id).orElse(null);
        MemberDTO memberDTO = null;

        if(member !=null){
            memberDTO= modelMapper.map(member, MemberDTO.class);
        }
        return memberDTO;
    }

    @Override
    public MemberDTO addMember(MemberDTO memberDTO) {
        Member member = modelMapper.map(memberDTO, Member.class);
        Member member2= repository.save(member);
        memberDTO.setId(member2.getId());
        return memberDTO;
    }

    @Override
    public MemberDTO updateMember(int id, MemberDTO memberDTO) {
        try {
            Member member = repository.getOne(id);
            Member member2= modelMapper.map(memberDTO, Member.class);
            member.setEmail(member2.getEmail());
            member.setName(member2.getName());
            member.setLicence(member2.getLicence());
            member.setPhone(member2.getPhone());
            member.setStreet(member2.getStreet());
            repository.save(member);
            memberDTO.setId(id);
        } catch (Exception e){
            memberDTO = null;
        }

        return memberDTO;
    }

    @Override
    public boolean deleteMemberById(int id) {
        try {
            Member member = repository.getOne(id);
            repository.delete(member);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
