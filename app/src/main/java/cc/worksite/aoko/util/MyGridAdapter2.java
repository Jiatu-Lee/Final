package cc.worksite.aoko.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import cc.worksite.aoko.R;


/**
 * Created by Lee on 2016/7/30 0030.
 */
public class MyGridAdapter2 extends BaseAdapter {
    private Context mContext;

    public String[] img_text = { "国内供应", "全球供应",  "国内求购",
            "国际求购","虚位以待", "","","","","","","","","","",""};
    public int[] imgs = { R.drawable.grid_brade,
            R.drawable.grid_globle, R.drawable.grid_lis,
            R.drawable.grid_plane,0,
            0 ,0,0,0,0,0,0,0,0,0,0};

    public MyGridAdapter2(Context mContext) {
        super();
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return img_text.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.grid_item, parent, false);
        }
        TextView tv = BaseViewHolder.get(convertView, R.id.tv_item);
        ImageView iv = BaseViewHolder.get(convertView, R.id.iv_item);
        iv.setBackgroundResource(imgs[position]);

        tv.setText(img_text[position]);
        return convertView;
    }

}
