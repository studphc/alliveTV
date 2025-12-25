package com.google.firebase.platforminfo;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
import p000.C1868ud;
import p000.C2032yt;

/* loaded from: classes2.dex */
public class LibraryVersionComponent {

    /* loaded from: classes2.dex */
    public interface VersionExtractor<T> {
        String extract(T t);
    }

    public static Component<?> create(String str, String str2) {
        return Component.intoSet(new C1868ud(str, str2), (Class<C1868ud>) C1868ud.class);
    }

    public static Component<?> fromContext(String str, VersionExtractor<Context> versionExtractor) {
        return Component.intoSetBuilder(C1868ud.class).add(Dependency.required((Class<?>) Context.class)).factory(new C2032yt(versionExtractor, 1, str)).build();
    }
}
