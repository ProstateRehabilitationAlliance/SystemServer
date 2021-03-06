package com.prostate.common.controller;

import com.prostate.system.domain.UserToken;
import org.springframework.stereotype.Controller;
import com.prostate.common.utils.ShiroUtils;
import com.prostate.system.domain.UserDO;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}