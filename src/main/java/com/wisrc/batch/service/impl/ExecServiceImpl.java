package com.wisrc.batch.service.impl;

import com.wisrc.batch.dao.ExecDao;
import com.wisrc.batch.dto.BatchRunConfDto;
import com.wisrc.batch.entity.ExecLogEntity;
import com.wisrc.batch.service.ExecService;
import com.wisrc.batch.utils.RetMsg;
import com.wisrc.batch.utils.SysStatus;
import com.wisrc.batch.utils.factory.RetMsgFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hzwy23 on 2017/7/13.
 */
@Service
public class ExecServiceImpl implements ExecService {
    private final Logger logger = LoggerFactory.getLogger(ExecServiceImpl.class);
    @Autowired
    private ExecDao execDao;

    @Override
    public RetMsg echo(ExecLogEntity row) {
        try {
            int size = execDao.insert(row);
            if (1 == size) {
                return RetMsgFactory.getRetMsg(SysStatus.SUCCESS_CODE, "success", null);
            }
            return RetMsgFactory.getRetMsg(SysStatus.ERROR_CODE, "写入执行信息失败", null);
        } catch (Exception e) {
            return RetMsgFactory.getRetMsg(SysStatus.EXCEPTION_ERROR_CODE, e.getMessage(), row.toString());
        }
    }

    @Override
    public List<ExecLogEntity> query(String id, String jobId) {
        try {
            return execDao.query(id, jobId);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public RetMsg init(BatchRunConfDto confDto) {
        try {
            execDao.init(confDto);
            return RetMsgFactory.getRetMsg(SysStatus.SUCCESS_CODE, "success", null);
        } catch (DataAccessException e) {
            return RetMsgFactory.getRetMsg(SysStatus.EXCEPTION_ERROR_CODE, e.getMessage(), confDto.getBatchId());
        }
    }
}
