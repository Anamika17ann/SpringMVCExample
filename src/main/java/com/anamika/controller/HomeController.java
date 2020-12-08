package com.anamika.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	JdbcTemplate template;
	Dao dao = new Dao();

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/getdata")
	public String getdata(Locale locale, Model model)  {
		try {
			if (dao.getDataSource().equals(null)) {
				String error = "Please check Database Connection";
				model.addAttribute("score", error);
				
			} else {
				template = new JdbcTemplate(dao.getDataSource());
				String query1 = "SELECT score FROM springtest.tbl_test";
				int score = (Integer) this.template.queryForObject(query1, Integer.class);
				int score1 = score + 1;
				template.execute("UPDATE springtest.tbl_test SET Score =" + score1);
				model.addAttribute("score", score1);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "test";
	}

}
