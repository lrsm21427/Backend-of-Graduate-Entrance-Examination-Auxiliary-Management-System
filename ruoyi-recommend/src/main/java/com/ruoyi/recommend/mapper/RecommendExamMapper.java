package com.ruoyi.recommend.mapper;

import java.util.List;
import com.ruoyi.recommend.domain.RecommendExam;

/**
 * 考研历年具体分数信息Mapper接口
 * 
 * @author logic
 * @date 2024-10-16
 */
public interface RecommendExamMapper 
{
    /**
     * 查询考研历年具体分数信息
     * 
     * @param lineId 考研历年具体分数信息主键
     * @return 考研历年具体分数信息
     */
    public RecommendExam selectRecommendExamByLineId(Long lineId);

    /**
     * 查询考研历年具体分数信息列表（带分数范围）
     *
     * @param recommendExam 查询条件
     * @return 分数信息列表
     */
    public List<RecommendExam> selectRecommendExamListAry(RecommendExam recommendExam);
    
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
     * 删除考研历年具体分数信息
     * 
     * @param lineId 考研历年具体分数信息主键
     * @return 结果
     */
    public int deleteRecommendExamByLineId(Long lineId);

    /**
     * 批量删除考研历年具体分数信息
     * 
     * @param lineIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRecommendExamByLineIds(Long[] lineIds);
}
