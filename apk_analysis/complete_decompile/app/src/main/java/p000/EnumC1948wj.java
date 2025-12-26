package p000;

import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: wj */
/* loaded from: classes.dex */
public final class EnumC1948wj implements RemovalListener {

    /* renamed from: a */
    public static final EnumC1948wj f28200a;

    /* renamed from: b */
    public static final /* synthetic */ EnumC1948wj[] f28201b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [wj, java.lang.Enum] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f28200a = r1;
        f28201b = new EnumC1948wj[]{r1};
    }

    public static EnumC1948wj valueOf(String str) {
        return (EnumC1948wj) Enum.valueOf(EnumC1948wj.class, str);
    }

    public static EnumC1948wj[] values() {
        return (EnumC1948wj[]) f28201b.clone();
    }

    @Override // com.google.common.cache.RemovalListener
    public final void onRemoval(RemovalNotification removalNotification) {
    }
}
