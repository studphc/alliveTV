package p000;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class b61 implements Iterator {

    /* renamed from: a */
    public static final b61 f7906a;

    /* renamed from: b */
    public static final /* synthetic */ b61[] f7907b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, b61] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f7906a = r1;
        f7907b = new b61[]{r1};
    }

    public static b61 valueOf(String str) {
        return (b61) Enum.valueOf(b61.class, str);
    }

    public static b61[] values() {
        return (b61[]) f7907b.clone();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        p63.m6876t(false);
    }
}
