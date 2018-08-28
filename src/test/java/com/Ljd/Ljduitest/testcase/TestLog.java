package com.Ljd.Ljduitest.testcase;

import com.Ljd.Ljduitest.common.LogType.LogTypeName;
import com.Ljd.Ljduitest.common.Logger;


public class TestLog {
	public static void main(String args){
		System.out.println("111");
		Logger.Output(LogTypeName.INFO, "测试输入方法名");
	}
}
