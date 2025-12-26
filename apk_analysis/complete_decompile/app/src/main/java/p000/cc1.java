package p000;

import com.google.common.cache.ConcurrentMapC0840e;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class cc1 extends WeakReference implements j92 {

    /* renamed from: a */
    public final int f8325a;

    /* renamed from: b */
    public final j92 f8326b;

    /* renamed from: c */
    public volatile zb1 f8327c;

    public cc1(int i, j92 j92Var, Object obj, ReferenceQueue referenceQueue) {
        super(obj, referenceQueue);
        this.f8327c = ConcurrentMapC0840e.f14585x;
        this.f8325a = i;
        this.f8326b = j92Var;
    }

    @Override // p000.j92
    /* renamed from: a */
    public final j92 mo2220a() {
        return this.f8326b;
    }

    @Override // p000.j92
    /* renamed from: b */
    public final zb1 mo2221b() {
        return this.f8327c;
    }

    @Override // p000.j92
    /* renamed from: c */
    public final int mo2222c() {
        return this.f8325a;
    }

    /* renamed from: d */
    public j92 mo50d() {
        throw new UnsupportedOperationException();
    }

    @Override // p000.j92
    /* renamed from: e */
    public final void mo2223e(zb1 zb1Var) {
        this.f8327c = zb1Var;
    }

    /* renamed from: f */
    public long mo51f() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: g */
    public void mo52g(j92 j92Var) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.j92
    public final Object getKey() {
        return get();
    }

    /* renamed from: h */
    public void mo53h(j92 j92Var) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: i */
    public void mo54i(long j) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: j */
    public void mo55j(j92 j92Var) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: k */
    public j92 mo56k() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: l */
    public long mo57l() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: m */
    public void mo58m(long j) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: n */
    public j92 mo59n() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: o */
    public void mo60o(j92 j92Var) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: p */
    public j92 mo61p() {
        throw new UnsupportedOperationException();
    }
}
