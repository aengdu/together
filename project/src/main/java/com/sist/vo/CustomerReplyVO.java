package com.sist.vo;
/*
HRNO       NOT NULL NUMBER       
NNO                 NUMBER       
MSG        NOT NULL CLOB         
STATE               VARCHAR2(50) 
GROUP_ID   NOT NULL NUMBER       
GROUP_STEP          NUMBER       
GROUP_TAB           NUMBER       
REGDATE             DATE         
MODDATE             DATE         
HIT                 NUMBER  
 */
import java.util.*;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class CustomerReplyVO {
	
	private int hrno;
	
	private int nno;
	
	private int group_id;
	
	private int group_step;
	
	private int group_tab;
	
	private int hit;
	
	private String msg;
	
	private String state;
	
	private Date regdate;
	
	private Date moddate;
	
	
}
