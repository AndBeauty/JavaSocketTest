# JavaSocketTest
java实验，实现Socket的多线程

【实验目的】
1、掌握Socket通讯机制；
2、掌握Socket和ServerSocket类和相关方法；
3、掌握多线程编程
【实验要求】
通过Socket编程，掌握网络应用程序的开发方法，掌握利用java提供的基本组件进行网络传输，掌握Java提供的多线程机制，异常处理机制和对底层协议的通信机制，通过Socket编程，掌握网络应用程序的开发方法。

【试验任务】
1、创建服务器和客户程序，在运行客户程序的计算机上输入的内容，可以在服务器屏幕上看到。要求实现多线程，即服务器同时服务多个客户端。
2、使用ServerSocket类和Socket类实现按如下协议通信的服务器端和客户端程序。
服务器程序的处理规则如下：
1）向客户端程序发送Verifying Server!。 
2）若读口令次数超过3次，则发送Illegal User!给客户端，程序退出。否则向下执行步骤3）。 
3）读取客户端程序提供的口令。 
4）若口令不正确，则发送PassWord Wrong!给客户端，并转步骤2），否则向下执行步骤5）。 
5）发送Registration Successful!给客户端程序。 

客户端程序的处理规则如下：
1）读取服务器反馈信息。 
2）若反馈信息不是Verifying Server!，则提示Server Wrong!，程序退出。否则向下执行步骤3） 。
3） 提示输入PassWord并将输入的口令发送给服务器。
4） 读取服务器反馈信息。 
5）若反馈信息是Illegal User!，则提示Illegal User!，程序退出。否则向下执行步骤6） 。
6）若反馈信息是PassWord Wrong!，则提示PassWord Wrong!，并转步骤3），否则向下执行步骤。 
7）输出Registration Successful!。
