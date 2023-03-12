package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.sist.vo.*;

/*
 *      private int cno;

	    private String title;
	
	    private String content;
	
	    private String type;
	
	    private Date createdAt;
	
	    private int mno;
 */
public interface CommunityMapper {
	@Select("SELECT cno,title,content,type,TO_CHAR(createdAt,'YYYY-MM-DD') as dbday,num "
			+"FROM (SELECT cno,title,content,type,createdAt,rownum as num "
			+"FROM (SELECT /* +INDEX_DESC(pet_community_2_1 pc1_cno_pk)*/cno,title,content,type,createdAt "
			+"FROM pet_community_2_1)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<CommunityVO> communityListData(Map map);
	
	@SelectKey(keyProperty = "no",resultType = int.class,before = true,
			statement = "SELECT NVL(MAX(no)+1,1) as no FROM pet_community_2_1")
	@Insert("INSERT INTO pet_community_2_1 VALUES(" 
			+ "#{cno},#{title},#{content},#{pwd},SYSDATE,0)")
	public void communityInsert(CommunityVO vo);
}