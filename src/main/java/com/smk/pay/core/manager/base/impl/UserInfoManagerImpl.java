package com.smk.pay.core.manager.base.impl;

import com.smk.pay.core.dto.UserInfoDto;
import com.smk.pay.core.entity.UserInfoEntity;
import com.smk.pay.core.entity.UserMappingEntity;
import com.smk.pay.core.exception.DBException;
import com.smk.pay.core.manager.base.IUserInfoManager;
import com.smk.pay.core.mapper.UserInfoEntityMapper;
import com.smk.pay.core.mapper.UserMappingEntityMapper;
import com.smk.pay.core.utils.BeanCopierCacheUtil;
import com.smk.pay.core.utils.StringUtil;
import com.smk.pay.dal.condtion.Criteria;
import com.smk.pay.dal.condtion.EntityCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/10/21 10:12
 */
@Service(value = "userInfoManager")
public class UserInfoManagerImpl implements IUserInfoManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoManagerImpl.class);
    @Autowired
    private UserInfoEntityMapper userInfoEntityMapper;
    @Autowired
    private UserMappingEntityMapper userMappingEntityMapper;

    @Override
    public String getUserIdByCustId(String custId) {
        UserMappingEntity userMappingEntity = userMappingEntityMapper.getByCustId(custId);
        if (userMappingEntity == null)
            return StringUtil.EMPTY;
        return userMappingEntity.getUserId();
    }

    public UserInfoDto getUserByTypeAndNo(String type, String no) {
        UserInfoDto userInfoDto = new UserInfoDto();
        try {
            List<UserInfoEntity> userInfoEntityList = userInfoEntityMapper
                    .selectList(new EntityCondition().addCriteria(new Criteria().addCriterion
                            ("PAPERS_TYPE=", type, "PAPERS_TYPE").addCriterion("PAPERS_NO=", no,
                            "PAPERS_NO")));
            if (!CollectionUtils.isEmpty(userInfoEntityList)) {
                UserInfoEntity userInfoEntity = userInfoEntityList.get(0);
                BeanCopierCacheUtil.copy(userInfoEntity, userInfoDto, null);
                return userInfoDto;
            }
            return null;
        } catch (Exception e) {
            throw new DBException(e);
        }
    }

    public void addUser(UserInfoDto userInfoDto) {
        try {
            UserInfoEntity userInfoEntity = new UserInfoEntity();
            BeanCopierCacheUtil.copy(userInfoDto, userInfoEntity, null);
            userInfoEntity.setCreateDate(new Date());
            userInfoEntityMapper.insertSelective(userInfoEntity);
        } catch (Exception e) {
            throw new DBException(e);
        }
    }

    @Override
    public UserInfoDto getUserByPkId(String userId) {
        UserInfoDto userInfoDto = new UserInfoDto();
        try {
            UserInfoEntity userInfoEntity = userInfoEntityMapper.selectByPrimaryKey(userId);
            if (null != userInfoEntity) {
                BeanCopierCacheUtil.copy(userInfoEntity, userInfoDto, null);
                return userInfoDto;
            }
            return null;
        } catch (Exception e) {
            throw new DBException(e);
        }
    }
}
