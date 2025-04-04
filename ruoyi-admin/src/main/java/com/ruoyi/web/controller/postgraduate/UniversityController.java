package com.ruoyi.web.controller.postgraduate;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.postgraduate.domain.University;
import com.ruoyi.postgraduate.service.IUniversityService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 大学信息Controller
 *
 * @author logic
 * @date 2023-05-01
 */
@RestController
@RequestMapping("/postgraduate/university")
public class UniversityController extends BaseController
{
    @Autowired
    private IUniversityService universityService;

    /**
     * 查询大学信息列表
     */
    @PreAuthorize("@ss.hasPermi('postgraduate:university:list')")
    @GetMapping("/list")
    public TableDataInfo list(University university)
    {
        startPage();
        List<University> list = universityService.selectUniversityList(university);
        return getDataTable(list);
    }

    /**
     * 导出大学信息列表
     */
    @PreAuthorize("@ss.hasPermi('postgraduate:university:export')")
    @Log(title = "大学信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, University university)
    {
        List<University> list = universityService.selectUniversityList(university);
        ExcelUtil<University> util = new ExcelUtil<University>(University.class);
        util.exportExcel(response, list, "大学信息数据");
    }

    /**
     * 获取大学信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('postgraduate:university:query')")
    @GetMapping(value = "/{schoolId}")
    public AjaxResult getInfo(@PathVariable("schoolId") Long schoolId)
    {
        return success(universityService.selectUniversityBySchoolId(schoolId));
    }

    /**
     * 新增大学信息
     */
    @PreAuthorize("@ss.hasPermi('postgraduate:university:add')")
    @Log(title = "大学信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody University university)
    {
        return toAjax(universityService.insertUniversity(university));
    }

    /**
     * 修改大学信息
     */
    @PreAuthorize("@ss.hasPermi('postgraduate:university:edit')")
    @Log(title = "大学信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody University university)
    {
        return toAjax(universityService.updateUniversity(university));
    }

    /**
     * 删除大学信息
     */
    @PreAuthorize("@ss.hasPermi('postgraduate:university:remove')")
    @Log(title = "大学信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{schoolIds}")
    public AjaxResult remove(@PathVariable Long[] schoolIds)
    {
        return toAjax(universityService.deleteUniversityBySchoolIds(schoolIds));
    }

    /**
     * 查询专业
     */
//    http://localhost/dev-api/postgraduate/university/AreaSchools/软件工程
//    会查询出包含{major}的学校,并按照省份分类
//    "data":{"山东":["中国海洋大学","青岛科技大学","聊城大学"],"福建":["福州大学","华侨大学"]}
    @Anonymous
//    @PreAuthorize("@ss.hasPermi('postgraduate:postgraduateexam:query')")
    @GetMapping("/AreaSchools/{major}")
    public AjaxResult AreaSchools(@PathVariable String major)
    {
        return success(universityService.selectAreaAndSchoolNameByMajor(major));
    }
}
