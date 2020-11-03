SELECT * FROM idn_common.tb_sdk_data_log_new where isactive =1;

UPDATE  idn_common.tb_sdk_data_log_new set isactive = 0 where id >=1;

truncate idn_sdk_backend001.network_info_0004;
truncate idn_sdk_backend001.network_info_0005;


select * from idn_sdk_backend001.network_info_0004;
select * from idn_sdk_backend001.network_info_0005;

select * from idn_common.tb_sdk_data_log_new order by id desc limit 5;

show create table idn_common.tb_sdk_data_log_new;


select * from idn_sdk_backend002.device_info_v2_0008;




CREATE TABLE `tb_sdk_data_log_new` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
   `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户id',
   `ext_text` mediumtext NOT NULL COMMENT '原始数据',
   `is_done` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否完成',
   `inserttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
   `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
   `isactive` tinyint(1) NOT NULL DEFAULT '1' COMMENT '逻辑删除(0:删除,1:未删除)',
   PRIMARY KEY (`id`),
   KEY `ix_is_done` (`is_done`),
   KEY `idx_user_id` (`user_id`),
   KEY `IDX_INSERTTIME` (`inserttime`),
   KEY `IDX_UPDATETIME` (`updatetime`)
 ) ENGINE=InnoDB AUTO_INCREMENT=187 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='SDK数据日志'
 
 

