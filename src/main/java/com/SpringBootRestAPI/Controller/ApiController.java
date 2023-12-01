package com.SpringBootRestAPI.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootRestAPI.Bean.Students;

@RestController
public class ApiController {

	//localhost:9090/
	@GetMapping("/")
	public String hello() {
		return "SpringBootRestAPI";
	}
	
	//localhost:9090/student
	@GetMapping("/student")
	public Students student() {
		
		Students stud = new Students(1,"Jhon");
		return stud;
	}
	
	//localhost:9090/students
	@GetMapping("/students")
	public List<Students> studentList(){
		List<Students> list = new ArrayList<>();
		Students s1= new Students(2,"Doe");
		Students s2= new Students(3,"Lambert");
		Students s3= new Students(4,"moon");
		list.add(s1);
		list.add(s3);
		list.add(s2);

		return list;
	}
	
	//Story of PathVariable
	// {id} - URI Template Variable
	// it is used to bind uri tempalte variable into method arguments
	@GetMapping("/students/{id}")
	public Students studentPathVaiable(@PathVariable("id") int studentId) {
		Students s = new Students(studentId, "Mr. Park");
		return s;
	}
	
	@GetMapping("/students/{id}/{name}")
	public Students studentPathVariables(@PathVariable("id") int studentId,
			@PathVariable("name") String fullName) {
		
		return new Students(studentId, fullName);
	}
	
	//Story of Request Param
	//localhost:9090/student/query?id=1
	// it is used to extract the query parameter from URL
	
	@GetMapping("/students/query")
	public Students studentRequestParam( @RequestParam int id) {
		Students stud = new Students(id, "Dr. Jhon");
		
		return stud;
	}
	
	//localhost:9090/student/query/multiple?id=1&name=sdbravo40
	@GetMapping("/students/query/multiple")
	public Students studentRequestParams(@RequestParam int id, @RequestParam String name) {
		
		return new Students(id, name);
	}
	
	
	//using postman
	//requestbody is used to convert jason to java object
	@PostMapping("/students/create")
	public Students studentCreate(@RequestBody Students stud) {
		
		System.out.println(stud.getId());
		System.out.println(stud.getName());
		
		return stud;
	}
	
	
}
