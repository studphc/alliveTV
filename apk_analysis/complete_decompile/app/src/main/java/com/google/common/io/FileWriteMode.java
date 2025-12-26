package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@GwtIncompatible
/* loaded from: classes2.dex */
public final class FileWriteMode {
    public static final FileWriteMode APPEND;

    /* renamed from: a */
    public static final /* synthetic */ FileWriteMode[] f15082a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, com.google.common.io.FileWriteMode] */
    static {
        ?? r1 = new Enum("APPEND", 0);
        APPEND = r1;
        f15082a = new FileWriteMode[]{r1};
    }

    public static FileWriteMode valueOf(String str) {
        return (FileWriteMode) Enum.valueOf(FileWriteMode.class, str);
    }

    public static FileWriteMode[] values() {
        return (FileWriteMode[]) f15082a.clone();
    }
}
