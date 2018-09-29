package sodepami.com.ami.custom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import sodepami.com.ami.model.Contact;
import sodepami.com.ami.R;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>{

    private Context mContext;
    private List<Contact> contactList;
    private ItemCheckedListener listener;

    public ContactAdapter(Context context, List<Contact> contactList, ItemCheckedListener listener) {
        mContext = context;
        this.contactList = contactList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_adapter_contact,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Contact contact = contactList.get(i);
        viewHolder.mContact.setText(contact.getName());
        viewHolder.mPhone.setText(contact.getPhone() + "  -->  " + contact.getConvertPhone());
        viewHolder.cbContact.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                contact.setCheck(b);
                if (listener != null) {
                    listener.onChecked(b, contact);
                }
            }
        });
        viewHolder.cbContact.setChecked(contact.isCheck());
    }

    @Override
    public int getItemCount() {
        if (contactList != null) {
            return contactList.size();
        }
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView mContact;
        TextView mPhone;
        CheckBox cbContact;

        public ViewHolder(View itemView) {
            super(itemView);
            mContact = itemView.findViewById(R.id.tvContact);
            mPhone = itemView.findViewById(R.id.tvPhone);
            cbContact = itemView.findViewById(R.id.cbContact);
        }
    }

    public interface ItemCheckedListener {
        public void onChecked(boolean isCheck, Contact contact);
    }
}
