package com.inphase.imccp.domain.service.impl;

import com.inphase.imccp.domain.dao.SysRouteConfMapper;
import com.inphase.imccp.domain.entity.GatewayFilterDefinition;
import com.inphase.imccp.domain.entity.GatewayPredicateDefinition;
import com.inphase.imccp.domain.entity.GatewayRouteDefinition;
import com.inphase.imccp.domain.entity.SysRouteConfEntity;
import com.inphase.imccp.domain.service.SysRouteConfService;
import com.inphase.imccp.object.constant.ResultCode;
import com.inphase.imccp.object.returnobject.JsonResult;
import com.inphase.imccp.object.returnobject.gitListResult;
import com.inphase.imccp.object.util.SnowflakeIdWorker;
import com.inphase.imccp.object.vo.SysRouteConfVo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;

/**
 * @Author:xianxiong
 * @Date: Create in 21:47 2018/12/25 0025
 */
@Service("SysRouteConfService")
public class SysRouteConfServiceImpl implements SysRouteConfService {

    private Logger log = LoggerFactory.getLogger(SysRouteConfServiceImpl.class);

    @Resource
    private SysRouteConfMapper sysRouteConfMapper;

    @Resource
    private RedisTemplate redisTemplate;

//    @Autowired
//    private AmqpTemplate amqpTemplate;
    @Autowired
    private KafkaTemplate kafkaTemplate;

    private String ROUTE_KEY = "gateway_route_key";

    @Override
    public gitListResult getList(Integer pageNum, Integer pageSize) {
        List<SysRouteConfEntity> list = sysRouteConfMapper.getList(pageNum,pageSize);
        List<SysRouteConfVo> voList = new ArrayList<>();
        for (int i =0;i<list.size();i++){
            SysRouteConfEntity sysRouteConfEntity = list.get(i);
            SysRouteConfVo sysRouteConfVo = SysRouteConfServiceImpl.this.tranceToVo(sysRouteConfEntity);
            voList.add(sysRouteConfVo);
        }
        gitListResult listjsonResult = new gitListResult();
        listjsonResult.setCode(ResultCode.SUCCESS.code());
        listjsonResult.setMessage(ResultCode.SUCCESS.message());
        listjsonResult.setData(voList);
        listjsonResult.setPageNum(pageNum);
        listjsonResult.setPageSize(pageSize);
        listjsonResult.setTotal(voList.size());
        return listjsonResult;
    }

    @Override
    public JsonResult add(SysRouteConfVo sysRouteConfVo) {
        SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(5L,9L);
        SysRouteConfServiceImpl sysRouteConfService = new SysRouteConfServiceImpl();
        SysRouteConfEntity sysRouteConfEntity = sysRouteConfService.tranceToPo(sysRouteConfVo);
        String id = String.valueOf(snowflakeIdWorker.nextId());
        sysRouteConfEntity.setId(id);
        sysRouteConfEntity.setOrder(1);
        Timestamp d = new Timestamp(System.currentTimeMillis());
        sysRouteConfEntity.setCreateTime(d);
        sysRouteConfEntity.setDelFlag("0");
        sysRouteConfMapper.add(sysRouteConfEntity);
        return new JsonResult(ResultCode.SUCCESS.code(),ResultCode.SUCCESS.message());
    }

    @Override
    public JsonResult deleteById(String id) {
        sysRouteConfMapper.deleteById(id);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(ResultCode.SUCCESS.code());
        jsonResult.setMessage(ResultCode.SUCCESS.message());
        return jsonResult;
    }

    @Override
    public JsonResult update(SysRouteConfVo sysRouteConfVo) {
        if (sysRouteConfVo.getId().equals("")){
            return new JsonResult(ResultCode.VALUE_NULL.code(),ResultCode.VALUE_NULL.message());
        }
        SysRouteConfServiceImpl sysRouteConfService = new SysRouteConfServiceImpl();
        SysRouteConfEntity sysRouteConfEntity = sysRouteConfService.tranceToPo(sysRouteConfVo);
        Timestamp d = new Timestamp(System.currentTimeMillis());
        sysRouteConfEntity.setUpdateTime(d);
        sysRouteConfMapper.update(sysRouteConfEntity);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(ResultCode.SUCCESS.code());
        jsonResult.setMessage(ResultCode.SUCCESS.message());
        jsonResult.setData("");
        return jsonResult;
    }

