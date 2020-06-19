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
        // ����Connection����
        Connection con;
        // ����������
        String driver = "com.mysql.cj.jdbc.Driver";
        // URLָ��Ҫ���ʵ����ݿ��� test
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        // MySQL����ʱ���û���
        String user = "root";
        // MySQL����ʱ������
        String password = "123456";
        // ������ѯ�����
        try {
            // ������������
            Class.forName(driver);
            // 1.getConnection()����������MySQL���ݿ⣡��
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed())
                System.out.println("\n\t\t��ӭʹ�þƵ����ϵͳ������");
 
            // 2.����statement���������ִ��SQL��䣡��
            Statement statement = con.createStatement();
            // Ҫִ�е�SQL���
            String sql = "select * from hotel1";
            // 3.ResultSet�࣬������Ż�ȡ�Ľ��������
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("\n\t\tĿǰ�Ƶ귿��״̬������ʾ:");
            System.out.println("\t\t-----------------------------------------------------------------");
            System.out.println("\t|\t" +"\t"+ "�����" + "\t"+"��ס״̬" +"\t"+ "�ͻ�����" + "\t\t" + "�绰" + "\t" );
            System.out.println("\t\t-----------------------------------------------------------------");
 
            int ID = 0;
            String state = null;
            String name = null;
            int number = 0;
            
 
            while (rs.next()) {
                // ��ȡ ID ��������
                ID = rs.getInt("id");
                // ��ȡ Name ��������
                state = rs.getString("state");
                // ��ȡ Sex ��������
                name = rs.getString("username");
                // ��ȡ Age ��������
                number = rs.getInt("phonenumber");
                // ��ȡ Phone ��������

                // ������
                System.out.println("\t\t|\t" + ID + "\t" + state + "\t" + name + "\t\t" + number  + "\t|\t\t");
            }
            System.out.println("\t\t-----------------------------------------------------------------");
            rs.close();
            con.close();
        }
        catch (ClassNotFoundException e) {
            // ���ݿ��������쳣����
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }
        catch (SQLException e) {
            // ���ݿ�����ʧ���쳣����
            e.printStackTrace();
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        finally {
            System.out.println("\t\t\t\t\t\t\t\t�Ƶ귿��״̬��ѯ��ϣ�!��");
        }
        
        
        
        for(int i=1;i>0;i++) {
        	Scanner reader = new Scanner(System.in);
            System.out.println("�����밴1���˷��밴2����ѯ�Ƶ귿��״̬�밴3���˳��밴0");
            int choice=reader.nextInt();
        	if(choice==1) {
            	// ����Connection����
                Connection con1;
                // ����������
                String driver1 = "com.mysql.cj.jdbc.Driver";
                // URLָ��Ҫ���ʵ����ݿ��� test
                String url1 = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
                // MySQL����ʱ���û���
                String user1 = "root";
                // MySQL����ʱ������
                String password1 = "123456";
                // ������ѯ�����
            	try {
            		Scanner ID = new Scanner(System.in);
                	System.out.println("�����뷿���");
                	int id=ID.nextInt();
                	Scanner STATE = new Scanner(System.in);
                	System.out.println("�����뷿��״̬");
                	String state=STATE.next();
                	Scanner NAME = new Scanner(System.in);
                	System.out.println("������ͻ�����");
                	String name=NAME.next();
                	Scanner NUMBER = new Scanner(System.in);
                	System.out.println("������绰");
                	int number=NUMBER.nextInt();
                    // ������������
                    Class.forName(driver1);
                    // 1.getConnection()����������MySQL���ݿ⣡��
                    con1 = DriverManager.getConnection(url1, user1, password1);
                    if (!con1.isClosed())
                        System.out.println("\n\t\t����¼�룬���Ժ󡣡���");
         
                    // 2.����statement���������ִ��SQL��䣡��
                    Statement statement = con1.createStatement();
                    // Ҫִ�е�SQL���
                    String sql = "update hotel1 set state='"+state+"',username='"+name+"',phonenumber="+number+" where id="+id;
                    // 3.ResultSet�࣬������Ż�ȡ�Ľ��������

                    statement.execute(sql) ;          // ִ�����ݿ���²���
                    statement.close() ;                               // �رղ��� 
                    con1.close();
                }
                catch (ClassNotFoundException e) {
                    // ���ݿ��������쳣����
                    System.out.println("Sorry,can`t find the Driver!");
                    e.printStackTrace();
                }
                catch (SQLException e) {
                    // ���ݿ�����ʧ���쳣����
                    e.printStackTrace();
                }
                catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
                finally {
                    System.out.println("\t\t\t\t\t\t\t\t�Ƶ귿��״̬�޸ıϣ�!��");
                }
            	
            }
            else if(choice==2) {
            	try {
                	Scanner Id = new Scanner(System.in);
                	System.out.println("�������˷������");
                	int id=Id.nextInt();
                    // ������������
                    Class.forName(driver);
                    // 1.getConnection()����������MySQL���ݿ⣡��
                    con = DriverManager.getConnection(url, user, password);
                    if (!con.isClosed())
                        System.out.println("\n\t\t����¼�룬���Ժ󡣡���");
         
                    // 2.����statement���������ִ��SQL��䣡��
                    Statement statement = con.createStatement();
                    // Ҫִ�е�SQL���
                    String sql = "update hotel1 set state='nobody',username=null,phonenumber=0 where id ="+id;
                    // 3.ResultSet�࣬������Ż�ȡ�Ľ��������
                    statement.executeUpdate(sql) ;          // ִ�����ݿ���²���
                    statement.close() ;                               // �رղ��� 
                    con.close();
                }
                catch (ClassNotFoundException e) {
                    // ���ݿ��������쳣����
                    System.out.println("Sorry,can`t find the Driver!");
                    e.printStackTrace();
                }
                catch (SQLException e) {
                    // ���ݿ�����ʧ���쳣����
                    e.printStackTrace();
                }
                catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
                finally {
                    System.out.println("\t\t\t\t\t\t\t\t�Ƶ귿��״̬�޸ıϣ�!��");
                }
            }
            else if(choice==3) {
            	Connection con3;
                // ����������
                String driver3 = "com.mysql.cj.jdbc.Driver";
                // URLָ��Ҫ���ʵ����ݿ��� test
                String url3 = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
                // MySQL����ʱ���û���
                String user3 = "root";
                // MySQL����ʱ������
                String password3 = "123456";
                // ������ѯ�����
                try {
                    // ������������
                    Class.forName(driver);
                    // 1.getConnection()����������MySQL���ݿ⣡��
                    con = DriverManager.getConnection(url, user, password);
                    if (!con.isClosed())
                        System.out.println("\n\t\t��ӭʹ�þƵ����ϵͳ������");
         
                    // 2.����statement���������ִ��SQL��䣡��
                    Statement statement = con.createStatement();
                    // Ҫִ�е�SQL���
                    String sql = "select * from hotel1";
                    // 3.ResultSet�࣬������Ż�ȡ�Ľ��������
                    ResultSet rs = statement.executeQuery(sql);
                    System.out.println("\n\t\tĿǰ�Ƶ귿��״̬������ʾ:");
                    System.out.println("\t\t-----------------------------------------------------------------");
                    System.out.println("\t|\t" +"\t"+ "�����" + "\t"+"��ס״̬" +"\t"+ "�ͻ�����" + "\t\t" + "�绰" + "\t" );
                    System.out.println("\t\t-----------------------------------------------------------------");
         
                    int ID = 0;
                    String state = null;
                    String name = null;
                    int number = 0;
                    
         
                    while (rs.next()) {
                        // ��ȡ ID ��������
                        ID = rs.getInt("id");
                        // ��ȡ Name ��������
                        state = rs.getString("state");
                        // ��ȡ Sex ��������
                        name = rs.getString("username");
                        // ��ȡ Age ��������
                        number = rs.getInt("phonenumber");
                        // ��ȡ Phone ��������

                        // ������
                        System.out.println("\t\t|\t" + ID + "\t" + state + "\t" + name + "\t\t" + number  + "\t|\t\t");
                    }
                    System.out.println("\t\t-----------------------------------------------------------------");
                    rs.close();
                    con.close();
                }
                catch (ClassNotFoundException e) {
                    // ���ݿ��������쳣����
                    System.out.println("Sorry,can`t find the Driver!");
                    e.printStackTrace();
                }
                catch (SQLException e) {
                    // ���ݿ�����ʧ���쳣����
                    e.printStackTrace();
                }
                catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
                finally {
                    System.out.println("\t\t\t\t\t\t\t\t�Ƶ귿��״̬��ѯ��ϣ�!��");
                }
                     
                     
            }
            else if(choice==0) {
            	System.out.println("�ɹ��˳�ϵͳ");
            	break;
            }
            else {
            	System.out.println("������������½���ϵͳ���в���");
            }
        }

        
        
        
        
        
        

    }
}