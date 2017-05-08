package com.lml.yyzj.bean;

import com.lml.yyzj.response.Response;

/**
 * Created by liml on 17/2/28.
 */

public class LunchBean extends Response{

    /**
     * status : 0
     * msg :
     * data : {"festival":{"id":1,"image":{"id":6596,"path":"http://114.215.200.140:8080/files/upload/images/2017/2/1486113044359.jpg","thumbs":"{\"480x320\":\"images/2017/2/1486113044359_480x320.jpg\"}","attribute":"{\"height\":1080,\"width\":720}","createDate":"2017-02-03 17:10:44"},"startTime":"2016-11-24 17:09:47","endTime":"2017-05-30 17:09:49"}}
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
         * festival : {"id":1,"image":{"id":6596,"path":"http://114.215.200.140:8080/files/upload/images/2017/2/1486113044359.jpg","thumbs":"{\"480x320\":\"images/2017/2/1486113044359_480x320.jpg\"}","attribute":"{\"height\":1080,\"width\":720}","createDate":"2017-02-03 17:10:44"},"startTime":"2016-11-24 17:09:47","endTime":"2017-05-30 17:09:49"}
         */

        private FestivalBean festival;

        public FestivalBean getFestival() {
            return festival;
        }

        public void setFestival(FestivalBean festival) {
            this.festival = festival;
        }

        public static class FestivalBean {
            /**
             * id : 1
             * image : {"id":6596,"path":"http://114.215.200.140:8080/files/upload/images/2017/2/1486113044359.jpg","thumbs":"{\"480x320\":\"images/2017/2/1486113044359_480x320.jpg\"}","attribute":"{\"height\":1080,\"width\":720}","createDate":"2017-02-03 17:10:44"}
             * startTime : 2016-11-24 17:09:47
             * endTime : 2017-05-30 17:09:49
             */

            private int id;
            private ImageBean image;
            private String startTime;
            private String endTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public ImageBean getImage() {
                return image;
            }

            public void setImage(ImageBean image) {
                this.image = image;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public static class ImageBean {
                /**
                 * id : 6596
                 * path : http://114.215.200.140:8080/files/upload/images/2017/2/1486113044359.jpg
                 * thumbs : {"480x320":"images/2017/2/1486113044359_480x320.jpg"}
                 * attribute : {"height":1080,"width":720}
                 * createDate : 2017-02-03 17:10:44
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
