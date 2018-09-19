package com.Ljd.Ljduitest.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ljd.Ljduitest.common.assertion;

public class Testassert {
	@Test
	public void test1(){
		System.out.println("测试用例一");
		int expected = 1;
		assertion.flog=true;
		for(int i = 0;i < 2;i++){
			System.out.println("断言开始"+i);
			assertion.verifyassert(i, expected, "测试两个字符是否相同");
			System.out.println(assertion.flog);
		}
		Assert.assertTrue(assertion.flog);
	}
	@Test
	public void test2(){
		System.out.println("1212");
	}
}
