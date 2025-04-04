package com.ruoyi.postgraduate.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 大学信息对象 university
 *
 * @author logic
 * @date 2023-05-01
 */
public class University extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学校的ID */
    private Long schoolId;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    /** 学校名称 */
    @Excel(name = "学校名称")
    private String schoolName;

    /** 学校类型 */
    @Excel(name = "学校类型")
    private String type;

    /** 公办或者民办
     * （公办为1，民办为2，中外合作办学为3）*/
    @Excel(name = "公办或者民办")
    private Long publicOrPrivate;

    /** 本科或者专科
     * （普通本科为1，专科高职为2） */
    @Excel(name = "本科或者专科")
    private Long regularOrSpecial;

    /** 是否985
     * （985为1，非985为2）*/
    @Excel(name = "是否985")
    private Long project985;

    /** 是否211
     * （211位1，非211为2）*/
    @Excel(name = "是否211")
    private Long project211;

    /** 是否双一流高校
     * （double First-Class）（双一流为1，非双一流为2）*/
    @Excel(name = "是否双一流高校")
    private Long dfc;

    /** 所在城市 */
    @Excel(name = "所在城市")
    private String city;

    /** 隶属于 */
    @Excel(name = "隶属于")
    private String subordinate;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    public void setSchoolId(Long schoolId)
    {
        this.schoolId = schoolId;
    }

    public Long getSchoolId()
    {
        return schoolId;
    }
    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getProvince()
    {
        return province;
    }
    public void setSchoolName(String schoolName)
    {
        this.schoolName = schoolName;
    }

    public String getSchoolName()
    {
        return schoolName;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setPublicOrPrivate(Long publicOrPrivate)
    {
        this.publicOrPrivate = publicOrPrivate;
    }

    public Long getPublicOrPrivate()
    {
        return publicOrPrivate;
    }
    public void setRegularOrSpecial(Long regularOrSpecial)
    {
        this.regularOrSpecial = regularOrSpecial;
    }

    public Long getRegularOrSpecial()
    {
        return regularOrSpecial;
    }
    public void setProject985(Long project985)
    {
        this.project985 = project985;
    }

    public Long getProject985()
    {
        return project985;
    }
    public void setProject211(Long project211)
    {
        this.project211 = project211;
    }

    public Long getProject211()
    {
        return project211;
    }
    public void setDfc(Long dfc)
    {
        this.dfc = dfc;
    }

    public Long getDfc()
    {
        return dfc;
    }
    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCity()
    {
        return city;
    }
    public void setSubordinate(String subordinate)
    {
        this.subordinate = subordinate;
    }

    public String getSubordinate()
    {
        return subordinate;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("schoolId", getSchoolId())
            .append("province", getProvince())
            .append("schoolName", getSchoolName())
            .append("type", getType())
            .append("publicOrPrivate", getPublicOrPrivate())
            .append("regularOrSpecial", getRegularOrSpecial())
            .append("project985", getProject985())
            .append("project211", getProject211())
            .append("dfc", getDfc())
            .append("city", getCity())
            .append("subordinate", getSubordinate())
            .append("address", getAddress())
            .toString();
    }
}