    @Override
    public JsonResult apply() {
        // 清空Redis 缓存
        Boolean result = redisTemplate.delete(ROUTE_KEY);
        log.info("清空网关路由 {} ", result);
        List<SysRouteConfEntity> list = sysRouteConfMapper.getAll();
        // 遍历数组，写入数据到redis
        for (int i=0;i<list.size();i++){
            GatewayRouteDefinition gatewayRouteDefinition = SysRouteConfServiceImpl.this.tranceToGatewayRouteDefinition(list.get(i));
            redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(GatewayRouteDefinition.class));
            redisTemplate.opsForHash().put(ROUTE_KEY, gatewayRouteDefinition.getId(), gatewayRouteDefinition);
        }
        String message = "*********更新路由************";
        ListenableFuture future = kafkaTemplate.send("topic.update",message);
        future.addCallback(o -> System.out.println("send-消息发送成功：" + message), throwable -> System.out.println("消息发送失败：" + message));
//        amqpTemplate.convertAndSend("exchange","topic.update","*********更新路由************");
        return new JsonResult(ResultCode.SUCCESS.code(),ResultCode.SUCCESS.message());
    }

    @Override
    public JsonResult getAll() {
        // 清空Redis 缓存
        Boolean result = redisTemplate.delete(ROUTE_KEY);
        log.info("清空网关路由 {} ", result);
        List<SysRouteConfEntity> list = sysRouteConfMapper.getAll();
        // 遍历数组，写入数据到redis
        for (int i=0;i<list.size();i++){
            GatewayRouteDefinition gatewayRouteDefinition = SysRouteConfServiceImpl.this.tranceToGatewayRouteDefinition(list.get(i));
            redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(GatewayRouteDefinition.class));
            redisTemplate.opsForHash().put(ROUTE_KEY, gatewayRouteDefinition.getId(), gatewayRouteDefinition);
        }
        JsonResult jsonResult = new JsonResult();
        try {
            log.info("*********开始写入消息到队列");
            kafkaTemplate.send("exchange","topic.send","*********初始化路由************");
//            amqpTemplate.convertAndSend("exchange","topic.send","*********初始化路由************");
            log.info("*********结束写入消息到队列");
        }catch (Exception e){
            jsonResult.setCode(ResultCode.INPUT_QUEUE_FAILD.code());
            jsonResult.setMessage(ResultCode.INPUT_QUEUE_FAILD.message());
            return jsonResult;
        }
        jsonResult.setCode(ResultCode.SUCCESS.code());
        jsonResult.setMessage(ResultCode.SUCCESS.message());
        return jsonResult;
    }

    /**
     * po(entity) 转 GatewayRouteDefinition
     */
    private GatewayRouteDefinition tranceToGatewayRouteDefinition(SysRouteConfEntity sysRouteConfEntity){
        GatewayRouteDefinition gatewayRouteDefinition = new GatewayRouteDefinition();
        gatewayRouteDefinition.setId(sysRouteConfEntity.getRouteId());
        // 设置断言
        Object object = sysRouteConfEntity.getPredicates();
        if(Objects.nonNull(object)){
            List<GatewayPredicateDefinition> predicates = new ArrayList<>();
            JSONArray jsonArray = JSONArray.fromObject(String.valueOf(object));
            for (int i=0;i<jsonArray.size();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                GatewayPredicateDefinition gatewayPredicateDefinition = new GatewayPredicateDefinition();
                gatewayPredicateDefinition.setName(jsonObject.getString("name"));
                JSONObject argsObject = (JSONObject)jsonObject.get("args");
                Map<String,String> map = new HashMap<>();
                map.put("_genkey_0",String.valueOf(argsObject.get("_genkey_0")));
                gatewayPredicateDefinition.setArgs(map);
                predicates.add(gatewayPredicateDefinition);
            }
            gatewayRouteDefinition.setPredicates(predicates);
        }
        // 设置过滤器
        Object filterobject = sysRouteConfEntity.getFilters();
        if(Objects.nonNull(filterobject)){
            List<GatewayFilterDefinition> filterDefinitionList = new ArrayList<>();
            JSONArray filterArray = JSONArray.fromObject(String.valueOf(filterobject));
            log.info("过滤器数组：{}"+ filterArray);
            for (int i =0;i<filterArray.size();i++){
                JSONObject filterObject = filterArray.getJSONObject(i);
                GatewayFilterDefinition filterDefinition = new GatewayFilterDefinition();
                filterDefinition.setName(filterObject.getString("name"));
                JSONObject argsObject = (JSONObject)filterObject.get("args");
                log.info("获取args:{}"+argsObject);
                if (argsObject.isEmpty()){
                    log.info("获取args:{}"+argsObject);
                    Map<String,String> map = new HashMap<>();
                    filterDefinition.setArgs(map);
                }else {
                    Map<String,String> map = new HashMap<>();
                    map.put("_genkey_0",String.valueOf(argsObject.get("_genkey_0")));
                    filterDefinition.setArgs(map);
                }
                filterDefinitionList.add(filterDefinition);
            }
            gatewayRouteDefinition.setFilters(filterDefinitionList);
        }
        // 设置排序
        gatewayRouteDefinition.setOrder(0);
        // 设置转发路径
        gatewayRouteDefinition.setUri(sysRouteConfEntity.getUri());
        return gatewayRouteDefinition;
    }
    /**
     * po (entity)转vo
     */
    private SysRouteConfVo tranceToVo(SysRouteConfEntity sysRouteConfEntity){
        SysRouteConfVo sysRouteConfVo = new SysRouteConfVo();
        sysRouteConfVo.setId(sysRouteConfEntity.getId());
        sysRouteConfVo.setRouteId(sysRouteConfEntity.getRouteId());
        sysRouteConfVo.setPredicates(String.valueOf(sysRouteConfEntity.getPredicates()));
        sysRouteConfVo.setFilters(String.valueOf(sysRouteConfEntity.getFilters()));
        sysRouteConfVo.setUri(sysRouteConfEntity.getUri());
        sysRouteConfVo.setOrder(sysRouteConfEntity.getOrder());
        return sysRouteConfVo;
    }

    /**
     * vo 转 po(entity)
     */
    private SysRouteConfEntity tranceToPo(SysRouteConfVo sysRouteConfVo){
        SysRouteConfEntity sysRouteConfEntity = new SysRouteConfEntity();
        sysRouteConfEntity.setId(sysRouteConfVo.getId());
        sysRouteConfEntity.setRouteId(sysRouteConfVo.getRouteId());
        JSONArray predicatesjsonArray = JSONArray.fromObject(sysRouteConfVo.getPredicates());
        sysRouteConfEntity.setPredicates(predicatesjsonArray);
        JSONArray filtersjsonArray = JSONArray.fromObject(sysRouteConfVo.getFilters());
        sysRouteConfEntity.setFilters(filtersjsonArray);
        sysRouteConfEntity.setUri(sysRouteConfVo.getUri());
        return sysRouteConfEntity;
    }

}
