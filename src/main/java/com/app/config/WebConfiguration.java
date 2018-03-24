package com.app.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.app.*")
public class WebConfiguration extends WebMvcConfigurerAdapter{
	@Bean
	public InternalResourceViewResolver createVR() {
		InternalResourceViewResolver internalResourceViewResolver=null;
		internalResourceViewResolver=new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("WEB-INF/pages/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	@Bean
	public DataSource createDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/test");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	@Bean
	public JdbcTemplate createJDBCTemplate() {
		JdbcTemplate template=new JdbcTemplate();
		template.setDataSource(createDataSource());
		return template;
	}
	 
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
}

}
