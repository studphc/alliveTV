package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class PatternFilenameFilter implements FilenameFilter {

    /* renamed from: a */
    public final Pattern f15091a;

    public PatternFilenameFilter(String str) {
        this(Pattern.compile(str));
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return this.f15091a.matcher(str).matches();
    }

    public PatternFilenameFilter(Pattern pattern) {
        this.f15091a = (Pattern) Preconditions.checkNotNull(pattern);
    }
}
