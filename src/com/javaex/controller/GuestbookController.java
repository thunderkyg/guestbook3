package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping(value = "gbc")
public class GuestbookController {

	//Method Start
	//------------------------------ AddList ------------------------------//
	@RequestMapping(value="/addlist", method = { RequestMethod.GET, RequestMethod.POST } )
	public String addlist(Model model) {
		
		//List Array from Database
		GuestbookDao guestbookDao = new GuestbookDao();
		List<GuestbookVo> guestList = guestbookDao.getList();
		
		//Attribute
		model.addAttribute("guestList", guestList);
		
		return "/WEB-INF/addlist.jsp";
	}
	
	//------------------------------ Add(Insert Function) ------------------------------//
	@RequestMapping(value="/add", method = { RequestMethod.GET, RequestMethod.POST } )
	public String add(//@RequestParam("name") String name,
					  //@RequestParam("password") String password,
					  //@RequestParam("content") String content
					  @ModelAttribute GuestbookVo guestbookVo) {
		
		//Dao
		GuestbookDao guestbookDao = new GuestbookDao();
		//Insert Dao Method
		guestbookDao.guestbookInsert(guestbookVo);
		
		return "redirect:./addlist";
	}
	
	//------------------------------ Delete Form ------------------------------//
	@RequestMapping(value="/deleteForm", method = { RequestMethod.GET, RequestMethod.POST } )
	public String deleteForm(@RequestParam ("no") int no, Model model) {
		System.out.println(no);
		model.addAttribute("no", no);
		
		return "/WEB-INF/deleteForm.jsp";
	}
	
	//------------------------------ Delete Function ------------------------------//
	@RequestMapping(value="/delete", method = { RequestMethod.GET, RequestMethod.POST } )
	public String delete(//@RequestParam("no") int no,
						 //@RequestParam("password") String password
						 @ModelAttribute GuestbookVo deletepw) {
		System.out.println("Delete Function");
		System.out.println(deletepw);
		//Vo
//		GuestbookVo deletepw = new GuestbookVo(no, password);
		System.out.println(deletepw);
		//Dao
		GuestbookDao guestbookDao = new GuestbookDao();
		
		//Delete
		guestbookDao.guestbookDelete(deletepw);
		
		return "redirect:./addlist";
	}
	
}