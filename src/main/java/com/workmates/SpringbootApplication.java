package com.workmates;

import com.workmates.Entity.Role;
import com.workmates.Entity.Users;
import com.workmates.Repository.UserRepository;
import com.workmates.Service.UserService;
import com.workmates.config.CustomUserDetails;
import com.workmates.dto.Notice;
import com.workmates.dto.NoticeQueue;
import com.workmates.dto.NoticeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

@SpringBootApplication
public class SpringbootApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
        List<Notice> list = new ArrayList<>();
        long t = System.currentTimeMillis();
        Random rnd = new Random();
        for (int i = 0; i < 20; i++) {
            Notice notice = new Notice();
            notice.setPusher("syq");
            notice.setTarget("user");
            notice.setNoticeTime(new Date(t-rnd.nextInt(999999999)));
            notice.setNoticeType(rnd.nextInt(3)>1?NoticeType.FOLLOW:NoticeType.MESSAGE);
            list.add(notice);
        }
        NoticeQueue.instance.enQueue(list);
		SpringApplication.run(SpringbootApplication.class, args);
	}

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository, UserService service) throws Exception {
        //Setup a default user if db is empty
        if (repository.count() == 1) {
            service.save(new Users("cxd","123", Arrays.asList(new Role("USER"),new Role("ACTUATOR"))));
            service.save(new Users("syq","123", Arrays.asList(new Role("USER"),new Role("ACTUATOR"))));
        }
        builder.userDetailsService(userDetailsService(repository)).passwordEncoder((passwordEncoder));
    }

    private UserDetailsService userDetailsService(final UserRepository repository) {
	    return username->new CustomUserDetails(repository.findByUsername(username));
    }
//	@Bean
//	public CommandLineRunner setup(BookRepository bookRepository) {
//		return (args)->{
//			bookRepository.save(new Book("Sherlock", "Holmes", true,new Timestamp(new Date().getTime()),new java.sql.Date(new Date().getTime()),new Date()));
//			bookRepository.save(new Book("Sherlock2", "Holmes", true,new Timestamp(new Date().getTime()),new java.sql.Date(new Date().getTime()),new Date()));
//			bookRepository.save(new Book("Sherlock3", "Holmes", true,new Timestamp(new Date().getTime()),new java.sql.Date(new Date().getTime()),new Date()));
//			bookRepository.save(new Book("Sherlock4", "Holmes", true,new Timestamp(new Date().getTime()),new java.sql.Date(new Date().getTime()),new Date()));
//			bookRepository.save(new Book("Sherlock5", "Holmes", true,new Timestamp(new Date().getTime()),new java.sql.Date(new Date().getTime()),new Date()));
//			bookRepository.save(new Book("Sherlock6", "Holmes", true,new Timestamp(new Date().getTime()),new java.sql.Date(new Date().getTime()),new Date()));
//		};
//	}
}
