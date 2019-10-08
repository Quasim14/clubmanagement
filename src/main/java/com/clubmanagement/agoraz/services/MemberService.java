package com.clubmanagement.agoraz.services;

import com.clubmanagement.agoraz.dto.MemberDTO;

import java.util.List;

public interface MemberService {
     List<MemberDTO> getAllMember();
     MemberDTO getMemberById(int id);
     MemberDTO addMember(MemberDTO memberDTO);
     MemberDTO updateMember(int id, MemberDTO memberDTO);
     boolean deleteMemberById(int id);
}
