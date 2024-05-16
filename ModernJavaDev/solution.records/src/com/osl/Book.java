package com.osl;

import java.time.Year;

public record Book(String title, String genre, String author, Year published, String description) {

    public static class Builder {

        private String title;
        private String genre;
        private String author;
        private Year published;
        private String description;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder published(Year published) {
            this.published = published;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Book build() throws IllegalStateException {
            validate();
            return new Book(title, genre, author, published, description);
        }

        private void validate() throws IllegalStateException {

            StringBuilder sb = new StringBuilder();

            if (title == null) {
                sb.append("Title must not be null.");
            }
            else if (title.length() > 100) {
                sb.append("Title cannot have more than 100 characters.");
            }

            if (genre != null && genre.length() > 20) {
                sb.append("Genre cannot have more than 20 characters.");
            }

            if (author != null && author.length() > 50) {
                sb.append("Author cannot have more than 50 characters.");
            }

            if (published.isAfter(Year.now())) {
                sb.append("Year published cannot be greater than current year.");
            }

            if (description != null && description.length() > 500) {
                sb.append("Description cannot have more than 500 characters.");
            }

            if (sb.length() > 0) {
                throw new IllegalStateException(sb.toString());
            }
        }
    }
}