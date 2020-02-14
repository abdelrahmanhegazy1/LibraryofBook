package com.example.libraryofbooks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SearchMovieAdapter extends RecyclerView.Adapter<SearchMovieAdapter.SearchMovieViewHolder> {

    List<Movie> bookList;
       public SearchMovieAdapter(List<Movie> bookList)

       {
           this.bookList=bookList;

       }

    @NonNull
    @Override
    public SearchMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.first_recyclerview,parent,false);
        return new SearchMovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchMovieViewHolder holder, int position) {

           String authorNameR=bookList.get(position).getAuthor();
           String nameBook= bookList.get(position).getNameOfBook();
           int ImageofBook= bookList.get(position).getIdIcon();
           int ImageofRate = bookList.get(position).getRateIcon();
           holder.nameOfBook.setText(nameBook);
           holder.authorName.setText(authorNameR);
           holder.iconBook.setImageResource(ImageofBook);
           holder.Rate.setImageResource(ImageofRate);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class SearchMovieViewHolder extends RecyclerView.ViewHolder
    {
        ImageView iconBook;
        TextView nameOfBook;
        TextView authorName;
        ImageView Rate;
        public SearchMovieViewHolder(View view)
           {
            super(view);
            iconBook=(ImageView) view.findViewById(R.id.imageid);
            nameOfBook=(TextView)view.findViewById(R.id.NameofBook);
            authorName=(TextView)view.findViewById(R.id.AuthorName);
            Rate =(ImageView) view.findViewById(R.id.Rate);
           }
    }


}
