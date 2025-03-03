    package com.example.librarymanagement.dtos;

    import com.example.librarymanagement.models.AuthorDeatils;
    import com.example.librarymanagement.models.Category;

    public class EditDetailsDto {
        public EditDetailsDto() {

        }
        // public static boolean getBookName;

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public boolean isBorrowed() {
            return isBorrowed;
        }

        public void setBorrowed(boolean borrowed) {
            isBorrowed = borrowed;
        }



        private String bookName;
        private boolean isBorrowed;

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        private String  categoryName;

    //    public AuthorDeatils getAuthorDeatils() {
    //        return authorDeatils;
    //    }
    //
    //    public void setAuthorDeatils(AuthorDeatils authorDeatils) {
    //        this.authorDeatils = authorDeatils;
    //    }

        private AuthorDeatils authorDeatils;

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        private Category category;

        public EditDetailsDto(String bookName, boolean isBorrowed, Category category) {
            this.bookName = bookName;
            this.isBorrowed = isBorrowed;
            this.category = category;
           // this.authorDeatils = authorDeatils;
        }


    }
