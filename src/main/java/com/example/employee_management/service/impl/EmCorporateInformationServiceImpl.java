package com.example.employee_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.employee_management.common.utils.FileUtil;
import com.example.employee_management.entity.EmCorporateInformation;
import com.example.employee_management.mapper.EmCorporateInformationMapper;
import com.example.employee_management.service.EmCorporateInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 企业信息管理 服务实现类
 * </p>
 */
@Service
public class EmCorporateInformationServiceImpl implements EmCorporateInformationService {
    @Autowired
    EmCorporateInformationMapper mapper;

    /**
     * 获取当前企业的运营状态
     * @param id
     * @return
     */
    public String getOperationsStatus(int id) {
        List<EmCorporateInformation> emCorporateInformation = mapper.selectList(new QueryWrapper<EmCorporateInformation>()
                .select("operations_status")
                .eq("id", id));
        //企业不存在时返回null
        if(emCorporateInformation.size()==0){
            return null;
        }
        return emCorporateInformation.get(0).getOperationsStatus();
    }

    /**
     * 改变企业运营状态
     * @param id
     * @param newState
     * @return
     */
    @Override
    public String changeOperationsStatus(int id, String newState) {
        //获取旧状态，判断是否存在或需要修改
        String oldState=getOperationsStatus(id);
        if(oldState==null){
            return "企业不存在或已被注销";
        }
        if(oldState.equals(newState)){
            return "已启用或暂停，不要重复请求";
        }
        //更新状态
        EmCorporateInformation emCorporateInformation = new EmCorporateInformation().setId(id).setOperationsStatus(newState);
        mapper.update(emCorporateInformation,new UpdateWrapper<EmCorporateInformation>().eq("id",id));
        updateOperationRecord(id);
        return "succeed";
    }

    /**
     *  注销企业
     * @param id
     * @return 返回结果
     */
    @Override
    public boolean cancelEnterprise(int id) {
        return mapper.cancelEnterprise(id);
    }

    /**
     * 更新操作记录
     * @param id
     */
    public void updateOperationRecord(int id){
        EmCorporateInformation admin = new EmCorporateInformation().setUpdateBy("admin").setUpdateTime(LocalDateTime.now());
        mapper.update(admin,new UpdateWrapper<EmCorporateInformation>().eq("id",id));
    }




    /**
     * 对EmCorporateInformationMapper进行接口注入
     */
    @Autowired
    EmCorporateInformationMapper emCorporateInformationMapper;

    /**
     * 对所有企业按照创建时间排序查询
     * @param queryPage
     * @return
     */
    @Override
    public Page<EmCorporateInformation> queryByCreatimeService(QueryPage queryPage) {
        Page<EmCorporateInformation> page = new Page<>(queryPage.getPage(), queryPage.getLimit());
        Page<EmCorporateInformation> corInfos = emCorporateInformationMapper.sortByTime(page);
        return corInfos;
    }

    /**
     * 按照企业名称进行查询
     * @param emCorporateInformation
     * @param queryPage
     * @return
     */
    @Override
    public IPage<EmCorporateInformation> queryByNameService(EmCorporateInformation emCorporateInformation, QueryPage queryPage) {
        IPage<EmCorporateInformation> page = new Page<>(queryPage.getPage(), queryPage.getLimit());
        LambdaQueryWrapper<EmCorporateInformation> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(EmCorporateInformation::getId);
        queryWrapper.like(StringUtils.isNotEmpty(emCorporateInformation.getCorporateName())
                                                ,EmCorporateInformation::getCorporateName
                                                ,emCorporateInformation.getCorporateName());
        IPage<EmCorporateInformation> selectPage = emCorporateInformationMapper.selectPage(page, queryWrapper);
       return selectPage;
    }

    /**
     * 查询所有未审核的企业
     * @return
     */
    @Override
    public List<EmAttachmentAndEmCorporateInformation> queryByStatusService() {
        List<EmAttachmentAndEmCorporateInformation> listAll=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        map.put("review_status","verified");
        List<EmCorporateInformation> lists = emCorporateInformationMapper.selectByMap(map);
        for (EmCorporateInformation information : lists) {
           EmAttachmentAndEmCorporateInformation  allmsg = emCorporateInformationMapper.getAllMsg(information.getId());
           listAll.add(allmsg);
        }
        return listAll;
    }



    /**
     * 根据前端传来的企业id对某个未审核的企业进行查询信息
     * @param id
     * @return
     */
    @Override
    public EmAttachmentAndEmCorporateInformation queryStatusByIdService(Integer id) {
        EmAttachmentAndEmCorporateInformation allmsg = emCorporateInformationMapper.getAllMsg( id);
        return allmsg;
    }

    /**
     * 更改企业审核状态
     * @param emAttachmentAndEmCorporateInformation
     * @param status
     * @return
     */

    @Override
    public String updateCorInfoStatusService(EmAttachmentAndEmCorporateInformation emAttachmentAndEmCorporateInformation,Integer status) {

        LambdaUpdateWrapper<EmCorporateInformation> queryWrapper = new LambdaUpdateWrapper<>();
        String result=null;
        queryWrapper.like(EmCorporateInformation::getId
                         ,emAttachmentAndEmCorporateInformation.getId());
        if (status==1){
            queryWrapper.set(EmCorporateInformation::getReviewStatus,"pending_reward");
            result="succed";
        }else {
            queryWrapper.set(EmCorporateInformation::getReviewStatus,"not_approved");
            result="falid";
        }

        return result;
    }


/*更改企业信息
* */
    public boolean updateEmCorporateInformation(EmCorporateInformation emCorporateInformation){

        try{
            mapper.updateById(emCorporateInformation);
            return true;
        }catch(Exception exception){
            exception.printStackTrace();
            return false;
        }

    }


}
