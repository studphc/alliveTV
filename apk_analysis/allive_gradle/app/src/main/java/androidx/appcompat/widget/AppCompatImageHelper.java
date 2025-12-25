package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class AppCompatImageHelper {

    /* renamed from: a */
    public final ImageView f1169a;

    /* renamed from: b */
    public TintInfo f1170b;

    /* renamed from: c */
    public int f1171c = 0;

    public AppCompatImageHelper(@NonNull ImageView imageView) {
        this.f1169a = imageView;
    }

    /* renamed from: a */
    public final void m241a() {
        TintInfo tintInfo;
        ImageView imageView = this.f1169a;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            DrawableUtils.m247a(drawable);
        }
        if (drawable != null && (tintInfo = this.f1170b) != null) {
            AppCompatDrawableManager.m240a(drawable, tintInfo, imageView.getDrawableState());
        }
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        int resourceId;
        ImageView imageView = this.f1169a;
        Context context = imageView.getContext();
        int[] iArr = R.styleable.AppCompatImageView;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, 0);
        ImageView imageView2 = this.f1169a;
        ViewCompat.saveAttributeDataForStyleable(imageView2, imageView2.getContext(), iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        try {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = AppCompatResources.getDrawable(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                DrawableUtils.m247a(drawable);
            }
            int i2 = R.styleable.AppCompatImageView_tint;
            if (obtainStyledAttributes.hasValue(i2)) {
                ImageViewCompat.setImageTintList(imageView, obtainStyledAttributes.getColorStateList(i2));
            }
            int i3 = R.styleable.AppCompatImageView_tintMode;
            if (obtainStyledAttributes.hasValue(i3)) {
                ImageViewCompat.setImageTintMode(imageView, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i3, -1), null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setImageResource(int i) {
        ImageView imageView = this.f1169a;
        if (i != 0) {
            Drawable drawable = AppCompatResources.getDrawable(imageView.getContext(), i);
            if (drawable != null) {
                DrawableUtils.m247a(drawable);
            }
            imageView.setImageDrawable(drawable);
        } else {
            imageView.setImageDrawable(null);
        }
        m241a();
    }
}
