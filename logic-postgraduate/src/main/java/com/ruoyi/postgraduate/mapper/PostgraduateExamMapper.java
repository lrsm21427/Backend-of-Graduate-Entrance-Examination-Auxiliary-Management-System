package com.ruoyi.postgraduate.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.postgraduate.domain.PostgraduateExam;
import io.lettuce.core.dynamic.annotation.Param;

/**
 * 考研历年具体分数信息Mapper接口
 * 
 * @author logic
 * @date 2023-05-02
 */
public interface PostgraduateExamMapper 
{
    /**
     * 查询考研历年具体分数信息
     *
     * @param lineId 考研历年具体分数信息主键
     * @return 考研历年具体分数信息
     */
    public PostgraduateExam selectPostgraduateExamByLineId(Long lineId);

    /**
     * 查询考研历年具体分数信息列表
     * 
     * @param postgraduateExam 考研历年具体分数信息
     * @return 考研历年具体分数信息集合
     */
    public List<PostgraduateExam> selectPostgraduateExamList(PostgraduateExam postgraduateExam);

    /**
     * 查询专业
     *
     * @return 考研历年具体分数信息集合
     */
    public List<PostgraduateExam> selectMajorName(String name);

    /**
     * 查询专业
     *
     * @return 考研历年具体分数信息集合
     */
    public List<PostgraduateExam> selectSchoolIdByMajor(String name);

    /**
     * 新增考研历年具体分数信息
     * 
     * @param postgraduateExam 考研历年具体分数信息
     * @return 结果
     */
    public int insertPostgraduateExam(PostgraduateExam postgraduateExam);

    /**
     * 修改考研历年具体分数信息
     * 
     * @param postgraduateExam 考研历年具体分数信息
     * @return 结果
     */
    public int updatePostgraduateExam(PostgraduateExam postgraduateExam);

    /**
     * 删除考研历年具体分数信息
     * 
     * @param lineId 考研历年具体分数信息主键
     * @return 结果
     */
    public int deletePostgraduateExamByLineId(Long lineId);

    /**
     * 批量删除考研历年具体分数信息
     * 
     * @param lineIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePostgraduateExamByLineIds(Long[] lineIds);

    /**
     * 根据院校和专业查分数
     *
     * @return 结果
     */
    public List<PostgraduateExam> selectAreaScore(Map map);

    /**
     * 根据地区查询该所院校分数信息
     *
     * @return 结果
     */
    public List<PostgraduateExam> selectAreaTreeScore(String ids);
}
