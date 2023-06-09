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

			User henri = User.builder().name("Henri").email("test@gmil.com").build();
			User bilel = User.builder().name("Bilel").email("test@gmil.com").build();
			Activity rugby = Activity.builder().name("Rugby").build();
			
			userService.saveUser(henri);
			userService.saveUser(bilel);
			userService.saveUser(User.builder().name("Victor").email("test@gmil.com").build());
			userService.saveUser(User.builder().name("Allane").email("test@gmil.com").build());

			activiteService.saveActivity(rugby);
			activiteService.saveActivity(Activity.builder().name("Football").build());
			activiteService.saveActivity(Activity.builder().name("Meditation").build());
			activiteService.saveActivity(Activity.builder().name("Natation").build());
			activiteService.saveActivity(Activity.builder().name("Aquagym").build());
			activiteService.saveActivity(Activity.builder().name("Streshing").build());

			userService.addUserToActivity(henri.getId(), rugby.getId());

			commentService.saveAvis(Comment.builder().content("Activité très relaxante").author(henri).activity(rugby).build());
			commentService.saveAvis(Comment.builder().content("C'est assez physique !").author(bilel).activity(rugby).build());

	
		};
	}

}
