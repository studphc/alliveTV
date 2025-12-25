package com.google.android.exoplayer2.text;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;
import p000.C1255h3;

/* loaded from: classes.dex */
public final class CueGroup implements Bundleable {
    public final ImmutableList<Cue> cues;
    public static final CueGroup EMPTY = new CueGroup(ImmutableList.m3902of());
    public static final Bundleable.Creator<CueGroup> CREATOR = new C1255h3(12);

    public CueGroup(List<Cue> list) {
        this.cues = ImmutableList.copyOf((Collection) list);
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        String num = Integer.toString(0, 36);
        ImmutableList<Cue> immutableList = this.cues;
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < immutableList.size(); i++) {
            if (immutableList.get(i).bitmap == null) {
                builder.add((ImmutableList.Builder) immutableList.get(i));
            }
        }
        bundle.putParcelableArrayList(num, BundleableUtil.toBundleArrayList(builder.build()));
        return bundle;
    }
}
