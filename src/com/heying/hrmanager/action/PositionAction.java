package com.heying.hrmanager.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.heying.hrmanager.pojo.Dept;
import com.heying.hrmanager.pojo.Position;
import com.heying.hrmanager.service.DeptService;
import com.heying.hrmanager.service.PositionService;

@Controller
public class PositionAction {
	@Resource
	private DeptService deptService;
	@Resource
	private PositionService positionService;
	
	@ModelAttribute("deptList")
	public List<Dept> getAllDept(){
		return deptService.getAllDept();
	}
	@RequestMapping("/postionAddOper")
	public String addPostionOper()throws Exception{
		return "company/addPosition";
	}
	@RequestMapping("/addPosition")
	public String addPosition(Position position) throws Exception{
		position.setCreatetime(new Date());
		positionService.add(position);
		return "redirect:postionAddOper.action";
	}
	@RequestMapping("/positionEditOper")
	public String editPositionOper(Integer id,Model model) throws Exception{
		Position position=positionService.getPositionById(id);
		model.addAttribute("position", position);
		return "company/editPostion";
	}
	@RequestMapping("/editPosition")
	public String editPosition(@ModelAttribute("position") Position position) throws Exception{
		positionService.update(position);
		return "redirect:positionListOper.action";
	}
	@RequestMapping("/positionListOper")
	public String listPositionOper(Model model,@RequestParam(defaultValue="2") Integer deptid) throws Exception{
		List<Position> positionList=positionService.getAllPostionByDeptId(deptid);
		model.addAttribute("positionList", positionList);
		return "company/positionList";
	}
}
