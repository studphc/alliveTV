package p000;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
public final class hu0 {

    /* renamed from: a */
    public int f18174a;

    /* renamed from: b */
    public Fragment f18175b;

    /* renamed from: c */
    public boolean f18176c = false;

    /* renamed from: d */
    public int f18177d;

    /* renamed from: e */
    public int f18178e;

    /* renamed from: f */
    public int f18179f;

    /* renamed from: g */
    public int f18180g;

    /* renamed from: h */
    public Lifecycle.State f18181h;

    /* renamed from: i */
    public Lifecycle.State f18182i;

    public hu0(int i, Fragment fragment) {
        this.f18174a = i;
        this.f18175b = fragment;
        Lifecycle.State state = Lifecycle.State.RESUMED;
        this.f18181h = state;
        this.f18182i = state;
    }

    public hu0(Fragment fragment, int i, int i2) {
        this.f18174a = i;
        this.f18175b = fragment;
        Lifecycle.State state = Lifecycle.State.RESUMED;
        this.f18181h = state;
        this.f18182i = state;
    }
}
