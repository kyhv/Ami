package sodepami.com.ami.custom;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import sodepami.com.ami.R;
import sodepami.com.ami.WebActivity;

public class ImagePagerAdapter extends PagerAdapter {

    int[] mResources = {
            R.drawable.bg_sim_birthday,
            R.drawable.bg_sim_tragop,
            R.drawable.bg_sim_phongthuy,
            R.drawable.bg_sim_khuyenmai50,
            R.drawable.bg_sim_vip,
            R.drawable.bg_sim_laixuatthap
    };
    Context mContext;
    LayoutInflater mLayoutInflater;

    public ImagePagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        imageView.setImageResource(mResources[position]);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position) {
                    case 0:
                        WebActivity.startWebActivity(mContext, "https://sodepami.vn/sim-nam-sinh.html");
                        break;
                    case 1:
                        WebActivity.startWebActivity(mContext, "https://sodepami.vn/bai-viet/mua-sim-tra-gop-ami.html");
                        break;
                    case 2:
                        WebActivity.startWebActivity(mContext, "https://sodepami.vn/sim-phong-thuy.html");
                        break;
                    case 3:
                        WebActivity.startWebActivity(mContext, "https://sodepami.vn/sim-giam-gia.html");
                        break;
                    case 4:
                        WebActivity.startWebActivity(mContext, "https://sodepami.vn/bai-viet/thue-sim-vip.html");
                        break;
                    case 5:
                        WebActivity.startWebActivity(mContext, " https://sodepami.vn/bai-viet/cam-sim-dep.html");
                        break;
                }
            }
        });

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}