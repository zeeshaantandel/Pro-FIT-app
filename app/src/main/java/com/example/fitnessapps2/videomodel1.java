package com.example.fitnessapps2;

public class videomodel1
{
    String desc,title,url;

    public videomodel1(String desc, String title, String url)
    {
        this.desc = desc;
        this.title = title;
        this.url = url;
    }
    videomodel1()
    {

    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}