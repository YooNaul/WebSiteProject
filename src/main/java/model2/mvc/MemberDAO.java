package model2.mvc;
import javax.servlet.ServletContext;   

import common.JDBConnect;

public class MemberDAO extends JDBConnect
{
   public MemberDAO(String drv, String url, String id, String pw)
   {
      super(drv, url, id, pw);
   }

   public MemberDTO getMemberDTO(String uid, String upass)
   {
      MemberDTO dto = new MemberDTO();
      
      String query = "SELECT * FROM user_info WHERE id=? AND password=?";
      
      try
      {
         psmt = con.prepareStatement(query);
         
         psmt.setString(1, uid);
         psmt.setString(2, upass);
         
         rs = psmt.executeQuery();
         
         if (rs.next())
         {
            dto.setName(rs.getString("name"));
            dto.setId(rs.getString("id"));
            dto.setPassword(rs.getString("password"));
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      
      return dto;
   }
   
   public int updateMember(MemberDTO dto)
   {
      int dtoEdit = 0;
      
      try
      {
         String query = "UPDATE user_info SET "
                   + " name=?, tel1=?, tel2=?, tel3=?, phone1=?, phone2=?, phone3=?, "
                   + " email1=?, email2=?, zipcode=?, address1=?, address2=? "
                   + " WHERE id=?";
         
         psmt = con.prepareStatement(query);
         
         psmt.setString(1, dto.getName());
         psmt.setString(2, dto.getTel1());
         psmt.setString(3, dto.getTel2());
         psmt.setString(4, dto.getTel3());
         psmt.setString(5, dto.getPhone1());
         psmt.setString(6, dto.getPhone2());
         psmt.setString(7, dto.getPhone3());
         psmt.setString(8, dto.getEmail1());
         psmt.setString(9, dto.getEmail2());
         psmt.setString(10, dto.getZipcode());
         psmt.setString(11, dto.getAddress1());
         psmt.setString(12, dto.getAddress2());
         psmt.setString(13, dto.getId());
         
         dtoEdit = psmt.executeUpdate();
      }
      catch (Exception e)
      {
         System.out.println("회원 정보 수정 예외 발생");
         e.printStackTrace();
      }
      
      return dtoEdit;
   }
   
   public MemberDTO viewMember(String userId)
   {
      MemberDTO dto = new MemberDTO();
      
      String query = "SELECT * FROM user_info WHERE id=?";
      
      try
      {
         psmt = con.prepareStatement(query);
         
         psmt.setString(1, userId);
         
         rs = psmt.executeQuery();
         
         if (rs.next())
         {
            dto.setName(rs.getString("name"));
            dto.setId(rs.getString("id"));
            dto.setTel1(rs.getString("tel1"));
            dto.setTel2(rs.getString("tel2"));
            dto.setTel3(rs.getString("tel3"));
            dto.setPhone1(rs.getString("phone1"));
            dto.setPhone2(rs.getString("phone2"));
            dto.setPhone3(rs.getString("phone3"));
            dto.setEmail1(rs.getString("email1"));
            dto.setEmail2(rs.getString("email2"));
            dto.setZipcode(rs.getString("zipcode"));
            dto.setAddress1(rs.getString("address1"));
            dto.setAddress2(rs.getString("address2"));
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      
      return dto;
   }
   
   public int writeMember(MemberDTO dto)
   {
      int result = 0;
      
      String query = "INSERT INTO user_info VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      
      try {
         psmt = con.prepareStatement(query);
         
         psmt.setString(1, dto.getName());
         psmt.setString(2, dto.getId());
         psmt.setString(3, dto.getPassword());
         psmt.setString(4, dto.getTel1());
         psmt.setString(5, dto.getTel2());
         psmt.setString(6, dto.getTel3());
         psmt.setString(7, dto.getPhone1());
         psmt.setString(8, dto.getPhone2());
         psmt.setString(9, dto.getPhone3());
         psmt.setString(10, dto.getEmail1());
         psmt.setString(11, dto.getEmail2());
         psmt.setString(12, dto.getZipcode());
         psmt.setString(13, dto.getAddress1());
         psmt.setString(14, dto.getAddress2());
         
         result = psmt.executeUpdate();
      }
      catch (Exception e)
      {
         System.out.println("회원가입 예외발생");
         e.printStackTrace();
      }
      
      return result;
   }

   //   
   public int idCheck(String id) {
      int rst = 0;
      
      try
      {
         String query = "SELECT * FROM user_info WHERE id=?";
         psmt = con.prepareStatement(query);
         psmt.setString(1, id);
         rs = psmt.executeQuery();
         if (rs.next())
         {
            rst = 1;
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return rst;
   }
   
   public MemberDAO(ServletContext application)
   {
      super(application);
   }
}