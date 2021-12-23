package model1.board;

public class BoardDTO
{
   private String idx;
   private String writer;
   private String title;
   private String content;
   private String tablename;
   private String ofile;
   private String sfile;
   private java.sql.Date postdate;
   private int visicount;
   private int downcount;
   private String postpass;
   
   public String getIdx()
   {
      return idx;
   }
   
   public void setIdx(String idx)
   {
      this.idx = idx;
   }
   
   public String getWriter()
   {
      return writer;
   }
   
   public void setWriter(String writer)
   {
      this.writer = writer;
   }
   
   public String getTitle()
   {
      return title;
   }
   
   public void setTitle(String title)
   {
      this.title = title;
   }
   
   public String getContent()
   {
      return content;
   }
   
   public void setContent(String content)
   {
      this.content = content;
   }
   
   public String getTablename()
   {
      return tablename;
   }
   
   public void setTablename(String tablename)
   {
      this.tablename = tablename;
   }
   
   public String getOfile()
   {
      return ofile;
   }
   
   public void setOfile(String ofile)
   {
      this.ofile = ofile;
   }
   
   public String getSfile()
   {
      return sfile;
   }
   
   public void setSfile(String sfile)
   {
      this.sfile = sfile;
   }
   
   public java.sql.Date getPostdate()
   {
      return postdate;
   }
   
   public void setPostdate(java.sql.Date postdate)
   {
      this.postdate = postdate;
   }
   
   public int getVisicount()
   {
      return visicount;
   }
   
   public void setVisicount(int visicount)
   {
      this.visicount = visicount;
   }
   
   public int getDowncount()
   {
      return downcount;
   }
   
   public void setDowncount(int downcount)
   {
      this.downcount = downcount;
   }
   
   public String getPostpass()
   {
      return postpass;
   }
   
   public void setPostpass(String postpass)
   {
      this.postpass = postpass;
   }   
}
