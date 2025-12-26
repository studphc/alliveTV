package p000;

import com.google.common.collect.Ordering;
import java.util.List;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class pl2 {

    /* renamed from: a */
    public static final kl2 f25216a;

    /* renamed from: b */
    public static final ll2 f25217b;

    /* renamed from: c */
    public static final ml2 f25218c;

    /* renamed from: d */
    public static final nl2 f25219d;

    /* renamed from: e */
    public static final /* synthetic */ pl2[] f25220e;

    static {
        kl2 kl2Var = new kl2();
        f25216a = kl2Var;
        ll2 ll2Var = new ll2();
        f25217b = ll2Var;
        ml2 ml2Var = new ml2();
        f25218c = ml2Var;
        nl2 nl2Var = new nl2();
        f25219d = nl2Var;
        f25220e = new pl2[]{kl2Var, ll2Var, ml2Var, nl2Var, new pl2() { // from class: ol2
            @Override // p000.pl2
            /* renamed from: a */
            public final int mo5563a(Ordering ordering, Object obj, List list, int i) {
                return pl2.f25218c.mo5563a(ordering, obj, list, i) - 1;
            }
        }};
    }

    public static pl2 valueOf(String str) {
        return (pl2) Enum.valueOf(pl2.class, str);
    }

    public static pl2[] values() {
        return (pl2[]) f25220e.clone();
    }

    /* renamed from: a */
    public abstract int mo5563a(Ordering ordering, Object obj, List list, int i);
}
