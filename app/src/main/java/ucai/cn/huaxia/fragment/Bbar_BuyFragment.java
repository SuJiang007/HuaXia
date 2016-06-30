package ucai.cn.huaxia.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ucai.cn.huaxia.HuaXiaApplication;
import ucai.cn.huaxia.MainActivity;
import ucai.cn.huaxia.R;
import ucai.cn.huaxia.activity.BaseActivity;
import ucai.cn.huaxia.adapter.BuyAdapter;
import ucai.cn.huaxia.bean.CartBean;
import ucai.cn.huaxia.bean.ResultBean;
import ucai.cn.huaxia.data.ApiParams;
import ucai.cn.huaxia.data.GsonRequest;


/**
 * A simple {@link Fragment} subclass.
 */
public class Bbar_BuyFragment extends Fragment {
    SwipeRefreshLayout swipeRefreshLayout;
    TextView mtv_Refresh_Hint;
    RecyclerView mRecyclerView;
    LinearLayoutManager manager;
    ArrayList<CartBean> mArrayList;
    BuyAdapter mAdapter;
    static final int ACTION_PULLDOWN = 0;
    static final int ACTION_DOWNING = 1;
    static final int ACTION_PULLUP = 2;
    int action = ACTION_DOWNING;
    static final String TOKEN = "token";
    static final String LOGIN_NAME = "loginName";
    static final String CURRPAGE = "currPage";
    int PAGE = 1;

    public Bbar_BuyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_bbar__buy, container, false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData(PAGE);
        setListener();
    }

    private void setListener() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                PAGE = 1;
                initData(PAGE);
                action = ACTION_PULLDOWN;
            }
        });

        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            int topposition;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastposition = manager.findLastVisibleItemPosition();
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastposition == mAdapter.getItemCount() - 1 && mAdapter.isMore()) {
                    PAGE += 1;
                    action = ACTION_PULLUP;
                    initData(PAGE);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                topposition = mRecyclerView == null || mRecyclerView.getChildCount() == 0 ? 0 : mRecyclerView.getChildAt(0).getTop();
                swipeRefreshLayout.setEnabled(topposition>=0);
            }
        });
    }

    private void initData(int page) {
        String path = getPath(page);
        Log.i("main", "path=" + path);
        ((BaseActivity)getActivity()).executeRequest(new GsonRequest<ResultBean>(path,ResultBean.class,
                responseCartListener(),((BaseActivity)getActivity()).errorListener()));
    }

    @NonNull
    private String getPath(int page) {
        return HuaXiaApplication.SERVER_ROOT + TOKEN + "=" + "&" + LOGIN_NAME + "=" + "&" + CURRPAGE + "=" + page;
    }
    public static <T> ArrayList<T> array2List(T[] ary){
        List<T> list = Arrays.asList(ary);
        ArrayList<T> arrayList=new ArrayList<T>(list);
        return arrayList;
    }
    private Response.Listener<ResultBean> responseCartListener() {
        return new Response.Listener<ResultBean>() {
            @Override
            public void onResponse(ResultBean resultBean) {
                if (resultBean != null) {
                    mAdapter.setMore(true);
                    swipeRefreshLayout.setRefreshing(false);
                    mtv_Refresh_Hint.setVisibility(View.GONE);
                    mAdapter.setFootText("加载更多");
                    Log.i("main", "resultBean Bbar_BuyFragment=" + resultBean.toString());
                    CartBean[] cartlist = resultBean.getCarList();
                    if (cartlist != null) {
                        ArrayList<CartBean> list = array2List(cartlist);
                        Log.i("main", "list Bbar_BuyFragment=" + list);
                        if (action == ACTION_PULLDOWN || action == ACTION_DOWNING) {
                            mAdapter.initList(list);
                        } else if (action == ACTION_PULLUP) {
                            mAdapter.addList(list);
                        }
                        if (list.size() < 15) {
                            mAdapter.setFootText("没有更多数据了");
                            mAdapter.setMore(false);
                        }
                    }
                }
            }
        };
    }

    private void initView() {
        swipeRefreshLayout = (SwipeRefreshLayout) getActivity().findViewById(R.id.swip);
        mtv_Refresh_Hint = (TextView) getActivity().findViewById(R.id.refresh_hint);
        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.recyclerview);
        manager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(manager);

        mArrayList = new ArrayList<>();
        mAdapter = new BuyAdapter(getActivity(), mArrayList);
        mRecyclerView.setAdapter(mAdapter);
    }

}
