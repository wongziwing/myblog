CREATE TABLE `myblog`.`article_info`  (
    `article_id` int(11) NOT NULL AUTO_INCREMENT,
    `article_name` varchar(64) NOT NULL COMMENT '文章名称',
    `article_content` text NOT NULL COMMENT '文章内容',
    `article_tag` varchar(64) NOT NULL COMMENT '文章标签',
    `create_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '文章创建时间',
    PRIMARY KEY (`article_id`)
);

CREATE TABLE `myblog`.`comment_info`  (
    `comment_id` int(11) NOT NULL AUTO_INCREMENT,
    `article_id` INT(11) NOT NULL COMMENT '文章编号',
    `comment_content` VARCHAR(255) NOT NULL COMMENT '评论内容',
    `create_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '评论时间',
    PRIMARY KEY (`comment_id`)
);