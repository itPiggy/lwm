package com.piggy.lwm.controller;

import com.piggy.lwm.domain.InboundRecordEntity;
import com.piggy.lwm.service.InboundRecordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.piggy.lwm.util.ReturnVO;

import javax.annotation.Resource;

/**
 * (InboundRecord)表控制层
 *
 * @author makejava
 * @since 2025-04-08 15:38:36
 */
@RestController
@RequestMapping("inboundRecord")
public class InboundRecordController {
    /**
     * 服务对象
     */
    @Resource
    private InboundRecordService inboundRecordService;

    /**
     * 分页查询
     *
     * @param inboundRecord 筛选条件
     * @return 查询结果
     */
    @RequestMapping("queryByPage")
    public ReturnVO queryByPage(InboundRecordEntity inboundRecord, Integer page, Integer size, String orderCol, String orderDirect) {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        
        //查询
        Page<InboundRecordEntity> pageVO = 
            this.inboundRecordService.queryByPage(
                inboundRecord, 
                page, size, 
                orderCol, orderDirect);
        //没有数据
        if(pageVO.getContent().isEmpty()){
            return returnVO;
        }
        //查询成功
        returnVO = ReturnVO.getSuccessDataReturnVO(pageVO);
        return returnVO;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("queryById/{id}")
    public ReturnVO queryById(@PathVariable("id") String id) {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        //查询单个
        InboundRecordEntity inboundRecord = this.inboundRecordService.queryById(id);
        
        if(inboundRecord == null){
            return returnVO;
        }
        //查询成功
        returnVO = ReturnVO.getSuccessDataReturnVO(inboundRecord);
        
        return returnVO;
    }

    /**
     * 新增数据
     *
     * @param inboundRecord 实体
     * @return 新增结果
     */
    @RequestMapping("add")
    public ReturnVO add(InboundRecordEntity inboundRecord) {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        //入库
        if(!this.inboundRecordService.insert(inboundRecord)){
            //入库失败
            return returnVO;
        }
        //入库成功
        returnVO.setCode(1);
        returnVO.setMsg("添加成功");
        
        return returnVO;
    }

    /**
     * 编辑数据
     *
     * @param inboundRecord 实体
     * @return 编辑结果
     */
    @RequestMapping("edit")
    public ReturnVO edit(InboundRecordEntity inboundRecord) {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        //修改
        if(!this.inboundRecordService.update(inboundRecord)){
            //修改失败
            return returnVO;
        }
        //修改成功
        returnVO.setCode(1);
        returnVO.setMsg("修改成功");
        
        return returnVO;
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @RequestMapping("deleteById/{id}")
    public ReturnVO deleteById(@PathVariable("id") String id) {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        //删除
        if(!this.inboundRecordService.deleteById(id)){
            //删除失败
            return returnVO;
        }
        //修改成功
        returnVO.setCode(1);
        returnVO.setMsg("删除成功");
        
        return returnVO;
    }

}
