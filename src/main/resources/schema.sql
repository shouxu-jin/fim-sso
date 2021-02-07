drop table if exists `t_user`;
drop table if exists `t_message_1`;
drop table if exists `t_message_2`;
drop table if exists `t_offline_message_1`;
drop table if exists `t_offline_message_2`;

CREATE TABLE `t_user` (
    `telephone` bigint(20) NOT NULL COMMENT '电话号码',
    `username` varchar(20) COMMENT '用户名',
    `avatar` text COMMENT '头像',
    `create_time` varchar(30) NOT NULL COMMENT '创建时间',
    PRIMARY KEY (`telephone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

create table t_message_1 (
    message_id bigint(20) NOT NULL COMMENT '消息id',
    sender_id bigint(20)  NOT NULL COMMENT '发送方id',
    receiver_id bigint(20)  NOT NULL COMMENT '接收方id',
    message_type int(8) NOT NULL COMMENT '消息类型',
    content varchar(500) NOT NULL COMMENT '消息内容',
    PRIMARY KEY (message_id, receiver_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消息分表1';
create table t_message_2 (
     message_id bigint(20) NOT NULL COMMENT '消息id',
     sender_id bigint(20)  NOT NULL COMMENT '发送方id',
     receiver_id bigint(20)  NOT NULL COMMENT '接收方id',
     message_type int(8) NOT NULL COMMENT '消息类型',
     content varchar(500) NOT NULL COMMENT '消息内容',
     PRIMARY KEY (message_id, receiver_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消息分表2';

create table t_offline_message_1 (
     receiver_id bigint(20)  NOT NULL COMMENT '接收方id',
     message_id bigint(20) NOT NULL COMMENT '消息id',
     PRIMARY KEY (message_id, receiver_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='离线消息分表1';
create table t_offline_message_2 (
     receiver_id bigint(20)  NOT NULL COMMENT '接收方id',
     message_id bigint(20) NOT NULL COMMENT '消息id',
     PRIMARY KEY (message_id, receiver_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='离线消息分表2';