package com.ruoyi.recommend.service;

import java.util.List;
import com.ruoyi.recommend.domain.RecommendExam;

/**
 * 考研历年具体分数信息Service接口
 * 
 * @author logic
 * @date 2024-10-16
 */
public interface IRecommendExamService 
{
    /**
     * 查询考研历年具体分数信息
     * 
     * @param lineId 考研历年具体分数信息主键
     * @return 考研历年具体分数信息
     */
    public RecommendExam selectRecommendExamByLineId(Long lineId);

    /**
     * 查询考研历年具体分数信息列表
     * 
     * @param recommendExam 考研历年具体分数信息
     * @return 考研历年具体分数信息集合
     */
    public List<RecommendExam> selectRecommendExamList(RecommendExam recommendExam);

    /**
     * 新增考研历年具体分数信息
     * 
     * @param recommendExam 考研历年具体分数信息
     * @return 结果
     */
    public int insertRecommendExam(RecommendExam recommendExam);

    /**
     * 修改考研历年具体分数信息
     * 
     * @param recommendExam 考研历年具体分数信息
     * @return 结果
     */
    public int updateRecommendExam(RecommendExam recommendExam);

    /**
     * 批量删除考研历年具体分数信息
     * 
     * @param lineIds 需要删除的考研历年具体分数信息主键集合
     * @return 结果
     */
    public int deleteRecommendExamByLineIds(Long[] lineIds);

    /**
     * 删除考研历年具体分数信息信息
     * 
     * @param lineId 考研历年具体分数信息主键
     * @return 结果
     */
    public int deleteRecommendExamByLineId(Long lineId);
}
