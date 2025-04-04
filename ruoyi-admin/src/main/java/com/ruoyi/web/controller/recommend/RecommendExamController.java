package com.ruoyi.web.controller.recommend;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.recommend.domain.RecommendExam;
import com.ruoyi.recommend.service.IRecommendExamService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 考研历年具体分数信息Controller
 *
 * @author logic
 * @date 2024-10-16
 */
@RestController
@RequestMapping("/recommend/exam")
public class RecommendExamController extends BaseController
{
    @Autowired
    private IRecommendExamService recommendExamService;

    /**
     * 查询考研历年具体分数信息列表
     */
    @PreAuthorize("@ss.hasPermi('recommend:exam:list')")
    @GetMapping("/list")
    public TableDataInfo list(RecommendExam recommendExam)
    {
        startPage();
        List<RecommendExam> list = recommendExamService.selectRecommendExamList(recommendExam);
        return getDataTable(list);
    }

    /**
     * 导出考研历年具体分数信息列表
     */
    @PreAuthorize("@ss.hasPermi('recommend:exam:export')")
    @Log(title = "考研历年具体分数信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RecommendExam recommendExam)
    {
        List<RecommendExam> list = recommendExamService.selectRecommendExamList(recommendExam);
        ExcelUtil<RecommendExam> util = new ExcelUtil<RecommendExam>(RecommendExam.class);
        util.exportExcel(response, list, "考研历年具体分数信息数据");
    }

    /**
     * 获取考研历年具体分数信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('recommend:exam:query')")
    @GetMapping(value = "/{lineId}")
    public AjaxResult getInfo(@PathVariable("lineId") Long lineId)
    {
        return success(recommendExamService.selectRecommendExamByLineId(lineId));
    }

    /**
     * 新增考研历年具体分数信息
     */
    @PreAuthorize("@ss.hasPermi('recommend:exam:add')")
    @Log(title = "考研历年具体分数信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RecommendExam recommendExam)
    {
        return toAjax(recommendExamService.insertRecommendExam(recommendExam));
    }

    /**
     * 修改考研历年具体分数信息
     */
    @PreAuthorize("@ss.hasPermi('recommend:exam:edit')")
    @Log(title = "考研历年具体分数信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RecommendExam recommendExam)
    {
        return toAjax(recommendExamService.updateRecommendExam(recommendExam));
    }

    /**
     * 删除考研历年具体分数信息
     */
    @PreAuthorize("@ss.hasPermi('recommend:exam:remove')")
    @Log(title = "考研历年具体分数信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{lineIds}")
    public AjaxResult remove(@PathVariable Long[] lineIds)
    {
        return toAjax(recommendExamService.deleteRecommendExamByLineIds(lineIds));
    }
}
