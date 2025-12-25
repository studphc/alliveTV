package com.google.firebase.platforminfo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p000.C1868ud;

/* loaded from: classes2.dex */
public class GlobalLibraryVersionRegistrar {

    /* renamed from: b */
    public static volatile GlobalLibraryVersionRegistrar f15654b;

    /* renamed from: a */
    public final HashSet f15655a = new HashSet();

    public static GlobalLibraryVersionRegistrar getInstance() {
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar = f15654b;
        if (globalLibraryVersionRegistrar == null) {
            synchronized (GlobalLibraryVersionRegistrar.class) {
                try {
                    globalLibraryVersionRegistrar = f15654b;
                    if (globalLibraryVersionRegistrar == null) {
                        globalLibraryVersionRegistrar = new GlobalLibraryVersionRegistrar();
                        f15654b = globalLibraryVersionRegistrar;
                    }
                } finally {
                }
            }
        }
        return globalLibraryVersionRegistrar;
    }

    /* renamed from: a */
    public final Set m4408a() {
        Set unmodifiableSet;
        synchronized (this.f15655a) {
            unmodifiableSet = Collections.unmodifiableSet(this.f15655a);
        }
        return unmodifiableSet;
    }

    public void registerVersion(String str, String str2) {
        synchronized (this.f15655a) {
            this.f15655a.add(new C1868ud(str, str2));
        }
    }
}
