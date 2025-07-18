package com.app.controller.study.practice.practice14;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.controller.study.practice.practice14.CoffeeBean;
import com.app.controller.study.practice.practice14.CupBean;
import com.app.controller.study.practice.practice14.DessertBean;
import com.app.controller.study.practice.practice14.PlateBean;


@Configuration
public class Practice14Configuration {
	
	@Bean
	public CoffeeBean coffeeBean() {
		CoffeeBean coffeeBean = new CoffeeBean();
		coffeeBean.setName("아임파인민트티");
		return coffeeBean;
	}
	
	@Bean
	public CupBean cupBean(CoffeeBean coffeeBean) {
		return new CupBean(coffeeBean);
	}
	
	
	@Bean
	public DessertBean dessertBean() {
		DessertBean dessertBean = new DessertBean();
		dessertBean.setName("애플망고");
		return dessertBean;
	}
	
	@Bean
	public PlateBean plateBean (DessertBean dessertBean) {
		return new PlateBean(dessertBean);
	}
}
