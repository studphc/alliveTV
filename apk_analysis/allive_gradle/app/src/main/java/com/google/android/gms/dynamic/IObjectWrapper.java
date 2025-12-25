package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public interface IObjectWrapper extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends com.google.android.gms.internal.common.zzb implements IObjectWrapper {
        public Stub() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.common.zza] */
        @NonNull
        public static IObjectWrapper asInterface(@NonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            if (queryLocalInterface instanceof IObjectWrapper) {
                return (IObjectWrapper) queryLocalInterface;
            }
            return new com.google.android.gms.internal.common.zza(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
        }
    }
}
