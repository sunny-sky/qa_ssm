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
import com.xjtu.qa.mapper.Category2Mapper;
import com.xjtu.qa.mapper.QuestionMapper;
import com.xjtu.qa.pojo.Category;
import com.xjtu.qa.pojo.Category2;
import com.xjtu.qa.pojo.Category2Example;
import com.xjtu.qa.pojo.Question;
import com.xjtu.qa.pojo.QuestionExample;
import com.xjtu.qa.service.CategoryService;
import com.xjtu.qa.util.ImageUtil;
import com.xjtu.qa.util.Page;
import com.xjtu.qa.util.UploadedImageFile;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    Category2Mapper category2Mapper;
    @Autowired
    QuestionMapper questionMapper;
    
    
    
    //后台首页
    @RequestMapping("admin_category_list")
    public String list(Model model,Page page){
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Category> cs= categoryService.list();
        int total = (int) new PageInfo<>(cs).getTotal();
        page.setTotal(total);
        model.addAttribute("cs", cs);
        model.addAttribute("page", page);
        return "admin/listCategory";
    }

    
    //添加
    @RequestMapping("admin_category_add")
    public String add(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        System.out.println(c.getId());
        categoryService.add(c);
        System.out.println(c.getId());
        File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,c.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        System.out.println(uploadedImageFile);
        System.out.println(uploadedImageFile.getImage());
        System.out.println(file);
        uploadedImageFile.getImage().transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
 
        return "redirect:/admin_category_list";
    }
    //删除
    @RequestMapping("admin_category_delete")
    public String delete(int id,HttpSession session) throws IOException {
        categoryService.delete(id);
     
        File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,id+".jpg");
        file.delete();
     
        return "redirect:/admin_category_list";
    }
    //编辑
    @RequestMapping("admin_category_edit")
    public String edit(int id,Model model) throws IOException {
        Category c= categoryService.get(id);
        model.addAttribute("c", c);
        return "admin/editCategory";
    }
    
    //更新
    @RequestMapping("admin_category_update")
    public String update(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        categoryService.update(c);
        MultipartFile image = uploadedImageFile.getImage();
        if(null!=image &&!image.isEmpty()){
            File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
            File file = new File(imageFolder,c.getId()+".jpg");
            image.transferTo(file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, "jpg", file);
        }
        return "redirect:/admin_category_list";
    }
    
    @RequestMapping("forecategory")
    public String forecategory(@RequestParam("c1id") int c1id, HttpSession session) throws IOException {
    	System.out.println("类别c1id："+c1id);
    	Category c = categoryService.get(c1id);
    	
    	Category2Example example = new Category2Example();
    	example.createCriteria().andC1idEqualTo(c1id);
    	example.setOrderByClause("id desc");
    	List<Category2> c2s = category2Mapper.selectByExample(example);
    	for(Category2 c2:c2s){
    		System.out.println("类别c2id："+c2.getId());
    	}
    	
    		
    	QuestionExample qExample = new QuestionExample();
    	qExample.createCriteria().andC1idEqualTo(c1id);
    	qExample.setOrderByClause("id desc");
    	List<Question> qs = questionMapper.selectByExample(qExample);
    	for(Question q:qs){
    		System.out.println("问题qid："+q.getId());
    	}
    	    	
    	session.setAttribute("c", c);
    	session.setAttribute("c2s", c2s);
    	session.setAttribute("qs", qs);
    	return "fore/category";
    }
}