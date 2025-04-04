package com.ruoyi.postgraduate.mapper;

import java.util.List;
import com.ruoyi.postgraduate.domain.University;

/**
 * 大学信息Mapper接口
 *
 * @author logic
 * @date 2023-05-01
 */
public interface UniversityMapper
{
    /**
     * 查询大学信息
     *
     * @param schoolId 大学信息主键
     * @return 大学信息
     */
    public University selectUniversityBySchoolId(Long schoolId);

    /**
     * 查询大学信息列表
     *
     * @param university 大学信息
     * @return 大学信息集合
     */
    public List<University> selectUniversityList(University university);

    /**
     * 新增大学信息
     *
     * @param university 大学信息
     * @return 结果
     */
    public int insertUniversity(University university);

    /**
     * 修改大学信息
     *
     * @param university 大学信息
     * @return 结果
     */
    public int updateUniversity(University university);

    /**
     * 删除大学信息
     *
     * @param schoolId 大学信息主键
     * @return 结果
     */
    public int deleteUniversityBySchoolId(Long schoolId);

    /**
     * 批量删除大学信息
     *
     * @param schoolIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUniversityBySchoolIds(Long[] schoolIds);

    /**
     * 查询包含的学校id的学校名称和地区
     *
     * @param name 包含的学校id
     * @return 结果
     */
    public List<University> selectAreaAndSchoolNameBySchoolId(String name);

    /**
     * 通过地区查询学校id和学校名
     *
     * @param areaName 省份名
     * @return 结果
     */
    public List<University> selectSchoolIdByArea(String areaName);
}
