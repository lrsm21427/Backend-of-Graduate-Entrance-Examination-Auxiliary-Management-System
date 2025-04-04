package com.ruoyi.recommend.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.recommend.mapper.InstitutionsExamMapper;
import com.ruoyi.recommend.domain.InstitutionsExam;
import com.ruoyi.recommend.service.IInstitutionsExamService;

/**
 * 大学推荐Service业务层处理
 * 
 * @author logic
 * @date 2024-10-16
 */
@Service
public class InstitutionsExamServiceImpl implements IInstitutionsExamService 
{
    @Autowired
    private InstitutionsExamMapper institutionsExamMapper;

    /**
     * 查询大学推荐
     * 
     * @param schoolId 大学推荐主键
     * @return 大学推荐
     */
    @Override
    public InstitutionsExam selectInstitutionsExamBySchoolId(Long schoolId)
    {
        return institutionsExamMapper.selectInstitutionsExamBySchoolId(schoolId);
    }

    /**
     * 查询大学推荐列表
     * 
     * @param institutionsExam 大学推荐
     * @return 大学推荐
     */
    @Override
    public List<InstitutionsExam> selectInstitutionsExamList(InstitutionsExam institutionsExam)
    {
        return institutionsExamMapper.selectInstitutionsExamList(institutionsExam);
    }

    /**
     * 新增大学推荐
     * 
     * @param institutionsExam 大学推荐
     * @return 结果
     */
    @Override
    public int insertInstitutionsExam(InstitutionsExam institutionsExam)
    {
        return institutionsExamMapper.insertInstitutionsExam(institutionsExam);
    }

    /**
     * 修改大学推荐
     * 
     * @param institutionsExam 大学推荐
     * @return 结果
     */
    @Override
    public int updateInstitutionsExam(InstitutionsExam institutionsExam)
    {
        return institutionsExamMapper.updateInstitutionsExam(institutionsExam);
    }

    /**
     * 批量删除大学推荐
     * 
     * @param schoolIds 需要删除的大学推荐主键
     * @return 结果
     */
    @Override
    public int deleteInstitutionsExamBySchoolIds(Long[] schoolIds)
    {
        return institutionsExamMapper.deleteInstitutionsExamBySchoolIds(schoolIds);
    }

    /**
     * 删除大学推荐信息
     * 
     * @param schoolId 大学推荐主键
     * @return 结果
     */
    @Override
    public int deleteInstitutionsExamBySchoolId(Long schoolId)
    {
        return institutionsExamMapper.deleteInstitutionsExamBySchoolId(schoolId);
    }
}
