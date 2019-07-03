package com.eduwechat.backend.backend;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApplication.class)
public class BackendApplicationTests {

//	@Autowired
//	BiologyAggregationImpl dao;
//
//	@Autowired
//	ExerciseService service;

	private void l(Object o) {
		System.out.println(o);
	}

	@Before
	public void init() {
		System.out.println("开始测试-----------------");
	}

	@After
	public void after() {
		System.out.println("测试结束-----------------");
	}

	@Test
	public void getBuctet() {

	}

	@Test
    public void getPics() {
    }
//
//	@Test
//	public void testServiceTitleList() throws SubjectDoesNotSupportedException {
//
//		l(service.getExerciseTitleList("生物"));
//		l(service.getExerciseTitleList("化学"));
//		l(service.getExerciseTitleList("语文"));
//		l(service.getExerciseTitleList("英语"));
//		l(service.getExerciseTitleList("地理"));
//		l(service.getExerciseTitleList("历史"));
//		l(service.getExerciseTitleList("数学"));
//		l(service.getExerciseTitleList("物理"));
//		l(service.getExerciseTitleList("政治"));
//
//
//	}
//
//	@Test
//	public void testServiceType() throws SubjectDoesNotSupportedException {
//
//		l(service.getExerciseTypeList("生物"));
//		l(service.getExerciseTypeList("化学"));
//		l(service.getExerciseTypeList("语文"));
//		l(service.getExerciseTypeList("英语"));
//		l(service.getExerciseTypeList("地理"));
//		l(service.getExerciseTypeList("历史"));
//		l(service.getExerciseTypeList("数学"));
//		l(service.getExerciseTypeList("物理"));
//		l(service.getExerciseTypeList("政治"));
//
//	}
//
//	@Test
//	public void testServiceExerciseList() throws SubjectDoesNotSupportedException {
//
//		l(service.getExerciseList("生物", "现代生物科技", "胚胎工程", "单选题", true, 20, 0));
//		l(service.getExerciseList("化学", "化学反应原理", "原电池", "单选题", true, 20, 0));
//		l(service.getExerciseList("语文", "文言文阅读", "文言文阅读", "单选题", true, 20, 0));
//		l(service.getExerciseList("英语", "阅读理解", "政治经济文化类阅读", "单选题", true, 20, 0));
//		l(service.getExerciseList("地理", "区域地理", "世界地理概况", "单选题", true, 20, 0));
//		l(service.getExerciseList("历史", "近代史", "新文化运动", "单选题", true, 20, 0));
//		l(service.getExerciseList("数学", "不等式", "二元一次不等(组)表示的平面区域", "单选题", true, 20, 0));
//		l(service.getExerciseList("物理", "机械振动机械波", "单摆及其周期", "单选题", true, 20, 0));
//		l(service.getExerciseList("政治", "文化生活", "文化的继承性与文化发展", "单选题", true, 20, 0));
//
//	}
//
//	@Test
//	public void testServiceDetail() throws SubjectDoesNotSupportedException {
//
//		l(service.getExerciseDetail("生物", "20eb04de20559e92303405ccc64e0118"));
//		l(service.getExerciseDetail("化学", "0b2b6d2ce48f02ee83a7c517a2efd362"));
//		l(service.getExerciseDetail("语文", "734d72595fe3a96e5073e739c933a845"));
//		l(service.getExerciseDetail("英语", "92fe9b684a9659b26154fe0c42b5855e"));
//		l(service.getExerciseDetail("地理", "14c87866c1bf4853eaf274afce67a917"));
//		l(service.getExerciseDetail("历史", "b7bbf09ae6f50ceac5b268b8473cfa18"));
//		l(service.getExerciseDetail("数学", "0f5db2f0e483199dd34102092b412f99"));
//		l(service.getExerciseDetail("物理", "29be9b9e4b344f03be0c7267307c5c59"));
//		l(service.getExerciseDetail("政治", "1e7108f34d5f5fc275d1de1232d56e85"));
//
//	}
}
