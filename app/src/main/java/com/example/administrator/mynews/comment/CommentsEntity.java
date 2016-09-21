package com.example.administrator.mynews.comment;

import com.example.administrator.mynews.video.BombConst;

import java.util.Date;

/**
 * 作者：yuanchao on 2016/8/18 0018 14:57
 * 邮箱：yuanchao@feicuiedu.com
 */
public class CommentsEntity {

    // 评论内容
    private String content;
    // 评论作者
    private UserPointer author;
    // 评论是针对哪条新闻
    private Pointer news;

    /**
     *
     * @param content 评论的内容
     * @param userId 你是谁
     * @param newsId 评论针对的新闻
     */
    public CommentsEntity(String content, String userId, String newsId) {
        this.content = content;
        this.author = new UserPointer(userId);
        this.news = new Pointer(BombConst.TABLE_NEWS, newsId);
    }

    public String getContent() {
        return content;
    }

    public UserPointer getAuthor() {
        return author;
    }

    public Pointer getNews() {
        return news;
    }
    private Date createdAt;

    public Date getCreatedAt() {
        return createdAt;
    }



    //    {
//        "content": "我是愤青！谁敢惹我！",
//        "author": {
//                "__type": "Object",
//                "className": "_User",
//                "objectId": "D5vlAAAJ",
//                "createdAt": "2016-07-11 12:20:07",
//                "updatedAt": "2016-07-11 12:20:09",
//                "username": "飞翔的猪头"
//        },
//        "news": {
//                "__type": "Pointer",
//                "className": "News",
//                "objectId": "sfd3Dd3s",
//    },

}
