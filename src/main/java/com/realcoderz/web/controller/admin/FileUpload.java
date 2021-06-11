package com.realcoderz.web.controller.admin;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.realcoderz.business.bean.StoredFile;

@Controller
public class FileUpload {
	
	@RequestMapping(value="/showFileForm", method=RequestMethod.GET)
	public ModelAndView showUploadForm()
	{
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("fileUpload");
		modelAndView.addObject("storedFile", new StoredFile());
		return modelAndView;
		
	}

	
	@RequestMapping(value="/savefile",method=RequestMethod.POST)  
	public ModelAndView upload(@ModelAttribute("storedFile") StoredFile storedFile ,HttpSession session){  
	        String path=session.getServletContext().getRealPath("/");  
	        String filename=storedFile.getFile()               
	        		.getOriginalFilename();  
	          
	        System.out.println(path+" "+filename);  
	        try{  
	        byte barr[]=storedFile.getFile() 
	        		.getBytes();  
	          
	        BufferedOutputStream bout=new BufferedOutputStream(  
	                 new FileOutputStream(path+"/"+filename));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();  
	          
	        }catch(Exception e){System.out.println(e);}  
	        
	        ModelAndView mv = new ModelAndView();
	        mv.setViewName("uploadSuccess");
	        mv.addObject("title", storedFile.getFileTitle());
	        mv.addObject("filename", path+"/"+filename);
	        
	        return mv;
	    }  
}
