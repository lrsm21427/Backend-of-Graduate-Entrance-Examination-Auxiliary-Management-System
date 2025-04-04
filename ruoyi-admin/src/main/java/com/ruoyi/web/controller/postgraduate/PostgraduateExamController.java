package com.ruoyi.web.controller.postgraduate;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.postgraduate.domain.PostgraduateExam;
import com.ruoyi.postgraduate.service.IPostgraduateExamService;
import com.ruoyi.web.controller.tool.AreaTree;
import com.ruoyi.web.controller.tool.PathUtils;
import com.ruoyi.web.controller.tool.PythonRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 考研历年具体分数信息Controller
 *
 * @author logic
 * @date 2023-05-02
 */
@RestController
@RequestMapping("/postgraduate/postgraduateexam")
public class PostgraduateExamController extends BaseController
{
    @Autowired
    private IPostgraduateExamService postgraduateExamService;

    /**
     * 查询考研历年具体分数信息列表
     */
    @PreAuthorize("@ss.hasPermi('postgraduate:postgraduateexam:list')")
    @GetMapping("/list")
    public TableDataInfo list(PostgraduateExam postgraduateExam)
    {
        startPage();
        List<PostgraduateExam> list = postgraduateExamService.selectPostgraduateExamList(postgraduateExam);
        return getDataTable(list);
    }

