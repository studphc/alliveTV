package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public class StringResourceValueReader {

    /* renamed from: a */
    public final Resources f13470a;

    /* renamed from: b */
    public final String f13471b;

    public StringResourceValueReader(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        Resources resources = context.getResources();
        this.f13470a = resources;
        this.f13471b = resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
    }

    @Nullable
    @KeepForSdk
    public String getString(@NonNull String str) {
        Resources resources = this.f13470a;
        int identifier = resources.getIdentifier(str, TypedValues.Custom.S_STRING, this.f13471b);
        if (identifier == 0) {
            return null;
        }
        return resources.getString(identifier);
    }
}
