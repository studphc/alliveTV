package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class s21 extends ImmutableList {

    /* renamed from: c */
    public final transient int f26210c;

    /* renamed from: d */
    public final transient int f26211d;

    /* renamed from: e */
    public final /* synthetic */ ImmutableList f26212e;

    public s21(ImmutableList immutableList, int i, int i2) {
        this.f26212e = immutableList;
        this.f26210c = i;
        this.f26211d = i2;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: b */
    public final Object[] mo3897b() {
        return this.f26212e.mo3897b();
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: c */
    public final int mo3898c() {
        return this.f26212e.mo3899d() + this.f26210c + this.f26211d;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: d */
    public final int mo3899d() {
        return this.f26212e.mo3899d() + this.f26210c;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Preconditions.checkElementIndex(i, this.f26211d);
        return this.f26212e.get(i + this.f26210c);
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator() {
        return super.listIterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f26211d;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return super.listIterator(i);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public final ImmutableList subList(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, this.f26211d);
        int i3 = this.f26210c;
        return this.f26212e.subList(i + i3, i2 + i3);
    }
}
