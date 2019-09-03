package com.tensquare.base.controller;



import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/label")
public class LabelController {


    @Autowired
    private LabelService labelService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功!",labelService.findAll());
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable("id")String id){
        return new Result(true,StatusCode.OK,"success",labelService.findById(id));
    }

    /**
     * 修改标签
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result updata(@PathVariable("id")String id){
        return new Result(true,StatusCode.OK,"success");
    }

    /**
     * 删除标签
     */

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable("id")String id){
        return new Result(true,StatusCode.OK,"success");
    }


    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result search(@RequestBody Label label){

        return new Result(true,StatusCode.OK,"查询成功!",labelService.search(label));
    }
}
