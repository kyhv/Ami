package sodepami.com.ami.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;
import sodepami.com.ami.MainActivity;
import sodepami.com.ami.R;
import sodepami.com.ami.WebActivity;
import sodepami.com.ami.custom.ImagePagerAdapter;

public class FragmentHome extends Fragment implements View.OnClickListener{

    EditText etSearch;
    ImageButton ibSearch;
    ViewPager imagePager;
    RelativeLayout rl1, rl2, rl3, rl4, rl5, rl6, llCacloaisim, llCacnhamang;
    Button btCacloaisim, btCacnhamang, btPre, btNext;
    TextView tvSim1, tvSim2, tvSim3, tvSim4, tvSim5, tvSim6, tvSim7, tvSim8,
            tvSim9, tvSim10, tvSim11, tvSim12, tvSim13, tvSim14, tvSim15, tvSim16,
            tvSim17, tvSim18, tvSim19, tvSim20, tvSim21, tvSim22, tvSim23, tvSim24,
            tvNhamang1, tvNhamang2, tvNhamang3, tvNhamang4, tvNhamang5, tvNhamang6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home_new, container, false);

        initView(view);
        initClickedListener();

        return view;
    }

    private void initView(View view) {
        etSearch = (EditText) view.findViewById(R.id.tv_search);
        ibSearch = (ImageButton) view.findViewById(R.id.ib_search);

        imagePager = (ViewPager) view.findViewById(R.id.pager);
        imagePager.setAdapter(new ImagePagerAdapter(getContext()));

        CircleIndicator indicator = (CircleIndicator) view.findViewById(R.id.indicator);
        indicator.setViewPager(imagePager);

        //service
        rl1 = (RelativeLayout) view.findViewById(R.id.rl1);
        rl2 = (RelativeLayout) view.findViewById(R.id.rl2);
        rl3 = (RelativeLayout) view.findViewById(R.id.rl3);
        rl4 = (RelativeLayout) view.findViewById(R.id.rl4);
        rl5 = (RelativeLayout) view.findViewById(R.id.rl5);
        rl6 = (RelativeLayout) view.findViewById(R.id.rl6);

        llCacloaisim = (RelativeLayout) view.findViewById(R.id.ll_cacloaisim);
        llCacnhamang = (RelativeLayout) view.findViewById(R.id.ll_nhamang);

        //button
        btCacloaisim = (Button) view.findViewById(R.id.bt_cacloaisim);
        btCacnhamang = (Button) view.findViewById(R.id.bt_cacnhamang);
        btPre = (Button) view.findViewById(R.id.bt_pre);
        btNext = (Button) view.findViewById(R.id.bt_next);

        //textview
        tvSim1 = (TextView) view.findViewById(R.id.sim1);
        tvSim2 = (TextView) view.findViewById(R.id.sim2);
        tvSim3 = (TextView) view.findViewById(R.id.sim3);
        tvSim4 = (TextView) view.findViewById(R.id.sim4);
        tvSim5 = (TextView) view.findViewById(R.id.sim5);
        tvSim6 = (TextView) view.findViewById(R.id.sim6);
        tvSim7 = (TextView) view.findViewById(R.id.sim7);
        tvSim8 = (TextView) view.findViewById(R.id.sim8);
        tvSim9 = (TextView) view.findViewById(R.id.sim9);
        tvSim10 = (TextView) view.findViewById(R.id.sim10);
        tvSim11 = (TextView) view.findViewById(R.id.sim11);
        tvSim12 = (TextView) view.findViewById(R.id.sim12);
        tvSim13 = (TextView) view.findViewById(R.id.sim13);
        tvSim14 = (TextView) view.findViewById(R.id.sim14);
        tvSim15 = (TextView) view.findViewById(R.id.sim15);
        tvSim16 = (TextView) view.findViewById(R.id.sim16);
        tvSim17 = (TextView) view.findViewById(R.id.sim17);
        tvSim18 = (TextView) view.findViewById(R.id.sim18);
        tvSim19 = (TextView) view.findViewById(R.id.sim19);
        tvSim20 = (TextView) view.findViewById(R.id.sim20);
        tvSim21 = (TextView) view.findViewById(R.id.sim21);
        tvSim22 = (TextView) view.findViewById(R.id.sim22);
        tvSim23 = (TextView) view.findViewById(R.id.sim23);
        tvSim24 = (TextView) view.findViewById(R.id.sim24);

        tvNhamang1 = (TextView) view.findViewById(R.id.nhamang1);
        tvNhamang2 = (TextView) view.findViewById(R.id.nhamang2);
        tvNhamang3 = (TextView) view.findViewById(R.id.nhamang3);
        tvNhamang4 = (TextView) view.findViewById(R.id.nhamang4);
        tvNhamang5 = (TextView) view.findViewById(R.id.nhamang5);
        tvNhamang6 = (TextView) view.findViewById(R.id.nhamang6);
    }

    private void initClickedListener() {
        ibSearch.setOnClickListener(this);

        rl1.setOnClickListener(this);
        rl2.setOnClickListener(this);
        rl3.setOnClickListener(this);
        rl4.setOnClickListener(this);
        rl5.setOnClickListener(this);
        rl6.setOnClickListener(this);

        llCacnhamang.setOnClickListener(this);
        llCacloaisim.setOnClickListener(this);

        btCacloaisim.setOnClickListener(this);
        btCacnhamang.setOnClickListener(this);
        btNext.setOnClickListener(this);
        btPre.setOnClickListener(this);

        tvSim1.setOnClickListener(this);
        tvSim2.setOnClickListener(this);
        tvSim3.setOnClickListener(this);
        tvSim4.setOnClickListener(this);
        tvSim5.setOnClickListener(this);
        tvSim6.setOnClickListener(this);
        tvSim7.setOnClickListener(this);
        tvSim8.setOnClickListener(this);
        tvSim9.setOnClickListener(this);
        tvSim10.setOnClickListener(this);
        tvSim11.setOnClickListener(this);
        tvSim12.setOnClickListener(this);
        tvSim13.setOnClickListener(this);
        tvSim14.setOnClickListener(this);
        tvSim15.setOnClickListener(this);
        tvSim16.setOnClickListener(this);
        tvSim17.setOnClickListener(this);
        tvSim18.setOnClickListener(this);
        tvSim19.setOnClickListener(this);
        tvSim20.setOnClickListener(this);
        tvSim21.setOnClickListener(this);
        tvSim22.setOnClickListener(this);
        tvSim23.setOnClickListener(this);
        tvSim24.setOnClickListener(this);

        tvNhamang1.setOnClickListener(this);
        tvNhamang2.setOnClickListener(this);
        tvNhamang3.setOnClickListener(this);
        tvNhamang4.setOnClickListener(this);
        tvNhamang5.setOnClickListener(this);
        tvNhamang6.setOnClickListener(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl5:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-nam-sinh.html");
                break;
            case R.id.rl1:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/bai-viet/mua-sim-tra-gop-ami.html");
                break;
            case R.id.rl4:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-phong-thuy.html");
                break;
            case R.id.rl6:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-giam-gia.html");
                break;
            case R.id.rl2:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/bai-viet/thue-sim-vip.html");
                break;
            case R.id.rl3:
                WebActivity.startWebActivity(getContext(), " https://sodepami.vn/bai-viet/cam-sim-dep.html");
                break;
            case R.id.ib_search:
                String url = "https://sodepami.vn/tim-sim.html?key=" + etSearch.getText().toString().trim();
                WebActivity.startWebActivity(getContext(), url);
                break;
            case R.id.bt_cacloaisim:
                btCacloaisim.setBackgroundColor(getResources().getColor(R.color.color_black));
                btCacnhamang.setBackgroundColor(getResources().getColor(R.color.color_red));
                llCacloaisim.setVisibility(View.VISIBLE);
                llCacnhamang.setVisibility(View.GONE);
                break;
            case R.id.bt_cacnhamang:
                btCacloaisim.setBackgroundColor(getResources().getColor(R.color.color_red));
                btCacnhamang.setBackgroundColor(getResources().getColor(R.color.color_black));
                llCacloaisim.setVisibility(View.GONE);
                llCacnhamang.setVisibility(View.VISIBLE);
                break;
            case R.id.bt_pre:
                int currentPosition1 = imagePager.getCurrentItem();
                if (currentPosition1 > 0) {
                    imagePager.setCurrentItem(currentPosition1 - 1);
                }
                break;
            case R.id.bt_next:
                int currentPosition2 = imagePager.getCurrentItem();
                if (currentPosition2 < 5) {
                    imagePager.setCurrentItem(currentPosition2 + 1);
                }
                break;
            case R.id.nhamang1:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-viettel");
                break;
            case R.id.nhamang2:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-vinaphone");
                break;
            case R.id.nhamang3:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-mobifone");
                break;
            case R.id.nhamang4:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-vietnamobile");
                break;
            case R.id.nhamang5:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-gmobile");
                break;
            case R.id.nhamang6:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-co-dinh");
                break;
            case R.id.sim1:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-luc-quy");
                break;
            case R.id.sim2:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-ngu-quy");
                break;
            case R.id.sim3:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-tu-quy");
                break;
            case R.id.sim4:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-tam-hoa");
                break;
            case R.id.sim5:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-tam-hoa-kep");
                break;
            case R.id.sim6:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-tam-hoa-giua");
                break;
            case R.id.sim7:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-taxi");
                break;
            case R.id.sim8:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-taxi-3");
                break;
            case R.id.sim9:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-taxi-4");
                break;
            case R.id.sim10:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-loc-phat");
                break;
            case R.id.sim11:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-lap");
                break;
            case R.id.sim12:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-ganh");
                break;
            case R.id.sim13:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-tien-don");
                break;
            case R.id.sim14:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-tien-doi");
                break;
            case R.id.sim15:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-kep-2");
                break;
            case R.id.sim16:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-kep-3");
                break;
            case R.id.sim17:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-so-dao-2");
                break;
            case R.id.sim18:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-so-dao-3");
                break;
            case R.id.sim19:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-than-tai");
                break;
            case R.id.sim20:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-ong-dia");
                break;
            case R.id.sim21:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-dau-so-co");
                break;
            case R.id.sim22:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-so-dep");
                break;
            case R.id.sim23:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-dac-biet");
                break;
            case R.id.sim24:
                WebActivity.startWebActivity(getContext(), "https://sodepami.vn/sim-tat-ca/sim-gia-re");
                break;
            default:
                return;
        }
    }

}
