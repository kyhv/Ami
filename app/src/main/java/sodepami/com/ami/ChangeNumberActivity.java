package sodepami.com.ami;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sodepami.com.ami.custom.AmiLoading;
import sodepami.com.ami.custom.ContactAdapter;
import sodepami.com.ami.custom.ContactComparator;
import sodepami.com.ami.custom.DividerItemDecoration;
import sodepami.com.ami.model.Contact;
import sodepami.com.ami.utils.AmiUtils;
import sodepami.com.ami.utils.DialogHelper;

public class ChangeNumberActivity extends AppCompatActivity implements ContactAdapter.ItemCheckedListener {

    private static final int PERMISSION_REQUEST_CONTACT = 1000;

    private List<Contact> contactList = new ArrayList();
    private List<Contact> checkedContactList = new ArrayList<>();
    private ContactAdapter adapter;

    @BindView(R.id.rc_contact)
    RecyclerView rcContact;

    @BindView(R.id.rr_restore)
    RelativeLayout rrRestore;

    @BindView(R.id.rr_search)
    RelativeLayout rrSearch;

    @BindView(R.id.bt_search)
    ImageButton ibSearch;

    @BindView(R.id.btConvert)
    Button btConvert;

    @BindView(R.id.restore_tv2)
    TextView tvRestore;

    @BindView(R.id.bt_restore)
    ImageButton btRestore;

    @BindView(R.id.img_action)
    ImageView imBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
        setContentView(R.layout.activity_change_number);

        ButterKnife.bind(this);

