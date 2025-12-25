package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class DependencyCycleException extends DependencyException {

    /* renamed from: a */
    public final List f15543a;

    public DependencyCycleException(List<Component<?>> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.f15543a = list;
    }

    public List<Component<?>> getComponentsInCycle() {
        return this.f15543a;
    }
}
