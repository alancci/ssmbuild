package com.project.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data//实现setter,getter,toString,hashCode,equals
@AllArgsConstructor//全参构造
@NoArgsConstructor//无参构造
@Component
public class Books {
    /**
     * 书id 主键
     */
    private Integer bookID;
    /**
     * 书名
     */
    @Value("haha")
    private String bookName;
    /**
     * 书的数量
     */
    private Integer bookCounts;
    /**
     * 描述
     */
    private String detail;

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookCounts() {
        return bookCounts;
    }

    public void setBookCounts(Integer bookCounts) {
        this.bookCounts = bookCounts;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
