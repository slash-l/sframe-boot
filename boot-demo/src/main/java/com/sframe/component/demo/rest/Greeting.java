package com.sframe.component.demo.rest;

/**
 * @ClassName: Greeting 
 * @Description: Greeting javaBean
 * @author mumu
 * @date 2016年4月23日 下午11:51:12 
 */
public class Greeting {
	
	private final long id;	//ID
	private final String content;	//内容

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	
}
