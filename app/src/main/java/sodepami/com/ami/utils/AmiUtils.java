package sodepami.com.ami.utils;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sodepami.com.ami.custom.ContactComparator;
import sodepami.com.ami.model.Contact;

import static android.content.Context.MODE_PRIVATE;

public class AmiUtils {

    public static final String KEY_CHANGED_NUMBER = "KEY_CHANGED_NUMBER";

    public static String convert11to10(String phoneInput) {
        String editedPhone = "";
        if (TextUtils.isEmpty(phoneInput)) {
            return "";
        } else if (phoneInput.length() < 10) {
            return phoneInput;
        } else {
            String digit4 = phoneInput.substring(0, 4);
            String digit5 = phoneInput.substring(0, 5);
            String digit6 = phoneInput.substring(0, 6);
            String digit7 = phoneInput.substring(0, 7);
            StringBuilder sb = new StringBuilder(phoneInput);
            switch (digit4) {
                case "0169":
                    sb.delete(0, 4);
                    editedPhone = "039" + sb.toString();
                    return editedPhone;
                case "0168":
                    sb.delete(0, 4);
                    editedPhone = "038" + sb.toString();
                    return editedPhone;
                case "0167":
                    sb.delete(0, 4);
                    editedPhone = "037" + sb.toString();
                    return editedPhone;
                case "0166":
                    sb.delete(0, 4);
                    editedPhone = "036" + sb.toString();
                    return editedPhone;
                case "0165":
                    sb.delete(0, 4);
                    editedPhone = "035" + sb.toString();
                    return editedPhone;
                case "0164":
                    sb.delete(0, 4);
                    editedPhone = "034" + sb.toString();
                    return editedPhone;
                case "0163":
                    sb.delete(0, 4);
                    editedPhone = "033" + sb.toString();
                    return editedPhone;
                case "0162":
                    sb.delete(0, 4);
                    editedPhone = "032" + sb.toString();
                    return editedPhone;
                case "0120":
                    sb.delete(0, 4);
                    editedPhone = "070" + sb.toString();
                    return editedPhone;
                case "0121":
                    sb.delete(0, 4);
                    editedPhone = "079" + sb.toString();
                    return editedPhone;
                case "0122":
                    sb.delete(0, 4);
                    editedPhone = "077" + sb.toString();
                    return editedPhone;
                case "0126":
                    sb.delete(0, 4);
                    editedPhone = "076" + sb.toString();
                    return editedPhone;
                case "0128":
                    sb.delete(0, 4);
                    editedPhone = "078" + sb.toString();
                    return editedPhone;
                case "0123":
                    sb.delete(0, 4);
                    editedPhone = "083" + sb.toString();
                    return editedPhone;
                case "0124":
                    sb.delete(0, 4);
                    editedPhone = "084" + sb.toString();
                    return editedPhone;
                case "0125":
                    sb.delete(0, 4);
                    editedPhone = "085" + sb.toString();
                    return editedPhone;
                case "0127":
                    sb.delete(0, 4);
                    editedPhone = "081" + sb.toString();
                    return editedPhone;
                case "0129":
                    sb.delete(0, 4);
                    editedPhone = "082" + sb.toString();
                    return editedPhone;
                case "0186":
                    sb.delete(0, 4);
                    editedPhone = "056" + sb.toString();
                    return editedPhone;
                case "0188":
                    sb.delete(0, 4);
                    editedPhone = "058" + sb.toString();
                    return editedPhone;
            }

            switch (digit5) {
                case "84169":
                    sb.delete(0, 5);
                    editedPhone = "8439" + sb.toString();
                    return editedPhone;
                case "84168":
                    sb.delete(0, 5);
                    editedPhone = "8438" + sb.toString();
                    return editedPhone;
                case "84167":
                    sb.delete(0, 5);
                    editedPhone = "8437" + sb.toString();
                    return editedPhone;
                case "84166":
                    sb.delete(0, 5);
                    editedPhone = "8436" + sb.toString();
                    return editedPhone;
                case "84165":
                    sb.delete(0, 5);
                    editedPhone = "8435" + sb.toString();
                    return editedPhone;
                case "84164":
                    sb.delete(0, 5);
                    editedPhone = "8434" + sb.toString();
                    return editedPhone;
                case "84163":
                    sb.delete(0, 5);
                    editedPhone = "8433" + sb.toString();
                    return editedPhone;
                case "84162":
                    sb.delete(0, 5);
                    editedPhone = "8432" + sb.toString();
                    return editedPhone;
                case "84120":
                    sb.delete(0, 5);
                    editedPhone = "8470" + sb.toString();
                    return editedPhone;
                case "84121":
                    sb.delete(0, 5);
                    editedPhone = "8479" + sb.toString();
                    return editedPhone;
                case "84122":
                    sb.delete(0, 5);
                    editedPhone = "8477" + sb.toString();
                    return editedPhone;
                case "84126":
                    sb.delete(0, 5);
                    editedPhone = "8476" + sb.toString();
                    return editedPhone;
                case "84128":
                    sb.delete(0, 5);
                    editedPhone = "8478" + sb.toString();
                    return editedPhone;
                case "84123":
                    sb.delete(0, 5);
                    editedPhone = "8483" + sb.toString();
                    return editedPhone;
                case "84124":
                    sb.delete(0, 5);
                    editedPhone = "8484" + sb.toString();
                    return editedPhone;
                case "84125":
                    sb.delete(0, 5);
                    editedPhone = "8485" + sb.toString();
                    return editedPhone;
                case "84127":
                    sb.delete(0, 5);
                    editedPhone = "8481" + sb.toString();
                    return editedPhone;
                case "84129":
                    sb.delete(0, 5);
                    editedPhone = "8482" + sb.toString();
                    return editedPhone;
                case "84186":
                    sb.delete(0, 5);
                    editedPhone = "8456" + sb.toString();
                    return editedPhone;
                case "84188":
                    sb.delete(0, 5);
                    editedPhone = "8458" + sb.toString();
                    return editedPhone;
                case "01992":
                    sb.delete(0, 5);
                    editedPhone = "059" + sb.toString();
                    return editedPhone;
                case "01993":
                    sb.delete(0, 5);
                    editedPhone = "059" + sb.toString();
                    return editedPhone;
                case "01998":
                    sb.delete(0, 5);
                    editedPhone = "059" + sb.toString();
                    return editedPhone;
                case "01999":
                    sb.delete(0, 5);
                    editedPhone = "059" + sb.toString();
                    return editedPhone;
            }

            switch (digit6) {
                case "+84169":
                    sb.delete(0, 6);
                    editedPhone = "+8439" + sb.toString();
                    return editedPhone;
                case "+84168":
                    sb.delete(0, 6);
                    editedPhone = "+8438" + sb.toString();
                    return editedPhone;
                case "+84167":
                    sb.delete(0, 6);
                    editedPhone = "+8437" + sb.toString();
                    return editedPhone;
                case "+84166":
                    sb.delete(0, 6);
                    editedPhone = "+8436" + sb.toString();
                    return editedPhone;
                case "+84165":
                    sb.delete(0, 6);
                    editedPhone = "+8435" + sb.toString();
                    return editedPhone;
                case "+84164":
                    sb.delete(0, 6);
                    editedPhone = "+8434" + sb.toString();
                    return editedPhone;
                case "+84163":
                    sb.delete(0, 6);
                    editedPhone = "+8433" + sb.toString();
                    return editedPhone;
                case "+84162":
                    sb.delete(0, 6);
                    editedPhone = "+8432" + sb.toString();
                    return editedPhone;
                case "+84120":
                    sb.delete(0, 6);
                    editedPhone = "+8470" + sb.toString();
                    return editedPhone;
                case "+84121":
                    sb.delete(0, 6);
                    editedPhone = "+8479" + sb.toString();
                    return editedPhone;
                case "+84122":
                    sb.delete(0, 6);
                    editedPhone = "+8477" + sb.toString();
                    return editedPhone;
                case "+84126":
                    sb.delete(0, 6);
                    editedPhone = "+8476" + sb.toString();
                    return editedPhone;
                case "+84128":
                    sb.delete(0, 6);
                    editedPhone = "+8478" + sb.toString();
                    return editedPhone;
                case "+84123":
                    sb.delete(0, 6);
                    editedPhone = "+8483" + sb.toString();
                    return editedPhone;
                case "+84124":
                    sb.delete(0, 6);
                    editedPhone = "+8484" + sb.toString();
                    return editedPhone;
                case "+84125":
                    sb.delete(0, 6);
                    editedPhone = "+8485" + sb.toString();
                    return editedPhone;
                case "+84127":
                    sb.delete(0, 6);
                    editedPhone = "+8481" + sb.toString();
                    return editedPhone;
                case "+84129":
                    sb.delete(0, 6);
                    editedPhone = "+8482" + sb.toString();
                    return editedPhone;
                case "+84186":
                    sb.delete(0, 6);
                    editedPhone = "+8456" + sb.toString();
                    return editedPhone;
                case "+84188":
                    sb.delete(0, 6);
                    editedPhone = "+8458" + sb.toString();
                    return editedPhone;
                case "841992":
                    sb.delete(0, 6);
                    editedPhone = "8459" + sb.toString();
                    return editedPhone;
                case "841993":
                    sb.delete(0, 6);
                    editedPhone = "8459" + sb.toString();
                    return editedPhone;
                case "841998":
                    sb.delete(0, 6);
                    editedPhone = "8459" + sb.toString();
                    return editedPhone;
                case "841999":
                    sb.delete(0, 6);
                    editedPhone = "8459" + sb.toString();
                    return editedPhone;
            }

            switch (digit7) {
                case "+841992":
                    sb.delete(0, 7);
                    editedPhone = "+8459" + sb.toString();
                    return editedPhone;
                case "+841993":
                    sb.delete(0, 7);
                    editedPhone = "+8459" + sb.toString();
                    return editedPhone;
                case "+841998":
                    sb.delete(0, 7);
                    editedPhone = "+8459" + sb.toString();
                    return editedPhone;
                case "+841999":
                    sb.delete(0, 7);
                    editedPhone = "+8459" + sb.toString();
                    return editedPhone;
            }

        }

        return phoneInput;
    }

