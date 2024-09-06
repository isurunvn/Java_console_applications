import java.util.ArrayList;
import java.util.SplittableRandom;

public class Library {
    ArrayList<Book> list = new ArrayList<>();
    ArrayList<Member> listMem = new ArrayList<>();
    ArrayList<Borrow> listBorrowed = new ArrayList<>();

    private int searchBook(String isbn){
        for(int i = 0; i < list.size(); i++){
            Book tempBook = list.get(i);
            String tempIsbn = tempBook.getIsbn();
            if(tempIsbn.equals(isbn)){
                return i;
            }
        }
        return -1;
    }

    private int searchMember(String id){
        for (int i = 0; i < listMem.size(); i++) {
            Member tempMember = listMem.get(i);
            String tempId = tempMember.getMemberId();
            if (tempId.equals(id)){
                return i;
            }
        }
        return -1;
    }

    public int searchBorrow(String b_id){
        for (int i = 0; i <listBorrowed.size(); i++) {
            Borrow tempBorrow = listBorrowed.get(i);
            String tempId = tempBorrow.getBorrowId();
            if (tempId.equals(b_id)){
                return i;
            }
        }
        return -1;
    }

    public boolean addBook(String isbn, String name, String author){
        if (searchBook(isbn) == -1){
            list.add(new Book(isbn, name, author));
            return true;
        }
        return false;
    }

    public boolean removeBook(String isbn){
        int index = searchBook(isbn);
        if (index == -1){
            return false;
        }
        list.remove(index);
        return true;
    }

    public Book getBook(String isbn){
        int index = searchBook(isbn);
        if (index == -1){
            return null;
        } else{
            return list.get(index);
        }
    }

    public boolean addMember(String id, String name){
        if (searchMember(id) == -1){
            listMem.add(new Member(id, name));
            return true;
        } else {
            return false;
        }
    }

    public boolean removeMember(String id){
        int index = searchMember(id);
        if (index == -1){
            return false;
        } else {
            listMem.remove(index);
            return true;
            }
        }

    public Member getMember(String id){
        int index = searchMember(id);
        if (index == -1){
            return null;
        } else {
            return listMem.get(index);
        }
    }

    public Borrow getBorrow(String id){
        int index = searchBorrow(id);
        if (index == -1){
            return null;
        } else {
            return listBorrowed.get(index);
        }
    }
    public boolean addBorrow(String id, String b_book, String b_member){
        if (searchBorrow(id) == -1){
            listBorrowed.add(new Borrow(null, null, null, id, b_book, b_member));
            return true;
        } else {
            return false;
        }
    }

    public boolean returnBook(String id){
        listBorrowed.remove(searchBorrow(id));
        return true;
    }

}
