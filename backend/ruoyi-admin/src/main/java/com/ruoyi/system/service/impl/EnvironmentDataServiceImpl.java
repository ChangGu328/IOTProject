package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EnvironmentDataMapper;
import com.ruoyi.system.domain.EnvironmentData;
import com.ruoyi.system.service.IEnvironmentDataService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-06-11
 */
@Service
public class EnvironmentDataServiceImpl implements IEnvironmentDataService 
{
    @Autowired
    private EnvironmentDataMapper environmentDataMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public EnvironmentData selectEnvironmentDataById(Long id)
    {
        return environmentDataMapper.selectEnvironmentDataById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param environmentData 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<EnvironmentData> selectEnvironmentDataList(EnvironmentData environmentData)
    {
        return environmentDataMapper.selectEnvironmentDataList(environmentData);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param environmentData 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertEnvironmentData(EnvironmentData environmentData)
    {
        return environmentDataMapper.insertEnvironmentData(environmentData);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param environmentData 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateEnvironmentData(EnvironmentData environmentData)
    {
        return environmentDataMapper.updateEnvironmentData(environmentData);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteEnvironmentDataByIds(String ids)
    {
        return environmentDataMapper.deleteEnvironmentDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteEnvironmentDataById(Long id)
    {
        return environmentDataMapper.deleteEnvironmentDataById(id);
    }
}
