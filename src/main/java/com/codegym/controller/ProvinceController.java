package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.DTO.ICountCustomer;
import com.codegym.model.DTO.ProvinceDTO;
import com.codegym.model.Province;
import com.codegym.service.ICustomerService;
import com.codegym.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;

    @Autowired
    private ICustomerService customerService;


    @GetMapping("/list")
    public ModelAndView modelAndView( Pageable pageable){
        pageable = PageRequest.of(pageable.getPageNumber(), 3);
        Page<Province> provinces = provinceService.findAll(pageable);
        return new ModelAndView("/province/list", "provinces", provinces);
    }

    
    @GetMapping
    public ModelAndView listProvince() {
        ModelAndView modelAndView = new ModelAndView("/province/list");
        Iterable<Province> provinces = provinceService.findAll();
        modelAndView.addObject("provinces", provinces);
        Iterable<ICountCustomer> province1 = provinceService.getCountCustomers();
        modelAndView.addObject("province1", province1);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }


    @PostMapping("/create")
    public String create(@ModelAttribute("province") Province province,
                         RedirectAttributes redirectAttributes) {
//        provinceService.save(province);
        redirectAttributes.addFlashAttribute("message", "Create new province successfully");
        return "redirect:/provinces";
    }
//    lay toan bo tham so len thong qua request param
//    tao doi tuong tu danh sach tham so

    @PostMapping("/create1")
    public String create1(@RequestParam String name,
                         RedirectAttributes redirectAttributes) {
        Province p = new Province();
        p.setName(name);
//        provinceService.save(province);
        redirectAttributes.addFlashAttribute("message", "Create new province successfully");
        return "redirect:/provinces";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable Long id) {
        Optional<Province> province = provinceService.findById(id);
        if (province.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/province/update");
            modelAndView.addObject("province", province.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
            provinceService.deleteProvinceById(id);
            return "redirect:/provinces";
    }


    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("province") Province province,
                         RedirectAttributes redirect) {
        provinceService.save(province);
        redirect.addFlashAttribute("message", "Update province successfully");
        return "redirect:/provinces";
    }

    @GetMapping("/view-province/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id){
        Optional<Province> provinceOptional = provinceService.findById(id);
        if(!provinceOptional.isPresent()){
            return new ModelAndView("/error_404");
        }

        Iterable<Customer> customers = customerService.findAllByProvince(provinceOptional.get());

        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
    @GetMapping("/demo")
    public ModelAndView getDemo(){
        ModelAndView modelAndView = new ModelAndView("/province/list");
        Iterable<ICountCustomer> provinces = provinceService.getCountCustomers();
        modelAndView.addObject("ps", provinces);
        return modelAndView;
    }

    @GetMapping("/count")
    public ModelAndView countProvince(){
        ModelAndView modelAndView = new ModelAndView("/province/count");
        Iterable<ProvinceDTO> provinces = provinceService.countCustomerByProvice();
        modelAndView.addObject("ps", provinces);
        return modelAndView;
    }
}
