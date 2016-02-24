package br.com.trama.cataloga.ui;

import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.Collections;

import br.com.trama.cataloga.R;
import br.com.trama.cataloga.model.Books;
import br.com.trama.cataloga.ui.adapters.ListBooksAdapter;
import br.com.trama.cataloga.util.Mocks;

/**
 * Created by thiago on 11/02/16.
 */
@EFragment(R.layout.fragment_list_books)
public class ListBooksFragment extends Fragment {

    @ViewById(R.id.fragment_listbooks_recyclerview)
    RecyclerView recyclerView;


    @AfterViews
    public void init(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new ListBooksAdapter(Mocks.getBooks(100)));
    }

    @Click(R.id.fabTop)
    void fabTopClick(){
        Toast.makeText(getActivity(), "fab top", Toast.LENGTH_SHORT).show();
    }

    @Click(R.id.fabMid)
    void fabMidClick(){
        Toast.makeText(getActivity(), "fab mid", Toast.LENGTH_SHORT).show();
    }

}
