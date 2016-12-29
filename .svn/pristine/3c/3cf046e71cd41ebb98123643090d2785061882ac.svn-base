package com.smk.pay.core.validator.base;

import com.smk.pay.account.core.enums.AccountInfoStatusEnum;
import com.smk.pay.account.core.enums.AccountLevelEnum;
import com.smk.pay.core.constant.AccountBizConstant;
import com.smk.pay.core.constant.ResultCodeConstant;
import com.smk.pay.core.dto.TransDetailDto;
import com.smk.pay.core.entity.LimitsEntity;
import com.smk.pay.core.entity.TransLimitEntity;
import com.smk.pay.core.enums.AccountTransTypeEnum;
import com.smk.pay.core.exception.DBException;
import com.smk.pay.core.manager.base.ITransDetailManager;
import com.smk.pay.core.mapper.LimitsEntityMapper;
import com.smk.pay.core.mapper.TransLimitEntityMapper;
import com.smk.pay.core.utils.DateUtil;
import com.smk.pay.core.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/11/15 11:44
 */
@Component(value = "transValidator")
public class TransValidator {

    @Autowired
    private ITransDetailManager transDetailManager;
    @Autowired
    private LimitsEntityMapper limitsEntityMapper;
    @Autowired
    private TransLimitEntityMapper transLimitEntityMapper;

    public Boolean isRepeatTrans(String... params) {
        try {
            return transDetailManager.isRepeatTrans(params);
        } catch (Exception e) {
            throw new DBException(e);
        }
    }

    public String transLimits(String accountCls, String accountId, String transType, BigDecimal amount) {
        Date fromDate = DateUtil.thisYear();
        Date toDate = new Date();
        List<TransLimitEntity> transLimitEntityList = transLimitEntityMapper.selectByTransType(transType);
        for (TransLimitEntity entity : transLimitEntityList) {
            BigDecimal limitVal = new BigDecimal(Long.valueOf(entity.getLimitValue()));
            String accountLevel = entity.getAccountClass();
            if (accountLevel.equals(accountCls)) {
                if (AccountBizConstant.TRANS_LIMITS_SINGLE_TIME_AMOUNT.equals(entity.getLimitType()))  {
                    if (amount.compareTo(limitVal) > 0) {
                        return ResultCodeConstant.TRANS_LIMITS_SINGLE_TIME_AMOUNT;
                    }
                } else if (AccountBizConstant.TRANS_LIMITS_SINGLE_DAY_AMOUNT.equals(entity.getLimitType())) {
                    TransDetailDto detailDto = transDetailManager.querySumAccount(transType, AccountBizConstant
                            .TRANS_DETAIL_TRANS_ID_1, accountId, AccountInfoStatusEnum.NORMAL.value(), fromDate, toDate);
                    BigDecimal totalAmt = detailDto.getAmount1().add(detailDto.getAmount2()).add(detailDto.getAmount3()).add
                            (detailDto.getAmount4()).add(detailDto.getAmount5()).add(detailDto.getAmount6());
                    if (totalAmt.add(amount).compareTo(limitVal) > 0)
                        return ResultCodeConstant.TRANS_LIMITS_SINGLE_DAY_AMOUNT;
                } else if (AccountBizConstant.TRANS_LIMITS_SINGLE_DAY_TIMES.equals(entity.getLimitType())) {
                    int times = transDetailManager.queryTransDetailCount(accountId, transType, null,
                            AccountInfoStatusEnum.NORMAL.value(), fromDate, toDate);
                    if (new BigDecimal(times + 1).compareTo(limitVal) > 0)
                        return ResultCodeConstant.TRANS_LIMITS_SINGLE_DAY_TIMES;
                } else if (AccountBizConstant.TRANS_LIMITS_SUM_AMOUNT.equals(entity.getLimitType())) {
                    TransDetailDto detailDto = transDetailManager.querySumAccount(Arrays.asList(transType), accountId,
                            fromDate, toDate, AccountInfoStatusEnum.NORMAL.value());
                    BigDecimal totalAmt = detailDto.getAmount1().add(detailDto.getAmount2()).add(detailDto.getAmount3()).add
                            (detailDto.getAmount4()).add(detailDto.getAmount5()).add(detailDto.getAmount6());
                    if (totalAmt.add(amount).compareTo(limitVal) > 0)
                        return ResultCodeConstant.TRANS_LIMITS_SUM_AMOUNT;
                }
            }
        }
        return StringUtil.EMPTY;
    }

    /**
     * 查询原交易是否存在
     *
     * @param originalSeq
     * @param originalDate
     * @param originalTime
     * @return
     */
    public TransDetailDto isExistOriginalTrans(String originalSeq, String originalDate, String originalTime) {
        TransDetailDto transDetailDto = transDetailManager.queryTransDetail(originalSeq, originalDate, originalTime);
        return transDetailDto;
    }

    public Boolean limits(String accountId, AccountLevelEnum levelEnum, BigDecimal amount) {

        LimitsEntity entity = limitsEntityMapper.selectOne();
        BigDecimal firstLevelLimit = entity.getYlzhLimit();
        BigDecimal secondLevelLimit = entity.getElzhLimit();
        BigDecimal thirdLevelLimit = entity.getSlzhLimit();
        String totalType = entity.getTotalType();

        Date toDate = new Date();
        Date fromDate;
        if (AccountBizConstant.LIMITS_TOTAL_TYPE_1.equals(totalType)) {
            fromDate = DateUtil.thisYear();
        } else {
            fromDate = DateUtil.addMonth(toDate, -12);
        }
        if (AccountLevelEnum.FIRST == levelEnum) {
            fromDate = toDate = null;
        }
        TransDetailDto transDetailDto = transDetailManager.querySumAccount(Arrays.asList
                        (AccountTransTypeEnum.CONSUME.key(), AccountTransTypeEnum.WITHDRAW.key(),
                                AccountTransTypeEnum
                                        .PRIVATE_2_PUBLIC_TRANSFER.key()), accountId, fromDate, toDate,
                AccountBizConstant.TRANS_DETAIL_STATUS_1);
        BigDecimal hisAmount = transDetailDto.getAmount1().add(transDetailDto.getAmount2()).add
                (transDetailDto.getAmount3()).add(transDetailDto.getAmount4()).add(transDetailDto
                .getAmount5()).add(transDetailDto.getAmount6());

        if (AccountLevelEnum.FIRST == levelEnum && hisAmount.add(amount).compareTo(firstLevelLimit) > 0) {
            return Boolean.FALSE;
        } else if (AccountLevelEnum.SECOND == levelEnum && hisAmount.add(amount).compareTo(secondLevelLimit) > 0) {
            return Boolean.FALSE;
        } else if (AccountLevelEnum.THIRD == levelEnum && hisAmount.add(amount).compareTo(thirdLevelLimit) > 0) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
