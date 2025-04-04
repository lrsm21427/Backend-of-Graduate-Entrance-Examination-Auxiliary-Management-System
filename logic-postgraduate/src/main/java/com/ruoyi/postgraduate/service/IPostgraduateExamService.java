package com.ruoyi.postgraduate.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import com.ruoyi.postgraduate.domain.PostgraduateExam;

/**
 * 考研历年具体分数信息Service接口
 * 
 * @author logic
 * @date 2023-05-02
 */
public interface IPostgraduateExamService 
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
     * 批量删除考研历年具体分数信息
     * 
     * @param lineIds 需要删除的考研历年具体分数信息主键集合
     * @return 结果
     */
    public int deletePostgraduateExamByLineIds(Long[] lineIds);

    /**
     * 删除考研历年具体分数信息信息
     * 
     * @param lineId 考研历年具体分数信息主键
     * @return 结果
     */
    public int deletePostgraduateExamByLineId(Long lineId);

    /**
     * 查询去重后的专业
     *
     * @return 结果
     */
    public HashSet<String> selectMajorName(String name);

    public HashSet<Long> selectAreaSchoolByMajor(String name);

    public HashMap<Long,int[]> selectAreaScore(String areaName, String majorName);

    public ArrayList<HashMap> selectYearSchoolScore(String areaName, String majorName, Long year);

    public HashMap<String,int[]> selectAreaTreeScore(String areaName);

    public HashMap selectAreaYearScore(String areaName);

    public HashMap selectAreaYearScore_overview(String areaName);

}
