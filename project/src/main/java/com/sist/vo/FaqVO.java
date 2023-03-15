package com.sist.vo;
/*
FNO     NOT NULL NUMBER         
TYPE    NOT NULL VARCHAR2(20)   
SUBJECT NOT NULL VARCHAR2(1000) 
CONTENT NOT NULL CLOB           
HIT              NUMBER 
 */
import java.util.*;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class FaqVO {
	private int fno,hit;
	private String type,subject,content;

	
}
