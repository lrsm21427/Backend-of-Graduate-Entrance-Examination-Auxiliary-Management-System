package com.ruoyi.postgraduate.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ruoyi.postgraduate.domain.PostgraduateExam;
import com.ruoyi.postgraduate.mapper.PostgraduateExamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.postgraduate.mapper.UniversityMapper;
import com.ruoyi.postgraduate.domain.University;
import com.ruoyi.postgraduate.service.IUniversityService;

/**
 * 大学信息Service业务层处理
 *
 * @author logic
 * @date 2023-05-01
 */
@Service
public class UniversityServiceImpl implements IUniversityService {
    @Autowired
    private UniversityMapper universityMapper;
    @Autowired
    private PostgraduateExamMapper postgraduateExamMapper;

    /**
     * 查询大学信息
     *
     * @param schoolId 大学信息主键
     * @return 大学信息
     */
    @Override
    public University selectUniversityBySchoolId(Long schoolId) {
        return universityMapper.selectUniversityBySchoolId(schoolId);
    }

    /**
     * 查询大学信息列表
     *
     * @param university 大学信息
     * @return 大学信息
     */
    @Override
    public List<University> selectUniversityList(University university) {
        return universityMapper.selectUniversityList(university);
    }

    /**
     * 新增大学信息
     *
     * @param university 大学信息
     * @return 结果
     */
    @Override
    public int insertUniversity(University university) {
        return universityMapper.insertUniversity(university);
    }

    /**
     * 修改大学信息
     *
     * @param university 大学信息
     * @return 结果
     */
    @Override
    public int updateUniversity(University university) {
        return universityMapper.updateUniversity(university);
    }

    /**
     * 批量删除大学信息
     *
     * @param schoolIds 需要删除的大学信息主键
     * @return 结果
     */
    @Override
    public int deleteUniversityBySchoolIds(Long[] schoolIds) {
        return universityMapper.deleteUniversityBySchoolIds(schoolIds);
    }

    /**
     * 删除大学信息信息
     *
     * @param schoolId 大学信息主键
     * @return 结果
     */
    @Override
    public int deleteUniversityBySchoolId(Long schoolId) {
        return universityMapper.deleteUniversityBySchoolId(schoolId);
    }

//    通过专业查询省份和学校名
    @Override
    public HashMap<String, ArrayList<String>> selectAreaAndSchoolNameByMajor(String name) {
        List<PostgraduateExam> postgraduateExams = postgraduateExamMapper.selectSchoolIdByMajor(name);
        String ids = "";
        for (PostgraduateExam p : postgraduateExams) {
            ids += p.getSchoolId().toString() + ",";
        }
        ids = ids.substring(0, ids.length() - 1);

        List<University> universities = universityMapper.selectAreaAndSchoolNameBySchoolId(ids);
        HashMap<String, ArrayList<String>> AreaSchools = new HashMap<>();
        for (University university : universities) {
            if (!AreaSchools.containsKey(university.getProvince())) {
                AreaSchools.put(university.getProvince(), new ArrayList<>());
            }
            AreaSchools.get(university.getProvince()).add(university.getSchoolName());
        }
        return AreaSchools;
    }

//    通过省份查询学校id
    @Override
    public ArrayList selectSchoolIdByArea(String areaName) {
        List<University> universities = universityMapper.selectSchoolIdByArea(areaName);
        ArrayList<Long> ids = new ArrayList<>();
        for (University u: universities) {
            ids.add(u.getSchoolId());
        }
        return ids;
    }
}
