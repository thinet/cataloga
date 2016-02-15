package br.com.trama.cataloga.ui;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

import br.com.trama.cataloga.R;

/**
 * Created by thiago on 11/02/16.
 */
@EFragment(R.layout.fragment_list_books)
public class ListBooksFragment extends Fragment {


    @Click(R.id.fabTop)
    void fabTopClick(){
        Toast.makeText(getActivity(), "fab top", Toast.LENGTH_SHORT).show();
    }

    @Click(R.id.fabMid)
    void fabMidClick(){
        Toast.makeText(getActivity(), "fab mid", Toast.LENGTH_SHORT).show();
    }

}
