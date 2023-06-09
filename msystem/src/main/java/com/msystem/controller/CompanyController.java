package com.msystem.controller;

import com.msystem.entity.Company;
import com.msystem.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @Description: Company的控制類
 * @author: Eker
 * @date: 2023/4/22 下午 07:39
 * @version: V1.0
 */
@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping(value = "/api")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    /**
     * @titile: queryCompanyById
     * @description: 依廠商id查詢廠商信息
     * @param id 廠商id
     * @return: Company 廠商信息
     * @author: Eker
     * @date: 2023/5/23 下午 04:38
     */
    @GetMapping(value = "/company/{id}")
    public Company queryCompanyById(@PathVariable("id") Integer id){
        Optional<Company> company = companyService.queryCompanyById(id);
        return company.orElse(null);
    }
    /**
     * @titile: queryAllCompany
     * @description: 查詢全部廠商信息
     * @return: List<Company> 廠商信息列表
     * @author: Eker
     * @date: 2023/5/23 下午 04:38
     */
    @GetMapping(value = "/company")
    public List<Company> queryAllCompany(){
        List<Company> companyList = companyService.queryAllCompany();
        return companyList;
    }


}
