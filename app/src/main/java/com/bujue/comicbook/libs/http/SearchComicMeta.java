package com.bujue.comicbook.libs.http;

/**
 * @author bujue
 * @date 16/4/15
 */
public class SearchComicMeta {

    /**
     * ErrCode :
     * ErrMsg :
     * Return : {"List":[{"Id":4,"Title":"火影忍者","FrontCover":"http://img02.ishuhui.com/mhcover/naruto.jpg","RefreshTime":"/Date(1450182613000)/","RefreshTimeStr":"2015-12-15 20:30:13","Explain":"只要有树叶飞舞的地方，火就会燃烧！","SerializedState":"已完结","Author":"岸本齐史","LastChapterNo":0,"ClassifyId":3,"LastChapter":{"AnotherId":null,"Id":1433,"Title":"火影忍者710话","Sort":710,"FrontCover":"http://img02.ishuhui.com/hy/end710/hys.jpg","Images":null,"RefreshTime":"/Date(1438269981000)/","RefreshTimeStr":"2015-07-30","Book":null,"PostUser":"发布者","ChapterNo":710,"Reel":0,"BookId":4,"ChapterType":0,"DownLoadUrl":null,"Copyright":null,"Tencent":null,"ExceptionChapter":null,"CreateTime":"/Date(-59011459200000)/"},"Chapters":null,"MoreUrl":null,"Recommend":false,"Copyright":1,"Sort":12}],"ParentItem":null,"ListCount":1,"PageSize":30,"PageIndex":0}
     * Costtime : 0
     * IsError : false
     */

    private String ErrCode;
    private String ErrMsg;
    /**
     * List : [{"Id":4,"Title":"火影忍者","FrontCover":"http://img02.ishuhui.com/mhcover/naruto.jpg","RefreshTime":"/Date(1450182613000)/","RefreshTimeStr":"2015-12-15 20:30:13","Explain":"只要有树叶飞舞的地方，火就会燃烧！","SerializedState":"已完结","Author":"岸本齐史","LastChapterNo":0,"ClassifyId":3,"LastChapter":{"AnotherId":null,"Id":1433,"Title":"火影忍者710话","Sort":710,"FrontCover":"http://img02.ishuhui.com/hy/end710/hys.jpg","Images":null,"RefreshTime":"/Date(1438269981000)/","RefreshTimeStr":"2015-07-30","Book":null,"PostUser":"发布者","ChapterNo":710,"Reel":0,"BookId":4,"ChapterType":0,"DownLoadUrl":null,"Copyright":null,"Tencent":null,"ExceptionChapter":null,"CreateTime":"/Date(-59011459200000)/"},"Chapters":null,"MoreUrl":null,"Recommend":false,"Copyright":1,"Sort":12}]
     * ParentItem : null
     * ListCount : 1
     * PageSize : 30
     * PageIndex : 0
     */

    private ReturnEntity Return;
    private String Costtime;
    private boolean IsError;

    public void setErrCode(String ErrCode) {
        this.ErrCode = ErrCode;
    }

    public void setErrMsg(String ErrMsg) {
        this.ErrMsg = ErrMsg;
    }

    public void setReturn(ReturnEntity Return) {
        this.Return = Return;
    }

    public void setCosttime(String Costtime) {
        this.Costtime = Costtime;
    }

    public void setIsError(boolean IsError) {
        this.IsError = IsError;
    }

    public String getErrCode() {
        return ErrCode;
    }

    public String getErrMsg() {
        return ErrMsg;
    }

    public ReturnEntity getReturn() {
        return Return;
    }

    public String getCosttime() {
        return Costtime;
    }

    public boolean isIsError() {
        return IsError;
    }

