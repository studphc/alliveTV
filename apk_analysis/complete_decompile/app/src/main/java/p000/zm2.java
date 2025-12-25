package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.C0855c3;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* loaded from: classes.dex */
public final class zm2 extends dn2 implements SortedMap {

    /* renamed from: f */
    public final /* synthetic */ an2 f29443f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zm2(an2 an2Var) {
        super(an2Var, 1);
        this.f29443f = an2Var;
    }

    @Override // p000.ih1
    /* renamed from: c */
    public final Set mo5238c() {
        return new zg1(this);
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return ((SortedMap) this.f29443f.f14788c).comparator();
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return ((SortedMap) this.f29443f.f14788c).firstKey();
    }

    @Override // java.util.SortedMap
    public final SortedMap headMap(Object obj) {
        Preconditions.checkNotNull(obj);
        an2 an2Var = this.f29443f;
        return new C0855c3(((SortedMap) an2Var.f14788c).headMap(obj), an2Var.f14789d).rowMap();
    }

    @Override // p000.dn2, p000.ih1, java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public final Set keySet() {
        return (SortedSet) super.keySet();
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return ((SortedMap) this.f29443f.f14788c).lastKey();
    }

    @Override // java.util.SortedMap
    public final SortedMap subMap(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        an2 an2Var = this.f29443f;
        return new C0855c3(((SortedMap) an2Var.f14788c).subMap(obj, obj2), an2Var.f14789d).rowMap();
    }

    @Override // java.util.SortedMap
    public final SortedMap tailMap(Object obj) {
        Preconditions.checkNotNull(obj);
        an2 an2Var = this.f29443f;
        return new C0855c3(((SortedMap) an2Var.f14788c).tailMap(obj), an2Var.f14789d).rowMap();
    }
}
