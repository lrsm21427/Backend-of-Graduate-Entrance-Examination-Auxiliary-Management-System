package com.ruoyi.postgraduate.service.impl;

import java.util.*;

import com.ruoyi.postgraduate.service.IUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.postgraduate.mapper.PostgraduateExamMapper;
import com.ruoyi.postgraduate.domain.PostgraduateExam;
import com.ruoyi.postgraduate.service.IPostgraduateExamService;

/**
 * 考研历年具体分数信息Service业务层处理
 * 
 * @author logic
 * @date 2023-05-02
 */
@Service
public class PostgraduateExamServiceImpl implements IPostgraduateExamService 
{
    @Autowired
    private PostgraduateExamMapper postgraduateExamMapper;
    @Autowired
    private IUniversityService universityService;

    /**
     * 查询考研历年具体分数信息
     * 
     * @param lineId 考研历年具体分数信息主键
     * @return 考研历年具体分数信息
     */
    @Override
    public PostgraduateExam selectPostgraduateExamByLineId(Long lineId)
    {
        return postgraduateExamMapper.selectPostgraduateExamByLineId(lineId);
    }

    /**
     * 查询考研历年具体分数信息列表
     * 
     * @param postgraduateExam 考研历年具体分数信息
     * @return 考研历年具体分数信息
     */
    @Override
    public List<PostgraduateExam> selectPostgraduateExamList(PostgraduateExam postgraduateExam)
    {
        return postgraduateExamMapper.selectPostgraduateExamList(postgraduateExam);
    }

    /**
     * 新增考研历年具体分数信息
     * 
     * @param postgraduateExam 考研历年具体分数信息
     * @return 结果
     */
    @Override
    public int insertPostgraduateExam(PostgraduateExam postgraduateExam)
    {
        return postgraduateExamMapper.insertPostgraduateExam(postgraduateExam);
    }

    /**
     * 修改考研历年具体分数信息
     * 
     * @param postgraduateExam 考研历年具体分数信息
     * @return 结果
     */
    @Override
    public int updatePostgraduateExam(PostgraduateExam postgraduateExam)
    {
        return postgraduateExamMapper.updatePostgraduateExam(postgraduateExam);
    }

    /**
     * 批量删除考研历年具体分数信息
     * 
     * @param lineIds 需要删除的考研历年具体分数信息主键
     * @return 结果
     */
    @Override
    public int deletePostgraduateExamByLineIds(Long[] lineIds)
    {
        return postgraduateExamMapper.deletePostgraduateExamByLineIds(lineIds);
    }

    /**
     * 删除考研历年具体分数信息信息
     * 
     * @param lineId 考研历年具体分数信息主键
     * @return 结果
     */
    @Override
    public int deletePostgraduateExamByLineId(Long lineId)
    {
        return postgraduateExamMapper.deletePostgraduateExamByLineId(lineId);
    }

    @Override
    public HashSet<String> selectMajorName(String name) {
        List<PostgraduateExam> majorNames = postgraduateExamMapper.selectMajorName(name);
        HashSet<String> depNamesSet = new HashSet<>();
        for (PostgraduateExam majorName:majorNames) {
            depNamesSet.add(majorName.getMajorName());
        }
        return depNamesSet;
    }

    @Override
    public HashSet<Long> selectAreaSchoolByMajor(String name) {
        List<PostgraduateExam> schoolIds = postgraduateExamMapper.selectSchoolIdByMajor(name);
        HashSet<Long> schoolIdSet = new HashSet<>();
        for (PostgraduateExam schoolId:schoolIds) {
            schoolIdSet.add(schoolId.getSchoolId());
        }
        return schoolIdSet;
    }

