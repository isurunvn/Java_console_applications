public class Borrow extends Book{
    private String borrow_id;
    private String borrow_book;
    private String borrow_member;

    public Borrow(String isbn, String book_name, String author, String borrow_id, String borrow_book, String borrow_member){
        super(isbn, book_name, author);
        this.borrow_id = borrow_id;
        this.borrow_book = borrow_book;
        this.borrow_member = borrow_member;
    }

    public String getBorrowId(){
        return borrow_id;
    }

    public String getBorrowBook(){
        return borrow_book;
    }

    public String getBorrowMember(){
        return borrow_member;
    }
}
