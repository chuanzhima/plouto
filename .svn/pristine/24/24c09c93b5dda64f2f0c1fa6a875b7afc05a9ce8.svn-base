package com.smk.pay.core.validator;

import com.smk.pay.account.core.enums.AccountInfoStatusEnum;
import com.smk.pay.account.core.request.RequestHeader;
import com.smk.pay.core.constant.AccountBizConstant;
import com.smk.pay.core.constant.ResultCodeConstant;
import com.smk.pay.core.dto.AccountInfoDto;
import com.smk.pay.core.dto.TransDetailDto;
import com.smk.pay.core.enums.AccountTransTypeEnum;
import com.smk.pay.core.manager.base.IAccountInfoManager;
import com.smk.pay.core.mapper.PrepaidCardGroupEntityMapper;
import com.smk.pay.core.validator.base.TransValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 冲正校验器
 * <p/>
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/20 14:29
 */
@Component("reverseValidator")
public class ReverseValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReverseValidator.class);

    @Autowired
    private TransValidator transValidator;
    @Resource(name = "accountInfoManager")
    private IAccountInfoManager accountInfoManager;
    @Autowired
    private PrepaidCardGroupEntityMapper prepaidCardGroupEntityMapper;

    // 商户充值校验
    public Map<Boolean, List<String>> validate(RequestHeader header, String originalSeq, String originalDate, String
            originalTime) {

        Map<Boolean, List<String>> validateMap = new HashMap<Boolean, List<String>>() {{
            put(Boolean.TRUE, Arrays.asList(ResultCodeConstant.SUCCESS));
        }};

        // 校验重复交易
        Boolean isRepeat = transValidator.isRepeatTrans(header.getReqSeq(), header.getTxDate
                (), header.getTxTime(), AccountTransTypeEnum.TRANS_REVERSE.key(), AccountInfoStatusEnum
                .NORMAL.value());
        if (isRepeat) {
            LOGGER.warn("validate result: sequence-no repeat,no=" + header.getReqSeq());
            return new HashMap<Boolean, List<String>>() {{
                put(Boolean.FALSE, Arrays.asList(ResultCodeConstant.REPEAT_TRANS_SEQUENCE_NO));
            }};
        }
        TransDetailDto detailDto = transValidator.isExistOriginalTrans(originalSeq, originalDate, originalTime);
        if (detailDto == null) {
            LOGGER.warn("original trans not exist: sequence-no =" + header.getReqSeq());
            return new HashMap<Boolean, List<String>>() {{
                put(Boolean.FALSE, Arrays.asList(ResultCodeConstant.ORIGINAL_TRANS_NOT_EXIST));
            }};
        }
        String detailStatus = detailDto.getStatus();
        // 是否已冲正
        if (AccountBizConstant.TRANS_DETAIL_STATUS_4.equals(detailStatus)) {
            LOGGER.warn("original trans has reversed: sequence-no =" + header.getReqSeq());
            return new HashMap<Boolean, List<String>>() {{
                put(Boolean.FALSE, Arrays.asList(ResultCodeConstant.TRANS_DETAIL_STATUS_HAS_REVERSED));
            }};
        } else if (!AccountBizConstant.TRANS_DETAIL_STATUS_1.equals(detailStatus)) {
            // 状态是否有效
            LOGGER.warn("original trans status invalid: sequence-no =" + header.getReqSeq());
            return new HashMap<Boolean, List<String>>() {{
                put(Boolean.FALSE, Arrays.asList(ResultCodeConstant.TRANS_DETAIL_STATUS_INVALID));
            }};
        }
        String accountId = detailDto.getAccountId();
        AccountInfoDto accountInfoDto = accountInfoManager.queryAccountById(detailDto.getAccountId());
        // 如果账户已经绑定，则查找主账户
        if (AccountInfoStatusEnum.BINDED.value().equals(accountInfoDto.getStatus())) {
            accountId = prepaidCardGroupEntityMapper.selectMainAccountIdByCardAccountId(detailDto
                    .getAccountId());
        }
        validateMap.put(Boolean.TRUE, Arrays.asList(accountId, detailDto.getTransType(), detailDto.getSerialNo()));
        return validateMap;
    }
}
