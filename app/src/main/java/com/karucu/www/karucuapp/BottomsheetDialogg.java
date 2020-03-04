package com.karucu.www.karucuapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BottomsheetDialogg extends BottomSheetDialogFragment {
    private BottomsheetListener mlistener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v=inflater.inflate(R.layout.bottompopup,container,false);
        LinearLayout home=v.findViewById(R.id.homel);
        LinearLayout call=v.findViewById(R.id.calll);
        LinearLayout text=v.findViewById(R.id.textl);
        LinearLayout close=v.findViewById(R.id.closel);
        LinearLayout update=v.findViewById(R.id.updatel);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            mlistener.Refressh();
            dismiss();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
                dismiss();
            }
        });
         call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneno="tel:0791621803";
                Intent dailintent=new Intent(Intent.ACTION_CALL);
                dailintent.setData(Uri.parse(phoneno));
                try {
                    startActivity(dailintent);

                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getContext(),
                            "phone app failed, please try again later.", Toast.LENGTH_SHORT).show();
                }
                dismiss();

            }
        });
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setData(Uri.parse("smsto:0791621803"));
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address"  , new String("0791621803"));
                smsIntent.putExtra("sms_body"  , "Hi");
                try {
                    startActivity(smsIntent);

                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getContext(),
                            "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
                }
            dismiss();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mlistener.updatee();
                dismiss();

            }
        });
    return v;
    }
    public interface BottomsheetListener{
        void Refressh();
        void updatee();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mlistener = (BottomsheetListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(toString()+"must implement Bottomsheet listener");
        }
    }
}
