package p000;

import com.bumptech.glide.load.model.LazyHeaderFactory;

/* loaded from: classes.dex */
public final class s71 implements LazyHeaderFactory {

    /* renamed from: a */
    public final String f26306a;

    public s71(String str) {
        this.f26306a = str;
    }

    @Override // com.bumptech.glide.load.model.LazyHeaderFactory
    public final String buildHeader() {
        return this.f26306a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof s71) {
            return this.f26306a.equals(((s71) obj).f26306a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f26306a.hashCode();
    }

    public final String toString() {
        return AbstractC1726qj.m7061q(new StringBuilder("StringHeaderFactory{value='"), this.f26306a, "'}");
    }
}