    public static String restorePhone(String phoneInput) {
        if (TextUtils.isEmpty(phoneInput)) {
            return "";
        }
        String editedPhone = "";
        return editedPhone;
    }

    public static List<Contact> getTotal11number(Context context) {
        List<Contact> contacts = new ArrayList<>();
        ContentResolver cr = context.getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);

        if ((cur != null ? cur.getCount() : 0) > 0) {
            while (cur != null && cur.moveToNext()) {
                String id = cur.getString(
                        cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(
                        ContactsContract.Contacts.DISPLAY_NAME));

                if (cur.getInt(cur.getColumnIndex(
                        ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {

                        Cursor pCur = cr.query(
                                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                null,
                                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                                new String[]{id}, null);
                        while (pCur.moveToNext()) {
                            String phoneNo = pCur.getString(pCur.getColumnIndex(
                                    ContactsContract.CommonDataKinds.Phone.NUMBER));
                            String phoneId = pCur.getString(pCur.getColumnIndex(
                                    ContactsContract.CommonDataKinds.Phone._ID));
                            String convertPhone = AmiUtils.convert11to10(phoneNo);
                            if (!TextUtils.isEmpty(phoneNo) && !phoneNo.equalsIgnoreCase(convertPhone)) {
                                String rawIdFromContactId = getRawIdFromContactId(context, id);
                                Contact contact = new Contact();
                                if (contact != null) {
                                    contact.setId(phoneId);
                                    contact.setRawContactId(rawIdFromContactId);
                                    contact.setName(name);
                                    contact.setPhone(phoneNo);
                                    contact.setConvertPhone(convertPhone);
                                    contacts.add(contact);
                                }
                            }
                        }
                        pCur.close();
                }
            }
        }
        if(cur!=null){
            cur.close();
        }
        if (contacts.size() > 0) {
            Collections.sort(contacts, new ContactComparator());
        }
        return contacts;
    }

    public static String getRawIdFromContactId(Context context, String contactId) {
        if (TextUtils.isEmpty(contactId)) {
            return null;
        }
        String mRawContactId = "";
        Cursor mRawContactCursor = context.getContentResolver().query(
                ContactsContract.RawContacts.CONTENT_URI,
                null,
                ContactsContract.Data.CONTACT_ID + " = ?",
                new String[] {contactId},
                null);
        try {
            ArrayList<String> mRawContactIds = new ArrayList<String>();
            while(mRawContactCursor.moveToNext()) {
                String rawId = mRawContactCursor.getString(mRawContactCursor.getColumnIndex(ContactsContract.RawContacts._ID));
                Log.d("RawContact", "ID: " + rawId);
                mRawContactIds.add(rawId);
            }

            for(String rawId : mRawContactIds) {
                // Make sure the "last checked" RawContactId is set locally for use in insert & update.
                mRawContactId = rawId;
                Cursor mDataCursor = context.getContentResolver().query(
                        ContactsContract.Data.CONTENT_URI,
                        null,
                        ContactsContract.Data.RAW_CONTACT_ID + " = ? ",
                        new String[] { mRawContactId},
                        null);

                if(mDataCursor.getCount() > 0) {
                    mDataCursor.close();
                    break;
                } else {
                    mDataCursor.close();
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            mRawContactCursor.close();
        }
        return mRawContactId;
    }

    // convert 11 to 10
    public static void updateNumberto10(Context context, List<Contact> contacts) {
        if (contacts == null || contacts.size() == 0) {
            return;
        }
        try {
            ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();
            for (int i = 0; i < contacts.size(); i++) {
                Contact contact = contacts.get(i);

                ops.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI)
                        .withSelection(ContactsContract.RawContacts.Data.RAW_CONTACT_ID + " = ?", new String[] {contact.getRawContactId()})
                        .withSelection(ContactsContract.CommonDataKinds.Phone._ID + " = ?", new String[]{contact.getId()})
                        .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, contact.getConvertPhone())
                        .build());
            }
            context.getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // restore 10 to 11
    public static void restoreNumberto11(Context context, List<Contact> contacts) {
        if (contacts == null || contacts.size() == 0) {
            return;
        }
        try {
            ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();
            for (int i = 0; i < contacts.size(); i++) {
                Contact contact = contacts.get(i);

                ops.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI)
                        .withSelection(ContactsContract.RawContacts.Data.RAW_CONTACT_ID + " = ?", new String[] {contact.getRawContactId()})
                        .withSelection(ContactsContract.CommonDataKinds.Phone._ID + " = ?", new String[]{contact.getId()})
                        .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, contact.getPhone())
                        .build());

            }
            context.getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // save changed contact to pref
    public static void saveChangedContactList(Context context, List<Contact> contacts) {
        if (contacts == null) {
            return;
        }
        SharedPreferences.Editor editor = context.getSharedPreferences("AmiPref" , MODE_PRIVATE).edit();
        String contactString = new Gson().toJson(contacts);
        editor.putString(KEY_CHANGED_NUMBER, contactString);
        editor.commit();
    }

    // get changed contact to pref
    public static List<Contact> getChangedContactList(Context context) {
        SharedPreferences pref = context.getSharedPreferences("AmiPref" , MODE_PRIVATE);
        String contactString = pref.getString(KEY_CHANGED_NUMBER, "");
        Type type = new TypeToken< List < Contact >>() {}.getType();
        List < Contact > contacts = new Gson().fromJson(contactString, type);
        return contacts;
    }
}
