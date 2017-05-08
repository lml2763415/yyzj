package com.lml.yyzj.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lml.yyzj.R;
import com.lml.yyzj.bean.AnswerBean;
import com.lml.yyzj.ui.home.activity.AnswerDetialActivity;
import com.lml.yyzj.util.ToastUtils;

import java.util.List;

/**
 * Created by liml on 17/3/18.
 */

public class AnswerAdapter extends RecyclerView.Adapter{
    private Context context;
    private List<AnswerBean.DataBean.ListBean> list;

    public AnswerAdapter(Context context, List<AnswerBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_answer_layout, parent,false);
//        View view = View.inflate(context, R.layout.item_answer_layout, null);
        return new MyHolder(view);
    }

    public void setList(List<AnswerBean.DataBean.ListBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final MyHolder myHolder = (MyHolder) holder;
        AnswerBean.DataBean.ListBean t = list.get(position);
        myHolder.describe.setText(t.getTitle());
        myHolder.describe_name.setText(t.getUser().getRegion().getName() + " "+t.getCommonType().getName() + " "+t.getUser().getName());
        myHolder.answer.setText(t.getAnswer());
        myHolder.answer_name.setText(t.getProfessor());
        myHolder.parise_number.setText(t.getPraises()+"");

        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AnswerDetialActivity.class);
                context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation((Activity) context,myHolder.parise_number, "shawView").toBundle());

            }
        });
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        private final TextView answer;
        private final TextView answer_name;
        private final TextView describe;
        private final TextView describe_name;
        private final TextView parise_number;

        public MyHolder(View itemView) {
            super(itemView);
            answer = (TextView) itemView.findViewById(R.id.answer);
            answer_name = (TextView) itemView.findViewById(R.id.answer_name);
            describe = (TextView) itemView.findViewById(R.id.describe);
            describe_name = (TextView) itemView.findViewById(R.id.describe_name);
            parise_number = (TextView) itemView.findViewById(R.id.parise_number);
        }
    }
}
