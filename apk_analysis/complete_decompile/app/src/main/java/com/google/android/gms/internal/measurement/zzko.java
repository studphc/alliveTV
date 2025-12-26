package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkn;
import com.google.android.gms.internal.measurement.zzko;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import p000.uc3;
import p000.vc3;
import p000.xd3;
import p000.ye0;

/* loaded from: classes.dex */
public abstract class zzko<MessageType extends zzko<MessageType, BuilderType>, BuilderType extends zzkn<MessageType, BuilderType>> implements zznh {
    protected int zza = 0;

    public static void zzcc(Iterable iterable, List list) {
        zzkn.zzaW(iterable, list);
    }

    /* renamed from: a */
    public int mo3461a(xd3 xd3Var) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zznh
    public final zzld zzcb() {
        try {
            int zzcf = zzcf();
            zzld zzldVar = zzld.zzb;
            byte[] bArr = new byte[zzcf];
            Logger logger = zzlk.f13877b;
            vc3 vc3Var = new vc3(bArr, zzcf);
            zzcB(vc3Var);
            vc3Var.zzB();
            return new uc3(bArr);
        } catch (IOException e) {
            throw new RuntimeException(ye0.m8296p("Serializing ", getClass().getName(), " to a ByteString threw an IOException (should never happen)."), e);
        }
    }

    public final byte[] zzcd() {
        try {
            int zzcf = zzcf();
            byte[] bArr = new byte[zzcf];
            Logger logger = zzlk.f13877b;
            vc3 vc3Var = new vc3(bArr, zzcf);
            zzcB(vc3Var);
            vc3Var.zzB();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(ye0.m8296p("Serializing ", getClass().getName(), " to a byte array threw an IOException (should never happen)."), e);
        }
    }
}
