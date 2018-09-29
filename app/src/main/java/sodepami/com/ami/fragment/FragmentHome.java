package sodepami.com.ami.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import sodepami.com.ami.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentHome.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FragmentHome extends Fragment implements View.OnClickListener{

    RelativeLayout llContact, llBirthday, llTragop, llPhongthuy, llKhuyenmai50, llSimVip, llLaixuatthap;
    EditText etSearch;
    ImageButton ibSearch;

    public OnFragmentInteractionListener getListener() {
        return mListener;
    }

    public void setListener(OnFragmentInteractionListener mListener) {
        this.mListener = mListener;
    }

    private OnFragmentInteractionListener mListener;

    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragment_home, container, false);

        initView(view);
        initClickedListener();

        return view;
    }

    private void initView(View view) {
        llContact = (RelativeLayout) view.findViewById(R.id.ll_contact);
        llBirthday = (RelativeLayout) view.findViewById(R.id.ll_sim_birthday);
        llTragop = (RelativeLayout) view.findViewById(R.id.ll_sim_tragop);
        llPhongthuy = (RelativeLayout) view.findViewById(R.id.ll_sim_phongthuy);
        llKhuyenmai50 = (RelativeLayout) view.findViewById(R.id.ll_sim_khuyenmai50);
        llSimVip = (RelativeLayout) view.findViewById(R.id.ll_sim_vip);
        llLaixuatthap = (RelativeLayout) view.findViewById(R.id.ll_sim_laixuatthap);
        etSearch = (EditText) view.findViewById(R.id.tv_search);
        ibSearch = (ImageButton) view.findViewById(R.id.ib_search);
    }

    private void initClickedListener() {
        llContact.setOnClickListener(this);
        llBirthday.setOnClickListener(this);
        llTragop.setOnClickListener(this);
        llPhongthuy.setOnClickListener(this);
        llKhuyenmai50.setOnClickListener(this);
        llSimVip.setOnClickListener(this);
        llLaixuatthap.setOnClickListener(this);
        ibSearch.setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_contact:
                if (mListener != null) {
                    mListener.onChangeContactClicked();
                }
                break;
            case R.id.ll_sim_birthday:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://sodepami.vn/sim-nam-sinh.html")));
                break;
            case R.id.ll_sim_tragop:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://sodepami.vn/bai-viet/mua-sim-tra-gop-ami.html")));
                break;
            case R.id.ll_sim_phongthuy:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://sodepami.vn/sim-phong-thuy.html")));
                break;
            case R.id.ll_sim_khuyenmai50:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://sodepami.vn/sim-giam-gia.html")));
                break;
            case R.id.ll_sim_vip:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://sodepami.vn/bai-viet/thue-sim-vip.html")));
                break;
            case R.id.ll_sim_laixuatthap:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://sodepami.vn/tin-tuc.html")));
                break;
            case R.id.ib_search:
                String url = "https://sodepami.vn/tim-sim.html?key=" + etSearch.getText().toString().trim();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                break;
            default:
                return;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onChangeContactClicked();
    }
}
