package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableImageSourceView;
import p000.AbstractC1497l3;
import p000.C1345j8;

/* loaded from: classes.dex */
public class AppCompatImageButton extends ImageButton implements TintableBackgroundView, TintableImageSourceView {

    /* renamed from: a */
    public final C1345j8 f1161a;

    /* renamed from: b */
    public final AppCompatImageHelper f1162b;

    /* renamed from: c */
    public boolean f1163c;

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* renamed from: a */
        public boolean f1164a = false;

        /* renamed from: b */
        public int f1165b;

        /* renamed from: c */
        public int f1166c;

        /* renamed from: d */
        public int f1167d;

        /* renamed from: e */
        public int f1168e;

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            int mapObject;
            int mapObject2;
            int mapObject3;
            int mapObject4;
            mapObject = propertyMapper.mapObject("backgroundTint", R.attr.backgroundTint);
            this.f1165b = mapObject;
            mapObject2 = propertyMapper.mapObject("backgroundTintMode", R.attr.backgroundTintMode);
            this.f1166c = mapObject2;
            mapObject3 = propertyMapper.mapObject("tint", R.attr.tint);
            this.f1167d = mapObject3;
            mapObject4 = propertyMapper.mapObject("tintMode", R.attr.tintMode);
            this.f1168e = mapObject4;
            this.f1164a = true;
        }

        public void readProperties(@NonNull AppCompatImageButton appCompatImageButton, @NonNull PropertyReader propertyReader) {
            if (this.f1164a) {
                propertyReader.readObject(this.f1165b, appCompatImageButton.getBackgroundTintList());
                propertyReader.readObject(this.f1166c, appCompatImageButton.getBackgroundTintMode());
                propertyReader.readObject(this.f1167d, appCompatImageButton.getImageTintList());
                propertyReader.readObject(this.f1168e, appCompatImageButton.getImageTintMode());
                return;
            }
            throw AbstractC1497l3.m5831i();
        }
    }

    public AppCompatImageButton(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1345j8 c1345j8 = this.f1161a;
        if (c1345j8 != null) {
            c1345j8.m5407a();
        }
        AppCompatImageHelper appCompatImageHelper = this.f1162b;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.m241a();
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        C1345j8 c1345j8 = this.f1161a;
        if (c1345j8 != null) {
            return c1345j8.m5408b();
        }
        return null;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1345j8 c1345j8 = this.f1161a;
        if (c1345j8 != null) {
            return c1345j8.m5409c();
        }
        return null;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportImageTintList() {
        TintInfo tintInfo;
        AppCompatImageHelper appCompatImageHelper = this.f1162b;
        if (appCompatImageHelper == null || (tintInfo = appCompatImageHelper.f1170b) == null) {
            return null;
        }
        return tintInfo.mTintList;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportImageTintMode() {
        TintInfo tintInfo;
        AppCompatImageHelper appCompatImageHelper = this.f1162b;
        if (appCompatImageHelper == null || (tintInfo = appCompatImageHelper.f1170b) == null) {
            return null;
        }
        return tintInfo.mTintMode;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        if (!(this.f1162b.f1169a.getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1345j8 c1345j8 = this.f1161a;
        if (c1345j8 != null) {
            c1345j8.m5411e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        C1345j8 c1345j8 = this.f1161a;
        if (c1345j8 != null) {
            c1345j8.m5412f(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        AppCompatImageHelper appCompatImageHelper = this.f1162b;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.m241a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        AppCompatImageHelper appCompatImageHelper = this.f1162b;
        if (appCompatImageHelper != null && drawable != null && !this.f1163c) {
            appCompatImageHelper.f1171c = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (appCompatImageHelper != null) {
            appCompatImageHelper.m241a();
            if (!this.f1163c) {
                ImageView imageView = appCompatImageHelper.f1169a;
                if (imageView.getDrawable() != null) {
                    imageView.getDrawable().setLevel(appCompatImageHelper.f1171c);
                }
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i) {
        super.setImageLevel(i);
        this.f1163c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i) {
        this.f1162b.setImageResource(i);
    }

    @Override // android.widget.ImageView
    public void setImageURI(@Nullable Uri uri) {
        super.setImageURI(uri);
        AppCompatImageHelper appCompatImageHelper = this.f1162b;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.m241a();
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        C1345j8 c1345j8 = this.f1161a;
        if (c1345j8 != null) {
            c1345j8.m5414h(colorStateList);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        C1345j8 c1345j8 = this.f1161a;
        if (c1345j8 != null) {
            c1345j8.m5415i(mode);
        }
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        AppCompatImageHelper appCompatImageHelper = this.f1162b;
        if (appCompatImageHelper != null) {
            if (appCompatImageHelper.f1170b == null) {
                appCompatImageHelper.f1170b = new TintInfo();
            }
            TintInfo tintInfo = appCompatImageHelper.f1170b;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = true;
            appCompatImageHelper.m241a();
        }
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportImageTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatImageHelper appCompatImageHelper = this.f1162b;
        if (appCompatImageHelper != null) {
            if (appCompatImageHelper.f1170b == null) {
                appCompatImageHelper.f1170b = new TintInfo();
            }
            TintInfo tintInfo = appCompatImageHelper.f1170b;
            tintInfo.mTintMode = mode;
            tintInfo.mHasTintMode = true;
            appCompatImageHelper.m241a();
        }
    }

    public AppCompatImageButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    public AppCompatImageButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        this.f1163c = false;
        ThemeUtils.checkAppCompatTheme(this, getContext());
        C1345j8 c1345j8 = new C1345j8(this);
        this.f1161a = c1345j8;
        c1345j8.m5410d(attributeSet, i);
        AppCompatImageHelper appCompatImageHelper = new AppCompatImageHelper(this);
        this.f1162b = appCompatImageHelper;
        appCompatImageHelper.loadFromAttributes(attributeSet, i);
    }
}
