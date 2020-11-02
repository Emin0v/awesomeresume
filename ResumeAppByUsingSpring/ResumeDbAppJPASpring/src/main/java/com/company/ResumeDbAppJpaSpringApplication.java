package com.company;

import com.company.dao.impl.UserRepositoryCustom;
import com.company.dao.impl.UserSkillRepositoryCustom;
import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ResumeDbAppJpaSpringApplication {

	@Autowired
	@Qualifier("userDao1")
	UserRepositoryCustom userDao;

	public static void main(String[] args) {
		SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner run(){
//		CommandLineRunner clr = new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//                User u = userDao.getById(2);
//                u.setName("Test");
//				userDao.updateUser(u);
//				System.out.println("Done");
//			}
//		};
//		return clr;
//	}
//    @Autowired
//	UserRepository userRepository;
//
//	@Bean
//	public CommandLineRunner run(){
//		CommandLineRunner clr = new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				List<User> u = userRepository.getAll(null,null,null);
//				System.out.println(u);
//			}
//		};
//		return clr;
//	}

	@Autowired
	private UserServiceInter userService;

	@Bean
	public CommandLineRunner run(){
		CommandLineRunner clr = new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				User u = userService.getById(1);
				System.out.println(u.getName());
			}
		};
		return clr;
	}

}
