package p000;

import com.google.android.gms.internal.common.zzaa;
import com.google.android.gms.internal.common.zzr;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* renamed from: jw */
/* loaded from: classes.dex */
public final class C1369jw implements Iterable {

    /* renamed from: a */
    public final /* synthetic */ int f20655a;

    /* renamed from: b */
    public final /* synthetic */ Object f20656b;

    /* renamed from: c */
    public final /* synthetic */ Object f20657c;

    public /* synthetic */ C1369jw(int i, Object obj, Object obj2) {
        this.f20655a = i;
        this.f20657c = obj;
        this.f20656b = obj2;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f20655a) {
            case 0:
                return new C1982xg(this);
            case 1:
                Splitter splitter = (Splitter) this.f20657c;
                return splitter.f14490c.mo92a(splitter, (CharSequence) this.f20656b);
            default:
                zzaa zzaaVar = (zzaa) this.f20657c;
                return new df3(zzaaVar, (CharSequence) this.f20656b, (zzr) zzaaVar.f13741c.f216b);
        }
    }

    public String toString() {
        CharSequence obj;
        CharSequence obj2;
        switch (this.f20655a) {
            case 1:
                Joiner m3766on = Joiner.m3766on(", ");
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                StringBuilder appendTo = m3766on.appendTo(sb, (Iterable<? extends Object>) this);
                appendTo.append(']');
                return appendTo.toString();
            case 2:
                StringBuilder sb2 = new StringBuilder();
                sb2.append('[');
                try {
                    df3 df3Var = (df3) iterator();
                    if (df3Var.hasNext()) {
                        Object next = df3Var.next();
                        Objects.requireNonNull(next);
                        if (next instanceof CharSequence) {
                            obj = (CharSequence) next;
                        } else {
                            obj = next.toString();
                        }
                        sb2.append(obj);
                        while (df3Var.hasNext()) {
                            sb2.append((CharSequence) ", ");
                            Object next2 = df3Var.next();
                            Objects.requireNonNull(next2);
                            if (next2 instanceof CharSequence) {
                                obj2 = (CharSequence) next2;
                            } else {
                                obj2 = next2.toString();
                            }
                            sb2.append(obj2);
                        }
                    }
                    sb2.append(']');
                    return sb2.toString();
                } catch (IOException e) {
                    throw new AssertionError(e);
                }
            default:
                return super.toString();
        }
    }
}