    @Override
    public HashMap<Long,int[]> selectAreaScore(String areaName, String majorName) {
        HashMap<String, ArrayList<String>> areaSchools = universityService.selectAreaAndSchoolNameByMajor(majorName);
        ArrayList<String> schools = areaSchools.get(areaName);
        String schnames = "";
        for (String school:schools) {
            schnames += school+",";
        }
        schnames = schnames.substring(0, schnames.length() - 1);
        Map<String,String> map=new HashMap<String,String>();
        map.put("schoolName",schnames);
        map.put("majorName",majorName);

        List<PostgraduateExam> postgraduateExams = postgraduateExamMapper.selectAreaScore(map);

        HashMap<Long,int[]> scores = new HashMap<>();
//        分别代表总分，英语，政治，专业课1，专业课2，数量
        for (PostgraduateExam p:postgraduateExams) {
            if(!scores.containsKey(p.getYear()))
            {
                int[] socre = {0,0,0,0,0,0};
                scores.put(p.getYear(),socre);
            }
            int[] score = scores.get(p.getYear());
            score[0] += p.getScoreTotal();
            score[1] += p.getScoreForeignLanguage();
            score[2] += p.getScorePolitics();
            score[3] += p.getScoreSpecialized1();
            score[4] += p.getScoreSpecialized2();
            score[5] += 1;
        }
        
        for (Long year: scores.keySet())
        {
            int[] score = scores.get(year);
            for (int i = 0; i < 5; i++) {
                score[i] /= score[5];
            }
        }

        return scores;
    }

    @Override
    public ArrayList<HashMap> selectYearSchoolScore(String areaName, String majorName, Long year) {
        HashMap<String, ArrayList<String>> areaSchools = universityService.selectAreaAndSchoolNameByMajor(majorName);
        ArrayList<String> schools = areaSchools.get(areaName);
        String schnames = "";
        for (String school:schools) {
            schnames += school+",";
        }
        schnames = schnames.substring(0, schnames.length() - 1);
        Map<String,String> map=new HashMap<String,String>();
        map.put("schoolName",schnames);
        map.put("majorName",majorName);

        List<PostgraduateExam> postgraduateExams = postgraduateExamMapper.selectAreaScore(map);
        HashMap<Long,ArrayList<HashMap>> scores = new HashMap<>();
//        分别代表总分，英语，政治，专业课1，专业课2
        for (PostgraduateExam p:postgraduateExams) {
            if(!scores.containsKey(p.getYear()))
            {
                ArrayList<HashMap> objects = new ArrayList<>();
                scores.put(p.getYear(),objects);
                objects.add(new HashMap());
            }

            HashMap<String,int[]> schoolName = new HashMap<>();
            int[] socre = {0,0,0,0,0};
            schoolName.put(p.getSchoolName(),socre);

            int[] score = schoolName.get(p.getSchoolName());
            score[0] += p.getScoreTotal();
            score[1] += p.getScoreForeignLanguage();
            score[2] += p.getScorePolitics();
            score[3] += p.getScoreSpecialized1();
            score[4] += p.getScoreSpecialized2();

            if (!scores.get(p.getYear()).get(0).containsKey(p.getSchoolName()))
            {
                scores.get(p.getYear()).add(schoolName);
                scores.get(p.getYear()).get(0).put(p.getSchoolName(),1);
            }else {
                scores.get(p.getYear()).get(0).put(p.getSchoolName(),(int)scores.get(p.getYear()).get(0).get(p.getSchoolName())+1);
            }
        }

        return scores.get(year);
    }

    @Override
    public HashMap<String,int[]> selectAreaTreeScore(String areaName) {
        ArrayList<Long> ids = universityService.selectSchoolIdByArea(areaName);
        String a = "";
        for (Long id:ids) {
            a+= id.toString()+",";
        }
        if (a.length()>=1)
        {
            a = a.substring(0, a.length() - 1);
        }


        List<PostgraduateExam> postgraduateExams = postgraduateExamMapper.selectAreaTreeScore(a);
        HashMap<String, int[]> scores = new HashMap<>();
        for (PostgraduateExam p:postgraduateExams) {
            if(!scores.containsKey(p.getSchoolName()))
            {
                int[] socre = {0,0,0,0,0,0};
                scores.put(p.getSchoolName(),socre);
            }
            int[] score = scores.get(p.getSchoolName());
            score[0] += p.getScoreTotal();
            score[1] += p.getScoreForeignLanguage();
            score[2] += p.getScorePolitics();
            score[3] += p.getScoreSpecialized1();
            score[4] += p.getScoreSpecialized2();
            score[5] += 1;
        }

        for (String year: scores.keySet())
        {
            int[] score = scores.get(year);
            for (int i = 0; i < 5; i++) {
                score[i] /= score[5];
            }
        }
        return scores;
    }

