
export type BOOK_TYPE = {
    bookId: string;
    bookName: {
        bookName: string;
    };
    isbn: {
        isbn: string;
    };
    image: {
        url: string;
    };
    author: {
        author: string;
    };
    releaseYear: {
        releaseYear: number;
    };
    rate: {
        rate: number;
    };
    language: {
        language: string;
    };
    available: {
        available: boolean;
    };
};

export type ORDERS_TYPE = {
    id: string;
    dateInfo: {
        creationDate: string;
    };
    booksID: string[];
}[];
export type ORDER_TYPE = {
    id: string;
    dateInfo: {
        creationDate: string;
    };
    booksID: string[];
};