package com.piggy.lwm.controller;

import com.piggy.lwm.domain.ThresholdSettingEntity;
import com.piggy.lwm.service.ThresholdSettingService;
import com.piggy.lwm.util.ReturnVO;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (ThresholdSetting)表控制层
 *
 * @author makejava
 * @since 2025-04-10 14:39:42
 */
@RestController
@RequestMapping("thresholdSetting")
public class ThresholdSettingController {
    /**
     * 服务对象
     */
    @Resource
    private ThresholdSettingService thresholdSettingService;

    /**
     * 分页查询
     *
     * @param thresholdSetting 筛选条件
     * @return 查询结果
     */
    @RequestMapping("queryByPage")
    public ReturnVO queryByPage(ThresholdSettingEntity thresholdSetting, Integer page, Integer size, String orderCol, String orderDirect) {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        
        //查询
        Page<ThresholdSettingEntity> pageVO = 
            this.thresholdSettingService.queryByPage(
                thresholdSetting, 
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
    public ReturnVO queryById(@PathVariable("id") Integer id) {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        //查询单个
        ThresholdSettingEntity thresholdSetting = this.thresholdSettingService.queryById(id);
        
        if(thresholdSetting == null){
            return returnVO;
        }
        //查询成功
        returnVO = ReturnVO.getSuccessDataReturnVO(thresholdSetting);
        
        return returnVO;
    }

    /**
     * 新增数据
     *
     * @param thresholdSetting 实体
     * @return 新增结果
     */
    @RequestMapping("add")
    public ReturnVO add(ThresholdSettingEntity thresholdSetting) {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        //入库
        if(!this.thresholdSettingService.insert(thresholdSetting)){
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
     * @param thresholdSetting 实体
     * @return 编辑结果
     */
    @RequestMapping("edit")
    public ReturnVO edit(ThresholdSettingEntity thresholdSetting) {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        //修改
        if(!this.thresholdSettingService.update(thresholdSetting)){
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
    public ReturnVO deleteById(@PathVariable("id") Integer id) {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        //删除
        if(!this.thresholdSettingService.deleteById(id)){
            //删除失败
            return returnVO;
        }
        //修改成功
        returnVO.setCode(1);
        returnVO.setMsg("删除成功");
        
        return returnVO;
    }

}
