package com.project.pojo;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.project.utils.ConstantUtils;


public class WebResultDto {
	private String status;
	private String info;
	private String data;
	
	public WebResultDto() {
		status = ConstantUtils.ExeCode.FAILED;
		info = ConstantUtils.ExeCodeString.FAILED;
		data = JSON.toJSONString(new JSONArray());
	}
	
	public void success(Object obj) {
		status = ConstantUtils.ExeCode.SUCCESS;
		info = ConstantUtils.ExeCodeString.SUCCESS;
		JSONArray arr = new JSONArray();
		arr.add(obj);
		data = JSON.toJSONString(arr);			
	}
	
	public void fail(Object obj) {
//		status = ConstantUtils.ExeCode.SUCCESS;
//		info = ConstantUtils.ExeCodeString.SUCCESS;
		JSONArray arr = new JSONArray();
		arr.add(obj);
		data = JSON.toJSONString(arr);			
	}
	
	public <T> void success(List<T> list) {
		status = ConstantUtils.ExeCode.SUCCESS;
		info = ConstantUtils.ExeCodeString.SUCCESS;
		if (list != null && list.size() > 0) {
			JSONArray arr = new JSONArray();
			arr.addAll(list);
			data = JSON.toJSONString(arr);
		}		
	}
	
	public <T> void fail(List<T> list) {
//		status = ConstantUtils.ExeCode.SUCCESS;
//		info = ConstantUtils.ExeCodeString.SUCCESS;
		if (list != null && list.size() > 0) {
			JSONArray arr = new JSONArray();
			arr.addAll(list);
			data = JSON.toJSONString(arr);
		}		
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}
