package com.example.jdbc;

import java.sql.*;

/**
 * 程序的耦合
 *      耦合：程序之间的依赖
 *           类之间的依赖
 *           方法之间的依赖
 *      解耦：降低程序间的依赖关系
 *  实际开发中：
 *      应该做到：编译期不依赖，运行期才依赖
 *  todo 解耦的思路：
 *      第一步：创建对象时使用反射来创建对象，避免使用new
 *      第二步：通过读取配置文件来获取要创建的对象的全限定类名
 */
public class JdbcDemo1  {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1注册驱动
//        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        // todo 如此修改，减少类依赖，即用字符串代替类名（类名没有括号）
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring?serverTimezone=Asia/Shanghai","root","root");
        //3获取数据库预处理对象
        PreparedStatement st = conn.prepareStatement("select * from account");
        //4执行SQL得到结果集
        ResultSet rs = st.executeQuery();
        //5封装结果集
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6释放资源
        rs.close();
        st.close();
        conn.close();
    }
}
