package com.google.firebase.events;

import com.google.firebase.components.Preconditions;

/* loaded from: classes2.dex */
public class Event<T> {

    /* renamed from: a */
    public final Class f15557a;

    /* renamed from: b */
    public final Object f15558b;

    public Event(Class<T> cls, T t) {
        this.f15557a = (Class) Preconditions.checkNotNull(cls);
        this.f15558b = Preconditions.checkNotNull(t);
    }

    public T getPayload() {
        return (T) this.f15558b;
    }

    public Class<T> getType() {
        return this.f15557a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.f15557a, this.f15558b);
    }
}
