package com.manish.quanlychitieucanhan;

class savedulieu{
    private int userId;
    private int Id;
    private String title;
    private boolean completed;//trả về true or false
    public savedulieu(){

    }
    public  savedulieu (int userId,  int Id, String title, boolean completed)

    {
        this.userId= userId;
        this.Id= Id;
        this.title=title;
        this.completed= completed;

    }
    public int getUserId(){
        return userId;
    }
    public int Id(){
        return Id;
    }
    public String getTitle(){
        return title;
    }
    public boolean isCompleted(){
        return completed;
    }
    @Override
    public String toString(){
        return "savedulieu{"+
                "userId="+userId+
                ",id="+Id+",title='" +title+'\''+",completed="+ completed+'}';
    }
}
