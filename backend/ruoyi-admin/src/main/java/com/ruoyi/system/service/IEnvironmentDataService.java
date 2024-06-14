package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.EnvironmentData;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2024-06-11
 */
public interface IEnvironmentDataService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public EnvironmentData selectEnvironmentDataById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param environmentData 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<EnvironmentData> selectEnvironmentDataList(EnvironmentData environmentData);

    /**
     * 新增【请填写功能名称】
     * 
     * @param environmentData 【请填写功能名称】
     * @return 结果
     */
    public int insertEnvironmentData(EnvironmentData environmentData);

    /**
     * 修改【请填写功能名称】
     * 
     * @param environmentData 【请填写功能名称】
     * @return 结果
     */
    public int updateEnvironmentData(EnvironmentData environmentData);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteEnvironmentDataByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteEnvironmentDataById(Long id);
}
