package com.device.limaiyun.thingsboard.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${Winter} on 2018/7/20.
 */
public class WantedBean{


    /**
     * id : 1
     * date : 2018-07-20T10:22:37
     * date_gmt : 2018-07-20T02:22:37
     * guid : {"rendered":"http://cms.limaicloud.com/qiyue/?p=1"}
     * modified : 2018-07-20T10:34:46
     * modified_gmt : 2018-07-20T02:34:46
     * slug : hello-world
     * status : publish
     * type : post
     * link : http://cms.limaicloud.com/qiyue/2018/07/20/hello-world/
     * title : {"rendered":"公告信息"}
     * content : {"rendered":"<p>欢迎来到奇跃<a href=\"http://cms.limaicloud.com/\">内容管理平台主站点<\/a>。这是您的第一篇文章。编辑或删除它，然后开始写公告吧！<\/p>\n","protected":false}
     * excerpt : {"rendered":"<p>欢迎来到奇跃内容管理平台主站点。这是您的第一篇文章。编辑或删除它，然后开始写公告吧！<\/p>\n","protected":false}
     * author : 3
     * featured_media : 0
     * comment_status : open
     * ping_status : open
     * sticky : false
     * template :
     * format : standard
     * meta : []
     * categories : [2]
     * tags : []
     * acf : []
     * _links : {"self":[{"href":"http://cms.limaicloud.com/qiyue/wp-json/wp/v2/posts/1"}],"collection":[{"href":"http://cms.limaicloud.com/qiyue/wp-json/wp/v2/posts"}],"about":[{"href":"http://cms.limaicloud.com/qiyue/wp-json/wp/v2/types/post"}],"author":[{"embeddable":true,"href":"http://cms.limaicloud.com/qiyue/wp-json/wp/v2/users/3"}],"replies":[{"embeddable":true,"href":"http://cms.limaicloud.com/qiyue/wp-json/wp/v2/comments?post=1"}],"version-history":[{"href":"http://cms.limaicloud.com/qiyue/wp-json/wp/v2/posts/1/revisions"}],"wp_attachment":[{"href":"http://cms.limaicloud.com/qiyue/wp-json/wp/v2/media?parent=1"}],"wp_term":[{"taxonomy":"category","embeddable":true,"href":"http://cms.limaicloud.com/qiyue/wp-json/wp/v2/categories?post=1"},{"taxonomy":"post_tag","embeddable":true,"href":"http://cms.limaicloud.com/qiyue/wp-json/wp/v2/tags?post=1"}],"curies":[{"name":"wp","href":"https://api.w.org/{rel}","templated":true}]}
     */

    private int id;
    private String date;
    private String date_gmt;
    private GuidBean guid;
    private String modified;
    private String modified_gmt;
    private String slug;
    private String status;
    private String type;
    private String link;
    private TitleBean title;
    private ContentBean content;
    private ExcerptBean excerpt;
    private int author;
    private int featured_media;
    private String comment_status;
    private String ping_status;
    private boolean sticky;
    private String template;
    private String format;
    private LinksBean _links;
    private List<?> meta;
    private List<Integer> categories;
    private List<?> tags;
    private List<?> acf;

    public static List<WantedBean> arrayWantedBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<WantedBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<WantedBean> arrayWantedBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<WantedBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate_gmt() {
        return date_gmt;
    }

    public void setDate_gmt(String date_gmt) {
        this.date_gmt = date_gmt;
    }

    public GuidBean getGuid() {
        return guid;
    }

