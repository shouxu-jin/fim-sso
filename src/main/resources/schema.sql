drop table if exists `t_user`;
CREATE TABLE `t_user` (
    `telephone` bigint(20) NOT NULL COMMENT '电话号码',
    `username` varchar(20) COMMENT '用户名',
    `avatar` text COMMENT '头像',
    `create_time` varchar(30) NOT NULL COMMENT '创建时间',
    PRIMARY KEY (`telephone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';
