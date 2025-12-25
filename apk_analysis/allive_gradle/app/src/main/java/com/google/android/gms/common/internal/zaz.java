package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import p000.ye0;

/* loaded from: classes.dex */
public final class zaz extends RemoteCreator {

    /* renamed from: c */
    public static final zaz f13512c = new RemoteCreator("com.google.android.gms.common.ui.SignInButtonCreatorImpl");

    public static View zaa(Context context, int i, int i2) {
        zaz zazVar = f13512c;
        try {
            zax zaxVar = new zax(1, i, i2, null);
            return (View) ObjectWrapper.unwrap(((zam) zazVar.getRemoteCreatorInstance(context)).zae(ObjectWrapper.wrap(context), zaxVar));
        } catch (Exception e) {
            throw new RemoteCreator.RemoteCreatorException(ye0.m8293m(i, "Could not get button with size ", " and color ", i2), e);
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        if (queryLocalInterface instanceof zam) {
            return (zam) queryLocalInterface;
        }
        return new com.google.android.gms.internal.base.zaa(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }
}
