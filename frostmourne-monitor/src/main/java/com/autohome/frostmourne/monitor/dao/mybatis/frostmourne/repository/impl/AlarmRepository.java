package com.autohome.frostmourne.monitor.dao.mybatis.frostmourne.repository.impl;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.mybatis.dynamic.sql.select.CountDSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.autohome.frostmourne.common.contract.PagerContract;
import com.autohome.frostmourne.monitor.dao.mybatis.frostmourne.domain.generate.Alarm;
import com.autohome.frostmourne.monitor.dao.mybatis.frostmourne.mapper.dynamic.AlarmDynamicMapper;
import com.autohome.frostmourne.monitor.dao.mybatis.frostmourne.mapper.dynamic.AlarmDynamicSqlSupport;
import com.autohome.frostmourne.monitor.dao.mybatis.frostmourne.repository.IAlarmRepository;
import com.autohome.frostmourne.monitor.model.enums.AlarmStatus;
import com.autohome.frostmourne.monitor.model.enums.ExecuteStatus;
import com.autohome.frostmourne.monitor.tool.MybatisTool;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Repository
public class AlarmRepository implements IAlarmRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlarmRepository.class);

    @Resource
    private AlarmDynamicMapper alarmDynamicMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return alarmDynamicMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Long insert(Alarm record) {
        alarmDynamicMapper.insert(record);
        return record.getId();
    }

    @Override
    public Optional<Alarm> selectByPrimaryKey(Long id) {
        return alarmDynamicMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Alarm record) {
        return alarmDynamicMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Alarm record) {
        return alarmDynamicMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateStatus(Long alarmId, AlarmStatus status) {
        Alarm record = new Alarm();
        record.setId(alarmId);
        record.setStatus(status);
        return alarmDynamicMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PagerContract<Alarm> findPage(int pageIndex, int pageSize, Long alarmId, String name, String teamName, AlarmStatus status, Long serviceId) {
        Page page = PageHelper.startPage(pageIndex, pageSize);
        List<Alarm> list = alarmDynamicMapper.select(query -> {
            query.where().and(AlarmDynamicSqlSupport.id, isEqualTo(alarmId).when(MybatisTool::notNullAndZero))
                .and(AlarmDynamicSqlSupport.alarmName, isLike(name).when(MybatisTool::notNullAndEmpty).then(MybatisTool::twoSideVagueMatch))
                .and(AlarmDynamicSqlSupport.teamName, isEqualTo(teamName).when(MybatisTool::notNullAndEmpty))
                .and(AlarmDynamicSqlSupport.status, isEqualTo(status).when(MybatisTool::notNull))
                .and(AlarmDynamicSqlSupport.serviceId, isEqualTo(serviceId).when(MybatisTool::notNullAndZero))
                .orderBy(AlarmDynamicSqlSupport.createAt.descending());
            return query;
        });
        return new PagerContract<>(list, page.getPageSize(), page.getPageNum(), (int)page.getTotal());
    }

    @Override
    public void updateAlarmLastExecuteInfo(Long alarmId, Date executeTime, ExecuteStatus executeResult) {
        Alarm record = new Alarm();
        record.setId(alarmId);
        record.setExecuteAt(executeTime);
        record.setExecuteResult(executeResult);
        alarmDynamicMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateJobId(Long alarmId, Long jobId) {
        Alarm record = new Alarm();
        record.setId(alarmId);
        record.setJobId(jobId);
        return alarmDynamicMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long total() {
        return alarmDynamicMapper.count(CountDSL::where);
    }

    @Override
    public List<Alarm> querySchedule(Long maxNextTime, Long size) {
        List<Alarm> list = alarmDynamicMapper.select(query -> {
            query.where().and(AlarmDynamicSqlSupport.status, isEqualTo(AlarmStatus.OPEN))
                .and(AlarmDynamicSqlSupport.triggerNextTime, isLessThanOrEqualTo(maxNextTime)).orderBy(AlarmDynamicSqlSupport.id.descending()).limit(size);
            return query;
        });
        return list;
    }

    @Override
    public int scheduleUpdate(long alarmId, long triggerLastTime, long triggerNextTime) {
        return alarmDynamicMapper.update(dsl -> dsl.set(AlarmDynamicSqlSupport.triggerLastTime).equalTo(triggerLastTime)
            .set(AlarmDynamicSqlSupport.triggerNextTime).equalTo(triggerNextTime).where(AlarmDynamicSqlSupport.id, isEqualTo(alarmId)));
    }
}
