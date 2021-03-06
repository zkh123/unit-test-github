CREATE TABLE `tb_audit_listing_case` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `listing_id` bigint(20) NOT NULL COMMENT '标的id',
  `borrower_id` bigint(20) NOT NULL COMMENT '借款人id',
  `product_type` int(11) NOT NULL COMMENT '产品类型',
  `status` varchar(32) NOT NULL COMMENT '案件状态,PENDING, DROOLS_RECEIVED,DROOLS_PASS, DROOLS_REJECT, DROOLS_MANUAL, FIRST_PASS, FIRST_REJECT, SECOND_PASS, SECOND_REJECT',
  `drools_audit_time` timestamp NULL DEFAULT NULL COMMENT 'drools审核时间',
  `first_audit_time` timestamp NULL DEFAULT NULL COMMENT '初审时间',
  `first_audit_owner` bigint(20) DEFAULT NULL COMMENT '初审分配审核人员id',
  `second_audit_time` timestamp NULL DEFAULT NULL COMMENT '二审时间',
  `second_audit_owner` bigint(20) DEFAULT NULL COMMENT '二审分配审核人员id',
  `inserttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isactive` tinyint(1) DEFAULT NULL COMMENT '逻辑删除(null=删除,1:未删除)',
  `drools_process_flag` int(11) DEFAULT NULL COMMENT 'drools审核结果',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_listing_id` (`listing_id`),
  KEY `idx_status` (`status`) USING BTREE,
  KEY `idx_first_audit_owner` (`first_audit_owner`) USING BTREE,
  KEY `idx_second_audit_owner` (`second_audit_owner`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1709 DEFAULT CHARSET=utf8mb4 COMMENT='标的审核case表';