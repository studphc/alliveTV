package p000;

import android.util.SizeF;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import androidx.core.util.SizeFCompat;

/* loaded from: classes.dex */
public abstract class mk2 {
    @NonNull
    @DoNotInline
    /* renamed from: a */
    public static SizeF m6179a(@NonNull SizeFCompat sizeFCompat) {
        Preconditions.checkNotNull(sizeFCompat);
        return new SizeF(sizeFCompat.getWidth(), sizeFCompat.getHeight());
    }

    @NonNull
    @DoNotInline
    /* renamed from: b */
    public static SizeFCompat m6180b(@NonNull SizeF sizeF) {
        Preconditions.checkNotNull(sizeF);
        return new SizeFCompat(sizeF.getWidth(), sizeF.getHeight());
    }
}
