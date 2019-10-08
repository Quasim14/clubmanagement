package com.clubmanagement.agoraz.controllers;

import com.clubmanagement.agoraz.dto.MemberDTO;
import com.clubmanagement.agoraz.services.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("member")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> getMembre(@PathVariable int id){
        MemberDTO memberDTO = memberService.getMemberById(id);
        if(memberDTO != null)
            return ResponseEntity.ok(memberDTO);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping()
    public ResponseEntity<List<MemberDTO>> getAll(){
        List<MemberDTO> memberDTOS = memberService.getAllMember();
        return ResponseEntity.ok(memberDTOS);
    }

    @PostMapping
    public MemberDTO createMember(@RequestBody MemberDTO memberDTO)
    {

        return memberService.addMember(memberDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MemberDTO> updateMember(@PathVariable int id, @RequestBody MemberDTO memberDTO)
    {
       MemberDTO mDTO= memberService.updateMember(id, memberDTO);

       if (mDTO!=null){
           return ResponseEntity.ok(mDTO);
       }else
           return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteMember(@PathVariable int id){
         return memberService.deleteMemberById(id);
    }

}
