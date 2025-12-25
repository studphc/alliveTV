package p000;

import com.google.android.gms.internal.common.zzaa;
import com.google.android.gms.internal.common.zzr;
import com.google.android.gms.internal.common.zzv;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class df3 implements Iterator {

    /* renamed from: a */
    public String f16357a;

    /* renamed from: c */
    public final CharSequence f16359c;

    /* renamed from: d */
    public final boolean f16360d;

    /* renamed from: f */
    public int f16362f;

    /* renamed from: g */
    public final /* synthetic */ zzr f16363g;

    /* renamed from: b */
    public int f16358b = 2;

    /* renamed from: e */
    public int f16361e = 0;

    public df3(zzaa zzaaVar, CharSequence charSequence, zzr zzrVar) {
        this.f16363g = zzrVar;
        ve3 ve3Var = zzaaVar.f13739a;
        this.f16360d = zzaaVar.f13740b;
        this.f16362f = Integer.MAX_VALUE;
        this.f16359c = charSequence;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        CharSequence charSequence;
        int i2;
        int i3 = this.f16358b;
        if (i3 != 4) {
            int i4 = i3 - 1;
            String str = null;
            if (i3 != 0) {
                if (i4 == 0) {
                    return true;
                }
                if (i4 != 2) {
                    this.f16358b = 4;
                    int i5 = this.f16361e;
                    while (true) {
                        i = this.f16361e;
                        if (i != -1) {
                            charSequence = this.f16359c;
                            int length = charSequence.length();
                            zzv.zzb(i, length, FirebaseAnalytics.Param.INDEX);
                            while (true) {
                                if (i < length) {
                                    if (this.f16363g.zza(charSequence.charAt(i))) {
                                        break;
                                    }
                                    i++;
                                } else {
                                    i = -1;
                                    break;
                                }
                            }
                            if (i == -1) {
                                i = charSequence.length();
                                this.f16361e = -1;
                                i2 = -1;
                            } else {
                                i2 = i + 1;
                                this.f16361e = i2;
                            }
                            if (i2 == i5) {
                                int i6 = i2 + 1;
                                this.f16361e = i6;
                                if (i6 > charSequence.length()) {
                                    this.f16361e = -1;
                                }
                            } else {
                                if (i5 < i) {
                                    charSequence.charAt(i5);
                                }
                                if (i5 < i) {
                                    charSequence.charAt(i - 1);
                                }
                                if (!this.f16360d || i5 != i) {
                                    break;
                                }
                                i5 = this.f16361e;
                            }
                        } else {
                            this.f16358b = 3;
                            break;
                        }
                    }
                    int i7 = this.f16362f;
                    if (i7 == 1) {
                        i = charSequence.length();
                        this.f16361e = -1;
                        if (i > i5) {
                            charSequence.charAt(i - 1);
                        }
                    } else {
                        this.f16362f = i7 - 1;
                    }
                    str = charSequence.subSequence(i5, i).toString();
                    this.f16357a = str;
                    if (this.f16358b != 3) {
                        this.f16358b = 1;
                        return true;
                    }
                }
                return false;
            }
            throw null;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            this.f16358b = 2;
            String str = this.f16357a;
            this.f16357a = null;
            return str;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