    public static class ReturnEntity {
        private Object ParentItem;
        private int ListCount;
        private int PageSize;
        private int PageIndex;
        /**
         * Id : 4
         * Title : 火影忍者
         * FrontCover : http://img02.ishuhui.com/mhcover/naruto.jpg
         * RefreshTime : /Date(1450182613000)/
         * RefreshTimeStr : 2015-12-15 20:30:13
         * Explain : 只要有树叶飞舞的地方，火就会燃烧！
         * SerializedState : 已完结
         * Author : 岸本齐史
         * LastChapterNo : 0
         * ClassifyId : 3
         * LastChapter : {"AnotherId":null,"Id":1433,"Title":"火影忍者710话","Sort":710,"FrontCover":"http://img02.ishuhui.com/hy/end710/hys.jpg","Images":null,"RefreshTime":"/Date(1438269981000)/","RefreshTimeStr":"2015-07-30","Book":null,"PostUser":"发布者","ChapterNo":710,"Reel":0,"BookId":4,"ChapterType":0,"DownLoadUrl":null,"Copyright":null,"Tencent":null,"ExceptionChapter":null,"CreateTime":"/Date(-59011459200000)/"}
         * Chapters : null
         * MoreUrl : null
         * Recommend : false
         * Copyright : 1
         * Sort : 12
         */

        private java.util.List<ListEntity> List;

        public void setParentItem(Object ParentItem) {
            this.ParentItem = ParentItem;
        }

        public void setListCount(int ListCount) {
            this.ListCount = ListCount;
        }

        public void setPageSize(int PageSize) {
            this.PageSize = PageSize;
        }

        public void setPageIndex(int PageIndex) {
            this.PageIndex = PageIndex;
        }

        public void setList(java.util.List<ListEntity> List) {
            this.List = List;
        }

        public Object getParentItem() {
            return ParentItem;
        }

        public int getListCount() {
            return ListCount;
        }

        public int getPageSize() {
            return PageSize;
        }

        public int getPageIndex() {
            return PageIndex;
        }

        public java.util.List<ListEntity> getList() {
            return List;
        }

        public static class ListEntity {
            private int Id;
            private String Title;
            private String FrontCover;
            private String RefreshTime;
            private String RefreshTimeStr;
            private String Explain;
            private String SerializedState;
            private String Author;
            private int LastChapterNo;
            private int ClassifyId;
            /**
             * AnotherId : null
             * Id : 1433
             * Title : 火影忍者710话
             * Sort : 710
             * FrontCover : http://img02.ishuhui.com/hy/end710/hys.jpg
             * Images : null
             * RefreshTime : /Date(1438269981000)/
             * RefreshTimeStr : 2015-07-30
             * Book : null
             * PostUser : 发布者
             * ChapterNo : 710
             * Reel : 0
             * BookId : 4
             * ChapterType : 0
             * DownLoadUrl : null
             * Copyright : null
             * Tencent : null
             * ExceptionChapter : null
             * CreateTime : /Date(-59011459200000)/
             */

            private LastChapterEntity LastChapter;
            private Object Chapters;
            private Object MoreUrl;
            private boolean Recommend;
            private int Copyright;
            private int Sort;

