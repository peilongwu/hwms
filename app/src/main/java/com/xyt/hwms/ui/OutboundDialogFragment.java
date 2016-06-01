package com.xyt.hwms.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.xyt.hwms.R;
import com.xyt.hwms.adapter.AffirmItemsAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutboundDialogFragment extends DialogFragment {

    public ListView listview;
    private List<Map> list = new ArrayList<>();
    private AffirmItemsAdapter affirmItemsAdapter;

    public static OutboundDialogFragment newInstance(List<Map> querylist) {
        OutboundDialogFragment fragment = new OutboundDialogFragment();
        fragment.list.addAll(querylist);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        affirmItemsAdapter = new AffirmItemsAdapter(getActivity(), list);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_outbound_query, null);
        listview = (ListView) view.findViewById(R.id.listview);

        listview.setAdapter(affirmItemsAdapter);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                // Add action buttons
                .setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                })
                .setNegativeButton("出库", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((BaseActivity)getActivity()).closeDialog();
                    }
                });
        return builder.create();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case KeyEvent.KEYCODE_F4:
                        ((BaseActivity)getActivity()).closeDialog();
                        break;
                    case KeyEvent.KEYCODE_DEL:
                        break;
                }
                dismiss();
                return false;
            }
        });
        return super.onCreateView(inflater, container, savedInstanceState);
    }

//    @Override
//    public void onDismiss(DialogInterface dialog) {
//        super.onDismiss(dialog);
//        if (getActivity() != null) {
//            ((BaseActivity) getActivity()).closeDialog();
//        }
//    }

//    @Override
//    public void dismiss() {
//        super.dismiss();
//        if (getActivity() != null) {
//            ((BaseActivity) getActivity()).closeDialog();
//        }
//    }
}