package com.airtel.agilelab.pnp.service;

import java.time.LocalTime;
import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


//make sure that you do not use @Configurable on bean classes which are annotated with @Scheduled and registered 
//as regular Spring beans with the container: You would get double initialization otherwise, 
//once through the container and once through the @Configurable aspect, 
//with the consequence of each @Scheduled method being invoked twice.

@Configuration
@EnableAsync
@EnableScheduling
public class OrderScheduleService  {

	@Autowired
	private OrderService orderService;
	
	// methods to be scheduled must have void returns and must not expect any arguments
	// by default SimpleAsyncTaskExecutor is used and it starts a new thread everytime
	@Async("pnpthreadPoolTaskExecutor")
	@Scheduled(initialDelay=1000, fixedRate=1000)
	public void validateOrders() {
		System.out.println("== validateOrders =="+LocalTime.now());
		System.out.println(" == currrent thread name == "+Thread.currentThread().getName());
		orderService.updateOrderByScheduler();
	}

	 @Bean(name = "pnpthreadPoolTaskExecutor")
	 public Executor threadPoolTaskExecutor() {
	        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	        executor.setCorePoolSize(5);
	        executor.setMaxPoolSize(5);
	        executor.setQueueCapacity(100); // a fixed size pool is the only sensible case when using an unbounded queue
	        executor.setThreadNamePrefix("pnpthreadexecutor-");
	        return executor;
	    }

}
