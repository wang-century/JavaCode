package cn.centuryw.BooksManagementSystem;

import java.util.*;

/**
 * 图书管理系统
 * <p>
 * 业务需求分析:
 * (1）查看全部书籍。query
 * (2）添加书本信息。add
 * (3）删除书本信息。delete
 * (4）修改书本信息。update
 * (5）退出系统。exit
 * <p>
 * 书本信息的结构:
 * 类型           书名          价格          作者
 * 言情小说       《金瓶梅》　     99.9　         阿猫
 */

public class Manager {
    // 键盘录入
    static Scanner input = new Scanner(System.in);
    // 分类型存储图书
    static Map<String, List<Book>> BOOK_STORE = new HashMap<>();


    public static void main(String[] args) {
        int choice;

        // 测试数据
        Book book1 = new Book("武侠", "天涯明月刀", 45.0, "古龙");
        Book book2 = new Book("玄幻", "放开那个女巫", 44.0, "二目");
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        books1.add(book1);
        books2.add(book2);

        BOOK_STORE.put(book1.getBookType(), books1);
        BOOK_STORE.put(book2.getBookType(), books2);


        while (true) {
            showMenu();
            choice = input.nextInt();
            switch (choice) {
                case 1: // 查看书籍
                    showAllBooks();
                    break;
                case 2: // 添加书籍
                    addBook();
                    break;
                case 3: // 删除书籍
                    deleteBook();
                    break;
                case 4: // 修改书籍
                    updateBook();
                    break;
                case 5: // 退出系统
                    System.out.println("退出系统...");
                    return;
                default:
                    System.out.println("输入错误，请重新输入！");
            }
        }
    }

    static void showMenu() {
        /**
         * 显示菜单
         */
        System.out.println("图书管理系统");
        System.out.println("\t1.查看全部图书");
        System.out.println("\t2.添加图书");
        System.out.println("\t3.删除图书");
        System.out.println("\t4.修改图书");
        System.out.println("\t5.退出系统");
        System.out.print("请选择:");
    }

    static void showAllBooks() {
        /**
         * 查看全部图书
         */
        if (BOOK_STORE.isEmpty()) {
            System.out.println("无图书！请先添加书籍");
        } else {
            System.out.println("\t类型\t\t\t\t书名\t\t\t\t\t价格\t\t\t作者");
            // 获取所有图书类型键集合
            Set<String> bookTypes = BOOK_STORE.keySet();
            // 书橱
            List<Book> books = null;
            for (String bookType : bookTypes) {
                books = BOOK_STORE.get(bookType);
                for (Book book : books) {
                    System.out.println("\t" + book.getBookType() + "\t\t\t\t" + book.getBookName() + "\t\t\t" + book.getPrice() + "\t\t" + book.getAuthor());
                }
            }
        }
    }

    static void addBook() {
        /**
         * 添加图书
         */
        // 输入图书信息
        System.out.println("请输入图书信息：");
        System.out.print("类型:");
        String bookType = input.next();
        input.nextLine();
        System.out.print("书名:");
        String bookName = input.nextLine();
        double bookPrice;
        while (true) {
            Scanner sc = new Scanner(System.in);    // 防止输入ＢＵＧ
            System.out.print("价格:");
            try {
                bookPrice = Double.parseDouble(sc.next());
                break;
            } catch (Exception e) {
                System.out.println("价格输入错误，重新输入！");
            }
        }
        System.out.print("作者:");
        String author = input.nextLine();
        // 创建图书对象
        Book book = new Book(bookType, bookName, bookPrice, author);
        // 创建书橱
        List<Book> books = null;
        // 判断类型是否存在
        if (BOOK_STORE.containsKey(bookType)) {
            books = BOOK_STORE.get(bookType);
        } else {
            books = new ArrayList<>();
            BOOK_STORE.put(bookType, books);
        }
        // 将图书加入图书馆
        books.add(book);
        System.out.println("添加图书" + bookName + "成功!");
    }

    /**
     * 删除图书
     */
    static void deleteBook() {
        System.out.print("请输入要删除的图书类别:");
        String bookType = input.next();
        // 判断图书类别是否存在
        if (bookTypeIsExist(bookType)) {    // 存在
            System.out.print("请输入图书名称:");
            input.nextLine();
            String bookName = input.nextLine();
            List<Book> books = BOOK_STORE.get(bookType);
            for (Book book : books) {
                if (book.getBookName().equals(bookName)) {
                    books.remove(book);
                    System.out.println("图书《" + bookName + "》已删除");
                    return;
                }
            }
            System.out.println("图书不存在");
        } else {    // 不存在
            System.out.println("图书类别不存在，请重新选择！");
        }
    }

    /**
     * 修改图书
     */
    static void updateBook() {
        System.out.print("请输入要修改的图书类别:");
        String bookType = input.next();
        // 判断图书类别是否存在
        if (bookTypeIsExist(bookType)) {    // 存在
            System.out.print("请输入要修改的图书名称:");
            input.nextLine();
            String bookName = input.nextLine();
            List<Book> books = BOOK_STORE.get(bookType);
            for (Book book : books) {
                if (book.getBookName().equals(bookName)) {
                    while (true) {
                        System.out.print("请输入要修改的字段:");
                        System.out.println("1.图书类别 2.图书名称 3.图书价格　4.作者　5.退出图书修改");
                        int choice = input.nextInt();
                        input.nextLine();
                        switch (choice) {
                            case 1: // 图书类别
                                System.out.print("请输入类别:");
                                bookType = input.next();
                                book.setBookType(bookType);
                                break;
                            case 2: // 图书名称
                                System.out.print("请输入图书名称:");
                                bookName = input.nextLine();
                                book.setBookName(bookName);
                                break;
                            case 3: // 图书价格
                                double price;
                                while (true) {
                                    Scanner sc = new Scanner(System.in);    // 防止输入ＢＵＧ
                                    System.out.print("请输入价格:");
                                    try {
                                        price = Double.parseDouble(sc.nextLine());
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("价格输入错误，重新输入！");
                                    }
                                }
                                book.setPrice(price);
                                break;
                            case 4: // 作者
                                System.out.print("请输入作者:");
                                String author = input.nextLine();
                                book.setAuthor(author);
                                break;
                            case 5:
                                return;
                            default:
                                System.out.println("输入错误，请重新输入！");
                        }
                        System.out.println("图书《" + bookName + "》已修改，修改后的数据为:");
                        System.out.println(book);
                    }
                }
            }
            System.out.println("图书不存在");
        } else {    // 不存在
            System.out.println("图书类别不存在，请重新选择！");
        }

    }

    /**
     * 根据图书名称和图书类型判断图书是否存在
     *
     * @param bookType 图书名称
     * @param bookName 图书类型
     * @return 查询的图书或null
     */
    static Book bookIsExist(String bookType, String bookName) {
        List<Book> books = BOOK_STORE.get(bookType);
        for (Book book : books) {
            if (book.getBookName().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

    /**
     * 判断图书类别是否存在
     *
     * @param bookType 　图书类别
     * @return true/false
     */
    static boolean bookTypeIsExist(String bookType) {
        return BOOK_STORE.containsKey(bookType);
    }
}
