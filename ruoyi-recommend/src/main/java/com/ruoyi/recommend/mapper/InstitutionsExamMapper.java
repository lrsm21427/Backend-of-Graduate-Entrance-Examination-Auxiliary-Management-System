package com.ruoyi.recommend.mapper;

import java.util.List;
import com.ruoyi.recommend.domain.InstitutionsExam;

/**
 * 大学推荐Mapper接口
 * 
 * @author logic
 * @date 2024-10-16
 */
public interface InstitutionsExamMapper 
{
    /**
     * 查询大学推荐
     * 
     * @param schoolId 大学推荐主键
     * @return 大学推荐
     */
    public InstitutionsExam selectInstitutionsExamBySchoolId(Long schoolId);

    /**
     * 查询大学推荐列表
     * 
     * @param institutionsExam 大学推荐
     * @return 大学推荐集合
     */
    public List<InstitutionsExam> selectInstitutionsExamList(InstitutionsExam institutionsExam);

    /**
     * 新增大学推荐
     * 
     * @param institutionsExam 大学推荐
     * @return 结果
     */
    public int insertInstitutionsExam(InstitutionsExam institutionsExam);

    /**
     * 修改大学推荐
     * 
     * @param institutionsExam 大学推荐
     * @return 结果
     */
    public int updateInstitutionsExam(InstitutionsExam institutionsExam);

    /**
     * 删除大学推荐
     * 
     * @param schoolId 大学推荐主键
     * @return 结果
     */
    public int deleteInstitutionsExamBySchoolId(Long schoolId);

    /**
     * 批量删除大学推荐
     * 
     * @param schoolIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteInstitutionsExamBySchoolIds(Long[] schoolIds);
}
