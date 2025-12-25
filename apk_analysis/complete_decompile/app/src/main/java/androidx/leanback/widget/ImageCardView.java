package androidx.leanback.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class ImageCardView extends BaseCardView {
    public static final int CARD_TYPE_FLAG_CONTENT = 2;
    public static final int CARD_TYPE_FLAG_ICON_LEFT = 8;
    public static final int CARD_TYPE_FLAG_ICON_RIGHT = 4;
    public static final int CARD_TYPE_FLAG_IMAGE_ONLY = 0;
    public static final int CARD_TYPE_FLAG_TITLE = 1;

    /* renamed from: s */
    public final ImageView f5854s;

    /* renamed from: t */
    public final ViewGroup f5855t;

    /* renamed from: u */
    public final TextView f5856u;

    /* renamed from: v */
    public final TextView f5857v;

    /* renamed from: w */
    public final ImageView f5858w;

    /* renamed from: x */
    public boolean f5859x;

    /* renamed from: y */
    public final ObjectAnimator f5860y;

    @Deprecated
    public ImageCardView(Context context, int i) {
        this(new ContextThemeWrapper(context, i));
    }

    @Nullable
    public Drawable getBadgeImage() {
        ImageView imageView = this.f5858w;
        if (imageView == null) {
            return null;
        }
        return imageView.getDrawable();
    }

    @Nullable
    public CharSequence getContentText() {
        TextView textView = this.f5857v;
        if (textView == null) {
            return null;
        }
        return textView.getText();
    }

    @Nullable
    public Drawable getInfoAreaBackground() {
        ViewGroup viewGroup = this.f5855t;
        if (viewGroup != null) {
            return viewGroup.getBackground();
        }
        return null;
    }

    @Nullable
    public Drawable getMainImage() {
        ImageView imageView = this.f5854s;
        if (imageView == null) {
            return null;
        }
        return imageView.getDrawable();
    }

    @Nullable
    public final ImageView getMainImageView() {
        return this.f5854s;
    }

    @Nullable
    public CharSequence getTitleText() {
        TextView textView = this.f5856u;
        if (textView == null) {
            return null;
        }
        return textView.getText();
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f5859x = true;
        if (this.f5854s.getAlpha() == RecyclerView.f7068F0) {
            this.f5854s.setAlpha(RecyclerView.f7068F0);
            if (this.f5859x) {
                this.f5860y.start();
            }
        }
    }

    @Override // androidx.leanback.widget.BaseCardView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f5859x = false;
        this.f5860y.cancel();
        this.f5854s.setAlpha(1.0f);
        super.onDetachedFromWindow();
    }

    public void setBadgeImage(@Nullable Drawable drawable) {
        ImageView imageView = this.f5858w;
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
        if (drawable != null) {
            this.f5858w.setVisibility(0);
        } else {
            this.f5858w.setVisibility(8);
        }
    }

    public void setContentText(@Nullable CharSequence charSequence) {
        TextView textView = this.f5857v;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    public void setInfoAreaBackground(@Nullable Drawable drawable) {
        ViewGroup viewGroup = this.f5855t;
        if (viewGroup != null) {
            viewGroup.setBackground(drawable);
        }
    }

    public void setInfoAreaBackgroundColor(@ColorInt int i) {
        ViewGroup viewGroup = this.f5855t;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(i);
        }
    }

    public void setMainImage(@Nullable Drawable drawable) {
        setMainImage(drawable, true);
    }

    public void setMainImageAdjustViewBounds(boolean z) {
        ImageView imageView = this.f5854s;
        if (imageView != null) {
            imageView.setAdjustViewBounds(z);
        }
    }

    public void setMainImageDimensions(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f5854s.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.f5854s.setLayoutParams(layoutParams);
    }

    public void setMainImageScaleType(@NonNull ImageView.ScaleType scaleType) {
        ImageView imageView = this.f5854s;
        if (imageView != null) {
            imageView.setScaleType(scaleType);
        }
    }

    public void setTitleText(@Nullable CharSequence charSequence) {
        TextView textView = this.f5856u;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    public ImageCardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2 = androidx.leanback.R.style.Widget_Leanback_ImageCardView;
        setFocusable(true);
        setFocusableInTouchMode(true);
        LayoutInflater from = LayoutInflater.from(getContext());
        from.inflate(androidx.leanback.R.layout.lb_image_card_view, this);
        Context context2 = getContext();
        int[] iArr = androidx.leanback.R.styleable.lbImageCardView;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i, i2);
        ViewCompat.saveAttributeDataForStyleable(this, getContext(), iArr, attributeSet, obtainStyledAttributes, i, i2);
        int i3 = obtainStyledAttributes.getInt(androidx.leanback.R.styleable.lbImageCardView_lbImageCardViewType, 0);
        boolean z = i3 == 0;
        boolean z2 = (i3 & 1) == 1;
        boolean z3 = (i3 & 2) == 2;
        boolean z4 = (i3 & 4) == 4;
        boolean z5 = !z4 && (i3 & 8) == 8;
        ImageView imageView = (ImageView) findViewById(androidx.leanback.R.id.main_image);
        this.f5854s = imageView;
        if (imageView.getDrawable() == null) {
            this.f5854s.setVisibility(4);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f5854s, "alpha", 1.0f);
        this.f5860y = ofFloat;
        ofFloat.setDuration(this.f5854s.getResources().getInteger(android.R.integer.config_shortAnimTime));
        ViewGroup viewGroup = (ViewGroup) findViewById(androidx.leanback.R.id.info_field);
        this.f5855t = viewGroup;
        if (z) {
            removeView(viewGroup);
            obtainStyledAttributes.recycle();
            return;
        }
        if (z2) {
            TextView textView = (TextView) from.inflate(androidx.leanback.R.layout.lb_image_card_view_themed_title, viewGroup, false);
            this.f5856u = textView;
            this.f5855t.addView(textView);
        }
        if (z3) {
            TextView textView2 = (TextView) from.inflate(androidx.leanback.R.layout.lb_image_card_view_themed_content, this.f5855t, false);
            this.f5857v = textView2;
            this.f5855t.addView(textView2);
        }
        if (z4 || z5) {
            ImageView imageView2 = (ImageView) from.inflate(z5 ? androidx.leanback.R.layout.lb_image_card_view_themed_badge_left : androidx.leanback.R.layout.lb_image_card_view_themed_badge_right, this.f5855t, false);
            this.f5858w = imageView2;
            this.f5855t.addView(imageView2);
        }
        if (z2 && !z3 && this.f5858w != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f5856u.getLayoutParams();
            if (z5) {
                layoutParams.addRule(17, this.f5858w.getId());
            } else {
                layoutParams.addRule(16, this.f5858w.getId());
            }
            this.f5856u.setLayoutParams(layoutParams);
        }
        if (z3) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f5857v.getLayoutParams();
            if (!z2) {
                layoutParams2.addRule(10);
            }
            if (z5) {
                layoutParams2.removeRule(16);
                layoutParams2.removeRule(20);
                layoutParams2.addRule(17, this.f5858w.getId());
            }
            this.f5857v.setLayoutParams(layoutParams2);
        }
        ImageView imageView3 = this.f5858w;
        if (imageView3 != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) imageView3.getLayoutParams();
            if (z3) {
                layoutParams3.addRule(8, this.f5857v.getId());
            } else if (z2) {
                layoutParams3.addRule(8, this.f5856u.getId());
            }
            this.f5858w.setLayoutParams(layoutParams3);
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(androidx.leanback.R.styleable.lbImageCardView_infoAreaBackground);
        if (drawable != null) {
            setInfoAreaBackground(drawable);
        }
        ImageView imageView4 = this.f5858w;
        if (imageView4 != null && imageView4.getDrawable() == null) {
            this.f5858w.setVisibility(8);
        }
        obtainStyledAttributes.recycle();
    }

    public void setMainImage(@Nullable Drawable drawable, boolean z) {
        ImageView imageView = this.f5854s;
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            this.f5860y.cancel();
            this.f5854s.setAlpha(1.0f);
            this.f5854s.setVisibility(4);
            return;
        }
        this.f5854s.setVisibility(0);
        if (z) {
            this.f5854s.setAlpha(RecyclerView.f7068F0);
            if (this.f5859x) {
                this.f5860y.start();
                return;
            }
            return;
        }
        this.f5860y.cancel();
        this.f5854s.setAlpha(1.0f);
    }

    public ImageCardView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public ImageCardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, androidx.leanback.R.attr.imageCardViewStyle);
    }
}