        initView();
        initRestoreLayout();
        initClickedListener();
        askForContactPermission();
    }

    private void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.BLUE);
        }
    }

    private void initClickedListener() {
        imBack.setImageResource(R.drawable.ic_back);
        imBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeNumberActivity.this.finish();
            }
        });

        ibSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(
                            ChangeNumberActivity.this,Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(ChangeNumberActivity.this,
                                "Bạn chưa cấp quyền đọc danh bạ. Vui lòng cấp quyền đọc danh bạ để thực hiện tiếp tính năng này.", Toast.LENGTH_SHORT)
                                .show();

                        ActivityCompat.requestPermissions(ChangeNumberActivity.this,
                                new String[]{Manifest.permission.READ_CONTACTS},
                                PERMISSION_REQUEST_CONTACT);
                        return;
                    }
                }
                loading11Number();
            }
        });

        btConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkedContactList.size() > 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ChangeNumberActivity.this);
                    builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int position) {
                            List<Contact> saveContact = AmiUtils.getChangedContactList(ChangeNumberActivity.this);
                            if (saveContact == null) {
                                saveContact = new ArrayList<>();
                            }
                            for (int i = 0; i < checkedContactList.size(); i++) {
                                Contact contact = checkedContactList.get(i);
                                if (!saveContact.contains(contact)) {
                                    saveContact.add(contact);
                                }
                            }
                            /*List<Contact> demo = new ArrayList<>();
                            demo.add(checkedContactList.get(0));*/
                            AmiUtils.updateNumberto10(ChangeNumberActivity.this, checkedContactList);
                            AmiUtils.saveChangedContactList(ChangeNumberActivity.this, saveContact);
                            AmiUtils.saveChangedContactList(ChangeNumberActivity.this, saveContact);
                            DialogHelper.alertDialog(ChangeNumberActivity.this, "Chuyền đầu số thành công!", "OK", new DialogHelper.DialogButtonListener() {
                                @Override
                                public void onOKClicked() {
                                    ChangeNumberActivity.this.finish();
                                }
                            });
                        }
                    });
                    builder.setNegativeButton("Không", null);
                    builder.setMessage("Bạn có muốn chuyển các số điện thoại 11 số đã chọn sang 10 số không?");
                    builder.show();
                }
            }
        });
    }

    private void initView() {
        adapter = new ContactAdapter(ChangeNumberActivity.this, contactList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(ChangeNumberActivity.this, LinearLayoutManager.VERTICAL, false);
        rcContact.setHasFixedSize(true);
        rcContact.addItemDecoration(new DividerItemDecoration(ChangeNumberActivity.this));
        rcContact.setLayoutManager(layoutManager);
        rcContact.setAdapter(adapter);

    }

    private void initRestoreLayout() {
        List<Contact> saveContact = AmiUtils.getChangedContactList(ChangeNumberActivity.this);
        if (saveContact != null && saveContact.size() > 0) {
            rrRestore.setVisibility(View.VISIBLE);
            String restoreNumber = "Bạn đã chuyển " + saveContact.size() +
                    " sđt qua đầu số mới (10 số). Bạn có thể phục hồi lại đầu số cũ (11 số) nếu muốn.";
            tvRestore.setText(restoreNumber);
        } else {
            rrRestore.setVisibility(View.GONE);
        }
        btRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChangeNumberActivity.this);
                builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position) {
                        List<Contact> saveContact = AmiUtils.getChangedContactList(ChangeNumberActivity.this);
                        if (saveContact != null && saveContact.size() > 0) {
                            AmiUtils.restoreNumberto11(ChangeNumberActivity.this, saveContact);
                            saveContact.clear();
                        }
                        AmiUtils.saveChangedContactList(ChangeNumberActivity.this, saveContact);
                        DialogHelper.alertDialog(ChangeNumberActivity.this, "Phục hồi thành công!", "OK", new DialogHelper.DialogButtonListener() {
                            @Override
                            public void onOKClicked() {
                                ChangeNumberActivity.this.finish();
                            }
                        });
                    }
                });
                builder.setNegativeButton("Không", null);
                builder.setMessage("Bạn có chắc là muốn phục hồi về đầu số cũ (11 số) không?");
                builder.show();
            }
        });
    }

    private void loading11Number() {
        @SuppressLint("StaticFieldLeak")
        AsyncTask<Void, Void, List<Contact>> asyncTask = new AsyncTask<Void, Void, List<Contact>>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                AmiLoading.showLoadingDialog(ChangeNumberActivity.this);
            }

            @Override
            protected List<Contact> doInBackground(Void... voids) {
                return AmiUtils.getTotal11number(ChangeNumberActivity.this);
            }

            @Override
            protected void onPostExecute(List<Contact> contacts) {
                super.onPostExecute(contacts);

                AmiLoading.hideLoadingDialog();
                contactList.clear();
                contactList.addAll(AmiUtils.getTotal11number(ChangeNumberActivity.this));
                if (contactList != null && contactList.size() > 0) {
                    rrRestore.setVisibility(View.GONE);
                    rrSearch.setVisibility(View.GONE);
                    rcContact.setVisibility(View.VISIBLE);
                    btConvert.setVisibility(View.VISIBLE);
                    Collections.sort(contactList, new ContactComparator());
                    adapter.notifyDataSetChanged();
                    checkedContactList.addAll(contactList);
                    btConvert.setText("(ĐÃ CHỌN " + checkedContactList.size() + ")" + " CHUYỂN QUA 10 SỐ -->");
                } else {
                    rrSearch.setVisibility(View.VISIBLE);
                    rcContact.setVisibility(View.GONE);
                    btConvert.setVisibility(View.GONE);
                    DialogHelper.alertDialog(ChangeNumberActivity.this, "Không tìm thấy điện thoại 11 số trong danh bạ!",
                            "OK", null);
                }
            }
        };
        asyncTask.execute();
    }

    private void askForContactPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(
                    this,Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        PERMISSION_REQUEST_CONTACT);
            }
        }
    }

    @Override
    public void onChecked(boolean isCheck, Contact contact) {
        if (contact != null) {
            if (isCheck) {
                if (!checkedContactList.contains(contact)) {
                    checkedContactList.add(contact);
                }
            } else {
                checkedContactList.remove(contact);
            }

            btConvert.setText("(ĐÃ CHỌN " + checkedContactList.size() + " )" + " CHUYỂN QUA 10 SỐ -->");
        }
    }
}
