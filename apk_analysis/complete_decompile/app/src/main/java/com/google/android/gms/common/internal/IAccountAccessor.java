package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzb;

/* loaded from: classes.dex */
public interface IAccountAccessor extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends zzb implements IAccountAccessor {
        public Stub() {
            super("com.google.android.gms.common.internal.IAccountAccessor");
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.internal.common.zza, com.google.android.gms.common.internal.IAccountAccessor] */
        @NonNull
        public static IAccountAccessor asInterface(@NonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof IAccountAccessor) {
                return (IAccountAccessor) queryLocalInterface;
            }
            return new zza(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
        }

        @Override // com.google.android.gms.internal.common.zzb
        public final boolean zza(int i, @NonNull Parcel parcel, @NonNull Parcel parcel2, int i2) {
            if (i == 2) {
                Account zzb = zzb();
                parcel2.writeNoException();
                com.google.android.gms.internal.common.zzc.zzd(parcel2, zzb);
                return true;
            }
            return false;
        }
    }

    @NonNull
    Account zzb();
}