    @Override
    public HashMap selectAreaYearScore(String areaName) {
        ArrayList<Long> ids = universityService.selectSchoolIdByArea(areaName);
        String a = "";
        for (Long id:ids) {
            a+= id.toString()+",";
        }
        if (a.length()>=1)
        {
            a = a.substring(0, a.length() - 1);
        }


        List<PostgraduateExam> postgraduateExams = postgraduateExamMapper.selectAreaTreeScore(a);

        HashMap<Long, HashMap<String, int[]>> map = new HashMap<>();
        for (PostgraduateExam p:postgraduateExams) {
            if (!map.containsKey(p.getYear()))
            {
                HashMap<String, int[]> scores = new HashMap<>();
                map.put(p.getYear(),scores);
            }
            HashMap<String, int[]> scores = map.get(p.getYear());
            if(!scores.containsKey(p.getSchoolName()))
            {
                int[] socre = {0,0,0,0,0,0};
                scores.put(p.getSchoolName(),socre);
            }
            int[] score = scores.get(p.getSchoolName());
            score[0] += p.getScoreTotal();
            score[1] += p.getScoreForeignLanguage();
            score[2] += p.getScorePolitics();
            score[3] += p.getScoreSpecialized1();
            score[4] += p.getScoreSpecialized2();
            score[5] += 1;
        }

        for (Long year: map.keySet())
        {
            HashMap<String, int[]> schNames = map.get(year);
            for (String schName: schNames.keySet())
            {
                int[] score = schNames.get(schName);
                for (int i = 0; i < 5; i++) {
                    score[i] /= score[5];
                }
            }
        }
        return map;
    }

    @Override
    public HashMap selectAreaYearScore_overview(String areaName) {
        ArrayList<Long> ids = universityService.selectSchoolIdByArea(areaName);
        String a = "";
        for (Long id:ids) {
            a+= id.toString()+",";
        }
        if (a.length()>=1)
        {
            a = a.substring(0, a.length() - 1);
        }


        List<PostgraduateExam> postgraduateExams = postgraduateExamMapper.selectAreaTreeScore(a);

        HashMap<Long, HashMap<String, int[]>> map = new HashMap<>();
        for (PostgraduateExam p:postgraduateExams) {
            if (!map.containsKey(p.getYear()))
            {
                HashMap<String, int[]> scores = new HashMap<>();
                map.put(p.getYear(),scores);
            }
            HashMap<String, int[]> scores = map.get(p.getYear());
            if(!scores.containsKey(p.getSchoolName()))
            {
                int[] socre = {0,0,0,0,0,0};
                scores.put(p.getSchoolName(),socre);
            }
            int[] score = scores.get(p.getSchoolName());
            score[0] += p.getScoreTotal();
            score[1] += p.getScoreForeignLanguage();
            score[2] += p.getScorePolitics();
            score[3] += p.getScoreSpecialized1();
            score[4] += p.getScoreSpecialized2();
            score[5] += 1;
        }

        HashMap<Long, int[]> r = new HashMap<>();
        for (Long year: map.keySet())
        {
            int[] s = {0,0,0,0,0,0};
            HashMap<String, int[]> schNames = map.get(year);
            for (String schName: schNames.keySet())
            {
                int[] score = schNames.get(schName);
                for (int i = 0; i < 6; i++) {
                    s[i] += score[i];
                }
            }
            for (int i = 0; i < 5; i++) {
                s[i] /= s[5];
            }
            r.put(year,s);
        }
        return r;
    }

}
