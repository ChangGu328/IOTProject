package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.EnvironmentData;
import com.ruoyi.system.service.IEnvironmentDataService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2024-06-11
 */
@Controller
@RequestMapping("/system/data")
public class EnvironmentDataController extends BaseController {
    private String prefix = "system/data";

    @Autowired
    private IEnvironmentDataService environmentDataService;

    @RequiresPermissions("system:data:view")
    @GetMapping()
    public String data() {
        return prefix + "/data";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    // @RequiresPermissions("system:data:list")
    @PostMapping("/list")
    @Anonymous
    @ResponseBody
    @CrossOrigin
    public TableDataInfo list(EnvironmentData environmentData) {
        // startPage();
        List<EnvironmentData> list = environmentDataService.selectEnvironmentDataList(environmentData);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:data:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EnvironmentData environmentData) {
        List<EnvironmentData> list = environmentDataService.selectEnvironmentDataList(environmentData);
        ExcelUtil<EnvironmentData> util = new ExcelUtil<EnvironmentData>(EnvironmentData.class);
        return util.exportExcel(list, "【请填写功能名称】数据");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    // @RequiresPermissions("system:data:add")
    @Anonymous
    // @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EnvironmentData environmentData) {
        return toAjax(environmentDataService.insertEnvironmentData(environmentData));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:data:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        EnvironmentData environmentData = environmentDataService.selectEnvironmentDataById(id);
        mmap.put("environmentData", environmentData);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:data:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EnvironmentData environmentData) {
        return toAjax(environmentDataService.updateEnvironmentData(environmentData));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:data:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(environmentDataService.deleteEnvironmentDataByIds(ids));
    }
}
