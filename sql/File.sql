-- 创建文件夹表
CREATE TABLE `folders` (
                           `id` bigint NOT NULL AUTO_INCREMENT,              -- 文件夹ID
                           `title` varchar(255),                     -- 文件夹名称
                           `pid` bigint DEFAULT NULL,                         -- 父文件夹ID，修改为 bigint
                           `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- 创建时间
                           `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  -- 更新时间
                           `user_id` int,                                    -- 用户ID
                           `department` varchar(255),                        -- 部门
                           `is_shared` int,
                           PRIMARY KEY (`id`),
                           CONSTRAINT `fk_folders_pid` FOREIGN KEY (`pid`)  -- 外键约束
                               REFERENCES `folders` (`id`)
                               ON DELETE CASCADE                               -- 删除文件夹时级联删除子文件夹
);

-- 创建文件表
CREATE TABLE `files` (
                         `id` bigint NOT NULL AUTO_INCREMENT,              -- 文件ID
                         `file_name` varchar(255) NOT NULL,                 -- 文件名称
                         `ext` varchar(10),                                -- 文件扩展名
                         `size` int NOT NULL,                              -- 文件大小
                         `dir_id` bigint,                                  -- 文件夹ID，修改为 bigint
                         `url` varchar(1024) NOT NULL,                     -- 文件URL
                         `remark` text,                                    -- 备注
                         `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- 创建时间
                         `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  -- 更新时间
                         `user_id` int,                                    -- 用户ID
                         `department` varchar(255),                        -- 部门
                         `is_shared` int,
                         PRIMARY KEY (`id`),
                         CONSTRAINT `fk_files_dir_id` FOREIGN KEY (`dir_id`)  -- 外键约束
                             REFERENCES `folders` (`id`)
                             ON DELETE CASCADE                                -- 删除文件夹时级联删除文件
);
-- 建表后在folders里添加id为-2，-1，0的数据，分别代表公司文件夹，部门文件夹，个人文件夹。
