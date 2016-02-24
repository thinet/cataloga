package br.com.trama.cataloga.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import br.com.trama.cataloga.R;
import br.com.trama.cataloga.model.Books;
import br.com.trama.cataloga.util.Const;

/**
 * Created by trama on 17/02/16.
 */
public class ListBooksAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Books> booksList;

    public ListBooksAdapter(List<Books> booksList) {
        this.booksList = booksList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if(Const.EMPTY_VIEW == viewType){
            viewHolder = new EmptyViewHolder(inflater, parent);
        } else {
            viewHolder = new BooksViewHolder(inflater, parent);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(Const.EMPTY_VIEW != holder.getItemViewType()){

            Books books = this.booksList.get(position);

            BooksViewHolder booksViewHolder = (BooksViewHolder) holder;

            Glide.with(holder.itemView.getContext())
                    .load(books.imageUrl)
                    .centerCrop()
                    .placeholder(R.drawable.book_default)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(booksViewHolder.cardImage);

            booksViewHolder.cardText.setText(books.text);
            booksViewHolder.cardTitle.setText(books.title);
        }
    }

    @Override
    public int getItemViewType(int position) {

        int viewType = 123;

        if(this.booksList.isEmpty()){
            viewType = Const.EMPTY_VIEW;
        }

        return viewType;
    }

    @Override
    public int getItemCount() {
        return this.booksList.isEmpty() ? 1 : this.booksList.size();
    }


    public static class BooksViewHolder extends RecyclerView.ViewHolder{

        final ImageView cardImage;
        final TextView cardTitle;
        final TextView cardText;
        final ImageButton readButton;
        final ImageButton shareButton;

        public BooksViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_book, parent, false));
            cardImage   = (ImageView) super.itemView.findViewById(R.id.card_image);
            cardTitle   = (TextView)  super.itemView.findViewById(R.id.card_title);
            cardText    = (TextView)  super.itemView.findViewById(R.id.card_text);
            readButton  = (ImageButton) super.itemView.findViewById(R.id.read_button);
            shareButton = (ImageButton) super.itemView.findViewById(R.id.share_button);
        }
    }

    public static class EmptyViewHolder extends RecyclerView.ViewHolder{

        public EmptyViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.empty_book, parent, false));
        }
    }
}
