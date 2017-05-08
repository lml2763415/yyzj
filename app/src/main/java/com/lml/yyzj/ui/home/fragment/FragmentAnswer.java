package com.lml.yyzj.ui.home.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lml.yyzj.R;
import com.lml.yyzj.adapter.AnswerAdapter;
import com.lml.yyzj.base.BaseFragment;
import com.lml.yyzj.bean.AnswerBean;
import com.lml.yyzj.ui.home.contract.FragmentAnswerContract;
import com.lml.yyzj.view.EmptyRecycleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by liml on 17/2/28.
 */
public class FragmentAnswer extends BaseFragment<FragmentAnswerContract.Persenter> implements FragmentAnswerContract.View, View.OnClickListener {
    @Bind(R.id.recy)
    EmptyRecycleView recyclerView;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.empty)
    TextView empty;
    @Bind(R.id.refresh)
    TwinklingRefreshLayout refreshLayout;
    private int currentPage = 1;
    private int pageSize = 10;
    private AnswerAdapter adapter;
    private List<AnswerBean.DataBean.ListBean> answerList =new ArrayList<>();

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_answer_layout;
    }

    @Override
    protected void initDataAndEvent() {
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                currentPage++;
                mPresenter.loadMore(-1,currentPage,pageSize);
            }

            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
            }
        });
        adapter = new AnswerAdapter(mActivity, null);
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        recyclerView.setAdapter(adapter);
        recyclerView.setEmptyView(empty);
        title.setOnClickListener(this);
        mPresenter.loadAnswer(-1, 1, 10);
    }

    @Override
    protected FragmentAnswerContract.Persenter createPresenter() {
        return new FragmentAnswerContract.Persenter(this);
    }

    @Override
    public void progressDialog(boolean b) {

    }



    @Override
    public void refresh(AnswerBean.DataBean data) {

    }

    @Override
    public void setAnswer(AnswerBean.DataBean data) {
        currentPage = data.getPage().getCurrentPage();
        final List<AnswerBean.DataBean.ListBean> listBeen = data.getList();
        adapter.setList(listBeen);
        answerList.addAll(listBeen);

    }

    @Override
    public void loadMore(AnswerBean.DataBean data) {
        currentPage = data.getPage().getCurrentPage();
        final List<AnswerBean.DataBean.ListBean> listBeen = data.getList();
        answerList.addAll(listBeen);
        adapter.setList(answerList);
        refreshLayout.finishLoadmore();
    }



    @Override
    public void onClick(View view) {
        adapter.setList(null);
    }
}
