    package com.example.librarymanagement.dtos;

    import com.example.librarymanagement.models.Category;

    public class UpdateBooksDto {

        public boolean isIsborrowed() {
            return isborrowed;
        }

        public void setIsborrowed(boolean isborrowed) {
            this.isborrowed = isborrowed;
        }

        private  boolean isborrowed;

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getAuthName() {
            return authName;
        }

        public void setAuthName(String authName) {
            this.authName = authName;
        }

        public long getCode() {
            return code;
        }

        public void setCode(long code) {
            this.code = code;
        }

        private String bookName;
        private String category;
        private String authName;
        private long code;

    //    public Boolean getIsborrowed() {
    //        return isborrowed;
    //    }
    //
    //    public void setIsborrowed(Boolean isborrowed) {
    //        this.isborrowed = isborrowed;
    //    }

       // private Boolean isborrowed=false;

        public UpdateBooksDto(String bookName,long code, boolean isborrowed, String category, String authName){
            this.bookName=bookName;
           this.code=code;
            this.isborrowed=isborrowed;
            this.category= category;
            this.authName= authName;

        }

    }
