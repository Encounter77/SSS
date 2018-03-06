package com.ex.controller;

import com.ex.pojo.Content;
import com.ex.pojo.Product;
import com.ex.service.ContentService;
import com.ex.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class CoreController {

    @Resource
    private HttpSession httpSession;

    @Resource
    private ProductService productService;

    @Resource
    private ContentService contentService;


    /*
    * 首页--商品展示页
    * */
    @RequestMapping(value = {"/"})
    public String index(ModelMap modelMap,Integer type) {
        /**
         *
         * 判断展示页类型 当userType==0时  0-全部商品 1-未购买商品
         * 当 userType==1时 只有商品列表清单 表示已售出和未售出
         *
         * */
        if (type == null) {
            type = 0;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("type", type);
        modelMap.addAttribute("RequestParameters", map);
        List<Product> productList = productService.getProductList();
        //展示未购买商品列表
        if (type.equals(1)) {
            //页面显示判断
            pagingJudgment(productList,true);
        }
        modelMap.addAttribute("productList", productList);
        return "index";
    }

    /*
    * 登录
    * */
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    /*
    * 登出
    * */
    @RequestMapping(value = "/logout")
    public String logout() {
        if(httpSession.getAttribute("user") != null){
            httpSession.removeAttribute("user");
            return "redirect:/";
        }
        return "login";
    }

    /*
    * 查看已购买商品
    * */
    @RequestMapping(value = "/account")
    public String account(ModelMap modelMap) {
        List<Product> productList = productService.getProductList();
        pagingJudgment(productList,false);
        //System.out.println(productList.toString());
        modelMap.addAttribute("buyList", productList);
        return "account";
    }

    /*
    *  编辑商品
    * */
    @RequestMapping(value = "/edit")
    public String edit(ModelMap modelMap, Integer id) {
        if (id != null) {
            modelMap.addAttribute("product", productService.getProduct(id));
        }
        return "edit";
    }

    /*
    *  编辑提交
    * */
    @RequestMapping(value = "/editSubmit")
    public String editSubmit(ModelMap modelMap, Double price, String title, String image,  String summary, String detail,  Integer id) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("id", id);
        modelMap.addAttribute("RequestParameters", map);
        if(image.length() > 1000|| price > Double.MAX_VALUE){
            return "editSubmit";
        }

        /*
        *  设置商品编辑页的相关属性
        * */
        Content content = contentService.getContent(id);
        content.setPrice(price);
        content.setTitle(title);
        content.setPic(image);
        content.setSummary(summary);
        content.setDetail(detail);
        //传入更新后的账务对象进行账务更新 更新后信息传回页面
        contentService.updateContent(content);
        modelMap.addAttribute("product", contentService.getContent(id));
        return "editSubmit";
    }

    /*
    *  发布商品
    * */
    @RequestMapping(value = "/public")
    public String publicProduct() {
        return "public";
    }

    /*
    *  提交发布
    * */
    @RequestMapping(value = "/publicSubmit")
    public String publicSubmit(ModelMap modelMap, Double price, String title, String image, String summary, String detail) {
        //判断输入的商品图片地址长度以及价格是否合法
        if (image.length() > 1000 || price > Double.MAX_VALUE) {
            return "publicSubmit";
        }
        //获取商品发布页面文本框内容 并进行内容插入操作 插入完成后返回对象到页面
        Content content = contentService.getAndInsertContent(price, title, image, summary, detail);
        modelMap.addAttribute("product", content);
        return "publicSubmit";
    }

    /*
    *  展示
    * */
    @RequestMapping(value = "/show")
    public String show(ModelMap modelMap,int id) {
        Content productInfo = productService.getProduct(id);
        modelMap.addAttribute("product", productInfo);
        return "show";
    }

    /*
    *  分页判断
    * */
    public void pagingJudgment(List<Product> products,boolean flag){
        for (Iterator<Product> iterator = products.iterator(); iterator.hasNext(); ) {
            Product product = iterator.next();
            if(flag){
                if (product.getIsBuy() == true) {
                    iterator.remove();
                }
            }else{
                if (product.getIsBuy() == false) {
                    iterator.remove();
                }
            }
        }
    }
}
