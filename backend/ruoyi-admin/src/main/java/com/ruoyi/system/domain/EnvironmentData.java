package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 environment_data
 * 
 * @author ruoyi
 * @date 2024-06-11
 */
public class EnvironmentData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String recordTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal indoorTemperature;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String indoorHumidity;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String illumination;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String co2Concentration;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String pm25Concentration;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String pm10Concentration;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal formaldehydeLevel;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String noiseLevel;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setRecordTime(String recordTime) 
    {
        this.recordTime = recordTime;
    }

    public String getRecordTime() 
    {
        return recordTime;
    }

    public void setIndoorTemperature(BigDecimal indoorTemperature) 
    {
        this.indoorTemperature = indoorTemperature;
    }

    public BigDecimal getIndoorTemperature() 
    {
        return indoorTemperature;
    }

    public void setIndoorHumidity(String indoorHumidity) 
    {
        this.indoorHumidity = indoorHumidity;
    }

    public String getIndoorHumidity() 
    {
        return indoorHumidity;
    }

    public void setIllumination(String illumination) 
    {
        this.illumination = illumination;
    }

    public String getIllumination() 
    {
        return illumination;
    }

    public void setCo2Concentration(String co2Concentration) 
    {
        this.co2Concentration = co2Concentration;
    }

    public String getCo2Concentration() 
    {
        return co2Concentration;
    }

    public void setPm25Concentration(String pm25Concentration) 
    {
        this.pm25Concentration = pm25Concentration;
    }

    public String getPm25Concentration() 
    {
        return pm25Concentration;
    }

    public void setPm10Concentration(String pm10Concentration) 
    {
        this.pm10Concentration = pm10Concentration;
    }

    public String getPm10Concentration() 
    {
        return pm10Concentration;
    }

    public void setFormaldehydeLevel(BigDecimal formaldehydeLevel) 
    {
        this.formaldehydeLevel = formaldehydeLevel;
    }

    public BigDecimal getFormaldehydeLevel() 
    {
        return formaldehydeLevel;
    }

    public void setNoiseLevel(String noiseLevel) 
    {
        this.noiseLevel = noiseLevel;
    }

    public String getNoiseLevel() 
    {
        return noiseLevel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("recordTime", getRecordTime())
            .append("indoorTemperature", getIndoorTemperature())
            .append("indoorHumidity", getIndoorHumidity())
            .append("illumination", getIllumination())
            .append("co2Concentration", getCo2Concentration())
            .append("pm25Concentration", getPm25Concentration())
            .append("pm10Concentration", getPm10Concentration())
            .append("formaldehydeLevel", getFormaldehydeLevel())
            .append("noiseLevel", getNoiseLevel())
            .toString();
    }
}
