package com.google.android.gms.common.internal;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;

/* loaded from: classes.dex */
public final class zzy extends zza implements zzaa {
    @Override // com.google.android.gms.common.internal.zzaa
    public final int zzc() {
        Parcel zzB = zzB(2, zza());
        int readInt = zzB.readInt();
        zzB.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.common.internal.zzaa
    public final IObjectWrapper zzd() {
        Parcel zzB = zzB(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzB.readStrongBinder());
        zzB.recycle();
        return asInterface;
    }
}
