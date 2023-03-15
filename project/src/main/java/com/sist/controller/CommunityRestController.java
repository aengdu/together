package com.sist.controller;
import java.io.File;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.sist.service.*;

@RestController
public class CommunityRestController {
	@Autowired
	private CommunityService service;
	
	/*
	 * @Select("SELECT cno,hit,title,content,filesize,type,TO_CHAR(createdAt,'YYYY-MM-DD') as dbday,num "
			+"FROM (SELECT cno,hit,title,content,filesize,type,createdAt,rownum as num "
			+"FROM (SELECT /* +INDEX_DESC(pet_community_2_1 pc1_cno_pk)cno,hit,title,content,filesize,type,createdAt "
			+"FROM pet_community_2_1)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	 */
	@GetMapping(value="community/list_vue.do",produces = "text/plain;charset=UTF-8")
	 public String community_list(int page) 
	{
		Map map=new HashMap();
		map.put("start", (page*10)-9);
		map.put("end", page*10);
		List<CommunityVO> list=service.communityListData(map);
		int totalpage=service.communityTotalPage();
		
		JSONArray arr=new JSONArray();
		int i=0;
		for(CommunityVO vo:list)
		{
			JSONObject obj=new JSONObject();
			obj.put("cno", vo.getCno());
			obj.put("hit", vo.getHit());
			obj.put("title", vo.getTitle());
			obj.put("name", vo.getName());
			obj.put("dbday", vo.getDbday());
			if(i==0)
			{
				obj.put("curpage", page);
				obj.put("totalpage", totalpage);
			}
			arr.add(obj);
			i++;
		}
		return arr.toJSONString();
	}
	
	/*
	 * @GetMapping("community/insert_vue.do") public String
	 * community_insert(CommunityVO vo) { service.communityInsert(vo); return ""; }
	 */
	  
	  @GetMapping(value="community/detail_vue.do",produces = "text/plain;charset=UTF-8")
	  public String community_detail(int cno)
	  {
		  CommunityVO vo=service.communityDetailData(cno);
		  JSONObject obj=new JSONObject();
		  obj.put("cno", vo.getCno());
		  obj.put("title", vo.getTitle());
		  obj.put("name", vo.getName());
		  obj.put("dbday", vo.getDbday());
		  obj.put("hit", vo.getHit());
		  obj.put("content", vo.getContent());
		  obj.put("filesize", vo.getFilesize());
		  obj.put("filename", vo.getFilename());
		  return obj.toJSONString();
	  }
	  
	  @GetMapping(value="community/update_vue.do",produces = "text/plain;charset=UTF-8")
	  public String community_update(int cno)
	  {
		  CommunityVO vo=service.communityDetailData(cno);
		  JSONObject obj=new JSONObject();
		  obj.put("cno", vo.getCno());
		  obj.put("title", vo.getTitle());
		  obj.put("name", vo.getName());
		  obj.put("content", vo.getContent());
		  obj.put("filesize", vo.getFilesize());
		  obj.put("filename", vo.getFilename());
		  return obj.toJSONString();
	  }
	  
	  @GetMapping("community/update_ok_vue.do")
	  public String community_update_ok(CommunityVO vo)
	  {
		  String res=service.communityUpdate(vo);
		  return res;
	  }
	  
	  @GetMapping("community/community_delete_vue.do")
	  public String community_delete_ok(int cno,String pwd)
	  {
		  String res=service.communityDelete(cno, pwd);
		  return res;
	  }
	  
	  
	 

}
