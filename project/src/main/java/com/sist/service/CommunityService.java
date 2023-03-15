package com.sist.service;
import com.sist.mapper.*;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
@Repository
public class CommunityService {
	@Autowired
	private CommunityMapper mapper;
	
	public List<CommunityVO> communityListData(Map map)
	{
		return mapper.communityListData(map);
	}
	
	public void communityInsert(CommunityVO vo)
	{
		mapper.communityInsert(vo);
	}
	
	
	 public int communityTotalPage() 
	 { 
		 return mapper.communityTotalPage();
	 }
	 
	
	/*
	 * @Update("UPDATE pet_community_2_1 SET " 
			  +"hit=hit+1 " 
			  +"WHERE no=#{no}")
	 * public void communityHitIncrement(int cno);
	 */
	
	/*
	 * @Select("SELECT cno,name,title,content,filesize,TO_CHAR(createdAt,'YYYY-MM-DD') as dbday,hit "
			  +"FROM pet_community_2_1 " 
			  +"WHERE cno=#{cno}")
	 */
	public CommunityVO communityDetailData(int cno)
	{
		mapper.communityHitIncrement(cno);
		return mapper.communityDetailData(cno);
	}
	
	/*
	 * @Select("SELECT pwd FROM pet_community_2_1 " 
			  +"WHERE cno=#{cno}") public
	   String communityGetPassword(int no);
	 */
	
	/*
	 * @Update("UPDATE pet_community_2_1 SET "
			  +"name=#{name},title=#{title},content=#{content} " 
			  +"WHERE cno=#{cno}")
	 */
	public String communityUpdate(CommunityVO vo)
	{
		String res="cno";
		String db_pwd=mapper.communityGetPassword(vo.getCno());
		if(db_pwd.equals(vo.getPwd()))
		{
			mapper.communityUpdate(vo);
			res="yes";
		}
		return res;
	}
	
	/*
	 * @Delete("DELETE FROM pet_community_2_1 " 
	 *        +"WHERE cno=#{cno}")
	 */
	public String communityDelete(int cno,String pwd)
	{
		String res="cno";
		String db_pwd=mapper.communityGetPassword(cno);
		if(db_pwd.equals(pwd))
		{
			mapper.communityDelete(cno);
			res="yes";
		}
		return res;
	}
	 
	//@Select("SELECT filename,filesize,filecount FROM spring_databoard WHERE no=#{no}")
	   public CommunityVO communityFileInfoData(int cno)
	   {
		   return mapper.communityFileInfoData(cno);
	   }
	 
}
