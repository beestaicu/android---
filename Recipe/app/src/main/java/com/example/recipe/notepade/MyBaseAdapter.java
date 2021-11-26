package com.example.recipe.notepade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.recipe.R;

import java.util.List;

//创建继承自BaseAdapter的实现类进行ListView的展示
class MyBaseAdapter extends BaseAdapter {

    private List<Values> valuesList;
    private Context context;
    private int layoutId;

    public MyBaseAdapter(List<Values> valuesList, Context context, int layoutId) {
        this.valuesList = valuesList;
        this.context = context;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        if (valuesList != null && valuesList.size() > 0)
            return valuesList.size();
        else
            return 0;
    }

    @Override
    public Object getItem(int position) {
        if (valuesList != null && valuesList.size() > 0)
            return valuesList.get(position);
        else
            return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(
                    context.getApplicationContext()).inflate(R.layout.note_item, parent,
                    false);
            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.content = convertView.findViewById(R.id.tv_content);
            viewHolder.time = (TextView) convertView.findViewById(R.id.tv_time);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String title = valuesList.get(position).getTitle();
        String content = valuesList.get(position).getContent();
        viewHolder.title.setText(title);
        viewHolder.content.setText(content);
        viewHolder.time.setText(valuesList.get(position).getTime());
        return convertView;
    }
    public void removeItem(int position){
        this.valuesList.remove(position);
    }
    class ViewHolder{
        TextView title;
        TextView content;
        TextView time;
    }
}

