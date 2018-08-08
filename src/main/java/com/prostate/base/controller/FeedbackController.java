package com.prostate.base.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.prostate.common.utils.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prostate.base.domain.FeedbackDO;
import com.prostate.base.service.FeedbackService;
import com.prostate.common.utils.PageUtils;
import com.prostate.common.utils.Query;
import com.prostate.common.utils.R;

/**
 * 用户意见反馈表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-08 09:29:42
 */
 
@Controller
@RequestMapping("/base/feedback")
public class FeedbackController {
	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping()
	@RequiresPermissions("base:feedback:feedback")
	String Feedback(){
	    return "base/feedback/feedback";
	}



	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:feedback:feedback")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FeedbackDO> feedbackList = feedbackService.list(query);
		//只是简单的页面列表展示，因此先展示25个字。
		for (FeedbackDO feedbackDO:feedbackList) {
			String str = feedbackDO.getFeedbackText();
			if (str.length()>50){
				str = str.substring(0,50)+"……";
			}
			feedbackDO.setFeedbackText(str);
		}
		int total = feedbackService.count(query);
		PageUtils pageUtils = new PageUtils(feedbackList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("base:feedback:add")
	String add(){
	    return "base/feedback/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("base:feedback:edit")
	String edit(@PathVariable("id") String id,Model model){
		FeedbackDO feedback = feedbackService.get(id);
		model.addAttribute("feedback", feedback);
	    return "base/feedback/edit";
	}


	/**
	 *@Author:      ykbian
	 *@date_time:   2018/8/8 15:39
	 *@Description: 跳转反馈详情页
	 *@param:
	*/
	@GetMapping("/details/{id}")
	@RequiresPermissions("base:feedback:details")
	String details(@PathVariable("id") String id,Model model){
		FeedbackDO feedback = feedbackService.get(id);
		model.addAttribute("feedback", feedback);
		return "base/feedback/details";
	}


	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:feedback:add")
	public R save( FeedbackDO feedback){
		if(feedbackService.save(feedback)>0){
			return R.ok();
		}
		return R.error();
	}


	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:feedback:edit")
	public R update( FeedbackDO feedback){
		feedbackService.update(feedback);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:feedback:remove")
	public R remove( String id){
		if(feedbackService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:feedback:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		feedbackService.batchRemove(ids);
		return R.ok();
	}
	
}
