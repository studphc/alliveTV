package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@AnyThread
@RequiresApi(19)
/* loaded from: classes.dex */
public class TypefaceEmojiRasterizer {

    /* renamed from: d */
    public static final ThreadLocal f4224d = new ThreadLocal();

    /* renamed from: a */
    public final int f4225a;

    /* renamed from: b */
    public final MetadataRepo f4226b;

    /* renamed from: c */
    public volatile int f4227c = 0;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public @interface HasGlyph {
    }

    public TypefaceEmojiRasterizer(MetadataRepo metadataRepo, int i) {
        this.f4226b = metadataRepo;
        this.f4225a = i;
    }

    /* renamed from: a */
    public final MetadataItem m1065a() {
        ThreadLocal threadLocal = f4224d;
        MetadataItem metadataItem = (MetadataItem) threadLocal.get();
        if (metadataItem == null) {
            metadataItem = new MetadataItem();
            threadLocal.set(metadataItem);
        }
        this.f4226b.getMetadataList().list(metadataItem, this.f4225a);
        return metadataItem;
    }

    public void draw(@NonNull Canvas canvas, float f, float f2, @NonNull Paint paint) {
        MetadataRepo metadataRepo = this.f4226b;
        Typeface typeface = metadataRepo.f4221d;
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        canvas.drawText(metadataRepo.getEmojiCharArray(), this.f4225a * 2, 2, f, f2, paint);
        paint.setTypeface(typeface2);
    }

    public int getCodepointAt(int i) {
        return m1065a().codepoints(i);
    }

    public int getCodepointsLength() {
        return m1065a().codepointsLength();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public short getCompatAdded() {
        return m1065a().compatAdded();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getHasGlyph() {
        return this.f4227c & 3;
    }

    public int getHeight() {
        return m1065a().height();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getId() {
        return m1065a().m1080id();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public short getSdkAdded() {
        return m1065a().sdkAdded();
    }

    @NonNull
    public Typeface getTypeface() {
        return this.f4226b.f4221d;
    }

    public int getWidth() {
        return m1065a().width();
    }

    public boolean isDefaultEmoji() {
        return m1065a().emojiStyle();
    }

    public boolean isPreferredSystemRender() {
        if ((this.f4227c & 4) > 0) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public void resetHasGlyphCache() {
        if (isPreferredSystemRender()) {
            this.f4227c = 4;
        } else {
            this.f4227c = 0;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setExclusion(boolean z) {
        int hasGlyph = getHasGlyph();
        if (z) {
            this.f4227c = hasGlyph | 4;
        } else {
            this.f4227c = hasGlyph;
        }
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setHasGlyph(boolean z) {
        int i;
        int i2 = this.f4227c & 4;
        if (z) {
            i = i2 | 2;
        } else {
            i = i2 | 1;
        }
        this.f4227c = i;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(getId()));
        sb.append(", codepoints:");
        int codepointsLength = getCodepointsLength();
        for (int i = 0; i < codepointsLength; i++) {
            sb.append(Integer.toHexString(getCodepointAt(i)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
