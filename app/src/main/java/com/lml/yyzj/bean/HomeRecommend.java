package com.lml.yyzj.bean;

import com.lml.yyzj.response.Response;

/**
 * Created by liml on 17/2/28.
 */

public class HomeRecommend extends Response{

    /**
     * status : 0
     * msg :
     * data : {"promptInfo":{"id":239,"title":"反复自然流产 建议孕前做染色体检查","image":{"id":5280,"path":"http://114.215.200.140:8080/files/upload/images/2016/3/1458545669722.jpg","thumbs":"{\"480x320\":\"images/2016/3/1458545669722_480x320.jpg\"}","attribute":"{\"height\":320,\"width\":480}","createDate":"2016-03-21 15:34:30"},"content":"【浙江省金华市妇幼保健院】\n\n在备孕前进行染色体检查，可以预测生育染色体异常后代的风险，以便采取积极有效的干预措施，从而达到优生的目的。建议有反复自然流产史、家族中有生育过明显遗传性疾病、先天性畸形儿、严重智力低下儿的，最好做相应的染色体检查。","isAdded":"0","createDate":"2016-03-21 15:34:32","updateDate":"2017-02-27 08:49:38"}}
     */


    private DataBean data;



    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * promptInfo : {"id":239,"title":"反复自然流产 建议孕前做染色体检查","image":{"id":5280,"path":"http://114.215.200.140:8080/files/upload/images/2016/3/1458545669722.jpg","thumbs":"{\"480x320\":\"images/2016/3/1458545669722_480x320.jpg\"}","attribute":"{\"height\":320,\"width\":480}","createDate":"2016-03-21 15:34:30"},"content":"【浙江省金华市妇幼保健院】\n\n在备孕前进行染色体检查，可以预测生育染色体异常后代的风险，以便采取积极有效的干预措施，从而达到优生的目的。建议有反复自然流产史、家族中有生育过明显遗传性疾病、先天性畸形儿、严重智力低下儿的，最好做相应的染色体检查。","isAdded":"0","createDate":"2016-03-21 15:34:32","updateDate":"2017-02-27 08:49:38"}
         */

        private PromptInfoBean promptInfo;

        public PromptInfoBean getPromptInfo() {
            return promptInfo;
        }

        public void setPromptInfo(PromptInfoBean promptInfo) {
            this.promptInfo = promptInfo;
        }

        public static class PromptInfoBean {
            /**
             * id : 239
             * title : 反复自然流产 建议孕前做染色体检查
             * image : {"id":5280,"path":"http://114.215.200.140:8080/files/upload/images/2016/3/1458545669722.jpg","thumbs":"{\"480x320\":\"images/2016/3/1458545669722_480x320.jpg\"}","attribute":"{\"height\":320,\"width\":480}","createDate":"2016-03-21 15:34:30"}
             * content : 【浙江省金华市妇幼保健院】

             在备孕前进行染色体检查，可以预测生育染色体异常后代的风险，以便采取积极有效的干预措施，从而达到优生的目的。建议有反复自然流产史、家族中有生育过明显遗传性疾病、先天性畸形儿、严重智力低下儿的，最好做相应的染色体检查。
             * isAdded : 0
             * createDate : 2016-03-21 15:34:32
             * updateDate : 2017-02-27 08:49:38
             */

            private int id;
            private String title;
            private ImageBean image;
            private String content;
            private String isAdded;
            private String createDate;
            private String updateDate;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public ImageBean getImage() {
                return image;
            }

            public void setImage(ImageBean image) {
                this.image = image;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getIsAdded() {
                return isAdded;
            }

            public void setIsAdded(String isAdded) {
                this.isAdded = isAdded;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public String getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(String updateDate) {
                this.updateDate = updateDate;
            }

            public static class ImageBean {
                /**
                 * id : 5280
                 * path : http://114.215.200.140:8080/files/upload/images/2016/3/1458545669722.jpg
                 * thumbs : {"480x320":"images/2016/3/1458545669722_480x320.jpg"}
                 * attribute : {"height":320,"width":480}
                 * createDate : 2016-03-21 15:34:30
                 */

                private int id;
                private String path;
                private String thumbs;
                private String attribute;
                private String createDate;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getPath() {
                    return path;
                }

                public void setPath(String path) {
                    this.path = path;
                }

                public String getThumbs() {
                    return thumbs;
                }

                public void setThumbs(String thumbs) {
                    this.thumbs = thumbs;
                }

                public String getAttribute() {
                    return attribute;
                }

                public void setAttribute(String attribute) {
                    this.attribute = attribute;
                }

                public String getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(String createDate) {
                    this.createDate = createDate;
                }
            }
        }
    }
}
