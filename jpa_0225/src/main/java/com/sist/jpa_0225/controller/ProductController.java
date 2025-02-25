package com.sist.jpa_0225.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sist.jpa_0225.repository.CategoryRepository;
import com.sist.jpa_0225.repository.ProductRepository;
import com.sist.jpa_0225.store.Category1JPO;
import com.sist.jpa_0225.store.ProductJPO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("test")
    public String test() {
        ProductJPO p1 = ProductJPO.builder()
            .pNum(2L)
            .pName("빈센트 해바라기기")
            .pCompany("Art Box").build();
        
        System.out.println(p1);
        productRepository.save(p1);
        return "저장완료!";
    }

    @GetMapping("list")
    public String getList() {
        List<ProductJPO> list = 
            productRepository.findAll();
        
        StringBuffer sb = new StringBuffer();
        for(ProductJPO p : list){
            sb.append(p.getPNum());
            sb.append("/");
            sb.append(p.getPName());
            sb.append("/");
            sb.append(p.getCvo1().getCName());
            sb.append("/");
            sb.append(p.getCvo1().getCDesc());
            sb.append("</br>");
        }//for의 끝
        return sb.toString();
    }
    
    @GetMapping("list2")
    public String getList2() {
        List<Category1JPO> list = 
            categoryRepository.findAll();
        
        StringBuffer sb = new StringBuffer();
        for(Category1JPO c : list){
            sb.append(c.getCIdx());
            sb.append("/");
            sb.append(c.getCName());
            sb.append("/");
            sb.append(c.getCDesc());
            sb.append("</br>");
            for(ProductJPO p : c.getList()){
                sb.append("&nbsp;&nbsp;&nbsp;");
                sb.append(p.getPNum());
                sb.append("/");
                sb.append(p.getPName());
                sb.append("</br>");
            }
        }//for의 끝
        return sb.toString();
    }
}
