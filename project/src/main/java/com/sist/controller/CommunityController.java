package com.sist.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sist.service.CommunityService;
import com.sist.vo.CommunityVO;

@Controller
public class CommunityController {
	
	@Autowired
	private CommunityService service;
	
	@GetMapping("community/list.do")
	public String community_list()
	{
		return "community/list";
	}
	
	@GetMapping("community/insert.do")
	public String community_insert()
	{
		return "community/insert";
	}
	
	@PostMapping("community/insert_ok.do")
	   public String databoard_insert_ok(CommunityVO vo)
	   {
		   
		   List<MultipartFile> list=vo.getFiles();
		   if(list==null)//업로드가 안된 상태
		   {
			   vo.setFilename("");
			   vo.setFilesize("");
		   }
		   else// 업로드가 된 상태 a.jpg,b.jpg,c.jpg
		   {
			   String fn="";
			   String fs="";
			   for(MultipartFile mf:list)
			   {
				   String of=mf.getOriginalFilename();
				   fn+=of+","; // 데이터베이스 첨부
				   File file=new File("c:\\download\\"+of);//업로드
				   fs+=mf.getSize()+",";
				   try
				   {
				      mf.transferTo(file);
				   }catch(Exception ex) {}
			   }
			   vo.setFilename(fn.substring(0,fn.lastIndexOf(",")));
			   vo.setFilesize(fs.substring(0,fs.lastIndexOf(",")));
		   }
		   service.communityInsert(vo);
		   return "redirect:list.do";//sendRedirect => request를 초기화 => 화면 이동 
	   }
	
	@GetMapping("community/detail.do")
	public String community_detail(int cno,Model model)
	{
		model.addAttribute("cno",cno);
		return "community/detail";
	}
	
	@GetMapping("community/update.do")
	public String community_update(int cno,Model model)
	{
		model.addAttribute("cno",cno);
		return "community/update";
	}
	
	@GetMapping("community/delete.do")
	public String community_delete(int cno,Model model)
	{
		model.addAttribute("cno",cno);
		return "community/delete";
	}
}
