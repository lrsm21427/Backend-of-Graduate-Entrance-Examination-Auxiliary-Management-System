package com.ruoyi.recommend.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.recommend.mapper.RecommendExamMapper;
import com.ruoyi.recommend.domain.RecommendExam;
import com.ruoyi.recommend.service.IRecommendExamService;

/**
 * 考研历年具体分数信息Service业务层处理
 * 
 * @author logic
 * @date 2024-10-16
 */
@Service
public class RecommendExamServiceImpl implements IRecommendExamService 
{
    @Autowired
    private RecommendExamMapper recommendExamMapper;

    /**
     * 查询考研历年具体分数信息
     * 
     * @param lineId 考研历年具体分数信息主键
     * @return 考研历年具体分数信息
     */
    @Override
    public RecommendExam selectRecommendExamByLineId(Long lineId)
    {
        return recommendExamMapper.selectRecommendExamByLineId(lineId);
    }

    /**
     * 查询考研历年具体分数信息列表
     * 
     * @param recommendExam 考研历年具体分数信息
     * @return 考研历年具体分数信息
     */
    @Override
    public List<RecommendExam> selectRecommendExamList(RecommendExam recommendExam)
    {
        return recommendExamMapper.selectRecommendExamList(recommendExam);
    }
/**
     * 范围查询考研历年具体分数信息列表
     * 
     * @param recommendExam 考研历年具体分数信息
     * @return 考研历年具体分数信息
     */
    @Override
    public List<RecommendExam> selectRecommendExamListAry(RecommendExam recommendExam) {
        return recommendExamMapper.selectRecommendExamListAry(recommendExam);
    }

    /**
     * 新增考研历年具体分数信息
     * 
     * @param recommendExam 考研历年具体分数信息
     * @return 结果
     */
    @Override
    public int insertRecommendExam(RecommendExam recommendExam)
    {
        return recommendExamMapper.insertRecommendExam(recommendExam);
    }

    /**
     * 修改考研历年具体分数信息
     * 
     * @param recommendExam 考研历年具体分数信息
     * @return 结果
     */
    @Override
    public int updateRecommendExam(RecommendExam recommendExam)
    {
        return recommendExamMapper.updateRecommendExam(recommendExam);
    }

    /**
     * 批量删除考研历年具体分数信息
     * 
     * @param lineIds 需要删除的考研历年具体分数信息主键
     * @return 结果
     */
    @Override
    public int deleteRecommendExamByLineIds(Long[] lineIds)
    {
        return recommendExamMapper.deleteRecommendExamByLineIds(lineIds);
    }

    /**
     * 删除考研历年具体分数信息信息
     * 
     * @param lineId 考研历年具体分数信息主键
     * @return 结果
     */
    @Override
    public int deleteRecommendExamByLineId(Long lineId)
    {
        return recommendExamMapper.deleteRecommendExamByLineId(lineId);
    }
}
