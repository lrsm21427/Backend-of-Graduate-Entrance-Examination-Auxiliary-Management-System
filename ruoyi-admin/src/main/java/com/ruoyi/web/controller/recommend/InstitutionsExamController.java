package com.ruoyi.web.controller.recommend;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.recommend.domain.InstitutionsExam;
import com.ruoyi.recommend.service.IInstitutionsExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 大学推荐Controller
 * 
 * @author logic
 * @date 2024-10-16
 */
@RestController
@RequestMapping("/recommend/institutions")
public class InstitutionsExamController extends BaseController
{
    @Autowired
    private IInstitutionsExamService institutionsExamService;

    /**
     * 查询大学推荐列表
     */
    @PreAuthorize("@ss.hasPermi('recommend:institutions:list')")
    @GetMapping("/list")
    public TableDataInfo list(InstitutionsExam institutionsExam)
    {
        startPage();
        List<InstitutionsExam> list = institutionsExamService.selectInstitutionsExamList(institutionsExam);
        return getDataTable(list);
    }

    /**
     * 导出大学推荐列表
     */
    @PreAuthorize("@ss.hasPermi('recommend:institutions:export')")
    @Log(title = "大学推荐", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, InstitutionsExam institutionsExam)
    {
        List<InstitutionsExam> list = institutionsExamService.selectInstitutionsExamList(institutionsExam);
        ExcelUtil<InstitutionsExam> util = new ExcelUtil<InstitutionsExam>(InstitutionsExam.class);
        util.exportExcel(response, list, "大学推荐数据");
    }

    /**
     * 获取大学推荐详细信息
     */
    @PreAuthorize("@ss.hasPermi('recommend:institutions:query')")
    @GetMapping(value = "/{schoolId}")
    public AjaxResult getInfo(@PathVariable("schoolId") Long schoolId)
    {
        return success(institutionsExamService.selectInstitutionsExamBySchoolId(schoolId));
    }

    /**
     * 新增大学推荐
     */
    @PreAuthorize("@ss.hasPermi('recommend:institutions:add')")
    @Log(title = "大学推荐", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody InstitutionsExam institutionsExam)
    {
        return toAjax(institutionsExamService.insertInstitutionsExam(institutionsExam));
    }

    /**
     * 修改大学推荐
     */
    @PreAuthorize("@ss.hasPermi('recommend:institutions:edit')")
    @Log(title = "大学推荐", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody InstitutionsExam institutionsExam)
    {
        return toAjax(institutionsExamService.updateInstitutionsExam(institutionsExam));
    }

    /**
     * 删除大学推荐
     */
    @PreAuthorize("@ss.hasPermi('recommend:institutions:remove')")
    @Log(title = "大学推荐", businessType = BusinessType.DELETE)
	@DeleteMapping("/{schoolIds}")
    public AjaxResult remove(@PathVariable Long[] schoolIds)
    {
        return toAjax(institutionsExamService.deleteInstitutionsExamBySchoolIds(schoolIds));
    }
}
