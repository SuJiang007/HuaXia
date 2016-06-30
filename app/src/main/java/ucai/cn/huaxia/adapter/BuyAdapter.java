package ucai.cn.huaxia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

import ucai.cn.huaxia.R;
import ucai.cn.huaxia.bean.CartBean;
import ucai.cn.huaxia.bean.ResultBean;
import ucai.cn.huaxia.data.RequestManager;

/**
 * Created by Administrator on 2016/6/29.
 */
public class BuyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    String footText;
    boolean isMore;
    private static final int TYPE_FOOT = 0;
    private static final int TYPE_ITEM = 1;
    FootViewHolder footViewHolder;
    BuyViewHolder buyViewHolder;
    ArrayList<CartBean> cartlist;

    public BuyAdapter(Context context,ArrayList<CartBean> cartlist) {
        this.context = context;
        this.cartlist = cartlist;
    }

    public String getFootText() {
        return footText;
    }

    public void setFootText(String footText) {
        this.footText = footText;
        notifyDataSetChanged();
    }

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }

    public void initList(ArrayList<CartBean> list) {
        if (list != null) {
            this.cartlist.clear();
        }
        this.cartlist.addAll(list);
        notifyDataSetChanged();
    }

    public void addList(ArrayList<CartBean> list) {
        this.cartlist.addAll(list);
        notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater from = LayoutInflater.from(context);
        RecyclerView.ViewHolder holder = null;
        View layout;
        switch (viewType) {
            case TYPE_ITEM:
                layout = from.inflate(R.layout.buy_item, parent, false);
                holder = new BuyViewHolder(layout);
                break;
            case TYPE_FOOT:
                layout = from.inflate(R.layout.foot_item, parent, false);
                holder = new FootViewHolder(layout);
                break;
        }
        return holder;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return TYPE_FOOT;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FootViewHolder) {
            footViewHolder = (FootViewHolder) holder;
            footViewHolder.mtv_foot.setText(footText);
            footViewHolder.mtv_foot.setVisibility(View.VISIBLE);
        }
        if (holder instanceof BuyViewHolder) {
            buyViewHolder = (BuyViewHolder) holder;
            CartBean cartBean = cartlist.get(position);
            buyViewHolder.mtv_data.setText(cartBean.getPublishDate());
            buyViewHolder.mtv_price.setText("¥"+cartBean.getPrice()+"万元");
            buyViewHolder.mtv_city.setText(cartBean.getLocation()+"/"+cartBean.getMileAge()+"万公里");
            buyViewHolder.mtv_title.setText(cartBean.getBuyDate()+" "+cartBean.getSeriesBrandCarStyle());
            buyViewHolder.mtv_count.setText(""+cartBean.getCredit());
            String path = cartBean.getPhotoAddress();
            buyViewHolder.niv_image.setImageUrl(path, RequestManager.getImageLoader());
            buyViewHolder.niv_image.setDefaultImageResId(R.drawable.default_cart);
            buyViewHolder.niv_image.setErrorImageResId(R.drawable.default_cart);
        }
    }

    @Override
    public int getItemCount() {
        return cartlist==null?0:cartlist.size()+1;
    }

    class FootViewHolder extends RecyclerView.ViewHolder {
        public TextView mtv_foot;
        public FootViewHolder(View itemView) {
            super(itemView);
            mtv_foot = (TextView) itemView.findViewById(R.id.foot);
        }
    }
    class BuyViewHolder extends RecyclerView.ViewHolder {
        NetworkImageView niv_image;
        TextView mtv_title,mtv_city,mtv_count, mtv_price, mtv_data;
        public BuyViewHolder(View itemView) {
            super(itemView);
            niv_image = (NetworkImageView) itemView.findViewById(R.id.buy_niv_item);
            mtv_title = (TextView) itemView.findViewById(R.id.title_buy);
            mtv_city = (TextView) itemView.findViewById(R.id.city);
            mtv_count = (TextView) itemView.findViewById(R.id.count);
            mtv_price = (TextView) itemView.findViewById(R.id.price_buy);
            mtv_data = (TextView) itemView.findViewById(R.id.data);
        }
    }
}

