package com.xjtu.qa.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xjtu.qa.pojo.Category;
import com.xjtu.qa.pojo.Category2;
import com.xjtu.qa.service.Category2Service;
import com.xjtu.qa.service.CategoryService;
import com.xjtu.qa.util.ImageUtil;
import com.xjtu.qa.util.Page;
import com.xjtu.qa.util.UploadedImageFile;


@Controller
@RequestMapping("")
public class Category2Controller {
	 @Autowired
	 Category2Service category2Service;
	 @Autowired
	 CategoryService categoryService;
	    //后台首页
	    @RequestMapping("admin_category2_list")
	    public String list(Model model,Page page){
	        PageHelper.offsetPage(page.getStart(),page.getCount());
	        List<Category2> c2s= category2Service.list();
	        category2Service.setCategory(c2s);
	        int total = (int) new PageInfo<>(c2s).getTotal();
	        page.setTotal(total);
	        
	        List<Category> cs= categoryService.list();
	        model.addAttribute("cs", cs);
	        model.addAttribute("c2s", c2s);
	        model.addAttribute("page", page);
	        return "admin/listCategory2";
	    }

	    //添加
	    @RequestMapping("admin_category2_add")
	    public String add( @RequestParam("name") String name,@RequestParam("c1id") int c1id,HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
	    	System.out.println("二级分类名："+name+",一级分类id："+c1id);
	    	Category2 c2 = new Category2();
	    	c2.setName(name);
	    	c2.setC1id(c1id);
	        category2Service.add(c2);
	        System.out.println(c2.getC1id());
	        File  imageFolder= new File(session.getServletContext().getRealPath("img/category2"));
	        File file = new File(imageFolder,c2.getId()+".jpg");
	        if(!file.getParentFile().exists())
	            file.getParentFile().mkdirs();
	        System.out.println(uploadedImageFile);
	        System.out.println(uploadedImageFile.getImage());
	        System.out.println(file);
	        uploadedImageFile.getImage().transferTo(file);
	        BufferedImage img = ImageUtil.change2jpg(file);
	        ImageIO.write(img, "jpg", file);
	 
	        return "redirect:/admin_category2_list";
	    }
	    
	    //删除
	    @RequestMapping("admin_category2_delete")
	    public String delete(int id,HttpSession session) throws IOException {
	        category2Service.delete(id);
	     
//	        File  imageFolder= new File(session.getServletContext().getRealPath("img/category2"));
//	        File file = new File(imageFolder,id+".jpg");
//	        file.delete();
	     
	        return "redirect:/admin_category2_list";
	    }
	    
	    //编辑
	    @RequestMapping("admin_category2_edit")
	    public String edit(int id,Model model) throws IOException {
	        Category2 c2= category2Service.get(id);
	        List<Category> cs= categoryService.list();
	        model.addAttribute("cs", cs);
	        model.addAttribute("c2", c2);
	        return "admin/editCategory2";
	    }
	    
	    //更新
	    @RequestMapping("admin_category2_update")
	    public String update( @RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("c1id") int c1id, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
	    	Category2 c2 = category2Service.get(id);
	    	c2.setName(name);
	        c2.setC1id(c1id);	        
	    	category2Service.update(c2);
	        MultipartFile image = uploadedImageFile.getImage();
	        if(null!=image &&!image.isEmpty()){
	            File  imageFolder= new File(session.getServletContext().getRealPath("img/category2"));
	            File file = new File(imageFolder,c2.getId()+".jpg");
	            image.transferTo(file);
	            BufferedImage img = ImageUtil.change2jpg(file);
	            ImageIO.write(img, "jpg", file);
	        }
	        return "redirect:/admin_category2_list";
	    }
}
