package sodepami.com.ami;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
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
                break;
            case R.id.datsimtheoyeucau:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/dat-sim-theo-yeu-cau.html");
                break;
            case R.id.huongdanmuasim:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/thong-tin/huong-dan-mua-sim.html");
                break;
            case R.id.cacdichvucungcap:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/bai-viet/mua-sim-tra-gop-ami.html");
                break;
            case R.id.cacnhamang:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-viettel.html");
                break;
            case R.id.cacloaisim:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/sim-tat-ca/sim-luc-quy");
                break;
            case R.id.tintuc:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/tin-tuc.html");
                break;
            case R.id.lienhe:
                WebActivity.startWebActivity(MainActivity.this, "https://sodepami.vn/lien-he.html");
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
