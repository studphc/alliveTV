package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public class ErrorDialogFragment extends DialogFragment {

    /* renamed from: a */
    public Dialog f12978a;

    /* renamed from: b */
    public DialogInterface.OnCancelListener f12979b;

    /* renamed from: c */
    public AlertDialog f12980c;

    @NonNull
    public static ErrorDialogFragment newInstance(@NonNull Dialog dialog) {
        return newInstance(dialog, null);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NonNull DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f12979b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog dialog = this.f12978a;
        if (dialog == null) {
            setShowsDialog(false);
            if (this.f12980c == null) {
                this.f12980c = new AlertDialog.Builder((Context) Preconditions.checkNotNull(getActivity())).create();
            }
            return this.f12980c;
        }
        return dialog;
    }

    @Override // android.app.DialogFragment
    public void show(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        super.show(fragmentManager, str);
    }

    @NonNull
    public static ErrorDialogFragment newInstance(@NonNull Dialog dialog, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        Dialog dialog2 = (Dialog) Preconditions.checkNotNull(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        errorDialogFragment.f12978a = dialog2;
        if (onCancelListener != null) {
            errorDialogFragment.f12979b = onCancelListener;
        }
        return errorDialogFragment;
    }
}