    /**
     * 导出考研历年具体分数信息列表
     */
    @PreAuthorize("@ss.hasPermi('postgraduate:postgraduateexam:export')")
    @Log(title = "考研历年具体分数信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PostgraduateExam postgraduateExam)
    {
        List<PostgraduateExam> list = postgraduateExamService.selectPostgraduateExamList(postgraduateExam);
        ExcelUtil<PostgraduateExam> util = new ExcelUtil<PostgraduateExam>(PostgraduateExam.class);
        util.exportExcel(response, list, "考研历年具体分数信息数据");
    }

    /**
     * 获取考研历年具体分数信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('postgraduate:postgraduateexam:query')")
    @GetMapping(value = "/{lineId}")
    public AjaxResult getInfo(@PathVariable("lineId") Long lineId)
    {
        return success(postgraduateExamService.selectPostgraduateExamByLineId(lineId));
    }

    /**
     * 新增考研历年具体分数信息
     */
    @PreAuthorize("@ss.hasPermi('postgraduate:postgraduateexam:add')")
    @Log(title = "考研历年具体分数信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PostgraduateExam postgraduateExam)
    {
        return toAjax(postgraduateExamService.insertPostgraduateExam(postgraduateExam));
    }

    /**
     * 修改考研历年具体分数信息
     */
    @PreAuthorize("@ss.hasPermi('postgraduate:postgraduateexam:edit')")
    @Log(title = "考研历年具体分数信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PostgraduateExam postgraduateExam)
    {
        return toAjax(postgraduateExamService.updatePostgraduateExam(postgraduateExam));
    }

    /**
     * 删除考研历年具体分数信息
     */
    @PreAuthorize("@ss.hasPermi('postgraduate:postgraduateexam:remove')")
    @Log(title = "考研历年具体分数信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{lineIds}")
    public AjaxResult remove(@PathVariable Long[] lineIds)
    {
        return toAjax(postgraduateExamService.deletePostgraduateExamByLineIds(lineIds));
    }

    /**
     * 查询专业
     */
//    模糊查询,包含输入的{name}的专业会被查询出,例如输入软件,会查询出软件工程,软件工程(学硕)等
//    http://localhost/dev-api/postgraduate/postgraduateexam/majorName/软件
//    "data":["软件工程 ","软件工程（学术型）","软件工程","数据科学（软件工程）"]
    @Anonymous
//    @PreAuthorize("@ss.hasPermi('postgraduate:postgraduateexam:query')")
    @GetMapping("/majorName/{name}")
    public AjaxResult departmentNames(@PathVariable String name)
    {
        return success(postgraduateExamService.selectMajorName(name));
    }

//    http://localhost/dev-api/postgraduate/postgraduateexam/average/山东/软件工程
//    查询每年该省院校平均分数
//    分数分别代表总分，英语，政治，专业课1，专业课2和科目数，科目数可不看
//    "data":{"2017":[318,41,41,71,71,3],"2018":[320,45,45,80,80,2],"2019":[300,44,44,66,66,3],"2023":[285,42,42,65,65,13]}
    @Anonymous
//    @PreAuthorize("@ss.hasPermi('postgraduate:postgraduateexam:query')")
    @GetMapping("/average/{area}/{major}")
    public AjaxResult average(@PathVariable String area,@PathVariable String major)
    {
        return success(postgraduateExamService.selectAreaScore(area,major));
    }


//    http://localhost/dev-api/postgraduate/postgraduateexam/average/山东/软件工程/2023
//    在average/后加省份，专业和年份，会返回该省份的高校该年份该专业的分数
//    分数分别代表总分，英语，政治，专业课1，专业课2
//    "data":[{"聊城大学":3,"中国海洋大学":1,"山东大学":9},{"聊城大学":[264,37,37,56,56]},{"中国海洋大学":[305,37,37,56,56]},{"山东大学":[290,45,45,70,70]}]
//    数组的第一个map为该大学出现次数(分数相同,仅专业链接不同,在此去重)
    @Anonymous
//    @PreAuthorize("@ss.hasPermi('postgraduate:postgraduateexam:query')")
    @GetMapping("/average/{area}/{major}/{year}")
    public AjaxResult average(@PathVariable String area,@PathVariable String major,@PathVariable Long year)
    {
        return success(postgraduateExamService.selectYearSchoolScore(area,major,year));
    }

//    http://localhost/dev-api/postgraduate/postgraduateexam/areaTree
//    用于绘制地区树
//    返回数据格式为{"中国":[{"东北":["黑龙江","吉林","辽宁"]},{"华北":["北京","天津","山西","河北","内蒙古"]},
//    {"西北":["陕西","甘肃","青海","宁夏","新疆"]},{"华东":["上海","江苏","浙江","安徽","福建","江西","山东","台湾"]},
//    {"西南":["四川","贵州","云南","重庆","西藏"]},{"华南":["广东","广西","海南","香港","澳门"]},
//    {"华中":["河南","湖北","湖南"]}]}}
    @Anonymous
//    @PreAuthorize("@ss.hasPermi('postgraduate:postgraduateexam:query')")
    @GetMapping("/areaTree")
    public AjaxResult tree()
    {
        return success(AreaTree.getAreaTree());

//        return success(postgraduateExamService.selectYearSchoolScore(area,major,year));
    }

//    http://localhost/dev-api/postgraduate/postgraduateexam/areaTreeScore/华北&华东
//    areaTreeScore/+地区,多个地区则用&连接
//    返回数据格式[{"华北":{"北京":{"首都经济贸易大学":[247,36,41,47,47,211]}},
//              {"华东":{"山东":{"山东财经大学":[328,47,49,66,66,66]}}}]
//    数组内共五个值，用于热力图绘制，分别代表总分，英语，政治，专业课1，专业课2和该学校专业数量
    @Anonymous
//    @PreAuthorize("@ss.hasPermi('postgraduate:postgraduateexam:query')")
    @GetMapping("/areaTreeScore/{allArea}")
    public AjaxResult areaTreeScore(@PathVariable String allArea)
    {
        String[] areas = allArea.split("&");
        HashMap<String,HashMap[]> areaTree = AreaTree.getAreaTree();
        ArrayList re = new ArrayList<>();
        for (String area:areas) {
            ArrayList re1 = new ArrayList<>();
            for(int i=0;i<areaTree.get("中国").length;i++)
            {
                if(areaTree.get("中国")[i].containsKey(area))
                {
                    HashMap<String,String[]> provinces = areaTree.get("中国")[i];
                    for (String province:provinces.get(area)) {
                        HashMap<String, HashMap> proSchool = new HashMap<>();
                        proSchool.put(province,postgraduateExamService.selectAreaTreeScore(province));
                        re1.add(proSchool);
                    }
                    break;

                }
            }
            HashMap<String, ArrayList> map = new HashMap<>();
            map.put(area,re1);
            re.add(map);
        }
        return success(re);
    }


//    http://localhost/dev-api/postgraduate/postgraduateexam/AreaYearScore/东北
//    areaTreeScore/+地区，只能单个地区
//    返回数据格式data":[{"黑龙江":{"2017":{"哈尔滨工业大学":[327,51,48,83,80,220],"东北农业大学":[270,36,35,55,52,67]},
//                              "2018":{...},"2019":{...}},
//                      "辽宁":{"2017":{...},"2018":{...},"2019":{...}}}]
//    数组内共五个值，分别代表总分，英语，政治，专业课1，专业课2和该学校专业数量
    @Anonymous
//    @PreAuthorize("@ss.hasPermi('postgraduate:postgraduateexam:query')")
    @GetMapping("/AreaYearScore/{allArea}")
    public AjaxResult AreaYearScore(@PathVariable String allArea)
    {
        HashMap<String,HashMap[]> areaTree = AreaTree.getAreaTree();
        ArrayList re = new ArrayList<>();
        for(int i=0;i<areaTree.get("中国").length;i++)
        {
            if(areaTree.get("中国")[i].containsKey(allArea))
            {
                HashMap<String,String[]> provinces = areaTree.get("中国")[i];
                for (String province:provinces.get(allArea)) {
                    HashMap<String, HashMap> proSchool = new HashMap<>();
                    proSchool.put(province,postgraduateExamService.selectAreaYearScore(province));
                    re.add(proSchool);
                }
                break;
            }
        }
        return success(re);
    }

    //    http://localhost/dev-api/postgraduate/postgraduateexam/AreaYearScoreOverview/东北
//    areaTreeScore/+地区，只能单个地区
//    返回数据格式"data":[{"黑龙江":{"2017":[272,39,37,62,59,525],"2018":[302,51,45,63,61,145],
//    "2019":[305,43,43,68,59,450],"2023":[300,41,43,73,49,1754]}},{"吉林":{"2017":[316,47,46,102,51,684],
//    "2018":[319,48,48,103,63,272],"2019":[309,44,44,92,58,598],"2023":[299,41,42,75,49,1989]}},
//    {"辽宁":{"2017":[314,45,43,75,69,473],"2018":[308,45,45,74,71,188],"2019":[302,44,45,71,56,637],
//    "2023":[291,40,41,68,50,2323]}}]
//    数组内共五个值，分别代表总分，英语，政治，专业课1，专业课2和该学校专业数量
    @Anonymous
//    @PreAuthorize("@ss.hasPermi('postgraduate:postgraduateexam:query')")
    @GetMapping("/AreaYearScoreOverview/{allArea}")
    public AjaxResult AreaYearScoreOverview(@PathVariable String allArea)
    {
        HashMap<String,HashMap[]> areaTree = AreaTree.getAreaTree();
        ArrayList re = new ArrayList<>();
        for(int i=0;i<areaTree.get("中国").length;i++)
        {
            if(areaTree.get("中国")[i].containsKey(allArea))
            {
                HashMap<String,String[]> provinces = areaTree.get("中国")[i];
                for (String province:provinces.get(allArea)) {
                    HashMap<String, HashMap> proSchool = new HashMap<>();
                    proSchool.put(province,postgraduateExamService.selectAreaYearScore_overview(province));
                    re.add(proSchool);
                }
                break;
            }
        }
        return success(re);
    }

//  调用python聚类
//  http://localhost/dev-api/postgraduate/postgraduateexam/cluster/华北
//    返回结果格式请在python中自定义，但必须为json，且返回结果的获取需要在python中print出来，具体请参考🐎写的样例
//    注意，要使用该方法请在application.yml中将MODEL_PATH修改为与logic-postgraduate下的python包的绝对路径对应
    @Anonymous
    //    @PreAuthorize("@ss.hasPermi('postgraduate:postgraduateexam:query')")
    @GetMapping("/cluster/{allArea}")
    public AjaxResult cluster(@PathVariable String allArea) throws IOException {
        PythonRunner pythonRunner = new PythonRunner();
        String[] sqlInfo = PathUtils.getSqlInfo();
        String path = PathUtils.getModelPath()+"/kaoyanTest.py";

        String attrs = "";
        HashMap<String,HashMap[]> areaTree = AreaTree.getAreaTree();
        for(int i=0;i<areaTree.get("中国").length;i++)
        {
            if(areaTree.get("中国")[i].containsKey(allArea))
            {
                HashMap<String,String[]> provinces = areaTree.get("中国")[i];
                for (String province:provinces.get(allArea)) {
                    attrs += province+",";
                }
                break;
            }
        }
        if (attrs.length()>=1)
        {
            attrs = attrs.substring(0, attrs.length() - 1);
        }

        JSONObject run = pythonRunner.run(path, attrs, sqlInfo[0], sqlInfo[1]);
        if (run!=null)
        {
            return success(run);
        }else {
            return error();
        }

    }



    @Anonymous
//    @PreAuthorize("@ss.hasPermi('postgraduate:postgraduateexam:query')")
    @GetMapping("/ProvinceYearScore/{province}")
    public AjaxResult ProvinceYearScore(@PathVariable String province)
    {
        HashMap<Long,HashMap<String,int[]>> hashMap = postgraduateExamService.selectAreaYearScore(province);
        ArrayList<String[]> r = new ArrayList<>();
        for(Long year:hashMap.keySet())
        {
            HashMap<String, int[]> schNames = hashMap.get(year);
            for (String schName: schNames.keySet()) {
                int[] scores = schNames.get(schName);
                String[] s = {"","","","","","","",""};
                for (int i = 0; i < 5; i++) {
                    s[i] = String.valueOf(scores[i]);
                }
                s[5] = schName;
                s[6] = AreaTree.provinceToArea(province);
                s[7] = String.valueOf(year);
                r.add(s);
            }
        }
        return success(r);
    }


}
