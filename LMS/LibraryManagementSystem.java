import java.rmi.dgc.Lease;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        char choice;

        Library library01 = new Library();

        do {
            System.out.println();
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Search and display book details");
            System.out.println("4. Add a member");
            System.out.println("5. Remove a member");
            System.out.println("6. Search and display member details");
            System.out.println("7. Borrow a book");
            System.out.println("8. Return a book");
            System.out.println("9. Quit");
            System.out.println();
            System.out.print("Choise: ");
            choice = EasyScanner.nextChar();
            System.out.println();

            switch (choice) {
                case '1':
                    option1(library01);
                    break;

                    case '2':
                        option2(library01);
                        break;

                        case '3':
                            option3(library01);
                            break;

                            case '4':
                                option4(library01);
                                break;

                                case '5':
                                    option5(library01);
                                    break;

                                    case '6':
                                        option6(library01);
                                        break;

                                        case '7':
                                            option7(library01);
                                            break;
                                            
                                            case '8':
                                                option8(library01);

                                                case '9':
                                                    break;

                default:
                    System.out.println("Invalid choice: " + choice);
            }
        } while (choice != '9');
    }

    static  void option1(Library bookIn) {
        System.out.println("Enter the book ISBN: ");
        String isbn = EasyScanner.nextString();

        System.out.println("Enter the book name: ");
        String name = EasyScanner.nextString();

        System.out.println("Enter the author of the book: ");
        String author = EasyScanner.nextString();

        boolean success = bookIn.addBook(isbn, name, author);

        if (success) {
            System.out.println("Book added successfully");
        } else {
            System.out.println("Book already exists!");
        }
    }

    static void option2(Library bookOut){
        System.out.println("Enter the book ISBN to remove: ");
        String isbn = EasyScanner.nextString();

        boolean success = bookOut.removeBook(isbn);

        if(success){
            System.out.println("Book removed successfully");
        } else {
            System.out.println("Book not found!");
        }
    }

    static void option3(Library bookSearch){
        System.out.println("Enter the book ISBN to search: ");
        String isbn = EasyScanner.nextString();

        Book book = bookSearch.getBook(isbn);

        if (book == null){
            System.out.println("Book not found");
        } else {
            System.out.println("Book Description");
            System.out.println("Book ISBN: " + book.getIsbn());
            System.out.println("Book Title: " + book.getTitle());
            System.out.println("Book author: " + book.getAuthor());
        }
    }

    static void option4(Library memberIn){
        System.out.println("Enter the member id: ");
        String memberId = EasyScanner.nextString();

        System.out.println("Enter the member name: ");
        String memberName = EasyScanner.nextString();

        boolean success = memberIn.addMember(memberId, memberName);

        if(success){
            System.out.println("Member added successfully");
        } else {
            System.out.println("A member already exists with same id!");
        }
    }

    static void option5(Library memberOut){
        System.out.println("Enter the member id to remove: ");
        String memberId = EasyScanner.nextString();

        boolean success = memberOut.removeMember(memberId);

        if(success){
            System.out.println("Member removed successfully");
        } else {
            System.out.println("Member not found with this id!");
        }
    }

    static void option6(Library memberSearch){
        System.out.println("Enter member id to search: ");
        String memberId = EasyScanner.nextString();

        Member member = memberSearch.getMember(memberId);

        if (member == null){
            System.out.println("Member not found!");
        } else {
            System.out.println("Member Description");
            System.out.println("Member Id: " + member.getMemberId());
            System.out.println("Member name: " + member.getMemberName());
        }
    }

    static void option7(Library borrow){
        System.out.println("Enter the borrow id: ");
        String borrow_id = EasyScanner.nextString();

        System.out.println("Enter the ISBN of the book going to be borrowed: ");
        String borrowBook = EasyScanner.nextString();

        System.out.println("Enter the id of the member who is going to borrow the book: ");
        String borrowMember = EasyScanner.nextString();

        boolean success = borrow.addBorrow(borrow_id, borrowBook, borrowMember) && borrow.removeBook(borrowBook);

        if (success){
            System.out.println("Added to borrow list & Now the book is not available in the library");
        } else {
            System.out.println("Already added this borrow id!");
        }
    }

    static void option8(Library borrow){
        System.out.println("Enter the borrow id: ");
        String borrowId = EasyScanner.nextString();

//        System.out.println("Borrow record found with this id");
//        System.out.println("Borrow id: " + id);
//        Borrow borrowed = listBorrowed.get(index);
//        System.out.println("Borrowed Book: " + borrowed.getBorrowBook() + ", borrowed by " + borrowed.getBorrowMember());

        Borrow borrowObj = borrow.getBorrow(borrowId);
        if (borrowObj == null){
            System.out.println("Record not found with this borrow id!");
        } else {
            System.out.println("Borrow description");
            System.out.println("Borrowed book: " + borrowObj.getBorrowBook());
            System.out.println("Borrowed by: " + borrowObj.getBorrowMember());

            System.out.println("If this info correct, type 'Y' to return the book: ");
            String res  = EasyScanner.nextString();

            if (res.equals("Y")) {

                String tempBookIsbn = borrowObj.getBorrowBook();
                String tempBookName = borrowObj.getTitle();
                String tempBookAuthor = borrowObj.getAuthor();

                boolean success = borrow.returnBook(borrowId) && borrow.addBook(tempBookIsbn,tempBookName,tempBookAuthor);

                if (success) {
                    System.out.println("Book returned successfully & book is now available in the library");
                } else {
                    System.out.println("Error in returning book");
                }

            }
        }

    }
}
