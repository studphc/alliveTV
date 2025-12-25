package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzb;

/* loaded from: classes.dex */
public interface ICancelToken extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends zzb implements ICancelToken {
        public Stub() {
            super("com.google.android.gms.common.internal.ICancelToken");
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.common.internal.ICancelToken, com.google.android.gms.internal.common.zza] */
        @NonNull
        public static ICancelToken asInterface(@NonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
            if (queryLocalInterface instanceof ICancelToken) {
                return (ICancelToken) queryLocalInterface;
            }
            return new zza(iBinder, "com.google.android.gms.common.internal.ICancelToken");
        }

        @Override // com.google.android.gms.internal.common.zzb
        public final boolean zza(int i, @NonNull Parcel parcel, @NonNull Parcel parcel2, int i2) {
            if (i == 2) {
                cancel();
                return true;
            }
            return false;
        }
    }

    void cancel();
}
