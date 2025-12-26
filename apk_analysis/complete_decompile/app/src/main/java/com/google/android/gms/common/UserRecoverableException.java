package com.google.android.gms.common;

import android.content.Intent;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class UserRecoverableException extends Exception {

    /* renamed from: a */
    public final Intent f13009a;

    public UserRecoverableException(@NonNull String str, @NonNull Intent intent) {
        super(str);
        this.f13009a = intent;
    }

    @NonNull
    public Intent getIntent() {
        return new Intent(this.f13009a);
    }
}
