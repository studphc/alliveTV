package androidx.core.view;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Predicate;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Objects;
import p000.AbstractC1267hf;
import p000.AbstractC1812sv;
import p000.C1886uv;
import p000.InterfaceC1849tv;
import p000.InterfaceC1923vv;
import p000.b01;

/* loaded from: classes.dex */
public final class ContentInfoCompat {
    public static final int FLAG_CONVERT_TO_PLAIN_TEXT = 1;
    public static final int SOURCE_APP = 0;
    public static final int SOURCE_AUTOFILL = 4;
    public static final int SOURCE_CLIPBOARD = 1;
    public static final int SOURCE_DRAG_AND_DROP = 3;
    public static final int SOURCE_INPUT_METHOD = 2;
    public static final int SOURCE_PROCESS_TEXT = 5;

    /* renamed from: a */
    public final InterfaceC1923vv f3857a;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface Flags {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface Source {
    }

    public ContentInfoCompat(InterfaceC1923vv interfaceC1923vv) {
        this.f3857a = interfaceC1923vv;
    }

    /* renamed from: a */
    public static ClipData m901a(ClipDescription clipDescription, ArrayList arrayList) {
        ClipData clipData = new ClipData(new ClipDescription(clipDescription), (ClipData.Item) arrayList.get(0));
        for (int i = 1; i < arrayList.size(); i++) {
            clipData.addItem((ClipData.Item) arrayList.get(i));
        }
        return clipData;
    }

    /* renamed from: b */
    public static Pair m902b(ClipData clipData, Predicate predicate) {
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (int i = 0; i < clipData.getItemCount(); i++) {
            ClipData.Item itemAt = clipData.getItemAt(i);
            if (predicate.test(itemAt)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(itemAt);
            } else {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(itemAt);
            }
        }
        if (arrayList == null) {
            return Pair.create(null, clipData);
        }
        if (arrayList2 == null) {
            return Pair.create(clipData, null);
        }
        return Pair.create(m901a(clipData.getDescription(), arrayList), m901a(clipData.getDescription(), arrayList2));
    }

    @NonNull
    @RequiresApi(31)
    public static ContentInfoCompat toContentInfoCompat(@NonNull ContentInfo contentInfo) {
        return new ContentInfoCompat(new b01(contentInfo));
    }

    @NonNull
    public ClipData getClip() {
        return this.f3857a.mo1985b();
    }

    @Nullable
    public Bundle getExtras() {
        return this.f3857a.getExtras();
    }

    public int getFlags() {
        return this.f3857a.getFlags();
    }

    @Nullable
    public Uri getLinkUri() {
        return this.f3857a.mo1984a();
    }

    public int getSource() {
        return this.f3857a.mo1995l();
    }

    @NonNull
    public Pair<ContentInfoCompat, ContentInfoCompat> partition(@NonNull Predicate<ClipData.Item> predicate) {
        ClipData mo1985b = this.f3857a.mo1985b();
        if (mo1985b.getItemCount() == 1) {
            boolean test = predicate.test(mo1985b.getItemAt(0));
            return Pair.create(test ? this : null, test ? null : this);
        }
        Pair m902b = m902b(mo1985b, predicate);
        if (m902b.first == null) {
            return Pair.create(null, this);
        }
        if (m902b.second == null) {
            return Pair.create(this, null);
        }
        return Pair.create(new Builder(this).setClip((ClipData) m902b.first).build(), new Builder(this).setClip((ClipData) m902b.second).build());
    }

    @NonNull
    @RequiresApi(31)
    public ContentInfo toContentInfo() {
        ContentInfo mo1993j = this.f3857a.mo1993j();
        Objects.requireNonNull(mo1993j);
        return AbstractC1267hf.m5074o(mo1993j);
    }

    @NonNull
    public String toString() {
        return this.f3857a.toString();
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public final InterfaceC1849tv f3858a;

        public Builder(@NonNull ContentInfoCompat contentInfoCompat) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f3858a = new b01(contentInfoCompat);
                return;
            }
            C1886uv c1886uv = new C1886uv();
            c1886uv.f27460b = contentInfoCompat.getClip();
            c1886uv.f27461c = contentInfoCompat.getSource();
            c1886uv.f27462d = contentInfoCompat.getFlags();
            c1886uv.f27463e = contentInfoCompat.getLinkUri();
            c1886uv.f27464f = contentInfoCompat.getExtras();
            this.f3858a = c1886uv;
        }

        @NonNull
        public ContentInfoCompat build() {
            return this.f3858a.build();
        }

        @NonNull
        public Builder setClip(@NonNull ClipData clipData) {
            this.f3858a.mo1989f(clipData);
            return this;
        }

        @NonNull
        public Builder setExtras(@Nullable Bundle bundle) {
            this.f3858a.setExtras(bundle);
            return this;
        }

        @NonNull
        public Builder setFlags(int i) {
            this.f3858a.setFlags(i);
            return this;
        }

        @NonNull
        public Builder setLinkUri(@Nullable Uri uri) {
            this.f3858a.mo1988e(uri);
            return this;
        }

        @NonNull
        public Builder setSource(int i) {
            this.f3858a.mo1986c(i);
            return this;
        }

        public Builder(@NonNull ClipData clipData, int i) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f3858a = new b01(clipData, i);
                return;
            }
            C1886uv c1886uv = new C1886uv();
            c1886uv.f27460b = clipData;
            c1886uv.f27461c = i;
            this.f3858a = c1886uv;
        }
    }

    @NonNull
    @RequiresApi(31)
    public static Pair<ContentInfo, ContentInfo> partition(@NonNull ContentInfo contentInfo, @NonNull java.util.function.Predicate<ClipData.Item> predicate) {
        return AbstractC1812sv.m7418a(contentInfo, predicate);
    }
}
