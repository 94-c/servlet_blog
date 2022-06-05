package com.blog.model;

import java.util.Date;

public class Board {


    /*create table board(
	`id` bigint(20)	auto_increment primary key,
	`title` varchar(200),
	`content` varchar(200),
	`created_at` timestamp.
    `update_at` timestamp
    );*/

    private Integer id;
    private String title;
    private String content;
    private Date createdAt;
    private Date updatedAt;

}
