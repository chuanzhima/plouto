package com.smk.pay.core.manager.base;

import com.smk.pay.core.dto.TransDetailDto;

import java.util.Date;
import java.util.List;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/11/11 16:26
 */
public interface ITransDetailManager {

    int addTransDetail(TransDetailDto transDetailDto);

    TransDetailDto querySumAccount(String transType, String transId, String accountId, String status,
                                   Date fromTransDate, Date toTransDate);

    TransDetailDto querySumAccount(List<String> transTypes, String accountId,
                                   Date fromTransDate, Date toTransDate, String status);

    List<TransDetailDto> queryTransDetail(String accountId, String transType, String merchantId,
                                          Date fromDate, Date toDate, int pageNum, int pageSize);

    int queryTransDetailCount(String accountId, String transType, String merchantId, String status, Date
            fromDate, Date toDate);

    TransDetailDto queryTransDetail(String reqseq, String originalDate, String originalTime);

    Boolean isRepeatTrans(String... params);

    TransDetailDto queryById(String sequence, String transId);

    int updateStatusByPkId(String sequence, String transId, String newStatus);
}
