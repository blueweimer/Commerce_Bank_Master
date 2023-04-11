import React, { useEffect, useState} from 'react';
import BookItem from '../../components/BookItem';
 
function Home() {

  const[books, setBooks] = useState([]);


  return (
    <div>
        {books.map(book=> <BookItem key={book.id} book = {book}></BookItem> )}        
    </div>
  );
}

export default Home;
