package ucai.cn.huaxia.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ucai.cn.huaxia.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Bbar_MessageFragment extends Fragment {


    public Bbar_MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bbar__message, container, false);
    }

}
