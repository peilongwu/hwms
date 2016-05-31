package com.xyt.hwms.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.xyt.hwms.R;

public class ReasonDialogFragment extends DialogFragment {

    int iii = 0;
    private String a[];

    public static ReasonDialogFragment newInstance() {
        ReasonDialogFragment fragment = new ReasonDialogFragment();
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        a = getResources().getStringArray(R.array.reason);
        iii = 0;

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("退回原因").setSingleChoiceItems(a, iii, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        return builder.create();
    }

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        this.getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
//            @Override
//            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
//                switch (keyCode) {
//                    case KeyEvent.KEYCODE_F4:
//                        ((Map) ((List) ((Map) Constants.AFFIRM_LIST.get(applyIndex)).get("detail")).get(wasteIndex)).put("back_reason", a[iii]);
//                        ((Map) ((List) ((Map) Constants.AFFIRM_LIST.get(applyIndex)).get("detail")).get(wasteIndex)).put("back_reason_index", iii);
//                        PreferencesUtils.putString(getActivity(), "affirm", new Gson().toJson(Constants.AFFIRM_LIST));
//                        dialog.dismiss();
//                        break;
//                }
//                dismiss();
//                return false;
//            }
//        });
//        return super.onCreateView(inflater, container, savedInstanceState);
//    }

//    @Override
//    public void onDismiss(DialogInterface dialog) {
//        super.onDismiss(dialog);
//        ((AffirmItemsActivity) getActivity()).reasonDialog = null;
//    }

//    @Override
//    public void dismiss() {
//        super.dismiss();
//        if (getActivity() != null) {
//            ((AffirmItemsActivity) getActivity()).updateView();
//            ((AffirmItemsActivity) getActivity()).dialog = null;
//        }
//    }
}
