package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public class Lazy<T> implements Provider<T> {

    /* renamed from: c */
    public static final Object f15544c = new Object();

    /* renamed from: a */
    public volatile Object f15545a = f15544c;

    /* renamed from: b */
    public volatile Provider f15546b;

    public Lazy(Provider<T> provider) {
        this.f15546b = provider;
    }

    @Override // com.google.firebase.inject.Provider
    public T get() {
        Object obj = (T) this.f15545a;
        Object obj2 = f15544c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.f15545a;
                    if (obj == obj2) {
                        obj = (T) this.f15546b.get();
                        this.f15545a = obj;
                        this.f15546b = null;
                    }
                } finally {
                }
            }
        }
        return (T) obj;
    }
}
