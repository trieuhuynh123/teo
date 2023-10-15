FROM tomcat:9.0-jdk11-corretto-al2
RUN rm -rf /usr/local/tomcat/webapps/ROOT
RUN rm -rf /usr/local/tomcat/webapps/examples
ADD hello.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]

#1 Apache Tomcat phiên bản 9.0 và Java 11 sử dụng Corretto (OpenJDK) trên Amazon Linux 2.
#2 Dòng này xóa thư mục /usr/local/tomcat/webapps/ROOT trong hình ảnh cơ sở. Thư mục này thường chứa ứng dụng mặc định của Tomcat.
#3Tương tự như dòng lệnh trước, dòng này xóa thư mục /usr/local/tomcat/webapps/examples. Thư mục này chứa các ví dụ mẫu của Tomcat, và chúng ta có thể loại bỏ chúng nếu không cần thiết.
#4 Dòng này thêm tệp tin awebpagesurvey-1.0-SNAPSHOT.war vào thư mục /usr/local/tomcat/webapps/ trong hình ảnh. Tệp tin WAR này chứa ứng dụng web mà bạn muốn triển khai vào Tomcat.
#5 Dòng này định nghĩa cổng mạng 8080 trong hình ảnh Docker, cho biết rằng ứng dụng web sẽ lắng nghe trên cổng này khi chạy trong container.
#6 Dòng này định nghĩa lệnh mặc định sẽ được thực thi khi container được khởi chạy. Trong trường hợp này, nó chạy lệnh catalina.sh run, điều này sẽ khởi động máy chủ Tomcat và chạy ứng dụng web được triển khai.