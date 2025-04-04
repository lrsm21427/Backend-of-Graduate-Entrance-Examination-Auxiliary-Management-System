package com.ruoyi.postgraduate.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.ruoyi.postgraduate.domain.University;

/**
 * 大学信息Service接口
 *
 * @author logic
 * @date 2023-05-01
 */
public interface IUniversityService
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
     * 批量删除大学信息
     *
     * @param schoolIds 需要删除的大学信息主键集合
     * @return 结果
     */
    public int deleteUniversityBySchoolIds(Long[] schoolIds);

    /**
     * 删除大学信息信息
     *
     * @param schoolId 大学信息主键
     * @return 结果
     */
    public int deleteUniversityBySchoolId(Long schoolId);

    /**
     * 查询包含的学校id的学校名称和地区
     *
     * @param name 包含的学校的id
     * @return 结果
     */
    public HashMap<String, ArrayList<String>> selectAreaAndSchoolNameByMajor(String name);

    /**
     * 通过省份查询学校的id和学校名
     *
     * @param areaName 省份
     * @return 结果
     */
    public ArrayList selectSchoolIdByArea(String areaName);
}
