package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Activity;
import com.example.demo.model.Comment;
import com.example.demo.model.User;
import com.example.demo.service.ActivityService;
import com.example.demo.service.CommentService;
import com.example.demo.service.UserService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserService userService, ActivityService activiteService, CommentService commentService){
		return args -> {

			User henri = User.builder().firstName("Henri").email("test1@gmil.com").password("test").lastName("Dujardin").build();
			User bilel = User.builder().firstName("Bilel").email("test2@gmil.com").password("test").lastName("Dujardin").build();
			Activity rugby = Activity.builder().name("Club Multi-Sport").address("Jean-Jaurès, Tours").phoneNumber("0029101002").sportName("Rugby").build();
			
			userService.saveUser(henri);
			userService.saveUser(bilel);
			userService.saveUser(User.builder().firstName("Victor").email("test3@gmil.com").password("test").lastName("Dujardin").build());
			userService.saveUser(User.builder().firstName("Allane").email("test4@gmil.com").password("test").lastName("Dujardin").build());

			activiteService.saveActivity(rugby);
			activiteService.saveActivity(Activity.builder().name("Club Multi-Sport").address("Jean-Jaurès, Tours").phoneNumber("0029101002").sportName("Football").build());
			activiteService.saveActivity(Activity.builder().name("Club Multi-Sport").address("Jean-Jaurès, Tours").phoneNumber("0029101002").sportName("Meditation").build());
			activiteService.saveActivity(Activity.builder().name("Club Multi-Sport").address("Jean-Jaurès, Tours").phoneNumber("0029101002").sportName("Natation").build());
			activiteService.saveActivity(Activity.builder().name("Club Multi-Sport").address("Jean-Jaurès, Tours").phoneNumber("0029101002").sportName("Aquagym").build());
			activiteService.saveActivity(Activity.builder().name("Club Multi-Sport").address("Jean-Jaurès, Tours").phoneNumber("0029101002").sportName("Streshing").build());

			userService.addUserToActivity(henri.getId(), rugby.getId());

			commentService.saveComment(Comment.builder().content("Activité très relaxante").author(henri).activity(rugby).build());
			commentService.saveComment(Comment.builder().content("C'est assez physique !").author(bilel).activity(rugby).build());

		};
	}

}
