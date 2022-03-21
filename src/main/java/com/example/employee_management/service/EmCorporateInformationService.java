package com.example.employee_management.service;

/**
 * <p>
 * 企业信息管理 服务类
 * </p>
 */
public interface EmCorporateInformationService{

    /**
     * 对所有企业按照创建时间排序查询
     * @param queryPage
     * @return
     */
     IPage<EmCorporateInformation> queryByCreatimeService(QueryPage queryPage);

    /**
     * 按照企业名称进行查询
     * @param emCorporateInformation
     * @param queryPage
     * @return
     */
     IPage<EmCorporateInformation> queryByNameService(EmCorporateInformation emCorporateInformation, QueryPage queryPage);


    /**
     * 查询所有未审核的企业
     * @return
     */
    List<EmAttachmentAndEmCorporateInformation>  queryByStatusService();

    /**
     * 根据前端传来的id对某个企业进行审核
     * @param id
     * @return
     */
    EmAttachmentAndEmCorporateInformation queryStatusByIdService(Integer id);


    /**
     * 审核通过后,更新数据
     * @param emAttachmentAndEmCorporateInformation
     * @param sta
     * @return
     */
    String updateCorInfoStatusService(EmAttachmentAndEmCorporateInformation emAttachmentAndEmCorporateInformation,Integer sta);



    String changeOperationsStatus(int id, String state);

    boolean cancelEnterprise(int id);




/**
 *         更改企业信息
 */

     boolean updateEmCorporateInformation(EmCorporateInformation emCorporateInformation);



}
