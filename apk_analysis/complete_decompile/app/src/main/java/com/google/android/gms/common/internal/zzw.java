package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.internal.common.zza;

/* loaded from: classes.dex */
public final class zzw extends zza implements IAccountAccessor {
    @Override // com.google.android.gms.common.internal.IAccountAccessor
    public final Account zzb() {
        Parcel zzB = zzB(2, zza());
        Account account = (Account) com.google.android.gms.internal.common.zzc.zza(zzB, Account.CREATOR);
        zzB.recycle();
        return account;
    }
}
