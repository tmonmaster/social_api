package kr.co.tmon.social.api.service;

import java.util.List;

import kr.co.tmon.social.api.dao.AndroidAppDao;
import kr.co.tmon.social.api.vo.AndroidApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 정승현 - RASPILLA16@tmon.co.kr
 * 
 */
@Service
public class AndroidAppService {

	@Autowired
	private AndroidAppDao androidAppDao;

	public List<AndroidApp> getAndroidAppList() {
		return androidAppDao.getAndroidAppList();
	}
}
