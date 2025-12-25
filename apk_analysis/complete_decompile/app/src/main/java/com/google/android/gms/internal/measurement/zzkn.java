package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkn;
import com.google.android.gms.internal.measurement.zzko;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import p000.td3;
import p000.vd3;
import p000.ye0;

/* loaded from: classes.dex */
public abstract class zzkn<MessageType extends zzko<MessageType, BuilderType>, BuilderType extends zzkn<MessageType, BuilderType>> implements zzng {
    /* renamed from: a */
    public static void m3460a(int i, List list) {
        String m8292l = ye0.m8292l(list.size() - i, "Element at index ", " is null.");
        int size = list.size();
        while (true) {
            size--;
            if (size >= i) {
                list.remove(size);
            } else {
                throw new NullPointerException(m8292l);
            }
        }
    }

    public static void zzaW(Iterable iterable, List list) {
        Charset charset = zzmk.f13887a;
        iterable.getClass();
        if (iterable instanceof zzmt) {
            List zza = ((zzmt) iterable).zza();
            zzmt zzmtVar = (zzmt) list;
            int size = list.size();
            for (Object obj : zza) {
                if (obj == null) {
                    String m8292l = ye0.m8292l(zzmtVar.size() - size, "Element at index ", " is null.");
                    int size2 = zzmtVar.size();
                    while (true) {
                        size2--;
                        if (size2 < size) {
                            break;
                        } else {
                            zzmtVar.remove(size2);
                        }
                    }
                    throw new NullPointerException(m8292l);
                }
                if (obj instanceof zzld) {
                    zzmtVar.zzb();
                } else if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    zzld.zzj(bArr, 0, bArr.length);
                    zzmtVar.zzb();
                } else {
                    zzmtVar.add((String) obj);
                }
            }
            return;
        }
        if (!(iterable instanceof td3)) {
            if (iterable instanceof Collection) {
                int size3 = ((Collection) iterable).size();
                if (list instanceof ArrayList) {
                    ((ArrayList) list).ensureCapacity(list.size() + size3);
                } else if (list instanceof vd3) {
                    vd3 vd3Var = (vd3) list;
                    int i = ((vd3) list).f27748c + size3;
                    int length = vd3Var.f27747b.length;
                    if (i > length) {
                        if (length != 0) {
                            while (length < i) {
                                length = Math.max(((length * 3) / 2) + 1, 10);
                            }
                            vd3Var.f27747b = Arrays.copyOf(vd3Var.f27747b, length);
                        } else {
                            vd3Var.f27747b = new Object[Math.max(i, 10)];
                        }
                    }
                }
            }
            int size4 = list.size();
            if ((iterable instanceof List) && (iterable instanceof RandomAccess)) {
                List list2 = (List) iterable;
                int size5 = list2.size();
                for (int i2 = 0; i2 < size5; i2++) {
                    Object obj2 = list2.get(i2);
                    if (obj2 != null) {
                        list.add(obj2);
                    } else {
                        m3460a(size4, list);
                        throw null;
                    }
                }
                return;
            }
            for (Object obj3 : iterable) {
                if (obj3 != null) {
                    list.add(obj3);
                } else {
                    m3460a(size4, list);
                    throw null;
                }
            }
            return;
        }
        list.addAll((Collection) iterable);
    }

    @Override // 
    public abstract zzkn zzaR();

    public zzkn zzaS(byte[] bArr, int i, int i2) {
        throw null;
    }

    public zzkn zzaT(byte[] bArr, int i, int i2, zzlp zzlpVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzng
    public final /* synthetic */ zzng zzaU(byte[] bArr) {
        return zzaS(bArr, 0, bArr.length);
    }

    @Override // com.google.android.gms.internal.measurement.zzng
    public final /* synthetic */ zzng zzaV(byte[] bArr, zzlp zzlpVar) {
        return zzaT(bArr, 0, bArr.length, zzlpVar);
    }
}
