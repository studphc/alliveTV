package p000;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class ll1 {
    @DoNotInline
    /* renamed from: a */
    public static MediaDescription m5940a(MediaDescription.Builder builder) {
        return builder.build();
    }

    @DoNotInline
    /* renamed from: b */
    public static MediaDescription.Builder m5941b() {
        return new MediaDescription.Builder();
    }

    @Nullable
    @DoNotInline
    /* renamed from: c */
    public static CharSequence m5942c(MediaDescription mediaDescription) {
        return mediaDescription.getDescription();
    }

    @Nullable
    @DoNotInline
    /* renamed from: d */
    public static Bundle m5943d(MediaDescription mediaDescription) {
        return mediaDescription.getExtras();
    }

    @Nullable
    @DoNotInline
    /* renamed from: e */
    public static Bitmap m5944e(MediaDescription mediaDescription) {
        return mediaDescription.getIconBitmap();
    }

    @Nullable
    @DoNotInline
    /* renamed from: f */
    public static Uri m5945f(MediaDescription mediaDescription) {
        return mediaDescription.getIconUri();
    }

    @Nullable
    @DoNotInline
    /* renamed from: g */
    public static String m5946g(MediaDescription mediaDescription) {
        return mediaDescription.getMediaId();
    }

    @Nullable
    @DoNotInline
    /* renamed from: h */
    public static CharSequence m5947h(MediaDescription mediaDescription) {
        return mediaDescription.getSubtitle();
    }

    @Nullable
    @DoNotInline
    /* renamed from: i */
    public static CharSequence m5948i(MediaDescription mediaDescription) {
        return mediaDescription.getTitle();
    }

    @DoNotInline
    /* renamed from: j */
    public static void m5949j(MediaDescription.Builder builder, @Nullable CharSequence charSequence) {
        builder.setDescription(charSequence);
    }

    @DoNotInline
    /* renamed from: k */
    public static void m5950k(MediaDescription.Builder builder, @Nullable Bundle bundle) {
        builder.setExtras(bundle);
    }

    @DoNotInline
    /* renamed from: l */
    public static void m5951l(MediaDescription.Builder builder, @Nullable Bitmap bitmap) {
        builder.setIconBitmap(bitmap);
    }

    @DoNotInline
    /* renamed from: m */
    public static void m5952m(MediaDescription.Builder builder, @Nullable Uri uri) {
        builder.setIconUri(uri);
    }

    @DoNotInline
    /* renamed from: n */
    public static void m5953n(MediaDescription.Builder builder, @Nullable String str) {
        builder.setMediaId(str);
    }

    @DoNotInline
    /* renamed from: o */
    public static void m5954o(MediaDescription.Builder builder, @Nullable CharSequence charSequence) {
        builder.setSubtitle(charSequence);
    }

    @DoNotInline
    /* renamed from: p */
    public static void m5955p(MediaDescription.Builder builder, @Nullable CharSequence charSequence) {
        builder.setTitle(charSequence);
    }
}
