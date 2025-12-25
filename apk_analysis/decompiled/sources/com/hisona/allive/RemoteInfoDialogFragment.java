package com.hisona.allive;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

/* loaded from: classes2.dex */
public class RemoteInfoDialogFragment extends DialogFragment {
    public static RemoteInfoDialogFragment newInstance() {
        return new RemoteInfoDialogFragment();
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new AlertDialog.Builder(getActivity(), 2131951952).setTitle(getResources().getString(R.string.manual_title)).setView((ImageView) LayoutInflater.from(getActivity()).inflate(R.layout.dialog_remoteinfo, (ViewGroup) null)).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null).create();
    }
}