    public void setGuid(GuidBean guid) {
        this.guid = guid;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getModified_gmt() {
        return modified_gmt;
    }

    public void setModified_gmt(String modified_gmt) {
        this.modified_gmt = modified_gmt;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public TitleBean getTitle() {
        return title;
    }

    public void setTitle(TitleBean title) {
        this.title = title;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public ExcerptBean getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(ExcerptBean excerpt) {
        this.excerpt = excerpt;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getFeatured_media() {
        return featured_media;
    }

    public void setFeatured_media(int featured_media) {
        this.featured_media = featured_media;
    }

    public String getComment_status() {
        return comment_status;
    }

    public void setComment_status(String comment_status) {
        this.comment_status = comment_status;
    }

    public String getPing_status() {
        return ping_status;
    }

    public void setPing_status(String ping_status) {
        this.ping_status = ping_status;
    }

    public boolean isSticky() {
        return sticky;
    }

    public void setSticky(boolean sticky) {
        this.sticky = sticky;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public LinksBean get_links() {
        return _links;
    }

    public void set_links(LinksBean _links) {
        this._links = _links;
    }

    public List<?> getMeta() {
        return meta;
    }

    public void setMeta(List<?> meta) {
        this.meta = meta;
    }

    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }

    public List<?> getTags() {
        return tags;
    }

    public void setTags(List<?> tags) {
        this.tags = tags;
    }

    public List<?> getAcf() {
        return acf;
    }

    public void setAcf(List<?> acf) {
        this.acf = acf;
    }

    public static class GuidBean {
        /**
         * rendered : http://cms.limaicloud.com/qiyue/?p=1
         */

        private String rendered;

        public static List<GuidBean> arrayGuidBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<GuidBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<GuidBean> arrayGuidBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<GuidBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getRendered() {
            return rendered;
        }

        public void setRendered(String rendered) {
            this.rendered = rendered;
        }
    }

    public static class TitleBean {
        /**
         * rendered : 公告信息
         */

        private String rendered;

        public static List<TitleBean> arrayTitleBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<TitleBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<TitleBean> arrayTitleBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<TitleBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getRendered() {
            return rendered;
        }

        public void setRendered(String rendered) {
            this.rendered = rendered;
        }
    }

    public static class ContentBean {
        /**
         * rendered : <p>欢迎来到奇跃<a href="http://cms.limaicloud.com/">内容管理平台主站点</a>。这是您的第一篇文章。编辑或删除它，然后开始写公告吧！</p>

         * protected : false
         */

        private String rendered;
        @SerializedName("protected")
        private boolean protectedX;

        public static List<ContentBean> arrayContentBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<ContentBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<ContentBean> arrayContentBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<ContentBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getRendered() {
            return rendered;
        }

        public void setRendered(String rendered) {
            this.rendered = rendered;
        }

        public boolean isProtectedX() {
            return protectedX;
        }

        public void setProtectedX(boolean protectedX) {
            this.protectedX = protectedX;
        }
    }

    public static class ExcerptBean {
        /**
         * rendered : <p>欢迎来到奇跃内容管理平台主站点。这是您的第一篇文章。编辑或删除它，然后开始写公告吧！</p>

         * protected : false
         */

        private String rendered;
        @SerializedName("protected")
        private boolean protectedX;

        public static List<ExcerptBean> arrayExcerptBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<ExcerptBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<ExcerptBean> arrayExcerptBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<ExcerptBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getRendered() {
            return rendered;
        }

        public void setRendered(String rendered) {
            this.rendered = rendered;
        }

        public boolean isProtectedX() {
            return protectedX;
        }

        public void setProtectedX(boolean protectedX) {
            this.protectedX = protectedX;
        }
    }

    public static class LinksBean {
        private List<SelfBean> self;
        private List<CollectionBean> collection;
        private List<AboutBean> about;
        private List<AuthorBean> author;
        private List<RepliesBean> replies;
        @SerializedName("version-history")
        private List<VersionhistoryBean> versionhistory;
        private List<WpAttachmentBean> wp_attachment;
        private List<WpTermBean> wp_term;
        private List<CuriesBean> curies;

        public static List<LinksBean> arrayLinksBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<LinksBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<LinksBean> arrayLinksBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<LinksBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public List<SelfBean> getSelf() {
            return self;
        }

        public void setSelf(List<SelfBean> self) {
            this.self = self;
        }

        public List<CollectionBean> getCollection() {
            return collection;
        }

        public void setCollection(List<CollectionBean> collection) {
            this.collection = collection;
        }

        public List<AboutBean> getAbout() {
            return about;
        }

        public void setAbout(List<AboutBean> about) {
            this.about = about;
        }

        public List<AuthorBean> getAuthor() {
            return author;
        }

        public void setAuthor(List<AuthorBean> author) {
            this.author = author;
        }

        public List<RepliesBean> getReplies() {
            return replies;
        }

        public void setReplies(List<RepliesBean> replies) {
            this.replies = replies;
        }

        public List<VersionhistoryBean> getVersionhistory() {
            return versionhistory;
        }

        public void setVersionhistory(List<VersionhistoryBean> versionhistory) {
            this.versionhistory = versionhistory;
        }

        public List<WpAttachmentBean> getWp_attachment() {
            return wp_attachment;
        }

        public void setWp_attachment(List<WpAttachmentBean> wp_attachment) {
            this.wp_attachment = wp_attachment;
        }

        public List<WpTermBean> getWp_term() {
            return wp_term;
        }

        public void setWp_term(List<WpTermBean> wp_term) {
            this.wp_term = wp_term;
        }

        public List<CuriesBean> getCuries() {
            return curies;
        }

        public void setCuries(List<CuriesBean> curies) {
            this.curies = curies;
        }

        public static class SelfBean {
            /**
             * href : http://cms.limaicloud.com/qiyue/wp-json/wp/v2/posts/1
             */

            private String href;

            public static List<SelfBean> arraySelfBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<SelfBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<SelfBean> arraySelfBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<SelfBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }

        public static class CollectionBean {
            /**
             * href : http://cms.limaicloud.com/qiyue/wp-json/wp/v2/posts
             */

            private String href;

            public static List<CollectionBean> arrayCollectionBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<CollectionBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<CollectionBean> arrayCollectionBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<CollectionBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }

        public static class AboutBean {
            /**
             * href : http://cms.limaicloud.com/qiyue/wp-json/wp/v2/types/post
             */

            private String href;

            public static List<AboutBean> arrayAboutBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<AboutBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<AboutBean> arrayAboutBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<AboutBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }

        public static class AuthorBean {
            /**
             * embeddable : true
             * href : http://cms.limaicloud.com/qiyue/wp-json/wp/v2/users/3
             */

            private boolean embeddable;
            private String href;

            public static List<AuthorBean> arrayAuthorBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<AuthorBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<AuthorBean> arrayAuthorBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<AuthorBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public boolean isEmbeddable() {
                return embeddable;
            }

            public void setEmbeddable(boolean embeddable) {
                this.embeddable = embeddable;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }

        public static class RepliesBean {
            /**
             * embeddable : true
             * href : http://cms.limaicloud.com/qiyue/wp-json/wp/v2/comments?post=1
             */

            private boolean embeddable;
            private String href;

            public static List<RepliesBean> arrayRepliesBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<RepliesBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<RepliesBean> arrayRepliesBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<RepliesBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public boolean isEmbeddable() {
                return embeddable;
            }

            public void setEmbeddable(boolean embeddable) {
                this.embeddable = embeddable;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }

        public static class VersionhistoryBean {
            /**
             * href : http://cms.limaicloud.com/qiyue/wp-json/wp/v2/posts/1/revisions
             */

            private String href;

            public static List<VersionhistoryBean> arrayVersionhistoryBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<VersionhistoryBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<VersionhistoryBean> arrayVersionhistoryBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<VersionhistoryBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }

        public static class WpAttachmentBean {
            /**
             * href : http://cms.limaicloud.com/qiyue/wp-json/wp/v2/media?parent=1
             */

            private String href;

            public static List<WpAttachmentBean> arrayWpAttachmentBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<WpAttachmentBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<WpAttachmentBean> arrayWpAttachmentBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<WpAttachmentBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }

        public static class WpTermBean {
            /**
             * taxonomy : category
             * embeddable : true
             * href : http://cms.limaicloud.com/qiyue/wp-json/wp/v2/categories?post=1
             */

            private String taxonomy;
            private boolean embeddable;
            private String href;

            public static List<WpTermBean> arrayWpTermBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<WpTermBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<WpTermBean> arrayWpTermBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<WpTermBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getTaxonomy() {
                return taxonomy;
            }

            public void setTaxonomy(String taxonomy) {
                this.taxonomy = taxonomy;
            }

            public boolean isEmbeddable() {
                return embeddable;
            }

            public void setEmbeddable(boolean embeddable) {
                this.embeddable = embeddable;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }

        public static class CuriesBean {
            /**
             * name : wp
             * href : https://api.w.org/{rel}
             * templated : true
             */

            private String name;
            private String href;
            private boolean templated;

            public static List<CuriesBean> arrayCuriesBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<CuriesBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<CuriesBean> arrayCuriesBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<CuriesBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public boolean isTemplated() {
                return templated;
            }

            public void setTemplated(boolean templated) {
                this.templated = templated;
            }
        }
    }
}
