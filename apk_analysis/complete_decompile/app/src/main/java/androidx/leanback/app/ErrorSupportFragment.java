package androidx.leanback.app;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.R;

/* loaded from: classes.dex */
public class ErrorSupportFragment extends BrandedSupportFragment {

    /* renamed from: n0 */
    public ViewGroup f4985n0;

    /* renamed from: o0 */
    public ImageView f4986o0;

    /* renamed from: p0 */
    public TextView f4987p0;

    /* renamed from: q0 */
    public Button f4988q0;

    /* renamed from: r0 */
    public Drawable f4989r0;

    /* renamed from: s0 */
    public CharSequence f4990s0;

    /* renamed from: t0 */
    public String f4991t0;

    /* renamed from: u0 */
    public View.OnClickListener f4992u0;

    /* renamed from: v0 */
    public Drawable f4993v0;

    /* renamed from: w0 */
    public boolean f4994w0 = true;

    @Nullable
    public Drawable getBackgroundDrawable() {
        return this.f4993v0;
    }

    @Nullable
    public View.OnClickListener getButtonClickListener() {
        return this.f4992u0;
    }

    @Nullable
    public String getButtonText() {
        return this.f4991t0;
    }

    @Nullable
    public Drawable getImageDrawable() {
        return this.f4989r0;
    }

    @Nullable
    public CharSequence getMessage() {
        return this.f4990s0;
    }

    public boolean isBackgroundTranslucent() {
        return this.f4994w0;
    }

    /* renamed from: l */
    public final void m1291l() {
        int i;
        ViewGroup viewGroup = this.f4985n0;
        if (viewGroup != null) {
            Drawable drawable = this.f4993v0;
            if (drawable != null) {
                viewGroup.setBackground(drawable);
                return;
            }
            Resources resources = viewGroup.getResources();
            if (this.f4994w0) {
                i = R.color.lb_error_background_color_translucent;
            } else {
                i = R.color.lb_error_background_color_opaque;
            }
            viewGroup.setBackgroundColor(resources.getColor(i));
        }
    }

    /* renamed from: m */
    public final void m1292m() {
        int i;
        Button button = this.f4988q0;
        if (button != null) {
            button.setText(this.f4991t0);
            this.f4988q0.setOnClickListener(this.f4992u0);
            Button button2 = this.f4988q0;
            if (TextUtils.isEmpty(this.f4991t0)) {
                i = 8;
            } else {
                i = 0;
            }
            button2.setVisibility(i);
            this.f4988q0.requestFocus();
        }
    }

    /* renamed from: n */
    public final void m1293n() {
        int i;
        TextView textView = this.f4987p0;
        if (textView != null) {
            textView.setText(this.f4990s0);
            TextView textView2 = this.f4987p0;
            if (TextUtils.isEmpty(this.f4990s0)) {
                i = 8;
            } else {
                i = 0;
            }
            textView2.setVisibility(i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i;
        int i2;
        int i3 = 0;
        View inflate = layoutInflater.inflate(R.layout.lb_error_fragment, viewGroup, false);
        this.f4985n0 = (ViewGroup) inflate.findViewById(R.id.error_frame);
        m1291l();
        installTitleView(layoutInflater, this.f4985n0, bundle);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.image);
        this.f4986o0 = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f4989r0);
            ImageView imageView2 = this.f4986o0;
            if (this.f4989r0 == null) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            imageView2.setVisibility(i2);
        }
        this.f4987p0 = (TextView) inflate.findViewById(R.id.message);
        m1293n();
        this.f4988q0 = (Button) inflate.findViewById(R.id.button);
        m1292m();
        TextView textView = this.f4987p0;
        Paint paint = new Paint(1);
        paint.setTextSize(textView.getTextSize());
        paint.setTypeface(textView.getTypeface());
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        if (viewGroup != null) {
            i = viewGroup.getResources().getDimensionPixelSize(R.dimen.lb_error_under_image_baseline_margin);
        } else {
            i = 0;
        }
        TextView textView2 = this.f4987p0;
        int i4 = i + fontMetricsInt.ascent;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
        marginLayoutParams.topMargin = i4;
        textView2.setLayoutParams(marginLayoutParams);
        if (viewGroup != null) {
            i3 = viewGroup.getResources().getDimensionPixelSize(R.dimen.lb_error_under_message_baseline_margin);
        }
        Button button = this.f4988q0;
        int i5 = i3 - fontMetricsInt.descent;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) button.getLayoutParams();
        marginLayoutParams2.topMargin = i5;
        button.setLayoutParams(marginLayoutParams2);
        return inflate;
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f4985n0.requestFocus();
    }

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        boolean z;
        this.f4993v0 = drawable;
        if (drawable != null) {
            int opacity = drawable.getOpacity();
            if (opacity != -3 && opacity != -2) {
                z = false;
            } else {
                z = true;
            }
            this.f4994w0 = z;
        }
        m1291l();
        m1293n();
    }

    public void setButtonClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f4992u0 = onClickListener;
        m1292m();
    }

    public void setButtonText(@Nullable String str) {
        this.f4991t0 = str;
        m1292m();
    }

    public void setDefaultBackground(boolean z) {
        this.f4993v0 = null;
        this.f4994w0 = z;
        m1291l();
        m1293n();
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        int i;
        this.f4989r0 = drawable;
        ImageView imageView = this.f4986o0;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            ImageView imageView2 = this.f4986o0;
            if (this.f4989r0 == null) {
                i = 8;
            } else {
                i = 0;
            }
            imageView2.setVisibility(i);
        }
    }

    public void setMessage(@Nullable CharSequence charSequence) {
        this.f4990s0 = charSequence;
        m1293n();
    }
}
