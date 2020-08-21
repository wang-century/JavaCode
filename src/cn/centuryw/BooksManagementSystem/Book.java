package cn.centuryw.BooksManagementSystem;

/**
 * 书本信息的结构:
 *     类型           书名          价格          作者
 *   言情小说       《金瓶梅》　     99.9　         阿猫
 */
public class Book {
    private String bookType;    // 类型
    private String bookName;    // 书名
    private Double price;       // 价格
    private String author;      // 作者

    public Book(String bookType,String bookName,Double price,String author){
        this.bookType = bookType;
        this.bookName = bookName;
        this.price = price;
        this.author = author;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "书名:"+this.bookName+"\t价格:"+this.price+"\t作者:"+this.author+"\t类别:"+this.bookType;
    }
}
