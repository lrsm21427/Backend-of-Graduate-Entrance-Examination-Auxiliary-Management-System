package com.ruoyi.recommend.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 考研历年具体分数信息对象 postgraduate_exam
 * 
 * @author logic
 * @date 2024-10-16
 */
public class RecommendExam extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 某一院校某一专业某一年分数的ID */
    private Long lineId;
    /** 专业ID */

    /** 学校的ID */
    @Excel(name = "学校的ID")
    private Long schoolId;

    /** 年份 */
    @Excel(name = "年份")
    private Long year;

    /** 学校链接 */
    @Excel(name = "学校链接")
    private String schoolLink;

    /** 学校名称 */
    @Excel(name = "学校名称")
    private String schoolName;

    /** 学院链接 */
    @Excel(name = "学院链接")
    private String departmentLink;

    /** 学院名字 */
    @Excel(name = "学院名字")
    private String departmentName;

    /** 专业编号 */
    @Excel(name = "专业编号")
    private String majorId;

    /** 专业链接 */
    @Excel(name = "专业链接")
    private String majorLink;

    /** 专业名字 */
    @Excel(name = "专业名字")
    private String majorName;

    /** 总分 */
    @Excel(name = "总分")
    private Long scoreTotal;

    /** 政治分数 */
    @Excel(name = "政治分数")
    private Long scorePolitics;

    /** 外语分数 */
    @Excel(name = "外语分数")
    private Long scoreForeignLanguage;

    /** 专业课一的分数 */
    @Excel(name = "专业课一的分数")
    private Long scoreSpecialized1;

    /** 专业课二的分数 */
    @Excel(name = "专业课二的分数")
    private Long scoreSpecialized2;

    public void setLineId(Long lineId) 
    {
        this.lineId = lineId;
    }

    public Long getLineId() 
    {
        return lineId;
    }
    public void setSchoolId(Long schoolId) 
    {
        this.schoolId = schoolId;
    }

    public Long getSchoolId() 
    {
        return schoolId;
    }
    public void setYear(Long year) 
    {
        this.year = year;
    }

    public Long getYear() 
    {
        return year;
    }
    public void setSchoolLink(String schoolLink) 
    {
        this.schoolLink = schoolLink;
    }

    public String getSchoolLink() 
    {
        return schoolLink;
    }
    public void setSchoolName(String schoolName) 
    {
        this.schoolName = schoolName;
    }

    public String getSchoolName() 
    {
        return schoolName;
    }
    public void setDepartmentLink(String departmentLink) 
    {
        this.departmentLink = departmentLink;
    }

    public String getDepartmentLink() 
    {
        return departmentLink;
    }
    public void setDepartmentName(String departmentName) 
    {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() 
    {
        return departmentName;
    }
    public void setMajorId(String majorId) 
    {
        this.majorId = majorId;
    }

    public String getMajorId() 
    {
        return majorId;
    }
    public void setMajorLink(String majorLink) 
    {
        this.majorLink = majorLink;
    }

    public String getMajorLink() 
    {
        return majorLink;
    }
    public void setMajorName(String majorName) 
    {
        this.majorName = majorName;
    }

    public String getMajorName() 
    {
        return majorName;
    }
    public void setScoreTotal(Long scoreTotal) 
    {
        this.scoreTotal = scoreTotal;
    }

    public Long getScoreTotal() 
    {
        return scoreTotal;
    }
    public void setScorePolitics(Long scorePolitics) 
    {
        this.scorePolitics = scorePolitics;
    }

    public Long getScorePolitics() 
    {
        return scorePolitics;
    }
    public void setScoreForeignLanguage(Long scoreForeignLanguage) 
    {
        this.scoreForeignLanguage = scoreForeignLanguage;
    }

    public Long getScoreForeignLanguage() 
    {
        return scoreForeignLanguage;
    }
    public void setScoreSpecialized1(Long scoreSpecialized1) 
    {
        this.scoreSpecialized1 = scoreSpecialized1;
    }

    public Long getScoreSpecialized1() 
    {
        return scoreSpecialized1;
    }
    public void setScoreSpecialized2(Long scoreSpecialized2) 
    {
        this.scoreSpecialized2 = scoreSpecialized2;
    }

    public Long getScoreSpecialized2() 
    {
        return scoreSpecialized2;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("lineId", getLineId())
            .append("schoolId", getSchoolId())
            .append("year", getYear())
            .append("schoolLink", getSchoolLink())
            .append("schoolName", getSchoolName())
            .append("departmentLink", getDepartmentLink())
            .append("departmentName", getDepartmentName())
            .append("majorId", getMajorId())
            .append("majorLink", getMajorLink())
            .append("majorName", getMajorName())
            .append("scoreTotal", getScoreTotal())
            .append("scorePolitics", getScorePolitics())
            .append("scoreForeignLanguage", getScoreForeignLanguage())
            .append("scoreSpecialized1", getScoreSpecialized1())
            .append("scoreSpecialized2", getScoreSpecialized2())
            .toString();
    }
}
