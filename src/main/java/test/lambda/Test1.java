package test.lambda;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test1 {

	public static void main(String[] args) {
		
		List<User> list = Arrays.asList(
				new User("1","是",10),
				new User("2","否",30),
				new User("3","否",20),
				new User("4","是",34),
				new User("5","否",23),
				new User("6","是",29)
				);
		
		List  slist1 = list.stream().sorted(Comparator.comparing((User u)-> u.getName()).reversed().thenComparing(User::getAge)).collect(Collectors.toList());
		System.out.println("排序输出："+slist1);
		
		System.err.println("--------List map---------------------");
		Map<String, User2> map2 = list.stream().map(User2::new).collect(Collectors.toMap(User2::getId, Function.identity()));
		List list2 = list.stream().map(User2::new).collect(Collectors.toList());
		System.out.println("map2:"+map2);
		System.out.println("list2:"+list2);
		
		System.err.println("------------------set-------------------");
		Set set1 = list.stream().collect(Collectors.toSet());
		System.out.println(set1.size());
		list.stream().distinct().forEach(System.out::println);
		
		System.err.println("------------------filter-------------------");
		Long c1 = list.stream().filter((p)-> p.getAge() > 100).count();
		System.out.println(c1);
		
		System.err.println("---------------平均值-----------------------------");
	 	Double age = list.stream()
		      .collect(Collectors.averagingDouble(User::getAge));
	    System.out.println(age);
	 	
	 	
	    System.err.println("----------------------过滤和排序-----------------------------------");
	    List slist = list.stream()
	    		//.filter((u) ->"wangwu".equals(u.getName()))
	    		.sorted((s1,s2) -> {
	    	return s1.getAge().compareTo(s2.getAge());
	    }).collect(Collectors.toList());
	    System.out.println("过滤和排序"+slist);
	    
	 /*	list.stream()
	   .filter( e-> e.getAge() > 1)
	   .forEach(System.out:: println);
		*/
		/*Collections.sort(list, (e1,e2) -> {
		 if(e2.getAge() > e1.getAge()) {
			 return e2.getName().compareTo(e1.getName());
		 } else {
			 return e2.getAge().compareTo(e1.getAge());
		 }
			
		});*/
		
		
		System.out.println("----------------------Optional构造器-----------------------------------------------");
		Optional<User> ouser = Optional.ofNullable(new User("1","zhansan",10));
		//System.out.println(ouser.map(User:: getAge).get());
 		
		System.out.println("list"+list);
		
	    System.err.println("-------------------orelse--------------------");
	    Integer aa = null;
	    int a = Optional.ofNullable(aa).orElse(1)-1;
	    System.out.println("a:"+a);
	    
		
	    System.err.println("-------------------orelse2--------------------");
	    String aa2 = "";
	    String aaaa2 = Optional.ofNullable(aa2).orElse("1");
	    System.out.println("aaaa2:"+aaaa2);
	    
	    
	    System.err.println("-----------------group by ----------------------");
	    List l = list.stream().limit(2).collect(Collectors.toList());
	    System.out.println(l);
	   System.out.println("group:"+list.stream().collect(Collectors.groupingBy(User::getName)));


		ArrayList<User> users = Lists.newArrayList(new User("1", "是", 10),
				new User("2", "否"),
				new User("3", "否", 20),
				new User("4", "是", 34),
				new User("5", "否"),
				new User("6", "是", 29));

		// 会空指针异常
		List<User> collect = users.stream().filter(p -> p.getAge() > 1).collect(Collectors.toList());
		System.out.println(collect);


	}

}
