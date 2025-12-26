package com.hisona.allive;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

/* loaded from: classes2.dex */
public class LicensesDialogFragment extends DialogFragment {
    public static LicensesDialogFragment newInstance() {
        return new LicensesDialogFragment();
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_licenses, (ViewGroup) null);
        ((WebView) inflate.findViewById(R.id.webview)).loadUrl(getResources().getString(R.string.LICENSE_URL));
        return new AlertDialog.Builder(getActivity(), 2131951952).setTitle(getResources().getString(R.string.opensource)).setView(inflate).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null).create();
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        getDialog().setOnDismissListener(onDismissListener);
    }
}