            public void setId(int Id) {
                this.Id = Id;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

            public void setFrontCover(String FrontCover) {
                this.FrontCover = FrontCover;
            }

            public void setRefreshTime(String RefreshTime) {
                this.RefreshTime = RefreshTime;
            }

            public void setRefreshTimeStr(String RefreshTimeStr) {
                this.RefreshTimeStr = RefreshTimeStr;
            }

            public void setExplain(String Explain) {
                this.Explain = Explain;
            }

            public void setSerializedState(String SerializedState) {
                this.SerializedState = SerializedState;
            }

            public void setAuthor(String Author) {
                this.Author = Author;
            }

            public void setLastChapterNo(int LastChapterNo) {
                this.LastChapterNo = LastChapterNo;
            }

            public void setClassifyId(int ClassifyId) {
                this.ClassifyId = ClassifyId;
            }

            public void setLastChapter(LastChapterEntity LastChapter) {
                this.LastChapter = LastChapter;
            }

            public void setChapters(Object Chapters) {
                this.Chapters = Chapters;
            }

            public void setMoreUrl(Object MoreUrl) {
                this.MoreUrl = MoreUrl;
            }

            public void setRecommend(boolean Recommend) {
                this.Recommend = Recommend;
            }

            public void setCopyright(int Copyright) {
                this.Copyright = Copyright;
            }

            public void setSort(int Sort) {
                this.Sort = Sort;
            }

            public int getId() {
                return Id;
            }

            public String getTitle() {
                return Title;
            }

            public String getFrontCover() {
                return FrontCover;
            }

            public String getRefreshTime() {
                return RefreshTime;
            }

            public String getRefreshTimeStr() {
                return RefreshTimeStr;
            }

            public String getExplain() {
                return Explain;
            }

            public String getSerializedState() {
                return SerializedState;
            }

            public String getAuthor() {
                return Author;
            }

            public int getLastChapterNo() {
                return LastChapterNo;
            }

            public int getClassifyId() {
                return ClassifyId;
            }

            public LastChapterEntity getLastChapter() {
                return LastChapter;
            }

            public Object getChapters() {
                return Chapters;
            }

            public Object getMoreUrl() {
                return MoreUrl;
            }

            public boolean isRecommend() {
                return Recommend;
            }

            public int getCopyright() {
                return Copyright;
            }

            public int getSort() {
                return Sort;
            }

            public static class LastChapterEntity {
                private Object AnotherId;
                private int Id;
                private String Title;
                private int Sort;
                private String FrontCover;
                private Object Images;
                private String RefreshTime;
                private String RefreshTimeStr;
                private Object Book;
                private String PostUser;
                private int ChapterNo;
                private int Reel;
                private int BookId;
                private int ChapterType;
                private Object DownLoadUrl;
                private Object Copyright;
                private Object Tencent;
                private Object ExceptionChapter;
                private String CreateTime;

                public void setAnotherId(Object AnotherId) {
                    this.AnotherId = AnotherId;
                }

                public void setId(int Id) {
                    this.Id = Id;
                }

                public void setTitle(String Title) {
                    this.Title = Title;
                }

                public void setSort(int Sort) {
                    this.Sort = Sort;
                }

                public void setFrontCover(String FrontCover) {
                    this.FrontCover = FrontCover;
                }

                public void setImages(Object Images) {
                    this.Images = Images;
                }

                public void setRefreshTime(String RefreshTime) {
                    this.RefreshTime = RefreshTime;
                }

                public void setRefreshTimeStr(String RefreshTimeStr) {
                    this.RefreshTimeStr = RefreshTimeStr;
                }

                public void setBook(Object Book) {
                    this.Book = Book;
                }

                public void setPostUser(String PostUser) {
                    this.PostUser = PostUser;
                }

                public void setChapterNo(int ChapterNo) {
                    this.ChapterNo = ChapterNo;
                }

                public void setReel(int Reel) {
                    this.Reel = Reel;
                }

                public void setBookId(int BookId) {
                    this.BookId = BookId;
                }

                public void setChapterType(int ChapterType) {
                    this.ChapterType = ChapterType;
                }

                public void setDownLoadUrl(Object DownLoadUrl) {
                    this.DownLoadUrl = DownLoadUrl;
                }

                public void setCopyright(Object Copyright) {
                    this.Copyright = Copyright;
                }

                public void setTencent(Object Tencent) {
                    this.Tencent = Tencent;
                }

                public void setExceptionChapter(Object ExceptionChapter) {
                    this.ExceptionChapter = ExceptionChapter;
                }

                public void setCreateTime(String CreateTime) {
                    this.CreateTime = CreateTime;
                }

                public Object getAnotherId() {
                    return AnotherId;
                }

                public int getId() {
                    return Id;
                }

                public String getTitle() {
                    return Title;
                }

                public int getSort() {
                    return Sort;
                }

                public String getFrontCover() {
                    return FrontCover;
                }

                public Object getImages() {
                    return Images;
                }

                public String getRefreshTime() {
                    return RefreshTime;
                }

                public String getRefreshTimeStr() {
                    return RefreshTimeStr;
                }

                public Object getBook() {
                    return Book;
                }

                public String getPostUser() {
                    return PostUser;
                }

                public int getChapterNo() {
                    return ChapterNo;
                }

                public int getReel() {
                    return Reel;
                }

                public int getBookId() {
                    return BookId;
                }

                public int getChapterType() {
                    return ChapterType;
                }

                public Object getDownLoadUrl() {
                    return DownLoadUrl;
                }

                public Object getCopyright() {
                    return Copyright;
                }

                public Object getTencent() {
                    return Tencent;
                }

                public Object getExceptionChapter() {
                    return ExceptionChapter;
                }

                public String getCreateTime() {
                    return CreateTime;
                }
            }
        }
    }
}
