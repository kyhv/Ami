package sodepami.com.ami;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.internal.NavigationMenuItemView;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sodepami.com.ami.fragment.FragmentHome;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentHome.OnFragmentInteractionListener, View.OnClickListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.img_action)
    ImageView imgBack;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.app_bar)
    AppBarLayout appBar;

    @BindView(R.id.nav_view)
    NavigationView mSlideNaviView;

    @BindView(R.id.content_container)
    FrameLayout mContentFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initViewClickedListener();
        initNavigationDrawer();
        initFragmentHome();
    }

    private void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.BLUE);
        }
    }

    /**
     * init view clicked listener
     */
    private void initViewClickedListener() {
        imgBack.setOnClickListener(this);
    }

    private void initFragmentHome() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        FragmentHome fragmentHome = new FragmentHome();
        fragmentHome.setListener(this);
        ft.replace(R.id.content_container, fragmentHome).commit();
    }

    private void initNavigationDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        mSlideNaviView.setItemIconTintList(null);
        mSlideNaviView.getMenu().getItem(3).setActionView(R.layout.nav_drawer_overlap);
        mSlideNaviView.getMenu().getItem(9).setActionView(R.layout.nav_drawer_overlap);
        mSlideNaviView.getMenu().getItem(16).setActionView(R.layout.nav_drawer_overlap);
        mSlideNaviView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.trangchu:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn");
                break;
            case R.id.datsimtheoyeucau:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/dat-sim-theo-yeu-cau.html");
                break;
            case R.id.huongdanmuasim:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/thong-tin/huong-dan-mua-sim.html");
                break;
            case R.id.cacdichvucungcap:
                if (mSlideNaviView.getMenu().getItem(4).isVisible()) {
                    mSlideNaviView.getMenu().getItem(3).setActionView(R.layout.nav_drawer_overlap);
                    mSlideNaviView.getMenu().getItem(4).setVisible(false);
                    mSlideNaviView.getMenu().getItem(5).setVisible(false);
                    mSlideNaviView.getMenu().getItem(6).setVisible(false);
                    mSlideNaviView.getMenu().getItem(7).setVisible(false);
                    mSlideNaviView.getMenu().getItem(8).setVisible(false);
                } else {
                    mSlideNaviView.getMenu().getItem(3).setActionView(R.layout.nav_drawer_collap);
                    mSlideNaviView.getMenu().getItem(4).setVisible(true);
                    mSlideNaviView.getMenu().getItem(5).setVisible(true);
                    mSlideNaviView.getMenu().getItem(6).setVisible(true);
                    mSlideNaviView.getMenu().getItem(7).setVisible(true);
                    mSlideNaviView.getMenu().getItem(8).setVisible(true);
                }
                return false;
            case R.id.cacnhamang:
                if (mSlideNaviView.getMenu().getItem(10).isVisible()) {
                    mSlideNaviView.getMenu().getItem(9).setActionView(R.layout.nav_drawer_overlap);
                    mSlideNaviView.getMenu().getItem(10).setVisible(false);
                    mSlideNaviView.getMenu().getItem(11).setVisible(false);
                    mSlideNaviView.getMenu().getItem(12).setVisible(false);
                    mSlideNaviView.getMenu().getItem(13).setVisible(false);
                    mSlideNaviView.getMenu().getItem(14).setVisible(false);
                    mSlideNaviView.getMenu().getItem(15).setVisible(false);
                } else {
                    mSlideNaviView.getMenu().getItem(9).setActionView(R.layout.nav_drawer_collap);
                    mSlideNaviView.getMenu().getItem(10).setVisible(true);
                    mSlideNaviView.getMenu().getItem(11).setVisible(true);
                    mSlideNaviView.getMenu().getItem(12).setVisible(true);
                    mSlideNaviView.getMenu().getItem(13).setVisible(true);
                    mSlideNaviView.getMenu().getItem(14).setVisible(true);
                    mSlideNaviView.getMenu().getItem(15).setVisible(true);
                }
                return false;
            case R.id.cacloaisim:
                if (mSlideNaviView.getMenu().getItem(17).isVisible()) {
                    mSlideNaviView.getMenu().getItem(16).setActionView(R.layout.nav_drawer_overlap);
                    for (int i = 17; i < 40; i++) {
                        mSlideNaviView.getMenu().getItem(i).setVisible(false);
                    }
                } else {
                    mSlideNaviView.getMenu().getItem(16).setActionView(R.layout.nav_drawer_collap);
                    for (int i = 17; i < 40; i++) {
                        mSlideNaviView.getMenu().getItem(i).setVisible(true);
                    }
                }
                return false;
            case R.id.tintuc:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/tin-tuc.html");
                break;
            case R.id.lienhe:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/lien-he.html");
                break;
            case R.id.simlucquy:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-luc-quy");
                break;
            case R.id.simtuquy:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-tu-quy");
                break;
            case R.id.simtamhoa:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-tam-hoa");
                break;
            case R.id.simtamhoakep:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-tam-hoa-kep");
                break;
            case R.id.simtamhoagiua:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-tam-hoa-giua");
                break;
            case R.id.simtaxiab:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-taxi");
                break;
            case R.id.simtaxiabcd:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-taxi-4");
                break;
            case R.id.simlocphat:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-loc-phat");
                break;
            case R.id.simlap:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-lap");
                break;
            case R.id.simganh:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-ganh");
                break;
            case R.id.simtiendon:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-tien-don");
                break;
            case R.id.simtiendoi:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-tien-doi");
                break;
            case R.id.simkep2:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-kep-2");
                break;
            case R.id.simkep3:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-kep-3");
                break;
            case R.id.simsodao2:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-so-dao-2");
                break;
            case R.id.simsodao3:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-so-dao-3");
                break;
            case R.id.simthantai:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-than-tai");
                break;
            case R.id.simongdia:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-ong-dia");
                break;
            case R.id.simdausoco:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-dau-so-co");
                break;
            case R.id.simsodep:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-so-dep");
                break;
            case R.id.simdacbiet:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-dac-biet");
                break;
            case R.id.simgiare:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-gia-re");
                break;

            case R.id.simviettel:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-viettel");
                break;
            case R.id.simvinaphone:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-vinaphone");
                break;
            case R.id.simmobifone:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-mobifone");
                break;
            case R.id.simvietnamobile:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-vietnamobile");
                break;
            case R.id.simgmobile:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-gmobile");
                break;
            case R.id.simcodinh:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-co-dinh");
                break;

            case R.id.simtragop:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/bai-viet/mua-sim-tra-gop-ami.html");
                break;
            case R.id.thuesimvip:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/bai-viet/thue-sim-vip.html");
                break;
            case R.id.camsimdep:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/bai-viet/cam-sim-dep.html");
                break;
            case R.id.simnamsinh:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-nam-sinh.html");
                break;
            case R.id.tracuusimphongthuy:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-phong-thuy.html");
                break;
            default:
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_action:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
                return;
        }
    }

    @Override
    public void onChangeContactClicked() {
        Intent intent = new Intent(this, ChangeNumberActivity.class);
        startActivity(intent);
    }
}
