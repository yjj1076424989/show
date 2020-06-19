package Hotel;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
 
public class Hotel {
 
    public static void main(String[] args) {
        // 声明Connection对象
        Connection con;
        // 驱动程序名
        String driver = "com.mysql.cj.jdbc.Driver";
        // URL指向要访问的数据库名 test
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        // MySQL配置时的用户名
        String user = "root";
        // MySQL配置时的密码
        String password = "123456";
        // 遍历查询结果集
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed())
                System.out.println("\n\t\t欢迎使用酒店管理系统！！！");
 
            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句
            String sql = "select * from hotel1";
            // 3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("\n\t\t目前酒店房间状态如下所示:");
            System.out.println("\t\t-----------------------------------------------------------------");
            System.out.println("\t|\t" +"\t"+ "房间号" + "\t"+"入住状态" +"\t"+ "客户姓名" + "\t\t" + "电话" + "\t" );
            System.out.println("\t\t-----------------------------------------------------------------");
 
            int ID = 0;
            String state = null;
            String name = null;
            int number = 0;
            
 
            while (rs.next()) {
                // 获取 ID 这列数据
                ID = rs.getInt("id");
                // 获取 Name 这列数据
                state = rs.getString("state");
                // 获取 Sex 这列数据
                name = rs.getString("username");
                // 获取 Age 这列数据
                number = rs.getInt("phonenumber");
                // 获取 Phone 这列数据

                // 输出结果
                System.out.println("\t\t|\t" + ID + "\t" + state + "\t" + name + "\t\t" + number  + "\t|\t\t");
            }
            System.out.println("\t\t-----------------------------------------------------------------");
            rs.close();
            con.close();
        }
        catch (ClassNotFoundException e) {
            // 数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }
        catch (SQLException e) {
            // 数据库连接失败异常处理
            e.printStackTrace();
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        finally {
            System.out.println("\t\t\t\t\t\t\t\t酒店房间状态查询完毕！!！");
        }
        
        
        
        for(int i=1;i>0;i++) {
        	Scanner reader = new Scanner(System.in);
            System.out.println("订房请按1，退房请按2，查询酒店房间状态请按3，退出请按0");
            int choice=reader.nextInt();
        	if(choice==1) {
            	// 声明Connection对象
                Connection con1;
                // 驱动程序名
                String driver1 = "com.mysql.cj.jdbc.Driver";
                // URL指向要访问的数据库名 test
                String url1 = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
                // MySQL配置时的用户名
                String user1 = "root";
                // MySQL配置时的密码
                String password1 = "123456";
                // 遍历查询结果集
            	try {
            		Scanner ID = new Scanner(System.in);
                	System.out.println("请输入房间号");
                	int id=ID.nextInt();
                	Scanner STATE = new Scanner(System.in);
                	System.out.println("请输入房间状态");
                	String state=STATE.next();
                	Scanner NAME = new Scanner(System.in);
                	System.out.println("请输入客户姓名");
                	String name=NAME.next();
                	Scanner NUMBER = new Scanner(System.in);
                	System.out.println("请输入电话");
                	int number=NUMBER.nextInt();
                    // 加载驱动程序
                    Class.forName(driver1);
                    // 1.getConnection()方法，连接MySQL数据库！！
                    con1 = DriverManager.getConnection(url1, user1, password1);
                    if (!con1.isClosed())
                        System.out.println("\n\t\t正在录入，请稍后。。。");
         
                    // 2.创建statement类对象，用来执行SQL语句！！
                    Statement statement = con1.createStatement();
                    // 要执行的SQL语句
                    String sql = "update hotel1 set state='"+state+"',username='"+name+"',phonenumber="+number+" where id="+id;
                    // 3.ResultSet类，用来存放获取的结果集！！

                    statement.execute(sql) ;          // 执行数据库更新操作
                    statement.close() ;                               // 关闭操作 
                    con1.close();
                }
                catch (ClassNotFoundException e) {
                    // 数据库驱动类异常处理
                    System.out.println("Sorry,can`t find the Driver!");
                    e.printStackTrace();
                }
                catch (SQLException e) {
                    // 数据库连接失败异常处理
                    e.printStackTrace();
                }
                catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
                finally {
                    System.out.println("\t\t\t\t\t\t\t\t酒店房间状态修改毕！!！");
                }
            	
            }
            else if(choice==2) {
            	try {
                	Scanner Id = new Scanner(System.in);
                	System.out.println("请输入退房房间号");
                	int id=Id.nextInt();
                    // 加载驱动程序
                    Class.forName(driver);
                    // 1.getConnection()方法，连接MySQL数据库！！
                    con = DriverManager.getConnection(url, user, password);
                    if (!con.isClosed())
                        System.out.println("\n\t\t正在录入，请稍后。。。");
         
                    // 2.创建statement类对象，用来执行SQL语句！！
                    Statement statement = con.createStatement();
                    // 要执行的SQL语句
                    String sql = "update hotel1 set state='nobody',username=null,phonenumber=0 where id ="+id;
                    // 3.ResultSet类，用来存放获取的结果集！！
                    statement.executeUpdate(sql) ;          // 执行数据库更新操作
                    statement.close() ;                               // 关闭操作 
                    con.close();
                }
                catch (ClassNotFoundException e) {
                    // 数据库驱动类异常处理
                    System.out.println("Sorry,can`t find the Driver!");
                    e.printStackTrace();
                }
                catch (SQLException e) {
                    // 数据库连接失败异常处理
                    e.printStackTrace();
                }
                catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
                finally {
                    System.out.println("\t\t\t\t\t\t\t\t酒店房间状态修改毕！!！");
                }
            }
            else if(choice==3) {
            	Connection con3;
                // 驱动程序名
                String driver3 = "com.mysql.cj.jdbc.Driver";
                // URL指向要访问的数据库名 test
                String url3 = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
                // MySQL配置时的用户名
                String user3 = "root";
                // MySQL配置时的密码
                String password3 = "123456";
                // 遍历查询结果集
                try {
                    // 加载驱动程序
                    Class.forName(driver);
                    // 1.getConnection()方法，连接MySQL数据库！！
                    con = DriverManager.getConnection(url, user, password);
                    if (!con.isClosed())
                        System.out.println("\n\t\t欢迎使用酒店管理系统！！！");
         
                    // 2.创建statement类对象，用来执行SQL语句！！
                    Statement statement = con.createStatement();
                    // 要执行的SQL语句
                    String sql = "select * from hotel1";
                    // 3.ResultSet类，用来存放获取的结果集！！
                    ResultSet rs = statement.executeQuery(sql);
                    System.out.println("\n\t\t目前酒店房间状态如下所示:");
                    System.out.println("\t\t-----------------------------------------------------------------");
                    System.out.println("\t|\t" +"\t"+ "房间号" + "\t"+"入住状态" +"\t"+ "客户姓名" + "\t\t" + "电话" + "\t" );
                    System.out.println("\t\t-----------------------------------------------------------------");
         
                    int ID = 0;
                    String state = null;
                    String name = null;
                    int number = 0;
                    
         
                    while (rs.next()) {
                        // 获取 ID 这列数据
                        ID = rs.getInt("id");
                        // 获取 Name 这列数据
                        state = rs.getString("state");
                        // 获取 Sex 这列数据
                        name = rs.getString("username");
                        // 获取 Age 这列数据
                        number = rs.getInt("phonenumber");
                        // 获取 Phone 这列数据

                        // 输出结果
                        System.out.println("\t\t|\t" + ID + "\t" + state + "\t" + name + "\t\t" + number  + "\t|\t\t");
                    }
                    System.out.println("\t\t-----------------------------------------------------------------");
                    rs.close();
                    con.close();
                }
                catch (ClassNotFoundException e) {
                    // 数据库驱动类异常处理
                    System.out.println("Sorry,can`t find the Driver!");
                    e.printStackTrace();
                }
                catch (SQLException e) {
                    // 数据库连接失败异常处理
                    e.printStackTrace();
                }
                catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
                finally {
                    System.out.println("\t\t\t\t\t\t\t\t酒店房间状态查询完毕！!！");
                }
                     
                     
            }
            else if(choice==0) {
            	System.out.println("成功退出系统");
            	break;
            }
            else {
            	System.out.println("输入错误，请重新进入系统进行操作");
            }
        }

        
        
        
        
        
        

    }
}