package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class kw0 {

    /* renamed from: a */
    public static final kw0 f22223a;

    /* renamed from: b */
    public static final CopyOnWriteArraySet f22224b;

    /* renamed from: c */
    public static final /* synthetic */ kw0[] f22225c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, kw0] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f22223a = r1;
        f22225c = new kw0[]{r1};
        f22224b = new CopyOnWriteArraySet();
    }

    public static kw0 valueOf(String str) {
        return (kw0) Enum.valueOf(kw0.class, str);
    }

    public static kw0[] values() {
        return (kw0[]) f22225c.clone();
    }

    /* renamed from: a */
    public final void m5796a(Class cls) {
        CopyOnWriteArraySet copyOnWriteArraySet = f22224b;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            if (cls.equals(((WeakReference) it.next()).get())) {
                return;
            }
        }
        Ordering ordering = mw0.f23142a;
        boolean z = true;
        Preconditions.checkArgument(!RuntimeException.class.isAssignableFrom(cls), "Futures.getChecked exception type (%s) must not be a RuntimeException", cls);
        try {
            mw0.m6260a(new Exception(), cls);
        } catch (Exception unused) {
            z = false;
        }
        Preconditions.checkArgument(z, "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", cls);
        if (copyOnWriteArraySet.size() > 1000) {
            copyOnWriteArraySet.clear();
        }
        copyOnWriteArraySet.add(new WeakReference(cls));
    }
}
