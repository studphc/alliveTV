package p000;

import android.content.ClipData;
import android.util.Pair;
import android.view.ContentInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.core.view.ContentInfoCompat;
import java.util.Objects;
import java.util.function.Predicate;

/* renamed from: sv */
/* loaded from: classes.dex */
public abstract class AbstractC1812sv {
    @NonNull
    @DoNotInline
    /* renamed from: a */
    public static Pair<ContentInfo, ContentInfo> m7418a(@NonNull ContentInfo contentInfo, @NonNull final Predicate<ClipData.Item> predicate) {
        ContentInfo contentInfo2;
        ClipData clip = contentInfo.getClip();
        if (clip.getItemCount() == 1) {
            boolean test = predicate.test(clip.getItemAt(0));
            if (test) {
                contentInfo2 = contentInfo;
            } else {
                contentInfo2 = null;
            }
            if (test) {
                contentInfo = null;
            }
            return Pair.create(contentInfo2, contentInfo);
        }
        Objects.requireNonNull(predicate);
        Pair m902b = ContentInfoCompat.m902b(clip, new androidx.core.util.Predicate() { // from class: rv
            @Override // androidx.core.util.Predicate
            public final /* synthetic */ androidx.core.util.Predicate and(androidx.core.util.Predicate predicate2) {
                return s62.m7334a(this, predicate2);
            }

            @Override // androidx.core.util.Predicate
            public final /* synthetic */ androidx.core.util.Predicate negate() {
                return s62.m7335b(this);
            }

            @Override // androidx.core.util.Predicate
            /* renamed from: or */
            public final /* synthetic */ androidx.core.util.Predicate mo897or(androidx.core.util.Predicate predicate2) {
                return s62.m7336c(this, predicate2);
            }

            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return predicate.test((ClipData.Item) obj);
            }
        });
        if (m902b.first == null) {
            return Pair.create(null, contentInfo);
        }
        if (m902b.second == null) {
            return Pair.create(contentInfo, null);
        }
        return Pair.create(new ContentInfo.Builder(contentInfo).setClip((ClipData) m902b.first).build(), new ContentInfo.Builder(contentInfo).setClip((ClipData) m902b.second).build());
    }
}
