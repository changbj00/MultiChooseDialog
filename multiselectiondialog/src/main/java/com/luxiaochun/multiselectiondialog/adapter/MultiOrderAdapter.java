package com.luxiaochun.multiselectiondialog.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import com.luxiaochun.multiselectiondialog.R;
import com.luxiaochun.multiselectiondialog.base.Node;
import com.luxiaochun.multiselectiondialog.viewholder.RVBaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * ProjectName: JiuZhou
 * PackageName: com.example.jun.jiuzhou.MultiTreeListView.adapter
 * Author: jun
 * Date: 2018-03-15 09:01
 */
public class MultiOrderAdapter extends AbsTreeRecyclerAdapter {
    private List<Node> list = new ArrayList<Node>();
    private int limited = 9;

    public MultiOrderAdapter(List<Node> datas, int limited) {
        super(datas, -1, -1, null);
        this.limited = limited;
        list.clear();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.multi_selection_order_item;
    }

    @Override
    public void onBindViewHolder(final Node node, final RVBaseViewHolder holder, final int position) {

        holder.setText(R.id.id_treenode_label, node.getName());
        holder.getTextView(R.id.id_treenode_order).setVisibility(View.VISIBLE);
        holder.getTextView(R.id.id_treenode_order).setText("");
        if (position == 0) {
            Node.textSize = holder.getTextView(R.id.id_treenode_label).getTextSize();
        }

        if (Node.textSize > 0) {
            holder.getTextView(R.id.id_treenode_label).setTextSize(TypedValue.COMPLEX_UNIT_PX, Node.textSize - 4 * node.getLevel());
        }
        if (list.size() < limited) {
            for (int i = 0; i < list.size(); i++) {
                if (node.getName().equals(list.get(i).getName())) {
                    if (i == 0) {
                        holder.getTextView(R.id.id_treenode_order).setText(R.string.quan1);
                    } else if (i == 1) {
                        holder.getTextView(R.id.id_treenode_order).setText(R.string.quan2);
                    } else if (i == 2) {
                        holder.getTextView(R.id.id_treenode_order).setText(R.string.quan3);
                    } else if (i == 3) {
                        holder.getTextView(R.id.id_treenode_order).setText(R.string.quan4);
                    } else if (i == 4) {
                        holder.getTextView(R.id.id_treenode_order).setText(R.string.quan5);
                    } else if (i == 5) {
                        holder.getTextView(R.id.id_treenode_order).setText(R.string.quan6);
                    } else if (i == 6) {
                        holder.getTextView(R.id.id_treenode_order).setText(R.string.quan7);
                    } else if (i == 7) {
                        holder.getTextView(R.id.id_treenode_order).setText(R.string.quan8);
                    } else if (i == 8) {
                        holder.getTextView(R.id.id_treenode_order).setText(R.string.quan9);
                    }
                }
            }
        }

        holder.getLinearLayout(R.id.ll_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                node.setChecked(!node.isChecked());
                if (list.size() < limited) {
                    if (node.isChecked()) {
                        list.add(node);
                    } else {
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getName().equals(node.getName())) {
                                list.remove(i);
                            }
                        }
                    }
                    notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public List<Node> getCheckedNodeList() {
        return list;
    }
}