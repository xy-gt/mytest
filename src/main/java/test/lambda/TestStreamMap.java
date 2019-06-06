package test.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStreamMap {

	public static void main(String[] args) {
		List<User> list = Arrays.asList(
				new User("1","zhansan",10),
				new User("2","lisi",30),
				new User("3","wangwu",20),
				new User("4","wangwu",34),
				new User("5","wangwu",23)
				);
		
	List<User2> userList2 = list.stream().map(User2::new).collect(Collectors.toList());
	System.out.println(userList2);

	}

}
